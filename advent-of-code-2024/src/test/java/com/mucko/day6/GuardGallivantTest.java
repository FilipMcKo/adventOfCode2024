package com.mucko.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuardGallivantTest {

    @Test
    void countSteps() {
        GuardGallivant gallivant = new GuardGallivant();
        assertEquals(41, gallivant.countSteps("day6/test.txt"));
        assertEquals(6, gallivant.countPossibleObstaclse("day6/test.txt"));
    }
}