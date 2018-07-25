package com.zhihuishu.athomework.filter;

import com.zhihuishu.athomework.constant.Config;
import com.zhihuishu.athomework.constant.UserConstant;
import com.zhihuishu.athomework.dto.CommonUserRmiDto;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.Map;

/**
 * 使用注解标注过滤器
 * @WebFilter将一个实现了javax.servlet.Filter接口的类定义为过滤器
 * 属性filterName声明过滤器的名称,可选
 * 属性urlPatterns指定要过滤 的URL模式,也可使用属性value来声明.(指定要过滤的URL模式是必选属性)
 *
 */
@WebFilter(filterName="myFilter",urlPatterns="/*")
public class MyFilter implements Filter {

    @Value("${spring.cas.cas-server-login-url}")
    private String loginurl;

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }

    private final Log log = LogFactory.getLog(this.getClass());

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        System.out.println("进入全局过滤器");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();
        String requestURI = request.getRequestURI();

        String fullurl = request.getScheme()+"://" + request.getServerName() //服务器地址
                + ":"
                + request.getServerPort()           //端口号
                + request.getContextPath()      //项目名称
                + request.getServletPath();     //请求页面或其他地址
                if(request.getQueryString()!=null){
                    fullurl = fullurl + "?" + (request.getQueryString()); //参数
                }

        fullurl = URLEncoder.encode(fullurl);

        try {

            // 判断SESSION中是否存在用户信息并且用户名与认证用户名一致
            String originAccount = (String) session.getAttribute(UserConstant.SESSION_LOGIN_USER_ACCOUNT_KEY);
            // 如果存在且相等，直接下行，否则重新获取用户信息，并写入SESSION中
            // 暂不比较，部分请求不走CAS Client的过滤器，会取不到principal信息，造成空指针异常 by zlikun
            if (originAccount != null) {
                chain.doFilter(request, response);
                return;
            }

            // 获取CAS传递过来的认证用户信息
            Principal principal = request.getUserPrincipal();
            // 获取用户登录账号(用户名)
            String account = principal.getName();

            CommonUserRmiDto loginUser = null;

            // 获取认证用户信息，包含字段(全部字符串类型)：userId / username / realname / avatar
            if (principal != null && principal instanceof AttributePrincipal) {
                Map<String, Object> map = ((AttributePrincipal) principal).getAttributes();
                if (!CollectionUtils.isEmpty(map)) {
                    loginUser = new CommonUserRmiDto();
                    if (map.get("userId") != null)

                        loginUser.setUserId(NumberUtils.toLong(map.get("userId").toString()));
                    if (map.get("username") != null)
                        loginUser.setUsername(map.get("username").toString());
                    if (map.get("realname") != null)
                        loginUser.setRealname(map.get("realname").toString());
                    if (map.get("avatar") != null)
                        loginUser.setAvatar(map.get("avatar").toString());
                }
            }
            // 如果CAS不包含用户信息，使用用户帐号查询用户
            //TODO,由于无法集成dubbo,这里可能后期需要走http接口获取用户数据
//            if (loginUser == null || loginUser.getUserId() == null) {
//                loginUser = userService.findUserInfoByUsernameOrEMail(account);
//            }
            // 用户信息为空
            if (loginUser == null || loginUser.getUserId() == null) {
                throw new RuntimeException("未能获取登录用户信息!");
            }


            // 完善用户头像
            if (StringUtils.isBlank(loginUser.getAvatar())) {
                // 为空是，填充默认用户头像
                loginUser.setAvatar(request.getContextPath() + "/assets/img/user_default.jpg");
            } else if (!StringUtils.startsWithIgnoreCase(loginUser.getAvatar(), "http")) {
                // 非以http开头时，添加前缀
                loginUser.setAvatar(Config.getFtpUrlSuffixImg() + loginUser.getAvatar());
            }

            session.setAttribute(UserConstant.SESSION_LOGIN_USER_ID_KEY, loginUser.getUserId());
            session.setAttribute(UserConstant.SESSION_LOGIN_USER_ACCOUNT_KEY, loginUser.getUsername());
            session.setAttribute(UserConstant.SESSION_LOGIN_USER_KEY, loginUser);
            chain.doFilter(request, response);

        } catch (Exception ex) {
            log.error("登录出错!", ex);
            //登陆出错，跳转回登陆页面
            PrintWriter out = response.getWriter();
            out.print("<script>window.top.location.href='"+loginurl+"?service="+fullurl+"';</script>");
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化");
    }

}
