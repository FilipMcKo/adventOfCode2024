package com.mucko.day11;

import com.mucko.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlutonianPebbles {
    public int countStones(String path) {
        List<String> strings = Utils.readInputData(path);
        List<String> stones = Arrays.stream(strings.get(0).split(" ")).toList();
        List<Long> splitStones = splitThoseStones(stones);
        return splitStones.size();
    }

    private List<Long> splitThoseStones(List<String> stones) {
        List<Long> numberStones = stones.stream().map(Long::valueOf).toList();
        for (int i = 0; i < 75; i++) {
            numberStones = splitThemAlready(numberStones);
            System.out.println(i);
        }

        return numberStones;
    }

    private List<Long> splitThemAlready(List<Long> numberStones) {
        List<Long> numbers = new ArrayList<>();
        for (Long numberStone : numberStones) {
            if (numberStone == 0) {
                numbers.add(1L);
            } else if (numberStone.toString().length() % 2 == 0) {
                numbers.add(firstHalf(numberStone));
                numbers.add(secondHalf(numberStone));
            } else {
                numbers.add(numberStone * 2024);
            }
        }
        return numbers;
    }

    private List<Long> splitThemAlreadyStream(Long numberStone) {
        List<Long> numbers = new ArrayList<>();

            if (numberStone == 0) {
                numbers.add(1L);
            } else if (numberStone.toString().length() % 2 == 0) {
                numbers.add(firstHalf(numberStone));
                numbers.add(secondHalf(numberStone));
            } else {
                numbers.add(numberStone * 2024);
            }

        return numbers;
    }

    private Long secondHalf(Long numberStone) {
        return Long.valueOf(numberStone.toString().substring(0, numberStone.toString().length() / 2));
    }

    private Long firstHalf(Long numberStone) {
        return Long.valueOf(numberStone.toString().substring(numberStone.toString().length() / 2));
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
