package com.carex.backend.util;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {

    public DateUtil() {
    }

    public String applyStringDatePattern(String date) {
        String year = date.substring(0, 4);
        String month = date.substring(5, 7);
        String day = date.substring(8, 10);
        return year + "/" + month + "/" + day;
    }
}
