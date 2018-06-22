package com.smarthane.mudfrog.auth.entities;

import com.smarthane.mudfrog.auth.utils.RandomUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with by smarthane-cloud-microservice.
 *
 * @author: smarthane
 * @Date: 2018/6/21 13:49
 * @Description: oauth_client_details
 */
@Entity
@Table(name = "oauth_client_details")
public class OAuthClientDetailsEntity implements Serializable {

    private static final long serialVersionUID = -7068189389187562580L;

    /**
     * 主键ID
     */
    @Id
    @Column(name = "client_id", length = 128)
    private String clientId = RandomUtils.getUUID();

    /**
     * resource Id
     */
    @Column(name = "resource_ids", length = 256)
    private String resourceIds;

    /**
     * secret
     */
    @Column(name = "client_secret", length = 256)
    private String clientSecret;

    /**
     * scope
     */
    @Column(name = "scope", length = 256)
    private String scope;

    /**
     * 授权类型
     */
    @Column(name = "authorized_grant_types", length = 256)
    private String authorizedGrantTypes;

    /**
     * 重定向地址
     */
    @Column(name = "web_server_redirect_uri", length = 256)
    private String webServerRedirectUri;

    /**
     * 权限
     */
    @Column(name = "authorities", length = 256)
    private String authorities;

    /**
     * access token的过期时间
     */
    @Column(name = "access_token_validity")
    private Integer accessTokenValidity;

    /**
     * refresh token的过期时间
     */
    @Column(name = "refresh_token_validity")
    private Integer refreshTokenValidity;

    /**
     * 额外信息
     */
    @Column(name = "additional_information", length = 4096)
    private String additionalInformation;

    @Column(name = "autoapprove", length = 256)
    private String autoapprove;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAutoapprove() {
        return autoapprove;
    }

    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
