package com.bskyb.db.util;

public class Regexp {
    public static final String USERNAME = "^[a-zA-Z0-9_-]{4,16}$";
    public static final String PASSWORD = "^(?=.*\\d).{8,16}$";
    public static final String BASE64_IMAGE = "data:image/(jpg|jpeg|png);base64,([^\"]*)";
}
