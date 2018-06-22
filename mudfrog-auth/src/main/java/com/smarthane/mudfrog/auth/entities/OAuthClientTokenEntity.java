package com.smarthane.mudfrog.auth.entities;

import com.smarthane.mudfrog.auth.utils.RandomUtils;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with by smarthane-cloud-microservice.
 *
 * @author: smarthane
 * @Date: 2018/6/21 13:51
 * @Description:  oauth_client_token
 */
@Entity
@Table(name = "oauth_client_token")
public class OAuthClientTokenEntity implements Serializable {

    private static final long serialVersionUID = -6261239246369156907L;

    @Id
    @Column(name = "authentication_id", length = 128)
    private String authenticationId = RandomUtils.getUUID();

    @Column(name = "token_id", length = 256)
    private String tokenId;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] token;

    @Column(name = "client_id", length = 256)
    private String clientId;

    @Column(name = "user_name", length = 256)
    private String userName;

    public String getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public byte[] getToken() {
        return token;
    }

    public void setToken(byte[] token) {
        this.token = token;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
