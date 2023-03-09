package it.example.securityexample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * *Author: Marco Orfei
 * *The Class SecurityConfig
 */
@Configuration
@EnableWebSecurity
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

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests((authorize) -> authorize
                        .mvcMatchers(HttpMethod.GET, "/security").permitAll()
                        .mvcMatchers(HttpMethod.GET, "/security/user").hasAuthority("ROLE_USER")
                        .mvcMatchers(HttpMethod.GET, "/security/admin").hasAuthority("ROLE_ADMINISTRATOR")
                        .anyRequest().denyAll())
                .httpBasic()
                .and()
                .formLogin();
        return httpSecurity.build();
    }
}
