package chen.service.imp;

import chen.dao.ClientDbHelper;
import chen.dao.DbOperator;
import chen.entity.ServiceBean;
import chen.mapper.ServiceMapper;
import chen.service.AddService;
import chen.util.ServiceUtil;
import chen.util.Util;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by chen on 17/2/6.
 */
@Service
public class AddServiceImp implements AddService {

    /**
     * 实现用户添加一个服务的逻辑
     * @param email
     * @param type
     * @param projectname
     * @return
     */
    public int addService(String email, int type,String projectname) {

        SqlSession sqlSession = DbOperator.getSession();
        ServiceMapper mapper = sqlSession.getMapper(ServiceMapper.class);
        //为参数赋值
        ServiceBean bean = new ServiceBean();
        bean.setEmail(email);
        bean.setProjectName(projectname);
        bean.setCreateTime(Util.createTimeStr());
        bean.setServerType(type);
        //随机生成code
        bean.setAuthorizationCode(RandomStringUtils.randomAlphabetic(16));
        //从配置文件中读取相应的服务类别对应的回调地址
        bean.setRedirectUri(Util.getUriByType(type));
        String clientId = ServiceUtil.createClientId(bean.getEmail(),bean.getServerType());
        bean.setClientId(clientId);
        try {
            mapper.addService(bean);
            sqlSession.commit();
            //创建用户的数据表
            ClientDbHelper helper = new ClientDbHelper();
            helper.createUserTable(clientId);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
