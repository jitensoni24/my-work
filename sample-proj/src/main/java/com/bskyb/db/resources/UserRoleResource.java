package com.bskyb.db.resources;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

public class UserRoleResource {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "user.validation.role.type.suffix")
    private String role;

    public UserRoleResource() { }

    public UserRoleResource(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
