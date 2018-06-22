package com.smarthane.mudfrog.auth.controller;

import com.smarthane.mudfrog.auth.dao.OAuthAccountDao;
import com.smarthane.mudfrog.auth.dao.OAuthClientDetailsDao;
import com.smarthane.mudfrog.auth.entities.OAuthAccountEntity;
import com.smarthane.mudfrog.auth.entities.OAuthClientDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with by smarthane-cloud-microservice.
 *
 * @author: smarthane
 * @Date: 2018/6/11 10:17
 * @Description:
 *
 *
 * http://localhost:10261/refresh post 刷新 config repo
 *
 */
@RestController
@RefreshScope
public class TestController {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Value("${test}")
    private String test;

    @GetMapping("/test")
    public String test() {
        return this.test;
    }

    @GetMapping("/redis")
    public String testRedis() {
        this.redisTemplate.opsForValue().set("test", "3333333333333");
        return "ok";
    }

    @Autowired
    private OAuthAccountDao oAuthAccountDao;
    @Autowired
    private OAuthClientDetailsDao oAuthClientDetailsDao;

    /**
     * 初始化用户数据
     */
    @Autowired
    public void init(){
        // 为了方便测试,这里添加了两个不同角色的账户
        if (oAuthAccountDao.findAll().isEmpty()) {
            OAuthAccountEntity accountA = new OAuthAccountEntity();
            accountA.setUsername("admin");
            accountA.setPassword("admin");
            accountA.setRoles(new String[]{"ROLE_ADMIN","ROLE_USER"});
            oAuthAccountDao.save(accountA);
            OAuthAccountEntity accountB = new OAuthAccountEntity();
            accountB.setUsername("guest");
            accountB.setPassword("guest");
            accountB.setRoles(new String[]{"ROLE_GUEST"});
            oAuthAccountDao.save(accountB);
        }

        if (oAuthClientDetailsDao.findAll().isEmpty()) {
            List<OAuthClientDetailsEntity> list = new ArrayList<>();
            OAuthClientDetailsEntity c1 = new OAuthClientDetailsEntity();
            c1.setClientId("android");
            c1.setClientSecret("android");
            c1.setAuthorizedGrantTypes("password,refresh_token");
            c1.setScope("read,write");
            list.add(c1);

            OAuthClientDetailsEntity c2 = new OAuthClientDetailsEntity();
            c2.setClientId("abc");
            c2.setClientSecret("abc");
            c2.setAuthorizedGrantTypes("client_credentials");
            c2.setAuthorities("ROLE_ADMIN");
            c2.setScope("read,write");
            list.add(c2);

            OAuthClientDetailsEntity c3 = new OAuthClientDetailsEntity();
            c3.setClientId("code");
            c3.setClientSecret("code");
            c3.setAuthorizedGrantTypes("authorization_code");
            c3.setScope("read,write");
            c3.setWebServerRedirectUri("http://www.baidu.com");
            list.add(c3);
            oAuthClientDetailsDao.save(list);
        }
        
    }

    /**
     * 获取授权用户的信息
     * @param user 当前用户
     * @return 授权信息
     */
    @GetMapping("/user")
    public Principal user(Principal user){
        return user;
    }


}
