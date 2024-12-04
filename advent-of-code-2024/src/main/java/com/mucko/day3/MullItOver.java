package com.mucko.day3;

import com.mucko.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MullItOver {

    public Integer mullItOver(String path) {
        List<List<Integer>> properMuls = findProperMuls(path);
        Integer sum = 0;
        for (List<Integer> properMul : properMuls) {
            sum += properMul.get(0) * properMul.get(1);
        }

        return sum;
    }

    private List<List<Integer>> findProperMuls(String path) {
        List<String> lines = Utils.readInputData(path);
        String consolidatedLines = String.join("", lines);
        List<String> matches = new ArrayList<>();
        Matcher matcherDos = Pattern.compile("do\\(\\).+?don't\\(\\)").matcher(consolidatedLines);
        while (matcherDos.find()) {
            Matcher matcher = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)").matcher(matcherDos.group());
            while (matcher.find()) {
                matches.add(matcher.group());
            }
        }
        return splitIntoNumberPairs(matches);
    }


    private List<List<Integer>> splitIntoNumberPairs(List<String> matches) {
        List<List<Integer>> pairs = new ArrayList<>();
        String regex = "\\d{1,3}";
        Pattern pattern = Pattern.compile(regex);
        for (String line : matches) {
            Matcher matcher = pattern.matcher(line);
            List<Integer> numbersFromSingleLine = new ArrayList<>();
            while (matcher.find()) {
                numbersFromSingleLine.add(Integer.parseInt(matcher.group()));
            }
            pairs.add(numbersFromSingleLine);

        }
        return pairs;
    }
}
