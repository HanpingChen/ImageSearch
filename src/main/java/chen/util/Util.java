package chen.util;

import chen.dao.DbOperator;
import chen.mapper.ServiceMapper;
import jdk.nashorn.internal.runtime.URIUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Properties;

/**
 * Created by chen on 17/1/20.
 * 公共方法类
 */
public class Util {

    /**
     * 生成时间字符串
     * @return
     */
    public static String createTimeStr(){
        String timeStr = "";
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        timeStr = year+"-"+month+"-"+day+" "+hour+":"+day;
        return timeStr;
    }

    /**
     * 获取字符串的MD5码
     * @param msg
     * @return
     */
    public static String getMD5(String msg){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(msg.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过服务类型获取默认的回调uri
     * @param type
     * @return
     */
    public static String getUriByType(int type){
        String uri = "";
        //从配置文件中读取相应的服务类别对应的回调地址
        Util util = new Util();
        uri = util.getPropertiesValue("servicetype.properties",String.valueOf(type));
        return uri;
    }

    /**
     * 通过clientId获取服务的回调uri
     * @return
     */
    public static String getUriByClientId(String clientId){
        String uri = "";

        SqlSession session = DbOperator.getSession();
        ServiceMapper mapper  = session.getMapper(ServiceMapper.class);
        try {
            int type = mapper.getTypeByClientId(clientId);
            uri = getUriByType(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uri;
    }

    /**
     * 从配置文件中读取相应的key值对应的value
     * @param filename
     * @param key
     * @return
     */
    public  String getPropertiesValue(String filename,String key){

        String value = "";
        //从配置文件中读取相应key的value
        Properties properties = new Properties();
        try {
            InputStream fin = this.getClass().getClassLoader().getResourceAsStream(filename);
            InputStreamReader isr = new InputStreamReader(fin,"UTF-8");
            //加载属性列表
            properties.load(isr);
            value = properties.getProperty(key);
            fin.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;

    }


}
