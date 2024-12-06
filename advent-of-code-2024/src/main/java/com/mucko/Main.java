package com.mucko;

import com.mucko.day2.RedNosedReports;
import com.mucko.day3.MullItOver;
import com.mucko.day4.CeresSearch;
import com.mucko.day5.PrintQueue;

public class Main {
    public static void main(String[] args) {
        PrintQueue queue = new PrintQueue();
        //System.out.println(queue.sumQueue("day5/input.txt"));
        System.out.println(queue.sumFixQueue("day5/input.txt"));
    }
}
