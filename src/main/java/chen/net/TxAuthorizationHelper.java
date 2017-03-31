package chen.net;

import chen.util.HmacSha1Helper;
import org.omg.CORBA.portable.ValueOutputStream;

import java.util.Random;

/**
 * Created by lionschen on 2017/3/22.
 * 腾讯签名帮助类
 */
public class TxAuthorizationHelper {


    private String urlStr = "";
    private String secretID = "AKIDNgstjSmLWMVebNvLYcWL0Tq23tY2AcdS";
    private String secretKey = "mT2PaaO1Toz2veBZnussmU9dwEOOFvU1";
    private String appID = "1251965538";
    private String bucketName = "imagesearch";

    private String data;

    /**
     * 拼接签名串
     */
    private void initData(){

        //时间戳
        String nowStr = System.currentTimeMillis()/1000+"";
        String timeLength = "1438669115";
        Random random = new Random();
        //用户生成随机数
        int r = random.nextInt();

        data = "a="+appID+"&b="+bucketName+"&k="+secretID+"&e="+timeLength+"&t="+nowStr+"&r="+r+"&u=0&f=";
        System.out.println(data);
    }

    /**
     * 获取鉴权码
     * @return
     */
    public String getAuthorization(){
        initData();
        return getAuthorization(data);
    }

    /**
     * 获取鉴权码
     * @param data
     * @return
     */
    public String getAuthorization(String data){
        String code = "";

        HmacSha1Helper helper = new HmacSha1Helper();
        code = helper.sign(secretKey,data);
        String author = "";

        System.out.println(code);
        String codes[] = code.split("\\n");

        for (int i=0;i<codes.length;i++){
            System.out.println(codes[i]);
        }

        System.out.println(author);
        return author;
    }

}
