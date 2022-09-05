package it.example.securityexample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * *Author: Marco Orfei
 * *The Class SecurityConfig
 */
@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService users() {
        UserDetails userDetails = User.builder().username("user").password(passwordEncoder().encode("user"))
                .roles("USER").build();
        UserDetails adminDetails = User.builder().username("admin").password(passwordEncoder().encode("admin"))
                .roles("ADMINISTRATOR", "USER")
                .build();
        return new InMemoryUserDetailsManager(userDetails, adminDetails);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
