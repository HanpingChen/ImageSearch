package chen.util;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.kerberos.KerberosTicket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lionschen on 2017/3/22.
 * 签名算法帮助类
 */
public class HmacSha1Helper {

    /**
     * 对数据签名
     * @param key 用户的key
     * @param data 签名串
     * @return 签名的base64的串
     */
    public String sign(String key,String data){
        String signStr = null;
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(),"HMACSHA1");
        try {
            Mac mac = Mac.getInstance("HMACSHA1");
            mac.init(keySpec);
            //签名的二进制数据
            byte signByte[] = mac.doFinal(data.getBytes());
            byte dataByte[] = data.getBytes();
            int length = signByte.length+dataByte.length;
            byte finalByte[] = new byte[length];
            for (int i=0;i<signByte.length;i++){
                finalByte[i] = signByte[i];
            }

            for (int i=0;i<dataByte.length;i++){
                finalByte[i+signByte.length-1] =dataByte[i];
            }
            //转成成base64字符串
            signStr = Base64.encodeBase64String(finalByte);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return signStr;
    }
}


