package com.bskyb.db.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user", 
		uniqueConstraints = @UniqueConstraint(name = "UC_USER_USERNAME", columnNames = { "username" }),
		indexes = { @Index(columnList="username", name = "IX_USER_USERNAME") }
)
public class User extends Identity {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_ROLE_USER_ID")),
            uniqueConstraints = @UniqueConstraint(name = "UC_ROLE_USER_ID_ROLE", columnNames = { "user_id", "role" })
    	)
    private Set<UserRole> roles = new HashSet<>();

    @Column(name = "address")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
    		name="user_address",
    		joinColumns = @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_ADDRESS_USER_ID")),
    		uniqueConstraints = @UniqueConstraint(name = "UC_ADDRESS_USER_ID_TYPE", columnNames = {"user_id", "type_"})
    	)
    private List<Address> address = new ArrayList<>();
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public void addRole(String role) {
        this.roles.add(new UserRole(role));
    }

    public void addRole(UserRole role) {
        this.roles.add(role);
    }

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
}
