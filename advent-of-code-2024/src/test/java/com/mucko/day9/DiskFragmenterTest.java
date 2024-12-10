package com.mucko.day9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiskFragmenterTest {

    @Test
    void calculateCheckSum() {
        DiskFragmenter diskFragmenter = new DiskFragmenter();
        //assertEquals(1928, diskFragmenter.calculateCheckSum("day9/test.txt"));
        assertEquals(2858, diskFragmenter.calculateCheckSum3("day9/test.txt"));
    }
}