package chen.dao;

import chen.util.Util;

import java.sql.*;

/**
 * Created by chen on 17/2/14.
 * 为用户数据库服务的工具类
 */
public class ClientDbHelper {

    private Connection con = null;
    private ConnectionBean bean = null;
    private Statement statement = null;
    private PreparedStatement pst = null;

    public ClientDbHelper(){
        //获取配置的连接参数
        bean = getPropertyForConnection();

        //加载驱动
        try {
            Class.forName(bean.getDriver());
            //创建数据库连接
            con = DriverManager.getConnection(bean.getUrl(),bean.getUsername(),bean.getPassword());
            statement = con.createStatement();
            System.out.println("数据库连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean createUserTable(String clientId){

        System.out.println("正在创建表");
        boolean flag = false;
        String sql = "CREATE TABLE "+clientId+
                "(file_id VARCHAR(50) NOT NULL ," +
                "file_name VARCHAR(50) NOT NULL," +
                "file_path VARCHAR(50) NOT NULL, " +
                "file_size DOUBLE NOT NULL," +
                "create_time VARCHAR(50) NOT NULL," +
                "PRIMARY KEY (file_id))";
        try {
            //执行创建语句
            statement.executeUpdate(sql);
            System.out.println("创建成功");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    public ConnectionBean getPropertyForConnection(){
        String filename = "mysql.properties";

        Util util = new Util();
        String driver = util.getPropertiesValue(filename,"jdbc.driver");

        String url = util.getPropertiesValue(filename,"jdbc.url");

        String username = util.getPropertiesValue(filename,"jdbc.username");

        String password = util.getPropertiesValue(filename,"jdbc.password");

        //封装bean
        ConnectionBean bean = new ConnectionBean();
        bean.setDriver(driver);
        bean.setPassword(password);
        bean.setUrl(url);
        bean.setUsername(username);

        return bean;
    }
}
