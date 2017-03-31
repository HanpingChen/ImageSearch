import chen.context.ServiceDict;
import chen.dao.DbOperator;
import chen.entity.ServiceBean;
import chen.mapper.ServiceMapper;
import chen.util.HttpRequest;
import chen.util.ServiceUtil;
import chen.util.Util;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import sun.reflect.generics.tree.VoidDescriptor;

import javax.print.attribute.standard.PageRanges;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by chen on 17/1/20.
 */
public class testservice {

    @Test
    public void addService(){
        String url = "http://localhost:13036/imagesearch/add_service";
        Map<String,String>params = new HashMap<String, String>();
        params.put(ServiceDict.PROJECT_NAME,"智能识图");
        params.put(ServiceDict.SERVER_TYPE,2+"");
        params.put(ServiceDict.USER_EMAIL,"chen@qq.com");
        HttpRequest request = new HttpRequest();
        request.sendRequest(url,params);
    }

    @Test
    public void applyToken(){
        String urlStr = "http://localhost:13036/imagesearch/apply_token";
        Map<String,String> params = new HashMap<String, String>();
        params.put(ServiceDict.CLIENT_ID,"0bec6b61b4493596da917e02454ca6a");
        //params.put(ServiceDict.REDIRECT_URI,null);

        HttpRequest request = new HttpRequest();
        String responeStr = request.sendRequest(urlStr,params);
        System.out.println(responeStr);
    }
}
