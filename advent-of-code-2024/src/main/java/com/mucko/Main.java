package com.mucko;

import com.mucko.day1.RedNosedReports;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RedNosedReports reports = new RedNosedReports();
        System.out.println(reports.countSafe("day1/input.txt"));
    }
}
