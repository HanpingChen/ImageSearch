package chen.controller;

import chen.context.ServiceDict;
import chen.service.AddService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by chen on 17/1/20.
 * 申请加入和删除服务的控制器
 */
@Controller
public class ServiceController {

    @Resource
    private AddService addService;

    @RequestMapping("add_service")
    public void addService(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        //增加一个服务
        //获取用户的邮箱和申请的服务类型
        String projectname = request.getParameter(ServiceDict.PROJECT_NAME);
        System.out.println(projectname);
        String email = (String) session.getAttribute(ServiceDict.USER_EMAIL);
        int type = Integer.parseInt((String) session.getAttribute(ServiceDict.SERVER_TYPE));
        int status = addService.addService(email,type,projectname);
        try {
            if (status == 1){
                //添加成功，跳转控制台
                response.sendRedirect("./jsp/console.jsp");
            }
            else {
                response.sendRedirect("./jsp/applyeb.jsp");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @RequestMapping("delete_service")
    public void deleteService(HttpServletRequest request, HttpServletResponse response){
        //删除一个服务
        //获取service_id
    }
}
