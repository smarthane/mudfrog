package com.smarthane.mudfrog.auth.dao;

import com.smarthane.mudfrog.auth.entities.OAuthClientDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with by smarthane-cloud-microservice.
 *
 * @author: smarthane
 * @Date: 2018/6/22 14:03
 * @Description:
 */
public interface OAuthClientDetailsDao extends JpaRepository<OAuthClientDetailsEntity, String> {
}
