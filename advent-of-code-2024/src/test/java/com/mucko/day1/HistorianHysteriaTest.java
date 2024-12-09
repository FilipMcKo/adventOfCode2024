package com.mucko.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistorianHysteriaTest {


    @Test
    void findDistances() {
        HistorianHysteria hist = new HistorianHysteria();
        assertEquals(11, hist.findDistances("day1/test.txt"));
        assertEquals(31, hist.checkSimilarityScore("day1/test.txt"));
    }
}