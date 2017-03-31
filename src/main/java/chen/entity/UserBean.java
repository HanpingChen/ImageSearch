package chen.entity;

import java.io.Serializable;

/**
 * Created by chen on 17/1/2.
 */
public class UserBean implements Serializable {

    private String email;
    private String password;
    private String username;

    public UserBean() {
    }

    public UserBean(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public UserBean(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
