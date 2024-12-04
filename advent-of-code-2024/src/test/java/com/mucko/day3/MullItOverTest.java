package com.mucko.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MullItOverTest {

    @Test
    void mullItOver() {
        MullItOver mullItOver = new MullItOver();
        assertEquals(48, mullItOver.mullItOver("day3/test2.txt"));
    }
}