package com.mucko.day1;

import com.mucko.Utils;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class HistorianHysteria {
    public int findDistances(String path) {
        List<String> strings = Utils.readInputData(path);
        Pair<List<Integer>, List<Integer>> twoLists = splitIntoTwoList(strings);
        Collections.sort(twoLists.getValue0());
        Collections.sort(twoLists.getValue1());
        int counter = 0;
        for (int i = 0; i < twoLists.getValue0().size(); i++) {
            counter += Math.abs(twoLists.getValue0().get(i) - twoLists.getValue1().get(i));
        }
        return counter;
    }

    public int checkSimilarityScore(String path) {
        List<String> strings = Utils.readInputData(path);
        Pair<List<Integer>, List<Integer>> twoLists = splitIntoTwoList(strings);
        AtomicInteger counter = new AtomicInteger(0);

        twoLists.getValue0().forEach(n ->  counter.addAndGet(twoLists.getValue1().stream().filter(m -> Objects.equals(m, n)).toList().size() * n));

        return counter.get();
    }


    private Pair<List<Integer>, List<Integer>> splitIntoTwoList(List<String> strings) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (String string : strings) {
            list1.add(Integer.parseInt(string.split(" {3}")[0]));
            list2.add(Integer.parseInt(string.split(" {3}")[1]));
        }
        return new Pair<>(list1, list2);
    }
}
