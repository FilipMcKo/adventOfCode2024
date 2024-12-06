package com.mucko.day5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintQueueTest {

    @Test
    void sumQueueTest(){
        PrintQueue pq = new PrintQueue();
        assertEquals(143, pq.sumQueue("day5/test.txt"));
        assertEquals(123, pq.sumFixQueue("day5/test.txt"));
    }

}