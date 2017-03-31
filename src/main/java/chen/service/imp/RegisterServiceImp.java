package chen.service.imp;

import chen.dao.DbOperator;
import chen.entity.UserBean;
import chen.mapper.UserMapper;
import chen.service.RegisterService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by chen on 17/1/2.
 */
@Service
public class RegisterServiceImp implements RegisterService {

    public ModelAndView doRegister(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        //获取用户输入的email
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        //向数据库中查询是否已注册
        SqlSession sqlSession = DbOperator.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        try {
            UserBean userBean = mapper.selectUserByEmail(email);
            if (userBean == null){
                //可以注册，插入
                UserBean user = new UserBean(email,password,username);

                mapper.insertUser(user);
                sqlSession.commit();
                //注册成功
                session.setAttribute("username",username);
                //返回首页
                return new ModelAndView("index.jsp");
            }else {
                //已经注册过
                //带回参数
                session.setAttribute("registerstatus","repeat");
                response.sendRedirect("./jsp/register.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
        return null;
    }
}
