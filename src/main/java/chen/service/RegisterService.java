package chen.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by chen on 17/1/2.
 * 注册服务的接口
 */
@Service
public interface RegisterService {
    public ModelAndView doRegister(HttpSession session, HttpServletRequest request, HttpServletResponse response);
}
