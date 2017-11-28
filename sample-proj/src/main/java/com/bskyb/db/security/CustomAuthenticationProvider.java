package com.bskyb.db.security;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.util.StringUtils;

public class CustomAuthenticationProvider extends BasicAuthenticationProvider {
	
	private String passwordAlgorithm;

	public CustomAuthenticationProvider(DataSource dataSource, String passwordAlgorithm) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
		
		this.passwordAlgorithm = passwordAlgorithm;
		
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		try {
			String password = getPassword(authentication.getName());

			if (!StringUtils.isEmpty(password) && password.equalsIgnoreCase(getPasswordDigest(passwordAlgorithm, authentication.getCredentials().toString()))) {

				System.out.println("--login success--");
				
			} else {

				throw new BadCredentialsException("Bad Credentials");
			}

			UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(authentication);
			
			return authenticationToken;

		} catch (Exception e) {
			throw new BadCredentialsException("Bad Credentials");
		}

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
