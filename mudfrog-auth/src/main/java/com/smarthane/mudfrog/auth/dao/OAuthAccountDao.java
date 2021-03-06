package com.smarthane.mudfrog.auth.dao;

import com.smarthane.mudfrog.auth.entities.OAuthAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with by smarthane-cloud-microservice.
 *
 * @author: smarthane
 * @Date: 2018/6/11 15:39
 * @Description:
 */
public interface OAuthAccountDao extends JpaRepository<OAuthAccountEntity, Integer> {

    /**
     * 根据用户名查找账户信息
     * @param username 用户名
     * @return 账户信息
     */
    OAuthAccountEntity findByUsername(String username);

}
