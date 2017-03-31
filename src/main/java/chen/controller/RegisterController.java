package chen.controller;

import chen.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by chen on 16/12/27.
 * 开发者注册开发者账号控制器
 */
@Controller
public class RegisterController {

    @Resource
    private RegisterService registerService;
    @RequestMapping("register")
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        String email = request.getParameter("email");

        return registerService.doRegister(session,request,response);
    }
}
