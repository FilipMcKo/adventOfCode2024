package com.mucko;

import com.mucko.day9.DiskFragmenter;

public class Main {
    public static void main(String[] args) {
        DiskFragmenter fragmenter = new DiskFragmenter();
        System.out.println(fragmenter.calculateCheckSum3("day9/input.txt"));
    }
}
