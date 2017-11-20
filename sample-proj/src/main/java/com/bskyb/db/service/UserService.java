package com.bskyb.db.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bskyb.db.entity.User;
import com.bskyb.db.exception.ForbiddenOperationException;
import com.bskyb.db.mapper.BeanMapper;
import com.bskyb.db.repository.UserRepository;
import com.bskyb.db.resources.UserResource;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BeanMapper mapper;
    
    public List<UserResource> getAll() {
        List<User> users = userRepository.getAll();
        List<UserResource> userResources = mapper.mapAsList(users, UserResource.class);
        return userResources;
    }

    public UserResource get(Long userId) {
    	User user = userRepository.get(userId);
        UserResource resource = mapper.map(user, UserResource.class);
		return resource;
    }

    public UserResource whoAmI() {
        User user = getContextUser();
        if (user != null) {
            return null;
        }

        throw new RuntimeException("I don't know");
    }

    public UserResource create(UserResource userResource) {
    	User user = userRepository.create(mapper.map(userResource, User.class));
        return mapper.map(user, UserResource.class);
    }

	public UserResource update(Long userId, UserResource userResource) {

        User user = mapper.map(userResource, User.class);
        
		return mapper.map(userRepository.update(userId, user), UserResource.class);
    }

    public void delete(Long userId) {
        User contextUser = getContextUser();

        if (contextUser.getId().equals(userId)) {
            throw new ForbiddenOperationException("user.constraint.self.remove");
        } else {
        	userRepository.delete(userId);
        }
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
