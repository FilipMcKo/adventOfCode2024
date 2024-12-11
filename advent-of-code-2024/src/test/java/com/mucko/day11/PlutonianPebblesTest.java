package com.mucko.day11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlutonianPebblesTest {

    @Test
    void countStones() {
        PlutonianPebbles pebbles = new PlutonianPebbles();
        assertEquals(55312, pebbles.countStones("day11/test.txt"));
    }
}
