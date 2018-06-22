package com.smarthane.mudfrog.auth.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with by smarthane-cloud-microservice.
 *
 * @author: smarthane
 * @Date: 2018/6/21 13:53
 * @Description:
 */
@Entity
@Table(name = "oauth_refresh_token")
public class OAuthRefreshTokenEntity implements Serializable {

    private static final long serialVersionUID = 3595604409225461441L;

    @Id
    @Column(name = "token_id", length = 128)
    private String tokenId;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] token;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] authentication;

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

    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }
}
