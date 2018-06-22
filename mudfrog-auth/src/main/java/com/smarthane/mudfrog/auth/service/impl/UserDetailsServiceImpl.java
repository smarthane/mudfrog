package com.smarthane.mudfrog.auth.service.impl;

import com.smarthane.mudfrog.auth.dao.OAuthAccountDao;
import com.smarthane.mudfrog.auth.entities.OAuthAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created with by smarthane-cloud-microservice.
 *
 * @author: smarthane
 * @Date: 2018/6/11 14:22
 * @Description: 用户信息服务
 * 实现 Spring Security的UserDetailsService接口方法，用于身份认证
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private OAuthAccountDao accountDao;

    /**
     * 根据用户名查找账户信息并返回用户信息实体
     * @param username 用户名
     * @return 用于身份认证的 UserDetails 用户信息实体
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        OAuthAccountEntity account = accountDao.findByUsername(username);
        if (account!=null) {
            return new User(account.getUsername(),account.getPassword(), AuthorityUtils.createAuthorityList(account.getRoles()));
        } else {
            throw  new UsernameNotFoundException("用户["+username+"]不存在");
        }
    }
}
