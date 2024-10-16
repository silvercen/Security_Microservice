package com.ust.Security_Microservice.Config;

import com.ust.Security_Microservice.Model.Userinfo;
import com.ust.Security_Microservice.Respository.UserinfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    UserinfoRepo userinfoRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return userinfoRepo.findByUsername(username).map(UserInfoUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
