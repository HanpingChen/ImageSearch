package chen.mapper;

import chen.entity.ServiceBean;

import java.security.Principal;
import java.util.List;

/**
 * Created by chen on 17/1/20.
 * 用户租用的服务类的操作
 */
public interface ServiceMapper {

    /**
     * 新增一个服务
     * @param bean
     * @return
     * @throws Exception
     */
    public int addService(ServiceBean bean) throws Exception;

    /**
     * 删除一个服务
     * @param email
     * @return
     * @throws Exception
     */
    public int deleteService(String email) throws Exception;

    /**
     * 根据email查询相应的服务
     * @param email
     * @return
     * @throws Exception
     */
    public List<ServiceBean> selectServiceByEmail(String email) throws Exception;

    /**
     * 根据clientId查询应用的code
     * @param clientId
     * @return
     * @throws Exception
     */
    public String selectCodeByClientid(String clientId) throws Exception;

    /**
     * 根据client查询应用注册的回调地址
     * @param clientId
     * @return
     * @throws Exception
     */
    public String selectUriByClientId(String clientId)throws Exception;

    /**
     * 更新token
     * @param clientId
     * @param token
     * @return
     * @throws Exception
     */
    public int updateAccessToken(String clientId,String accessToken) throws Exception;

    /**
     * 设置refresh_token ,在access_token 过期需要重新获取的时候需要的参数
     * @param clientId
     * @param refreshToken
     * @return
     * @throws Exception
     */
    public int setRefreshToken(String clientId ,String refreshToken) throws Exception;

    /**
     * 通过clientId获取服务类型
     * @param clientId
     * @return
     * @throws Exception
     */
    public int getTypeByClientId(String clientId) throws Exception;

    /**
     * 更新access_token的生成时间
     * @param time
     * @return
     * @throws Exception
     */
    public int updateTime(String clientId ,String time) throws Exception;
}
