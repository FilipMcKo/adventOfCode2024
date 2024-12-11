package com.mucko.day10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HoofItTest {

    @Test
    void gradeTrails() {
        HoofIt h = new HoofIt();
        assertEquals(81, h.gradeTrails("day10/test.txt"));
    }
}
