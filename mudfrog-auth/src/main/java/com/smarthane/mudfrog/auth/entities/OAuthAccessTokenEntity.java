package com.smarthane.mudfrog.auth.entities;

import com.smarthane.mudfrog.auth.utils.RandomUtils;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with by smarthane-cloud-microservice.
 *
 * @author: smarthane
 * @Date: 2018/6/21 13:52
 * @Description:
 */
@Entity
@Table(name = "oauth_access_token")
public class OAuthAccessTokenEntity implements Serializable {

    private static final long serialVersionUID = 8262440590465389795L;

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

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] authentication;

    @Column(name = "refresh_token", length = 256)
    private String refreshToken;

    public byte[] getToken() {
        return token;
    }

    public void setToken(byte[] token) {
        this.token = token;
    }

    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }

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

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
