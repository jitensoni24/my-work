package com.bskyb.db.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.codec.binary.Hex;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

public abstract class BasicAuthenticationProvider implements AuthenticationProvider {

	private static final String PASSWORD_QUERY = "SELECT password FROM user WHERE username = ?";
	
    private static final String ROLE_QUERY = "SELECT role FROM user_role INNER JOIN user ON user_role.user_id = user.id WHERE username = ?";
    
    JdbcTemplate jdbcTemplate;

    String getPassword(String username) {
        try {
            return jdbcTemplate.queryForObject(PASSWORD_QUERY, String.class, username);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    UsernamePasswordAuthenticationToken getAuthenticationToken(Authentication authentication) {
        List<String> roles = getRoles(authentication.getName());
        List<GrantedAuthority> authorities = getGrantedAuthorities(roles);
        return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), authorities);
    }

    List<String> getRoles(String username) {
        return jdbcTemplate.queryForList(ROLE_QUERY, String.class, username);
    }

    List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        return roles
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    String getPasswordDigest(String algorithm, String password) throws NoSuchAlgorithmException {
        if (StringUtils.isEmpty(algorithm)) {
            return password;
        }

        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.update(password.getBytes());
        byte[] digest = md.digest();

        return Hex.encodeHexString(digest);
    }
}
