package chen.util;

/**
 * Created by chen on 17/1/20.
 * 服务功能中的工具类
 */
public class ServiceUtil {

    /**
     * 生成clientid
     * @param email
     * @param serviceType
     * @return
     */
    public static String createClientId(String email,int serviceType){

        String clientId = "";
        String msg = email+serviceType;
        clientId = Util.getMD5(msg);
        return clientId;

    }
}
