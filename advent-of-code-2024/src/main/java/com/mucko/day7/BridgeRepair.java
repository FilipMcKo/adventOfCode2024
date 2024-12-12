package com.mucko.day7;

import com.mucko.Utils;

import java.util.List;
import java.util.Random;

public class BridgeRepair {
    public long repairBridge(String path) {
        List<String> strings = Utils.readInputData(path);
        return checkEquations(strings);
    }

    private long checkEquations(List<String> strings) {
        long count = 0;
        for (String string : strings) {
            if (itIsPossible2(string)) {
           // if (itIsPossible(string)) {
                count += Long.parseLong(string.split(":")[0]);
            }
        }
        return count;
    }

    private boolean itIsPossible(String string) {
        long expectedResult = Long.parseLong(string.split(": ")[0]);
        String[] split = string.split(": ")[1].split(" ");


        for (long i = 0; i < 900000000000000L; i++) {
            long[] splitLongs = new long[split.length];
            for (int k = 0; k < split.length; k++) {
                splitLongs[k] = Long.parseLong(split[k]);
            }
            for (int j = 0; j < splitLongs.length - 1; j++) {
                if (new Random().ints(1, 3).findFirst().getAsInt() == 1) {
                    splitLongs[j + 1] = splitLongs[j] + splitLongs[j + 1];
                } else {
                    splitLongs[j + 1] = splitLongs[j] * splitLongs[j + 1];
                }
            }
            if (expectedResult == splitLongs[splitLongs.length - 1]) {
                return true;
            }
        }

        return false;
    }

    private boolean itIsPossible2(String string) {
        long expectedResult = Long.parseLong(string.split(": ")[0]);
        String[] split = string.split(": ")[1].split(" ");


        for (int i = 0; i < 5000000; i++) {
            long[] splitLongs = new long[split.length];
            for (int k = 0; k < split.length; k++) {
                splitLongs[k] = Long.parseLong(split[k]);
            }
            for (int j = 0; j < splitLongs.length - 1; j++) {
                int rand = new Random().ints(1, 4).findFirst().getAsInt();
                if (rand == 1) {
                    splitLongs[j + 1] = splitLongs[j] + splitLongs[j + 1];
                } else if (rand == 2) {
                    splitLongs[j + 1] = splitLongs[j] * splitLongs[j + 1];
                } else {
                    splitLongs[j + 1] = Long.parseLong(String.valueOf(splitLongs[j]) + splitLongs[j + 1]);
                }
            }
            if (expectedResult == splitLongs[splitLongs.length - 1]) {
                return true;
            }
        }

        return false;
    }
}
