package com.bskyb.db.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.bskyb.db.entity.User;
import com.bskyb.db.exception.ForbiddenOperationException;
import com.bskyb.db.exception.InvalidArgumentException;
import com.bskyb.db.resources.UserResource;


@Service
public class UserService {

    public List<UserResource> getAll() {
        
        return null;
    }

    public UserResource get(Long userId) {
        return null;
    }

    public UserResource whoAmI() {
        User user = getContextUser();
        if (user != null) {
            return null;
        }

        throw new RuntimeException("I don't know");
    }

    public UserResource create(UserResource userResource) {
        return null;
    }

	public UserResource update(Long userId, UserResource userResource) {
        User currentUser = new User();

        // Prevent converting ldap to non-ldap account without supplying a password
        if (hasDirtyState(currentUser, userResource)) {
            throw new InvalidArgumentException("user.constraint.ldap.to.non.ldap.no.password");
        }

        if (keepPassword(userResource)) {
            userResource.setPassword(currentUser.getPassword());
        } else if (userResource.isLDAP()) {
            userResource.setPassword(null);
        }

        return null;
    }

    public void delete(Long userId) {
        User contextUser = getContextUser();

        if (contextUser.getId().equals(userId)) {
            throw new ForbiddenOperationException("user.constraint.self.remove");
        } else {
            //repository delete
        	
        }
    }

    private boolean keepPassword(UserResource userResource) {
        return userResource.isNonLDAP() && StringUtils.isEmpty(userResource.getPassword());
    }

    private boolean hasDirtyState(User user, UserResource userResource) {
        return StringUtils.isEmpty(user.getPassword()) && userResource.isNonLDAP() && StringUtils.isEmpty(userResource.getPassword());
    }

    private User getContextUser () {
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            String username = authentication.getName();
            return userRepository.get(username);
        }*/

        return null;
    }

}
