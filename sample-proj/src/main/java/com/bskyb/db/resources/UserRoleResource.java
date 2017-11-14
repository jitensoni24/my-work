package com.bskyb.db.resources;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

public class UserRoleResource {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "user.validation.role.type.suffix")
    private Role role;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "user.validation.role.territory.suffix")
    private Territory territory;

    public UserRoleResource() { }

    public UserRoleResource(Role role, Territory territory) {
        this.role = role;
        this.territory = territory;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Territory getTerritory() {
        return territory;
    }

    public void setTerritory(Territory territory) {
        this.territory = territory;
    }
}
