package com.bskyb.db.resources;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public abstract class IdentityResource {

    @JsonProperty(value = "id", access = Access.READ_ONLY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
