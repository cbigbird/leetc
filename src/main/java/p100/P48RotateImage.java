package main.java.p100;

public class P48RotateImage {
    public static void main(String[] args) {
        int[][] m1 = new int[][]{
                new int[] {1,2,3,},
                new int[] {4,5,6,},
                new int[] {7,8,9},
        };
        int[][] m2 = new int[][]{
                new int[] {5,1,9,11},
                new int[] {2,4,8,10},
                new int[] {13,3,6,7},
                new int[] {15,14,12,16},
        };
        P48RotateImage entity = new P48RotateImage();
        entity.rotate(m1);
        entity.rotate(m2);
        System.out.println();
        print(m1);
        print(m2);
    }

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int temp;
        for (int i = 0; i < (len + 1) / 2; i++) {
            for (int j = 0; j < len / 2; j++) {
                for (int k = 0, x = i, y = j; k < 4; k++) {
                    temp = x;
                    x = y;
                    y = len - 1 - temp;
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[x][y];
                    matrix[x][y] = temp;
                }
            }
        }
    }

    public static void print(int[][] m) {
        System.out.println();
        System.out.print("[");
        for (int[] a : m) {
            System.out.print("[");
            for (int i : a) {
                System.out.print(i);
                System.out.print(",");
            }
            System.out.print("],");
        }
        System.out.print("]");
    }
}
