package chen.service.imp;

import chen.context.AppData;
import chen.context.ServiceDict;
import chen.dao.DbOperator;
import chen.mapper.ServiceMapper;
import chen.service.ApplyCode;
import chen.util.HttpRequest;
import chen.util.Util;
import com.sun.tools.corba.se.idl.PragmaEntry;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chen on 17/2/8.
 * 获取code的实现
 */
@Service
public class ApplyCodeImp implements ApplyCode {

    /**
     *
     * @param clientId
     * @param uri 在应用注册的时候的申请的回调地址
     * @return
     */
    public String applyToken(String clientId, String uri) {

        String code = null;

        String response = new String();
        //先获取code,查询数据库
        SqlSession session = DbOperator.getSession();
        ServiceMapper mapper = session.getMapper(ServiceMapper.class);
        //需要提交给制定回调地址的参数
        Map<String,String> params = new HashMap<String, String>();
        try {
            //判断传入的url是否为空
            if(uri == null){
                uri = Util.getUriByClientId(clientId);
                params.put(ServiceDict.REDIRECT_URI,uri);

                //跳转到指定的重定向的url，并带入参数code（authorazition_code）
                uri = AppData.ip+"/imagesearch/"+uri;
                System.out.println("uri = "+uri);
            }
            else {
                //先判断这里传入的url是否和用户在应用注册的url是一致的，防止跳转到黑客伪造的url
                String regishtUri = mapper.selectUriByClientId(clientId);
                if (!regishtUri.equals(uri)){
                    //返回空
                    return null;
                }
                params.put(ServiceDict.REDIRECT_URI,uri);
            }
            code = mapper.selectCodeByClientid(clientId);

            System.out.println("code = "+code);

            if (code == null){
                //clientId出错 验证失败
                JSONObject object = new JSONObject();
                object.put("status",0);
                object.put("msg","client_id无效,验证失败");
                return object.toString();
            }

            HttpRequest request = new HttpRequest();
            params.put(ServiceDict.AUTHORIZATION_CODE,code);
            params.put(ServiceDict.CLIENT_ID,clientId);

            //跳转到应用注册是指定的回调地址
            response = request.sendRequest(uri,params);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return response;
    }
}
