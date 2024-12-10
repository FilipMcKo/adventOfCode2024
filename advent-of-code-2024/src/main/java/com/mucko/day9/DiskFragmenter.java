package com.mucko.day9;

import com.mucko.Utils;
import org.javatuples.Pair;

import java.util.*;

public class DiskFragmenter {
    public long calculateCheckSum(String path) {
        List<String> strings = Utils.readInputData(path);
        List<String> extended = extendDiskDescriptor(strings.get(0));
        List<String> refragmented = refragment(extended);
        return checkSum(refragmented);
    }

    public long calculateCheckSum2(String path) {
        List<String> strings = Utils.readInputData(path);
        List<Pair<Integer, String>> extended = extendDiskDescriptorIntoPairs(strings.get(0));
        List<Pair<Integer, String>> refragmented = refragmentWholeFiles(extended);
        //return checkSum(refragmented);
        return 1L;
    }

    public long calculateCheckSum3(String path) {
        List<String> strings = Utils.readInputData(path);
        List<String> extended = extendDiskDescriptor(strings.get(0));
        List<String> refragmented = refragmentWholeFilesTwo(extended);
        return checkSum(refragmented);
    }

    private List<String> refragmentWholeFilesTwo(List<String> extended) {
        for (int i = extended.size() - 1; i >= 0; i--) {
            if (!extended.get(i).equals(".")) {
                String nowReplacig = extended.get(i);
                int howManyIsToReplace = findHowManyIsThereToReplace(extended, i);
                int whereToFitIt = findAPlaceToFitIt(extended.subList(0,i), howManyIsToReplace);
                System.out.println(nowReplacig + " " + howManyIsToReplace + " " + whereToFitIt);
                if (whereToFitIt >= 0) {
                    for (int j = 0; j < howManyIsToReplace; j++) {
                        extended.set(whereToFitIt + j, nowReplacig);
                        extended.set(i-j, ".");
                    }
                }
                i = i - howManyIsToReplace + 1;
            }
        }

        return extended;
    }

    private int findAPlaceToFitIt(List<String> extended, int howManyIsToReplace) {
        int counter = 0;
        for (int i = 0; i < extended.size(); i++) {
            if (counter == howManyIsToReplace) {
                return i - counter;
            }
            if (extended.get(i).equals(".")) {
                counter++;
            } else {
                counter = 0;
            }
        }
        return -1;
    }

    private int findHowManyIsThereToReplace(List<String> extended, int i) {
        int counter = 1;
        for (int j = i; j >= 0; j--) {
            if (j - 1 >= 0) {
                if (extended.get(j).equals(extended.get(j - 1))) {
                    counter++;
                } else break;
            } else break;
        }
        return counter;
    }

    private List<Pair<Integer, String>> refragmentWholeFiles(List<Pair<Integer, String>> extended) {
        System.out.println("1");
        for (int i = extended.size() - 1; i >= 0; i--) {
            System.out.println("2");
            for (int j = 0; j < extended.size(); j++) {
                System.out.println("3");
                if (extended.get(j).getValue1().equals(".") && extended.get(i).getValue0() <= extended.get(j).getValue0()) {
                    System.out.println(extended.size());
                    List<Pair<Integer, String>> list1 = extended.subList(0, j);
                    List<Pair<Integer, String>> list2 = List.of(extended.get(i));
                    List<Pair<Integer, String>> list3 = List.of(Pair.with(extended.get(j).getValue0() - extended.get(i).getValue0(), "."));
                    List<Pair<Integer, String>> list4 = extended.subList(j + 1, extended.size());
                    List<Pair<Integer, String>> result = new ArrayList<>();
                    result.addAll(list1);
                    result.addAll(list2);
                    result.addAll(list3);
                    result.addAll(list4);
                    extended = result;
                }
            }

        }
        return extended;
    }

    private List<Pair<Integer, String>> extendDiskDescriptorIntoPairs(String s) {
        List<Pair<Integer, String>> pairs = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                pairs.add(Pair.with(Character.getNumericValue(s.charAt(i)), String.valueOf(count)));
                count++;
            } else {
                pairs.add(Pair.with(Character.getNumericValue(s.charAt(i)), "."));
            }
        }
        return pairs;

    }


    private long checkSum(List<String> refragmented) {
        long counter = 0;
        for (int i = 0; i < refragmented.size(); i++) {
            if (!Objects.equals(refragmented.get(i), ".")) counter += (long) Integer.parseInt(refragmented.get(i)) * i;
        }
        return counter;
    }

    private List<String> refragment(List<String> chars) {
        int counter = chars.size() - 1;
        for (int i = 0; i < chars.size(); i++) {
            if (chars.subList(i, chars.size()).stream().filter(a -> !Objects.equals(a, ".")).toList().isEmpty()) break;
            if (Objects.equals(chars.get(i), ".")) {
                while (Objects.equals(chars.get(counter), ".")) counter--;
                chars.set(i, chars.get(counter));
                chars.set(counter, ".");
            }
            counter = chars.size() - 1;
        }

        return chars;
    }

    private List<String> extendDiskDescriptor(String s) {
        List<String> strings = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < Character.getNumericValue(s.charAt(i)); j++) {
                    strings.add(String.valueOf(count));
                }
                count++;
            } else {
                for (int j = 0; j < Character.getNumericValue(s.charAt(i)); j++) {
                    strings.add(".");
                }
            }
        }
        return strings;
    }
}
