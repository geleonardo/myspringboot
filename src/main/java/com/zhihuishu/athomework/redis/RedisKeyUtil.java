package com.zhihuishu.athomework.redis;

import org.springframework.util.Assert;

public class RedisKeyUtil {

    private final static String EBOOK_PREFIX = "ebookcataloguestring";

    public final static String HOMEWORK_EXAM_PREFIX = "homeworkexam";
    /** 缓存Key分隔符 */
    private static final String CACHE_KEY_SEPERATOR = ":" ;

    // redis key过期时间， 5分钟
    public static final int EXPIRE_FRO_FIVE_MINUTE = 1 * 1 * 5 * 60;
    // redis key过期时间，1小时
    public static final int EXPIRE_ROR_ONE_HOUR = 1 * 1 * 60 * 60;
    // redis key过期时间，1天
    public static final int EXPIRE_ROR_ONE_DAY = 1 * 24 * 60 * 60;
    // redis key过期时间，7天
    public static final int EXPIRE_FOR_7_DAYS = 7 * 24 * 60 * 60;
    // redis key过期时间，30天
    public static final int EXPIRE_FOR_30_DAYS = 30 * 24 * 60 * 60;
    // redis key过期时间， 6个月
    public static final int EXPIR_FOR_6_MONTH = 24 * 60 * 60 * 30 * 6;
    // redis key过期时间， 12个月
    public static final int EXPIRE_ROR_ONE_YEAR = 30 * 24 * 60 * 60 * 12;

    /**
     * @param ebookId
     * @return
     */
    public static String getEbookCatalogueKey(Long ebookId) {
        return key(EBOOK_PREFIX, ebookId);
    }








    /**
     * 组装生成缓存Key，默认以":"分隔，所有Key必须使用此方法生成，会添加固定前缀，以区别其它应用
     * @param parts
     * @return
     */
    public static final String key(Object ... parts) {
        Assert.notEmpty(parts ,"生成Key方法参数不能为空!");
        StringBuffer sb = new StringBuffer() ;	// 缓存Key固定前缀
        for(int i = 0 ,len = parts.length ; i < len ; i ++) {
            Assert.notNull(parts[i] ,"生成Key方法参数不能为空!");
            sb.append(parts[i]) ;
            if(i < len - 1) sb.append(CACHE_KEY_SEPERATOR) ;
        }
        return sb.toString() ;
    }
}
