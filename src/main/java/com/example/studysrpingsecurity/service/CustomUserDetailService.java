package com.example.studysrpingsecurity.service;

import com.example.studysrpingsecurity.domain.entity.UserEntity;
import com.example.studysrpingsecurity.dto.CustomUserDetails;
import com.example.studysrpingsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userData = userRepository.findByUsername(username);
        if (userData != null) {

            return new CustomUserDetails(userData);
        }

        return null;
    }
}
