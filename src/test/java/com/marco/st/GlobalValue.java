package com.marco.st;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GlobalValue {

    public static String MARCO_VALUE;

    @Value("${com.marco.test.value}")
    public void setMarcoTestValue(String value) {
        MARCO_VALUE = value;
    }
}
