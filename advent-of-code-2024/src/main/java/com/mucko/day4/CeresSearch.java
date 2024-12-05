package com.mucko.day4;

import com.mucko.Utils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CeresSearch {
    private final String XMAS = "XMAS";
    private final String SAMX = "SAMX";
    private final String MAS = "MAS";
    private final String SAM = "SAM";

    public Integer searchForXmas(String path) {
        char[][] matrix = readInMatrix(path);
        return countXmas(matrix);
    }

    public Integer searchForXmas2(String path) {
        char[][] matrix = readInMatrix(path);
        return countMas(matrix);
    }

    private Integer countMas(char[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix.length - 2; j++) {
                char[][] smallMatrix = new char[3][3];
                smallMatrix[0][0] = matrix[i][j];
                smallMatrix[0][1] = matrix[i][j + 1];
                smallMatrix[0][2] = matrix[i][j + 2];
                smallMatrix[1][0] = matrix[i + 1][j];
                smallMatrix[1][1] = matrix[i + 1][j + 1];
                smallMatrix[1][2] = matrix[i + 1][j + 2];
                smallMatrix[2][0] = matrix[i + 2][j];
                smallMatrix[2][1] = matrix[i + 2][j + 1];
                smallMatrix[2][2] = matrix[i + 2][j + 2];
                if (checkSmallMatrix(smallMatrix)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean checkSmallMatrix(char[][] smallMatrix) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        String diagonal1 = sb1.append(smallMatrix[0][0]).append(smallMatrix[1][1]).append(smallMatrix[2][2]).toString();
        String diagonal2 = sb2.append(smallMatrix[0][2]).append(smallMatrix[1][1]).append(smallMatrix[2][0]).toString();
        boolean foo1 = diagonal1.equals(SAM) || diagonal1.equals(MAS);
        boolean foo2 = diagonal2.equals(SAM) || diagonal2.equals(MAS);
        return foo1 && foo2;
    }

    private Integer countXmas(char[][] matrix) {
        int count = 0;
        count += countHorizontal(matrix);
        count += countVertical(matrix);
        count += countDiagonal(matrix);
        return count;
    }

    private int countDiagonal(char[][] matrix) {
        int count = 0;
        List<String> lines = new ArrayList<String>();
        for (int i = 0; i < matrix[0].length; i++) {
            StringBuffer sb1 = new StringBuffer();
            for (int j = 0; j < matrix[0].length - i; j++) {
                sb1.append(matrix[j][j + i]);
            }
            lines.add(sb1.toString());

        }
        for (int i = 1; i < matrix[0].length; i++) {
            StringBuffer sb2 = new StringBuffer();
            for (int j = 0; j < matrix[0].length - i; j++) {
                sb2.append(matrix[i + j][j]);
            }
            lines.add(sb2.toString());
        }
        for (int i = 0; i < matrix[0].length; i++) {
            StringBuffer sb1 = new StringBuffer();
            for (int k = 0, j = matrix[0].length - 1; j >= 0; k++, j--) {
                if (k + i > matrix[0].length - 1) {
                    break;
                }
                sb1.append(matrix[i + k][j]);
            }
            lines.add(sb1.toString());
        }
        for (int i = 0; i < matrix[0].length; i++) {
            StringBuffer sb1 = new StringBuffer();
            for (int k = 0, j = matrix[0].length - 2; j >= 0; k++, j--) {
                if (j - i < 0) {
                    break;
                }
                sb1.append(matrix[k][j - i]);
            }
            lines.add(sb1.toString());
        }
        for (String line : lines) {
            count += StringUtils.countMatches(line, XMAS);
            count += StringUtils.countMatches(line, SAMX);
        }
        return count;
    }

    private int countVertical(char[][] matrix) {
        int count = 0;
        List<String> lines = new ArrayList<String>();
        for (int i = 0; i < matrix[0].length; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < matrix.length; j++) {
                sb.append(matrix[j][i]);
            }
            lines.add(sb.toString());
        }

        for (String line : lines) {
            count += StringUtils.countMatches(line, XMAS);
            count += StringUtils.countMatches(line, SAMX);
        }
        return count;
    }

    private int countHorizontal(char[][] matrix) {
        int count = 0;
        List<String> lines = new ArrayList<String>();
        for (int i = 0; i < matrix.length; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]);
            }
            lines.add(sb.toString());
        }

        for (String line : lines) {
            count += StringUtils.countMatches(line, XMAS);
            count += StringUtils.countMatches(line, SAMX);
        }
        return count;
    }

    private char[][] readInMatrix(String path) {
        List<String> lines = Utils.readInputData(path);
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

}
