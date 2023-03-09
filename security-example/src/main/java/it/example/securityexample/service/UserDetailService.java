package it.example.securityexample.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import it.example.securityexample.configuration.UserDetailConfiguration;
import it.example.securityexample.model.Authorities;
import it.example.securityexample.model.Users;
import it.example.securityexample.repositories.UserRepository;

/**
 * *Author: Marco Orfei
 * *The Class UserDetailService
 */
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> userByUsername = userRepository.findByUsername(username);
        if (!userByUsername.isPresent()) {
            throw new UsernameNotFoundException("Invalid credentials!");
        }
        Users user = userByUsername.get();
        if (user == null || !user.getUsername().equals(username)) {
            throw new UsernameNotFoundException("Invalid credentials!");
        }
        Set<Authorities> authorities = new HashSet<Authorities>();
        for (Authorities authority : authorities) {
            authorities.add(authority);
        }
        user.setAuthorities(authorities);
        return (UserDetails) new UserDetailConfiguration(user);
    }

}
