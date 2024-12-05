package com.mucko;

import com.mucko.day2.RedNosedReports;
import com.mucko.day3.MullItOver;
import com.mucko.day4.CeresSearch;

public class Main {
    public static void main(String[] args) {
        CeresSearch ceresSearch = new CeresSearch();
        System.out.println(ceresSearch.searchForXmas2("day4/input.txt"));
        System.out.println(ceresSearch.searchForXmas("day4/input.txt"));
    }
}
