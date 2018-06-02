package com.smava.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sudhanva on 5/31/18
 * @project smava
 */

public enum Banks {

    Kredit2Day("kredit2day"),
    SWK_BANK("swk"),
    BANK_OF_SCOTLAND("bankofscotland");

    private String displayName;

    Banks ( String displayName ) {
        this.displayName = displayName;
    }

    public String displayName () {
        return displayName;
    }

    @Override
    public String toString () {
        return displayName;
    }
}

