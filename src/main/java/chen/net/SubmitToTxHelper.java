package chen.net;
import com.qcloud.image.ImageClient;
import com.qcloud.image.common_utils.CommonFileUtils;
import com.qcloud.image.request.TagDetectRequest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by lionschen on 2017/3/22.
 * 向腾讯云提交申请的帮助类
 */
public class SubmitToTxHelper {

    private String urlStr = "http://service.image.myqcloud.com/v1/detection/imagetag_detect";
    private String host = "service.image.myqcloud.com";
    private int appID = 1251965538;
    private String secretID = "AKIDNgstjSmLWMVebNvLYcWL0Tq23tY2AcdS";
    private String secretKey = "mT2PaaO1Toz2veBZnussmU9dwEOOFvU1";

    private String bucketName = "imagesearch";
    /**
     * 提交请求
     * @param params json格式的参数
     * @return json格式的回复
     */
    public String submit(String path){

        ImageClient client = new ImageClient(appID,secretID,secretKey);
        byte[] tagImage = {0};
        try {
            tagImage = CommonFileUtils.getFileContentByte(path);
        } catch (Exception ex) {
            //Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        }

        TagDetectRequest tagReq = new TagDetectRequest(bucketName, tagImage);
        String ret = client.tagDetect(tagReq);


        return ret;
    }




}
