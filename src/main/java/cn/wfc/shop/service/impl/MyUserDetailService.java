package cn.wfc.shop.service.impl;

import cn.wfc.shop.config.MyPasswordEncoder;
import cn.wfc.shop.entity.MyUser;
import cn.wfc.shop.mapper.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private MyUserMapper myUserMapper;
    @Autowired
    private MyPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserMapper.findUserByEmail(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority("guest");
        roles.add(authority);
        return new User(myUser.getUsername(),myUser.getPassword(),roles);
    }
}
