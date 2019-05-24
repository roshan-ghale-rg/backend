package com.uhcl.amazonsellers.Utilities;

import java.sql.Timestamp;
import java.time.Instant;

public class DateUtilities {

    public static String getCurrentTimeStampInstant(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Instant instant = timestamp.toInstant();
        return instant.toString();
    }
}
