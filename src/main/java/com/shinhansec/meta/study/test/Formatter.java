package com.shinhansec.meta.study.test;

public class Formatter {

    public String format(String number) {
        return format(number, "-");
    }
    public String format(String number, String del) {
        if (number.length() == 12) {
            return getString(number, del, 3,3, 6);

        } else if (number.length() == 11) {
            return getString(number, del, 3,2, 6);
        }
        return number;
    }

    private static String getString(String number, String del,
                                    int a, int b, int c) {
        return number.substring(0, a) +
                del +
                number.substring(a, a+b) +
                del +
                number.substring(a+b);
    }
}
