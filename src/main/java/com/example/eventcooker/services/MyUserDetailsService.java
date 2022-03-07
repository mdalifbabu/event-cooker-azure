package com.example.eventcooker.services;

import com.example.eventcooker.masterdata.models.auth.UserAllInfo;
import com.example.eventcooker.masterdata.services.auth.UserAllInfoService;
import com.example.eventcooker.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserAllInfoService userAllInfoService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            UserAllInfo userAllInfo = userAllInfoService.findUserAllInfoByUserName(s);
            System.out.println(userAllInfo);
            return new User(userAllInfo.getUserName(), userAllInfo.getUserPassword(), new ArrayList<>());
        }catch (Exception e){
            return null;
        }
    }
}