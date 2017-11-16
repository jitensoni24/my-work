package com.bskyb.db.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bskyb.db.resources.UserResource;
import com.bskyb.db.service.UserService;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<UserResource> getAll() {
        List<UserResource> all = userService.getAll();
		return all;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserResource get(@PathVariable Long userId) {
        return userService.get(userId);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/whoami", method = RequestMethod.GET)
    public UserResource whoAmI() {
        return userService.whoAmI();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public UserResource create(@RequestBody @Valid UserResource userResource) {
        return userService.create(userResource);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public UserResource update(@PathVariable Long userId, @RequestBody @Valid UserResource userResource) {
        return userService.update(userId, userResource);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }

	
}
