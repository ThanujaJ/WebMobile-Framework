package com.tf.utils;

import java.util.HashMap;
import java.util.Map;

public class MobileMessages extends Messages {

    private Map<String, String> errorMap = new HashMap<String, String>() {{
        put("SignInErrorMessage", "Invalid login credentials");

    }};

    public String getMessage ( String key ) {
        return errorMap.get(key);
    }
}
