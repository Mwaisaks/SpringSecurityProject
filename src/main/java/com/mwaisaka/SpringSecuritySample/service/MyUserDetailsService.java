package com.mwaisaka.SpringSecuritySample.service;

import com.mwaisaka.SpringSecuritySample.model.UserPrincipal;
import com.mwaisaka.SpringSecuritySample.model.Users;
import com.mwaisaka.SpringSecuritySample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repository.findByUsername(username);

        if (user == null){
            System.out.println("User not Found!"); //prints in the console
            throw new UsernameNotFoundException("User not Found!")
        }

        return new UserPrincipal(user);
    }
}
