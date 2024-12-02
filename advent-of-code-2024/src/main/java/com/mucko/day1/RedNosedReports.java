package com.mucko.day1;

import com.mucko.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedNosedReports {
    public int countSafe(String inputFile) {
        List<String> safes = checkReportsWithRemoval(inputFile);
        //List<String> safes = checkReports(inputFile);
        int count = 0;
        for (String safe : safes) {
            if (safe.equals("Safe")) count++;
        }
        return count;
    }

    public List<String> checkReports(String inputFile) {
        List<String> input = Utils.readInputData(inputFile);
        ArrayList output = new ArrayList();
        for (String line : input) {
            List<String> singleLine = Arrays.stream(line.split(" ")).toList();
            output.add(checkLine(singleLine));
        }
        return output;
    }

    public List<String> checkReportsWithRemoval(String inputFile) {
        List<String> input = Utils.readInputData(inputFile);
        ArrayList output = new ArrayList();
        for (String line : input) {
            List<String> singleLine = Arrays.stream(line.split(" ")).toList();
            String answer = "Unsafe";
            for (int i = 0; i < singleLine.size(); i++) {
                List<String> smallList = new ArrayList<>();
                smallList.addAll(singleLine.subList(0, i));
                smallList.addAll(singleLine.subList(i+1, singleLine.size()));
                if(checkLine(smallList).equals("Safe")){
                    answer = "Safe";
                }
            }
            output.add(answer);
        }
        return output;
    }

    private String checkLine(List<String> lineElements) {
        List<Integer> lineNumbers = lineElements.stream().map(Integer::parseInt).toList();
        boolean increasing;
        if (lineNumbers.get(1) - lineNumbers.get(0) > 0) {
            increasing = true;
        } else if (lineNumbers.get(1) - lineNumbers.get(0) < 0) {
            increasing = false;
        } else {
            return "Unsafe";
        }

        for (int i = 1; i < lineElements.size(); i++) {
            if (Math.abs(lineNumbers.get(i - 1) - lineNumbers.get(i)) > 3 || Math.abs(lineNumbers.get(i - 1) - lineNumbers.get(i)) < 1) {
                return "Unsafe";
            }
            if (increasing) {
                if (lineNumbers.get(i) - lineNumbers.get(i - 1) < 1) {
                    return "Unsafe";
                }
            } else {
                if (lineNumbers.get(i - 1) - lineNumbers.get(i) < 1) {
                    return "Unsafe";
                }
            }
        }
        return "Safe";
    }

}
