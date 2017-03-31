package chen.controller;

import chen.context.ServiceDict;
import chen.dao.DbOperator;
import chen.mapper.ServiceMapper;
import chen.service.ApplyCode;
import chen.util.HttpRequest;
import chen.util.Util;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.tools.jar.CommandLine;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chen on 17/2/6.
 * 开放平台的鉴权控制器
 */
@Controller
public class AuthorController {

    @Resource
    private ApplyCode applyCode;
    /**
     * 获取临时token，默认有效时间为10分钟
     * @param request
     * @param response
     */
    @RequestMapping("apply_token")
    public void applyCode(HttpServletRequest request, HttpServletResponse response){

        System.out.println("进入申请token");
        //获取clientId
        String clientId = request.getParameter(ServiceDict.CLIENT_ID);
        //获取重定向的uri
        String uri = request.getParameter(ServiceDict.REDIRECT_URI);
        //调用service获取code
        System.out.println("调用service");
        String responseStr = applyCode.applyToken(clientId,uri);

        try {
            PrintWriter writer = response.getWriter();
            //JSONObject object = new JSONObject(responseStr);

            writer.println(responseStr);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 电商识图服务的验证服务器，用于生成授权token
     * @param request
     * @param response
     */
    @RequestMapping("ebsearch_oauth")
    public void ebseach(HttpServletRequest request, HttpServletResponse response){

        System.out.println("进入回调验证服务器");
        String token = null;
        String urlStr = "";
        Util util = new Util();
        urlStr = util.getPropertiesValue("servicetype.properties","resourseUri");
        System.out.println(urlStr);
        //获取传入参数中的url和code
        String oauthcode = request.getParameter(ServiceDict.AUTHORIZATION_CODE);
        String oauthurl = request.getParameter(ServiceDict.REDIRECT_URI);
        String clientId = request.getParameter(ServiceDict.CLIENT_ID);

        System.out.println("code = "+oauthcode);
        System.out.println("uri = "+oauthurl);
        System.out.println("clientId = "+clientId);
        //向资源验证服务器发送申请令牌请求
        Map<String,String>params = new HashMap<String, String>();
        params.put(ServiceDict.CLIENT_ID,clientId);
        params.put(ServiceDict.AUTHORIZATION_CODE,oauthcode);
        params.put(ServiceDict.REDIRECT_URI,oauthurl);

        HttpRequest httpRequest = new HttpRequest();
        String responseStr = httpRequest.sendRequest(urlStr,params);
        System.out.println(responseStr);
        try {
            PrintWriter writer = response.getWriter();
            writer.println(responseStr);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 智能识图的验证，生成授权token
     * @param request
     * @param response
     */
    @RequestMapping("similarsearch_oauth")
    public void  similarsearch(HttpServletRequest request, HttpServletResponse response){

    }

    /**
     * 图像分类的服务的验证
     * @param request
     * @param response
     */
    @RequestMapping("imagesort_oauth")
    public void imsearch(HttpServletRequest request, HttpServletResponse response){

    }
}
