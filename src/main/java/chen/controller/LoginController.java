package chen.controller;

import chen.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by chen on 16/12/29.
 */
@Controller
public class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping(value = "/login")
    public ModelAndView doLogin(HttpServletRequest request, HttpServletResponse response,HttpSession session){

        //获取邮箱
        String email = (String) request.getParameter("email");
        System.out.println("传入的email"+email);
        //获取密码
        String password = (String) request.getParameter("password");
        System.out.println("传入的密码"+password);
        String loginUrl = "./jsp/login.jsp";
        String loginSuccessUrl = "index.jsp";
        return loginService.doLogin(session,response,loginUrl,loginSuccessUrl,email,password);
    }

    @RequestMapping("logout")
    public ModelAndView doLogout(HttpSession session){
        //清除session
        session.setAttribute("username",null);
        //重定向
        return new ModelAndView("index.jsp");
    }
}
