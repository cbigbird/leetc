package p100;

import java.util.ArrayList;
import java.util.List;

public class P54SpiralMatrix {
    public static void main(String[] args) {
        P54SpiralMatrix entity = new P54SpiralMatrix();
        int[][] a1 = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] a2 = new int[][] {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int[][] a3 = new int[][] {
                { 1, 2, 3, 4},
                { 5, 6, 7, 8},
                { 9,10,11,12},
                {13,14,15,16},
                {17,18,19,20},
                {21,22,23,24},
        };
        int[][] a4 = new int[][] {
                {6,9,7},
        };
        int[][] a5 = new int[][] {
                {6},
                {9},
                {7},
        };
        System.out.println();
        System.out.println(entity.spiralOrder(a1));
        System.out.println(entity.spiralOrder(a2));
        System.out.println(entity.spiralOrder(a3));
        System.out.println(entity.spiralOrder(a4));
        System.out.println(entity.spiralOrder(a5));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);
        df(matrix, 0, result);
        return result;
    }

    private void df(int[][] matrix, int n, List<Integer> result) {
        int height = matrix.length - 2 * n;
        int width = matrix[0].length - 2 * n;
        if (height == 1) {
            for (int i = n; i < width + n; i++) {
                result.add(matrix[n][i]);
            }
        } else if (width == 1) {
            for (int i = n; i < height + n; i++) {
                result.add(matrix[i][width + n - 1]);
            }
        } else if (height > 0 && width > 0) {
            for (int i = n; i < width + n - 1; i++) {
                result.add(matrix[n][i]);
            }
            for (int i = n; i < height + n - 1; i++) {
                result.add(matrix[i][width + n - 1]);
            }
            for (int i = width + n - 1; i > n; i--) {
                result.add(matrix[height + n - 1][i]);
            }
            for (int i = height + n - 1; i > n; i--) {
                result.add(matrix[i][n]);
            }
            df(matrix, n + 1, result);
        }
    }
}
