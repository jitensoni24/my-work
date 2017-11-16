package com.bskyb.db.mapper;

import org.springframework.stereotype.Component;

import com.bskyb.db.entity.UserRole;
import com.bskyb.db.resources.UserRoleResource;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class UserRoleMapper extends CustomMapper<UserRole, UserRoleResource> {

    @Override
    public void mapAtoB(UserRole userRole, UserRoleResource userRoleResource, MappingContext context) {
        userRoleResource.setRole(userRole.getRole());
    }

    @Override
    public void mapBtoA(UserRoleResource userRoleResource, UserRole userRole, MappingContext context) {
        userRole.setRole(userRoleResource.getRole());
    }

}
