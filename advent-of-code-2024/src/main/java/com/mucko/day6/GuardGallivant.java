package com.mucko.day6;

import com.mucko.Utils;

import java.util.ArrayList;
import java.util.List;

public class GuardGallivant {
    private int dirX = 0;
    private int dirY = -1;

    public Integer countSteps(String path) {
        List<String> lines = Utils.readInputData(path);
        char[][] solved = navigateThroughMaze(lines);
        int count = 0;
        for (int i = 0; i < solved.length; i++) {
            for (int j = 0; j < solved[0].length; j++) {
                if (solved[i][j] == 'X') {
                    count++;
                }
            }
        }
        return count;
    }

    public Integer countPossibleObstaclse(String path) {
        List<String> lines = Utils.readInputData(path);
        int count = 0;
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(0).length(); j++) {
                List<String> newLines = new ArrayList<String>(lines);
                StringBuilder sb= new StringBuilder(newLines.get(i));
                sb.setCharAt(j, '#');
                newLines.set(j, sb.toString());
                if(checkIfIsInfiniteLoops(newLines)) {
                    count++;
                }
            }
        }


        return count;
    }

    private boolean checkIfIsInfiniteLoops(List<String> lines) {
        int guardPostionX = 0;
        int guardPostionY = 0;
        int rows = lines.size();
        int cols = lines.get(0).length();
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (lines.get(i).charAt(j) == '^') {
                    guardPostionX = i;
                    guardPostionY = j;
                }
                matrix[i][j] = lines.get(i).charAt(j);
            }
        }

        long l = System.currentTimeMillis();
        while (guardPostionX < cols && guardPostionY < rows) {
            matrix[guardPostionX][guardPostionY] = 'X';
            if (guardPostionX + dirY >= rows || guardPostionY + dirX >= cols||guardPostionX + dirY < 0 || guardPostionY + dirX < 0) {
                break;
            }
            if (matrix[guardPostionX + dirY][guardPostionY + dirX] == '#') {
                turnRight();
            } else {
                guardPostionX += dirY;
                guardPostionY += dirX;
            }
            if(System.currentTimeMillis() - l > 600) {
                return true;
            }
        }

        return false;
    }

    private char[][] navigateThroughMaze(List<String> lines) {
        int guardPostionX = 0;
        int guardPostionY = 0;
        int rows = lines.size();
        int cols = lines.get(0).length();
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (lines.get(i).charAt(j) == '^') {
                    guardPostionX = i;
                    guardPostionY = j;
                }
                matrix[i][j] = lines.get(i).charAt(j);
            }
        }


        while (guardPostionX < cols && guardPostionY < rows) {
            matrix[guardPostionX][guardPostionY] = 'X';
            if (guardPostionX + dirY >= rows || guardPostionY + dirX >= cols||guardPostionX + dirY < 0 || guardPostionY + dirX < 0) {
                break;
            }
            if (matrix[guardPostionX + dirY][guardPostionY + dirX] == '#') {
                turnRight();
            } else {
                guardPostionX += dirY;
                guardPostionY += dirX;
            }
        }

        return matrix;
    }

    private void turnRight() {
        if (dirX == 0 && dirY == -1) {
            dirX = 1;
            dirY = 0;
        } else if (dirX == 1 && dirY == 0) {
            dirX = 0;
            dirY = 1;
        } else if (dirX == 0 && dirY == 1) {
            dirX = -1;
            dirY = 0;
        } else if (dirX == -1 && dirY == 0) {
            dirX = 0;
            dirY = -1;
        }
    }
}
