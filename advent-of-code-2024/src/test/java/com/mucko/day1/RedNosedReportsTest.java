package com.mucko.day1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class RedNosedReportsTest {

    @Test
    void checkReports() {
        String filePath = "day1/test.txt";
        List<String> expectedResults = Arrays.asList("Safe", "Unsafe", "Unsafe", "Unsafe", "Unsafe", "Safe");
        RedNosedReports reports = new RedNosedReports();
        List<String> results = reports.checkReports(filePath);
        System.out.println(results.toArray());
        assert results.equals(expectedResults);
    }

    @Test
    void checkReportsWithRemoval() {
        String filePath = "day1/test.txt";
        List<String> expectedResults = Arrays.asList("Safe", "Unsafe", "Unsafe", "Safe", "Safe", "Safe");
        RedNosedReports reports = new RedNosedReports();
        List<String> results = reports.checkReportsWithRemoval(filePath);
        System.out.println(results.toArray());
        assert results.equals(expectedResults);
    }
}