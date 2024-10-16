package com.ust.Security_Microservice.Controller;

import com.ust.Security_Microservice.Model.Userinfo;
import com.ust.Security_Microservice.Service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserinfoController {
    @Autowired
    private UserinfoService userinfoService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public Userinfo addUser(@RequestBody Userinfo userinfo) {
        return userinfoService.addUser(userinfo);
    }

    @GetMapping("/validate/{token}")
    public boolean validateToken(@PathVariable String token) {
        return userinfoService.verifyToken(token);
    }

    @PostMapping("/validate/user")
    public String validateUser(@RequestBody Userinfo user)
    {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated())
            return userinfoService.generateToken(user.getUsername());
        else
        {
            return "User not authenticated";
        }
    }
}
