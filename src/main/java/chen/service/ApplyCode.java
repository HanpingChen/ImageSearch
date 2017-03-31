package chen.service;

import chen.entity.ServiceBean;
import org.springframework.stereotype.Service;

/**
 * Created by chen on 17/2/8.
 */
@Service
public interface ApplyCode {

    /**
     * 根据clientId获取code
     * @param clientId
     * @param url 在应用注册的时候的申请的回调地址
     * @return
     */
    public String applyToken(String clientId, String url);
}
