package com.smarthane.mudfrog.auth.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with by smarthane-cloud-microservice.
 *
 * @author: smarthane
 * @Date: 2018/6/22 13:45
 * @Description:
 */
@Entity
@Table(name = "oauth_account")
public class OAuthAccountEntity implements Serializable {

    private static final long serialVersionUID = 6489639750245179999L;

    @Id
    @GeneratedValue
    private Integer id;          // 主键
    private String username;     // 用户名
    private String password;     // 密码
    private String[] roles;      // 角色

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
