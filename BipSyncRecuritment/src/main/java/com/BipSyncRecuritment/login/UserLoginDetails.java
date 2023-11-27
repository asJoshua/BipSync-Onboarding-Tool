package com.BipSyncRecuritment.login;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserLoginDetails implements UserDetails {


    private String username;
    private String password;

    private String userFirstName;
    private String userLastName;

    private Collection<? extends GrantedAuthority> authorities;


    public UserLoginDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
                             String userFirstName,String userLastName) {

        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;


    }
    public String getUserFirstName() {
        return userFirstName;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }

    @Override
    public String getPassword() {

        return password;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

}