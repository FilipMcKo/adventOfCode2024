package com.mucko.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CeresSearchTest {

    @Test
    void searchForXmas() {
        CeresSearch ceresSearch = new CeresSearch();
        assertEquals(18, ceresSearch.searchForXmas("day4/test.txt"));
        assertEquals(9, ceresSearch.searchForXmas2("day4/test2.txt"));
        assertEquals(1905, ceresSearch.searchForXmas2("day4/input.txt"));
        assertEquals(2613, ceresSearch.searchForXmas("day4/input.txt"));
    }
}