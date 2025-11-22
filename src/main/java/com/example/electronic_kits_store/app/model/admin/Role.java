package com.example.electronic_kits_store.app.model.admin;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_SUPER_ADMIN,
    ROLE_MANAGER,
    ROLE_OPERATOR;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
