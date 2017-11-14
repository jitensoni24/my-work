package com.bskyb.db.exception;

public class ForbiddenOperationException extends RuntimeException {
    private static final long serialVersionUID = -993467865671411605L;

    private Object[] args;

    public ForbiddenOperationException(String message) {
        super(message);
    }

    public ForbiddenOperationException(String message, Object... args) {
        super(message);
        this.args = args;
    }

    public Object[] getArgs() {
        return args;
    }
}
