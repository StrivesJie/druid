package com.jie.druid.rest;

import com.jie.common.base.ApiResponse;
import com.jie.common.utils.Md5Util;
import com.jie.druid.annotation.Limit;
import com.jie.druid.controller.BaseController;
import com.jie.druid.entity.LoginLog;
import com.jie.druid.entity.User;
import com.jie.druid.exception.BaseException;
import com.jie.druid.service.ITLoginLogService;
import com.jie.druid.service.ITUserService;
import com.jie.druid.service.ValidateCodeService;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.*;

/**
 * @author MrBird
 */
@Validated
@RestController
@RequiredArgsConstructor
public class LoginController extends BaseController {

    private final ITUserService userService;
    private final ValidateCodeService validateCodeService;
    private final ITLoginLogService loginLogService;
    private final SessionDAO sessionDAO;

    @PostMapping("login")
    @Limit(key = "login", period = 60, count = 10, name = "登录接口", prefix = "limit")
    public ApiResponse login(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password,
            @NotBlank(message = "{required}") String verifyCode,
            boolean rememberMe, HttpServletRequest request) throws BaseException {
        HttpSession session = request.getSession();
        validateCodeService.check(session.getId(), verifyCode);
        Subject subject = super.getSubject();
        /*List<Session> loginedList = getLoginedSession(subject);
        for (Session session1 : loginedList) {
            System.out.println("登录用户zzz" + session1.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
                session1.stop();
        }*/
        password = Md5Util.encrypt(username.toLowerCase(), password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        super.login(token);
        // 保存登录日志
        LoginLog loginLog = new LoginLog();
        loginLog.setUsername(username);
        loginLog.setSystemBrowserInfo();
        this.loginLogService.saveLoginLog(loginLog);

        return new ApiResponse().success();
    }

    //遍历同一个账户的session
    private List<Session> getLoginedSession(Subject currentUser) {
        Collection<Session> list = ((DefaultSessionManager) ((DefaultSecurityManager) SecurityUtils
                .getSecurityManager()).getSessionManager()).getSessionDAO()
                .getActiveSessions();
        List<Session> loginedList = new ArrayList<Session>();
        User loginUser = super.getCurrentUser();
        for (Session session : list) {
            Subject s = new Subject.Builder().session(session).buildSubject();

            if (s.isAuthenticated()) {
                User user = (User) s.getPrincipal();

                if (user.getUsername().equalsIgnoreCase(loginUser.getUsername())) {
                    if (!session.getId().equals(
                            currentUser.getSession().getId())) {
                        loginedList.add(session);
                    }
                }
            }
        }
        return loginedList;
    }

    @PostMapping("regist")
    public ApiResponse regist(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password) throws BaseException {
        User user = userService.findByName(username);
        if (user != null) {
            throw new BaseException("该用户名已存在");
        }
        this.userService.regist(username, password);
        return new ApiResponse().success();
    }

    @GetMapping("index/{username}")
    public ApiResponse index(@NotBlank(message = "{required}") @PathVariable String username) {
        // 更新登录时间
        this.userService.updateLoginTime(username);
        Map<String, Object> data = new HashMap<>(5);
        // 获取系统访问记录
        Long totalVisitCount = this.loginLogService.findTotalVisitCount();
        data.put("totalVisitCount", totalVisitCount);
        Long todayVisitCount = this.loginLogService.findTodayVisitCount();
        data.put("todayVisitCount", todayVisitCount);
        Long todayIp = this.loginLogService.findTodayIp();
        data.put("todayIp", todayIp);
        // 获取近期系统访问记录
        List<Map<String, Object>> lastSevenVisitCount = this.loginLogService.findLastSevenDaysVisitCount(null);
        data.put("lastSevenVisitCount", lastSevenVisitCount);
        User param = new User();
        param.setUsername(username);
        List<Map<String, Object>> lastSevenUserVisitCount = this.loginLogService.findLastSevenDaysVisitCount(param);
        data.put("lastSevenUserVisitCount", lastSevenUserVisitCount);
        return new ApiResponse().ofSuccess(data);
    }

    @GetMapping("images/captcha")
    @Limit(key = "get_captcha", period = 60, count = 10, name = "获取验证码", prefix = "limit")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException, BaseException {
        validateCodeService.create(request, response);
    }
}
