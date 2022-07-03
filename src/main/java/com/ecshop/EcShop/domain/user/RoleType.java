package com.ecshop.EcShop.domain.user;

import lombok.Getter;

@Getter
public enum RoleType {

    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private final String role;

    RoleType(String role) {
        this.role = role;
    }

}
