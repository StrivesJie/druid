package com.jie.common.base;

/**
 * @author thyme
 * @ClassName Constant
 * @Description TODO
 * @Date 2019/12/19 15:48
 */
public class Constants {

    public static final String LOGIN_URL = "/login";

    public static final String LOGOUT_URL = "/logout";

    public static final Integer INT_PAGE_ERROR = 500;

    public static final Integer INT_PAGE_NOT_FOUND = 404;

    public static final String STRING_PAGE_ERROR = "500";

    public static final String STRING_PAGE_NOT_FOUND = "404";

    public static final String REQUEST_MODE_POST = "POST";

    public static final String LOGIN_SUCCESS = "登录成功";

    public static final String LOGIN_FAIL = "登录失败";

    public static final String LOGOUT_SUCCESS = "退出成功";

    public static final String LOGIN_MAX_LIMIT = "登录超出最大限制";

    /**
     * 五分钟需要之内允许修改密码错误三次
     */
    public static final Long PASSWORD_UPDATE_MINUTE = 300L;

    public static final String PASSWORD_UPDATE = "PASSWORD_UPDATE";

    public static final Integer ACCESS_AUTH_FILTER_ORDER = 10;

    public static final String MENU_ICON_PREFIX = "layui-icon ";


    /**
     * 注册用户角色ID
     */
    public static final Long REGISTER_ROLE_ID = 2L;

    /**
     * 排序规则：降序
     */
    public static final String ORDER_DESC = "desc";

    /**
     * 排序规则：升序
     */
    public static final String ORDER_ASC = "asc";

    /**
     * 前端页面路径前缀
     */
    public static final String VIEW_PREFIX = "febs/views/";

    /**
     * 验证码 Session Key
     */
    public static final String CODE_PREFIX = "febs_captcha_";

    /**
     * 允许下载的文件类型，根据需求自己添加（小写）
     */
    public static final String[] VALID_FILE_TYPE = {"xlsx", "zip"};

    /**
     * 异步线程池名称
     */
    public static final String ASYNC_POOL = "febsAsyncThreadPool";

    /**
     * 开发环境
     */
    public static final String DEVELOP = "dev";

    /**
     * Windows 操作系统
     */
    public static final String SYSTEM_WINDOWS = "windows";


    /**
     * 用于IP定位转换
     */
    public static final String REGION = "内网IP|内网IP";

    public static final String INTRANET_IP = "内网IP";

    public static final String LOCAL_HOST = "127.0.0.1";

    /**
     * 重置密码  123456
     */
    public static final String CZMM = "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92";
}
