package com.mucko.day5;

import com.mucko.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PrintQueue {
    public int sumQueue(String path) {
        List<String> lines = Utils.readInputData(path);
        return countMiddleNumbers(lines);
    }

    public int sumFixQueue(String path) {
        List<String> lines = Utils.readInputData(path);
        return countFixedMiddleNumbers(lines);
    }

    private int countMiddleNumbers(List<String> lines) {
        int count = 0;
        List<String> rules = new ArrayList<>();
        List<String> queues = new ArrayList<>();
        boolean flag = false;
        for (String line : lines) {
            if (!flag) {
                rules.add(line);
            }
            if (line.trim().isBlank()) {
                flag = true;
            }
            if (flag) {
                queues.add(line);
            }
        }

        for (String queue : queues) {
            List<String> queueList = List.of(queue.split(","));
            if (!queue.isBlank() && checkQueue(queueList, rules)) {
                count += Integer.parseInt(queueList.get(queueList.size() / 2));
            }
        }

        return count;
    }

    private int countFixedMiddleNumbers(List<String> lines) {
        int count = 0;
        List<String> rules = new ArrayList<>();
        List<String> queues = new ArrayList<>();
        boolean flag = false;
        for (String line : lines) {
            if (!flag) {
                rules.add(line);
            }
            if (line.trim().isBlank()) {
                flag = true;
            }
            if (flag) {
                queues.add(line);
            }
        }

        for (String queue : queues) {
            List<String> queueList = List.of(queue.split(","));
            if (!queue.isBlank() && !checkQueue(queueList, rules)) {
                queueList = fixQueue(queueList, rules);
                count += Integer.parseInt(queueList.get(queueList.size() / 2));
            }
        }

        return count;
    }

    private List<String> fixQueue(List<String> queueList, List<String> rules) {
        List<String> mutableList = new ArrayList<>(queueList);
        for (String rule : rules) {
            if (!rule.isBlank()) {
                String number1 = rule.split("\\|")[0];
                String number2 = rule.split("\\|")[1];
                if (mutableList.contains(number1) && mutableList.contains(number2)) {
                    if (mutableList.indexOf(number1) > mutableList.indexOf(number2)) {
                        Collections.swap(mutableList, mutableList.indexOf(number1), mutableList.indexOf(number2));
                    }
                }
            }
        }
        if(checkQueue(mutableList, rules)) {
            return mutableList;
        }
        return fixQueue(mutableList, rules);
    }

    private boolean checkQueue(List<String> queueList, List<String> rules) {
        boolean flag = true;
        for (String rule : rules) {
            if (!rule.isBlank()) {
                String number1 = rule.split("\\|")[0];
                String number2 = rule.split("\\|")[1];
                if (queueList.contains(number1) && queueList.contains(number2)) {
                    if (queueList.indexOf(number1) > queueList.indexOf(number2)) {
                        flag = false;
                    }
                }
            }
        }
        return flag;
    }
}
