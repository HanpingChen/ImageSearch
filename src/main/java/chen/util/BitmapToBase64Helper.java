package chen.util;

import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lionschen on 2017/3/22.
 * 将图片转换成base64
 */
public class BitmapToBase64Helper {


    //图片的路径
    private String imgFile;

    public BitmapToBase64Helper(String imgFile) {
        this.imgFile = imgFile;
    }

    /**
     * 将图片转换成base64
     * @return
     */
    public String castImageToBase64(){

        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 转换成base64
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);

    }
}
