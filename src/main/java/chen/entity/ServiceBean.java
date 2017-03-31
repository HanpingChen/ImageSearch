package chen.entity;

/**
 * Created by chen on 17/1/20.
 * 服务的实体类
 */
public class ServiceBean {

    //项目名
    private String projectName ;
    //用户的id，APPID
    private String clientId;
    //用户的邮箱，唯一标识
    private String email;
    //服务的类型
    private int serverType;
    //授权码
    private String authorizationCode;
    //
    private String redirectUri;

    private String createTime;

    private String accessToken;

    private String refreshToken;



    public ServiceBean(String projectName, String clientId, String email, int serverType, String authorizationCode, String redirectUri) {
        this.projectName = projectName;
        this.clientId = clientId;
        this.email = email;
        this.serverType = serverType;
        this.authorizationCode = authorizationCode;
        this.redirectUri = redirectUri;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public ServiceBean() {
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getServerType() {
        return serverType;
    }

    public void setServerType(int serverType) {
        this.serverType = serverType;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }
}
