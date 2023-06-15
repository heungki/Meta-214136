package com.shinhansec.meta.study.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormatterTest {

    @Test
    public void formatTest() {
        Formatter formatter = new Formatter();
        assertEquals("012-34-567890", formatter.format("01234567890"));
        assertEquals("012-345-678901", formatter.format("012345678901"));
        assertEquals("012", formatter.format("012"));
        assertEquals("012.34.567890", formatter.format("01234567890", "."));

    }
}