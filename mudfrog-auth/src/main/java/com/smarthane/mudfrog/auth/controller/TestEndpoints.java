package com.smarthane.mudfrog.auth.controller;

import com.smarthane.mudfrog.auth.dao.AccountDao;
import com.smarthane.mudfrog.auth.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 
 */
@RestController
public class TestEndpoints {

    @Autowired
    private AccountDao accountDao;

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "product id : " + id;
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "order id : " + id;
    }

    /**
     * 初始化用户数据
     */
    @Autowired
    public void init(){

        // 为了方便测试,这里添加了两个不同角色的账户
        accountDao.deleteAll();

        Account accountA = new Account();
        accountA.setUsername("admin");
        accountA.setPassword("admin");
        accountA.setRoles(new String[]{"ROLE_ADMIN","ROLE_USER"});
        accountDao.save(accountA);

        Account accountB = new Account();
        accountB.setUsername("guest");
        accountB.setPassword("pass123");
        accountB.setRoles(new String[]{"ROLE_GUEST"});
        accountDao.save(accountB);
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
