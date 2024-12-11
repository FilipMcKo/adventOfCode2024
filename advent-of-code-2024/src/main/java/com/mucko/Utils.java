package com.mucko;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<String> readInputData(String fileName) {
        List<String> lines = new ArrayList<>();
        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(fileName)) {
            assert inputStream != null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public static char[][] readInMatrix(String path) {
        List<String> lines = readInputData(path);
        int rows = lines.size();
        int cols = lines.get(0).length();
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = lines.get(i).charAt(j);
            }
        }
        return matrix;
    }

    public static int[][] readInMatrixIntegers(String path) {
        List<String> lines = readInputData(path);
        int rows = lines.size();
        int cols = lines.get(0).length();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Character.getNumericValue(lines.get(i).charAt(j));
            }
        }
        return matrix;
    }
}
