package com.smarthane.mudfrog.auth.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with by smarthane-cloud-microservice.
 *
 * @author: smarthane
 * @Date: 2018/6/21 13:54
 * @Description:
 */
@Entity
@Table(name = "oauth_code")
public class OAuthCodeEntity implements Serializable {

    private static final long serialVersionUID = -900611014452916837L;

    @Id
    @Column(name = "code", length = 128)
    private String code;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] authentication;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }
}
