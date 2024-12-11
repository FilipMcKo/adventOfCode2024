package com.mucko.day10;

import com.mucko.Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HoofIt {
    public int gradeTrails(String path) {
        int[][] ints = Utils.readInMatrixIntegers(path);

        return countGrade(ints);
    }

    private int countGrade(int[][] ints) {
        int gradeOfAllTrails = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[i][j] == 0) {
                    gradeOfAllTrails += countGradeOfSingleTrail2(ints, i, j);
                }
            }
        }
        return gradeOfAllTrails;
    }

    private int countGradeOfSingleTrail(int[][] originalInts, int startingy, int startingx) {
        int[][] ints = deepCopy(originalInts);
        int countOfSingleTrail = 0;
        for (int j = 0; j < 10000; j++) {
            int currenty = startingy;
            int currentx = startingx;
            for (int i = 0; i < 10000; i++) {
                if (ints[currenty][currentx] == 9) {
                    countOfSingleTrail++;
                    ints[currenty][currentx] = -1;
                    break;
                }
                int random = new Random().ints(1, 5).findFirst().getAsInt();
                if (random == 1) {
                    if (currentx == 0) {
                        continue;
                    }
                    if (ints[currenty][currentx - 1] - ints[currenty][currentx] == 1) {
                        currentx--;
                    }
                } else if (random == 2) {
                    if (currentx == ints.length - 1) {
                        continue;
                    }
                    if (ints[currenty][currentx + 1] - ints[currenty][currentx] == 1) {
                        currentx++;
                    }
                } else if (random == 3) {
                    if (currenty == 0) {
                        continue;
                    }
                    if (ints[currenty - 1][currentx] - ints[currenty][currentx] == 1) {
                        currenty--;
                    }

                } else if (random == 4) {
                    if (currenty == ints.length - 1) {
                        continue;
                    }
                    if (ints[currenty + 1][currentx] - ints[currenty][currentx] == 1) {
                        currenty++;
                    }
                }


            }
        }
        return countOfSingleTrail;
    }

    private int countGradeOfSingleTrail2(int[][] originalInts, int startingy, int startingx) {
        int[][] ints = deepCopy(originalInts);
        Set<String> hashSet = new HashSet<>();
        for (int j = 0; j < 10000; j++) {
            int currenty = startingy;
            int currentx = startingx;
            StringBuilder hash = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                if (ints[currenty][currentx] == 9) {
                    hashSet.add(hash.toString());
                    break;
                }
                int random = new Random().ints(1, 5).findFirst().getAsInt();
                if (random == 1) {
                    if (currentx == 0) {
                        continue;
                    }
                    if (ints[currenty][currentx - 1] - ints[currenty][currentx] == 1) {
                        currentx--;
                        hash.append(currenty).append(",").append(currentx).append("->").append(ints[currenty][currentx]).append("\n");
                    }
                } else if (random == 2) {
                    if (currentx == ints.length - 1) {
                        continue;
                    }
                    if (ints[currenty][currentx + 1] - ints[currenty][currentx] == 1) {
                        currentx++;
                        hash.append(currenty).append(",").append(currentx).append("->").append(ints[currenty][currentx]).append("\n");
                    }
                } else if (random == 3) {
                    if (currenty == 0) {
                        continue;
                    }
                    if (ints[currenty - 1][currentx] - ints[currenty][currentx] == 1) {
                        currenty--;
                        hash.append(currenty).append(",").append(currentx).append("->").append(ints[currenty][currentx]).append("\n");
                    }

                } else if (random == 4) {
                    if (currenty == ints.length - 1) {
                        continue;
                    }
                    if (ints[currenty + 1][currentx] - ints[currenty][currentx] == 1) {
                        currenty++;
                        hash.append(currenty).append(",").append(currentx).append("->").append(ints[currenty][currentx]).append("\n");
                    }
                }


            }

        }
        return hashSet.size();
    }

    private static int[][] deepCopy(int[][] original) {
        if (original == null) {
            return null;
        }
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i] != null ? Arrays.copyOf(original[i], original[i].length) : null;
        }
        return copy;
    }
}
