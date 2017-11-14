package com.bskyb.db.resources;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.bskyb.db.util.Regexp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@SuppressWarnings("deprecation")
public class UserResource {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean active;

    @NotEmpty(message = "validation.base.not.empty")
    @Pattern(regexp = Regexp.USERNAME, message = "user.validation.username.suffix")
    private String username;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Pattern(regexp = Regexp.PASSWORD, message = "user.validation.password.suffix")
    private String password;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Email(message = "user.validation.email.suffix")
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "user.validation.type.suffix")
    private AccountType accountType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Valid
    private List<UserRoleResource> roles = new ArrayList<UserRoleResource>();

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @JsonIgnore
    public boolean isLDAP() {
        return accountType.equals(AccountType.LDAP);
    }

    @JsonIgnore
    public boolean isNonLDAP() {
        return accountType.equals(AccountType.NON_LDAP);
    }

    public List<UserRoleResource> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRoleResource> roles) {
        this.roles = roles;
    }
}
