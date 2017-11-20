package com.bskyb.db.mapper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.bskyb.db.entity.User;
import com.bskyb.db.entity.UserRole;
import com.bskyb.db.resources.UserResource;
import com.bskyb.db.resources.UserRoleResource;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class UserMapper extends CustomMapper<User, UserResource> {

	@Autowired
	private Environment env;

	@Autowired
	private BeanMapper orikaBeanMapper;

	@Override
	public void mapAtoB(User user, UserResource userResource, MappingContext context) {
		super.mapAtoB(user, userResource, context);
		userResource.setPassword(null);
		userResource.setRoles(orikaBeanMapper.mapAsList(user.getRoles(), UserRoleResource.class));
	}

	@Override
	public void mapBtoA(UserResource userResource, User user, MappingContext context) {
		user.setRoles(orikaBeanMapper.mapAsSet(userResource.getRoles(), UserRole.class));

		String password = userResource.getPassword();

		if (StringUtils.isNotEmpty(password)) {
			try {
				if (!password.matches("[0-9a-f]+")) {
					MessageDigest md = MessageDigest.getInstance(env.getProperty("sample.bskyb.password.algorithm"));
					md.update(password.getBytes());
					password = Hex.encodeHexString(md.digest());
				}

				user.setPassword(password);
			} catch (NoSuchAlgorithmException e) {
				throw new RuntimeException(e);
			}
		}

	}

}
