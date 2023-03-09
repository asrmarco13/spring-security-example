package it.example.securityexample.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import it.example.securityexample.model.Authorities;
import it.example.securityexample.model.Users;
import lombok.Getter;
import lombok.Setter;

/**
 * *Author: Marco Orfei
 * *The Class UserDetailConfiguration
 */
@Getter
@Setter
public class UserDetailConfiguration implements UserDetails {

    private Users user;

    public UserDetailConfiguration(Users user) {
        this.user = user;
    }

    /**
     * @return Collection<? extends GrantedAuthority>
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authorities> roles = user.getAuthorities();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Authorities role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        return authorities;
    }

    /**
     * @return String
     */
    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return user.getPassword();
    }

    /**
     * @return String
     */
    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return user.getUsername();
    }

    /**
     * @return boolean
     */
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return user.getAccountNonExpired();
    }

    /**
     * @return boolean
     */
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return user.getAccountNonLocked();
    }

    /**
     * @return boolean
     */
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return user.getCredentialsNonExpired();
    }

    /**
     * @return boolean
     */
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return user.getEnabled();
    }

}
