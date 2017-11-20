package com.bskyb.db.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.bskyb.db.entity.User;

import net.jodah.expiringmap.ExpiringMap;

public class StatusManager {

    private Map<String, User> userMap ;
    
    public StatusManager() {
    	userMap = ExpiringMap.builder().expiration(5L, TimeUnit.SECONDS).build();
	}

    public User addEntry(String userId, User user) {
        
        User u = userMap.putIfAbsent(userId, user);
        
        return u;
    }

    public Map<String, User> getAllStatusList() {
        return userMap != null ? userMap : new HashMap<String, User>();
    }
}

