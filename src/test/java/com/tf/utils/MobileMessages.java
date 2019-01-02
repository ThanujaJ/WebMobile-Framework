package com.tf.utils;

import java.util.HashMap;
import java.util.Map;

public class MobileMessages extends Messages {

    private Map<String, String> errorMap = new HashMap<String, String>() {{
        put("SignInErrorMessage", "Ihre Angaben zum Einloggen sind ungültig. Bitte versuchen Sie es erneut. Bitte beachten Sie, dass Ihr Zugang bei 3 Fehlversuchen von uns vorläufig gesperrt wird.");

    }};

    public String getMessage ( String key ) {
        return errorMap.get(key);
    }
}
