package com.bskyb.db.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.bskyb.db.resources.Role;
import com.bskyb.db.resources.Territory;

@Embeddable
public class UserRole {

    @Column(name = "role", nullable = false, length = 16)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "territory", nullable = false, length = 3)
    @Enumerated(EnumType.STRING)
    private Territory territory;

    public UserRole() { }

    public UserRole(Role role, Territory territory) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        return new EqualsBuilder()
                .append(role, userRole.role)
                .append(territory, userRole.territory)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(role)
                .append(territory)
                .toHashCode();
    }
}
