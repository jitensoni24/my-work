package com.bskyb.db.exception;

import javax.persistence.NoResultException;

public class NotFoundException extends NoResultException {
    private static final long serialVersionUID = -715267071004960993L;
    
    private Integer code;
    
    public NotFoundException() {}

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(int code, String message) {
        super(message);
        this.code = code;
    }
    
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
