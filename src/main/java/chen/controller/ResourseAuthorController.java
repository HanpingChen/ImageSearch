package chen.controller;

import chen.context.ServiceDict;
import chen.dao.DbOperator;
import chen.mapper.ServiceMapper;
import chen.util.Util;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by chen on 17/2/11.
 * 资源服务器的验证控制器
 */
@Controller
public class ResourseAuthorController {

    @RequestMapping("resourse_author")
    public void resourseAuthor(HttpServletRequest request, HttpServletResponse response){

        System.out.println("进入资源服务器");
        //客户标识
        String clientId = request.getParameter(ServiceDict.CLIENT_ID);
        //获取传入参数中的url和code
        String oauthcode = request.getParameter(ServiceDict.AUTHORIZATION_CODE);
        String oauthurl = request.getParameter(ServiceDict.REDIRECT_URI);

        String accessToken = null;
        String refreshToken = null;
        //验证code和url是否正确
        SqlSession sqlSession = DbOperator.getSession();
        ServiceMapper mapper = sqlSession.getMapper(ServiceMapper.class);
        try {
            //从数据库中查询
            String code = mapper.selectCodeByClientid(clientId);
            String uri = mapper.selectUriByClientId(clientId);
            PrintWriter writer = response.getWriter();
            JSONObject object = new JSONObject();

            System.out.println("传入的code "+oauthcode+" 正确的code "+code);
            System.out.println("传入的uri "+oauthurl+" 正确的uri "+uri);
            if (code.equals(oauthcode)&&uri.equals(oauthurl)){

                //确认无误，发放access_token
                accessToken = RandomStringUtils.randomAlphabetic(16);
                refreshToken = RandomStringUtils.randomAlphabetic(16);
                //将token和refresh_token记录到数据库中，并记录时间
                mapper.updateAccessToken(clientId,accessToken);
                mapper.setRefreshToken(clientId,refreshToken);
                mapper.updateTime(clientId,Util.createTimeStr());
                sqlSession.commit();

                object.put("access_token",accessToken);
                object.put("refresh_token",refreshToken);
                object.put("expires_in",10);
                object.put("token_type","mac");
                object.put("status",1);
                object.put("msg","验证成功");
            }
            else {
                object.put("status",0);
                object.put("msg","验证失败");
            }

            writer.println(object.toString());
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
