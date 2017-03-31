
import chen.dao.ClientDbHelper;
import chen.dao.DbOperator;
import chen.entity.UserBean;
import chen.mapper.ServiceMapper;
import chen.mapper.UserMapper;
import chen.util.HttpRequest;
import chen.util.ServiceUtil;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.print.DocFlavor;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by chen on 16/12/27.
 */
public class test {

    @Test
    public void sendrequest(){
    }

    @Test
    public void pro(){
        InputStream inputStream = this.getClass().getResourceAsStream("mysql.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            inputStream.close();
            System.out.println("username" + properties.getProperty("jdbc.username") );
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("d41d8cd98f00b204e9800998ecf8427e");
        System.out.println(ServiceUtil.createClientId("chenl@qq.com",2));
    }
    @Test
    public void testInsert(){

        SqlSession session = DbOperator.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserBean user = new UserBean("h1aha11@qq.com", "123","电竞选手");
        try {
            mapper.insertUser(user);
            System.out.println(user.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

    @Test
    public void selectAllUser(){
        SqlSession session=DbOperator.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
            List<UserBean> user=mapper.selectAllUser();
            System.out.println("username "+user.get(0).getEmail());
            System.out.println("password "+user.get(0).getPassword());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

    @Test
    public void queryPass(){
        //查询数据库
        SqlSession sqlSession = DbOperator.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        try {
            UserBean pass = mapper.queryPassword("chenlions@163.com");
            //System.out.println(pass);
            System.out.println(pass.getPassword()+pass.getUsername());
            if (pass.equals(123)){
                //登录成功
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectCode(){
        String code = null;

        //先获取code,查询数据库
        SqlSession session = DbOperator.getSession();
        ServiceMapper mapper = session.getMapper(ServiceMapper.class);
        try {
            code = mapper.selectCodeByClientid("0bec6b61b4493596da917e02454ca6a4");
            System.out.println(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createTable(){
        ClientDbHelper helper = new ClientDbHelper();
        if (helper.createUserTable("cc")){
            System.out.println("创建成功");
        }
    }

    @Test
    public void testLogin(){
        HttpRequest request = new HttpRequest();
        Map<String,String> params = new HashMap<String, String>();
        params.put("user_email","chen@qq.com");
        params.put("password","123");
        String response = request.sendRequest("http://localhost:12345/logindemo/login",params);
    }
}
