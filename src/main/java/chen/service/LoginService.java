package chen.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by chen on 17/1/2.
 */
@Service
public interface LoginService {

    public ModelAndView doLogin(HttpSession session, HttpServletResponse response,String loginUrl, String loginSuccesUrl, String mail, String password);
}
