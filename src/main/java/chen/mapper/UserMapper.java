package chen.mapper;

import chen.entity.UserBean;

import java.util.List;

/**
 * Created by chen on 17/1/2.
 */
public interface UserMapper {

    /**
     * 新增用戶
     * @param user
     * @return
     * @throws Exception
     */
    public int insertUser(UserBean user) throws Exception;

    /**
     * 修改用戶
     * @param user
     * @param email
     * @return
     * @throws Exception
     */
    public int updateUser (UserBean user, String email) throws Exception;

    /**
     * 刪除用戶
     * @param email
     * @return
     * @throws Exception
     */
    public int deleteUser(String email) throws Exception;

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public UserBean selectUserByEmail(String email) throws Exception;

    /**
     * 查询所有的用户信息
     * @return
     * @throws Exception
     */
    public List<UserBean> selectAllUser() throws Exception;

    /**
     * 根据传入的email查询用户的密码
     * @param email
     * @return
     * @throws Exception
     */
    public UserBean queryPassword(String email) throws Exception;
}
