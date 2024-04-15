package com.banking.banking.entity;

import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {
    private final String role;


    public CustomGrantedAuthority(Role role) {
        this.role = role.getName();
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
