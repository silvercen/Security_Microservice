package com.ust.Security_Microservice.Respository;

import com.ust.Security_Microservice.Model.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserinfoRepo extends JpaRepository<Userinfo, Integer> {
    public Optional<Userinfo> findByUsername(String username);
}
