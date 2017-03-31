package chen.service;

import org.springframework.stereotype.Service;

/**
 * Created by chen on 17/2/6.
 */
@Service
public interface AddService {

    /**
     * 添加一个服务
     * @param email
     * @param type
     * @return
     */
    public int addService(String email,int type,String projectname);
}
