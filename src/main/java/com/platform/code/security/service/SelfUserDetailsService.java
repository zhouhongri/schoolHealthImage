package com.platform.code.security.service;

import com.platform.code.security.bean.SelfUserDetails;
import com.platform.main.bean.bo.User;
import com.platform.main.bean.po.BaseRole;
import com.platform.main.service.RoleService;
import com.platform.main.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description 角色权限加载
 **/
@Component("userDetailServiceImpl")
public class SelfUserDetailsService implements UserDetailsService {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SelfUserDetails userInfo = new SelfUserDetails();
        User user = userService.loadUserByUsername(username);
        if (user == null || user.getState() == -1) {
            throw new UsernameNotFoundException("未找到该用户！");
        }
        if (user.getState() == 2) {  //账号未启用
            userInfo.setEnabled(false);
        }
        if (user.getState() == 3) {  //账号已被锁定
            userInfo.setAccountNonLocked(false);
        }

        userInfo.setAccountId(user.getAccountId());
        userInfo.setUsername(user.getLoginName());
        userInfo.setPassword(user.getLoginPwd());

        // 登录时取权限列表
        Set authoritiesSet = new HashSet();

        List<BaseRole> baseRoleList = roleService.selectByAccountId(user.getAccountId());
        if (baseRoleList != null && !baseRoleList.isEmpty()) {
            for (BaseRole baseRole : baseRoleList) {
                GrantedAuthority authority = new SimpleGrantedAuthority(baseRole.getRoleSign());
                authoritiesSet.add(authority);
            }
        }
        userInfo.setAuthorities(authoritiesSet);

        return userInfo;
    }
}