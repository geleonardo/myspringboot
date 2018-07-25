# 项目说明
	作业考试项目
	
	！！！
	由于当前项目可能会部署在不同的学校里面
	所使用的用户系统又是智慧树的用户系统
	部署之前，项目需要做host
	如，本机研发： athome.zhihuishu,com   127.0.0.1   
	！！！
	
## 数据源说明
    当前项目配置了两个数据源
    AT_homeworkExam
    AT_homeworkExamAnswer
    通过DataSourceConfig 指定到mapper目录下面的master层和cluster层
	
## 研发环境
	（redis库暂时连接的是电子书项目的库，等稍后有单独配置之后，迁移一下，具体内容在：
	http://conf.zhihuishu.com/athomework/ 目录下，需做host，host信息在配置host中）

## 预发环境，生产环境
	由测试或者运维人员操作	

## Maven 命令
	mvn eclipse:eclipse    eclipse项目构建
	项目打包，eclipse:右键pom.xml-->run as -->maven install （mvn clean package）
	项目打包，idea:右侧maven projects -->项目名称-->lifecycle-->package
	
	
## 配置host
	研发：
	    host配置信息如下：
	    192.168.9.206   conf.zhihuishu.com
	    
	    研发环境，增加或者修改配置（*.properties）
	        登陆 192.168.9.206  usr/local/zhsnew/nginx/html/conf/athomework目录下   修改如上3个文件
	
	utils.Json==>标准格式返回值
	
## rabbitmq 消息队列相关
    当前项目已经配置消息队列
    如需新增队列，以研发为例：
        打开rabbitmq后台地址:  http://192.168.9.252:15672/#/queues   账号：admin  密码：admin
        进入 queues---->  
                Add a new queue-----> 
                    如果有 Virtual host，选择对应的 Virtual host（研发示例代码为：athomework）	----->
                        输入队列名称（如HelloSender1的helloQueue）--->
                            点击下方addqueue按钮
                            

## redis相关操作：
    redis 阻塞队列：如rabbittestcontroller
        //向队列中写入数据
        jedisTemplate.lpush("athomework:test:hello", "你好啊！");
                //因为是阻塞队列，所以这里用一个死循环，从队列中不停获取数据
                boolean flag = true;
                while(flag){
                    //从队列中获取数据
                                    List<String> str = jedisTemplate.brpop(0,"athomework:test:hello");
                                    if(!str.isEmpty() && str.size() == 2 && StringUtils.isNotEmpty(str.get(1))){
                                        System.out.println(str.get(1));
                                    }else{
                                        flag=false;
                                    }
                }
                
	具体可以参照其他项目
	
	
## 定时任务说明
    当前项目整合了xxl-job定时任务（job-->xxljob目录），同时采用原生定时任务（job-->normaljob目录）
    xxl-job 以研发为例，管理后台在 http://192.168.9.250:8080/xxl-job-admin/     admin      12345
            执行器管理--->辅助教学作业考试定时任务---->编辑，可以将自己的内网ip添加上去，具体可以参照（leo搜索项目建立索引）
                任务管理--->执行器（辅助教学作业考试定时任务）-->点击执行，可以执行当前定时任务--->日志按钮，查看相关日志
     #注意点：xxl-job 定时任务调度 需要关闭防火墙
                具体的时间表达式，可以百度查询
                
                
 ## 国际化相关
    研发为例，访问地址:
        http://athome.zhihuishu.com:8080/zhsathome/inter/test?lang=cn    中文
        http://athome.zhihuishu.com:8080/zhsathome/inter/test?lang=en    英文
        