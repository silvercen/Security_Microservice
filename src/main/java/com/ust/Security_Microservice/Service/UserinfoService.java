package com.ust.Security_Microservice.Service;

import com.ust.Security_Microservice.Model.Userinfo;
import com.ust.Security_Microservice.Respository.UserinfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserinfoService {
    @Autowired
    private UserinfoRepo userinfoRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    public Userinfo addUser(Userinfo userinfo){
        userinfo.setPassword(passwordEncoder.encode(userinfo.getPassword()));
        return userinfoRepo.saveAndFlush(userinfo);
    }

    public boolean verifyToken(String token)
    {
        jwtService.validateToken(token);
        return true;
    }

    public String generateToken(String username)
    {
        return jwtService.generateToken(username);
    }
}
