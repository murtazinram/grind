package org.example.sameMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.codewars.com/kata/635fc0497dadea0030cb7936/train/java
 * You have some 2*2 matrices, each matrix is represented by an array of length 4.
 * <p>
 * such as [a, b, c, d] is matrix
 * <p>
 * a b
 * c d
 * Matrix can be rotated:
 * <p>
 * a b   90 degrees  c a  180 degrees  d c  270 degrees  b d
 * c d  -----------> d b  -----------> b a  -----------> a c
 * If matrix A can be obtained by rotating matrix B clockwise by 0, 90, 180 or 270 degrees, we think that A and B are
 * the same matrix.
 * <p>
 * For example, the following matrices are considered the same.
 * <p>
 * 1 2
 * 3 4
 * <p>
 * 3 1
 * 4 2
 * <p>
 * 4 3
 * 2 1
 * <p>
 * 2 4
 * 1 3
 * The task of this kata is to count how many different matrices you have.
 * <p>
 * Samples
 * <p>
 * // Same as the above example.
 * count_different_matrices([[1, 2, 3, 4],
 * [3, 1, 4, 2],
 * [4, 3, 2, 1],
 * [2, 4, 1, 3]]);
 * <p>
 * //should return '1'
 * Notes
 * <p>
 * All the values of the elements in the matrix are between 1 and 9, and the number of matrices will not exceed 1000.
 */
public class SameMatrix {
    public static int count_different_matrices1(int[][] matrices) {
        List<String> combinations = new ArrayList<>();
        int nummberOfMatrices = 0;

        for (int i = 0; i < matrices.length; i++) {
            String a = "" + matrices[i][0] + matrices[i][1] + matrices[i][2] + matrices[i][3];
            String b = "" + matrices[i][2] + matrices[i][0] + matrices[i][3] + matrices[i][1];
            String c = "" + matrices[i][3] + matrices[i][2] + matrices[i][1] + matrices[i][0];
            String d = "" + matrices[i][1] + matrices[i][3] + matrices[i][0] + matrices[i][2];

            if (combinations.contains(a) || combinations.contains(b) || combinations.contains(c) || combinations.contains(d)) {
                continue;
            }
            nummberOfMatrices++;
            Collections.addAll(combinations, a, b, c, d);
        }

        return nummberOfMatrices;
    }

    static public int count_different_matrices(int[][] matrices) {
        int count = 1;
        int[][] ints = rotate(matrices);
        while (Arrays.deepEquals(matrices, ints)) {
            count++;
            ints = rotate(ints);
        }
        return count;
    }

    static public int[][] rotate(int[][] matrices) {

        int rows = matrices.length;
        int columns = matrices[0].length;
        int[][] rotMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                rotMatrix[i][j] = matrices[columns - 1 - j][i];
            }
        }
        return rotMatrix;
    }

    public static void main(String[] args) {
        int[][] ms;

        ms = new int[][]{
                {1, 2, 2, 1},
                {1, 1, 2, 2},
                {2, 1, 1, 2},
                {2, 1, 2, 1},
                {1, 2, 1, 2}};
        System.out.println(count_different_matrices1(ms));

    }
}
