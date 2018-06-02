package com.smava.utils;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Sudhanva on 5/30/18
 * @project smava
 */

public class WebMessages extends Messages {

    private Map<String,String> errorMap = new HashMap<String,String>(){{
        put("SignInErrorMessage", "Ihre Angaben zum Einloggen sind ungültig. Bitte versuchen Sie es erneut. Bitte beachten Sie, dass Ihr Zugang bei 3 Fehlversuchen von uns vorläufig gesperrt wird.");
    }};

    public String getMessage(String key){
        return errorMap.get(key);
    }
}
