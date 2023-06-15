package com.shinhansec.meta.study.common.module;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckTest {

    @Test
    public void check() {
        PasswordCheck passwordCheck = new PasswordCheck();

        assertFalse(passwordCheck.check("0000"));
        assertFalse(passwordCheck.check("123"));
        assertFalse(passwordCheck.check("12345"));
        assertTrue(passwordCheck.check("1234"));

    }
}