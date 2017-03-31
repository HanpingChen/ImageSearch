package chen.service.imp;

import chen.dao.DbOperator;
import chen.entity.UserBean;
import chen.mapper.UserMapper;
import chen.service.LoginService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by chen on 17/1/2.
 */
@Service
public class LoginServiceImp implements LoginService {

    /**
     * 处理登录校验逻辑
     * @param loginUrl 登录的地址，失败时返回
     * @param loginSuccesUrl 登录成功的地址
     * @param mail 用户传入的邮箱地址
     * @param password 用户传入的密码
     * @param session 会话对象，用于判断登录是否完成
     * @return
     */
    public ModelAndView doLogin(HttpSession session, HttpServletResponse response,String loginUrl, String loginSuccesUrl, String mail, String password) {

        //查询数据库
        SqlSession sqlSession = DbOperator.getSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        try {
            UserBean user = mapper.queryPassword(mail);
            if (user!=null){
                //用户名存在
                if (user.getPassword().equals(password)){
                    //登录成功跳转首页 从session带回username和email
                    session.setAttribute("username",user.getUsername());
                    session.setAttribute("email",user.getEmail());
                    System.out.println("登录成功");
                    return new ModelAndView(loginSuccesUrl);
                }
                else {
                    System.out.println("密码错误");
                    session.setAttribute("loginstatus","fail");
                    response.sendRedirect("./jsp/login.jsp?error='1'");
                    //return new ModelAndView(loginUrl,"error","密码错误");

                }
            }else {
                System.out.println("邮箱错误");
                session.setAttribute("loginstatus","nouser");
                response.sendRedirect("./jsp/login.jsp?error='1'");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
