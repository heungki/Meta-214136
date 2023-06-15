package com.shinhansec.meta.study.common.module;

import org.springframework.stereotype.Component;

@Component
public class PasswordCheck {
    public boolean check(String number) {

        if (number.length() != 4) {
            return false;
        } else {
            Integer n1 = Integer.parseInt(String.valueOf(number.charAt(0)));
            Integer n2 = Integer.parseInt(String.valueOf(number.charAt(1)));
            Integer n3 = Integer.parseInt(String.valueOf(number.charAt(2)));
            Integer n4 = Integer.parseInt(String.valueOf(number.charAt(3)));
            if (Math.sqrt(Math.sqrt(n1 * n2 * n3 * n4)) == n1) {
                return false;
            }
        }
        return true;
    }
}
