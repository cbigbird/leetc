import java.util.Arrays;

public class P36 {
    public static void main(String[] args) {
        P36 entity = new P36();
        char[][] arr1 = new char[][]{
                new char[]{'5','3','.','.','7','.','.','.','.'},
                new char[]{'6','.','.','1','9','5','.','.','.'},
                new char[]{'.','9','8','.','.','.','.','6','.'},
                new char[]{'8','.','.','.','6','.','.','.','3'},
                new char[]{'4','.','.','8','.','3','.','.','1'},
                new char[]{'7','.','.','.','2','.','.','.','6'},
                new char[]{'.','6','.','.','.','.','2','8','.'},
                new char[]{'.','.','.','4','1','9','.','.','5'},
                new char[]{'.','.','.','.','8','.','.','7','9'},
        };
        char[][] arr2 = new char[][]{
                new char[]{'8','3','.','.','7','.','.','.','.'},
                new char[]{'6','.','.','1','9','5','.','.','.'},
                new char[]{'.','9','8','.','.','.','.','6','.'},
                new char[]{'8','.','.','.','6','.','.','.','3'},
                new char[]{'4','.','.','8','.','3','.','.','1'},
                new char[]{'7','.','.','.','2','.','.','.','6'},
                new char[]{'.','6','.','.','.','.','2','8','.'},
                new char[]{'.','.','.','4','1','9','.','.','5'},
                new char[]{'.','.','.','.','8','.','.','7','9'},
        };
        char[][] arr3 = new char[][]{
                new char[]{'.','.','.','.','5','.','.','1','.'},
                new char[]{'.','4','.','3','.','.','.','.','.'},
                new char[]{'.','.','.','.','.','3','.','.','1'},
                new char[]{'8','.','.','.','.','.','.','2','.'},
                new char[]{'.','.','2','.','7','.','.','.','.'},
                new char[]{'.','1','5','.','.','.','.','.','.'},
                new char[]{'.','.','.','.','.','2','.','.','.'},
                new char[]{'.','2','.','9','.','.','.','.','.'},
                new char[]{'.','.','4','.','.','.','.','.','.'}
        };
        System.out.println();
//        System.out.println(entity.isValidSudoku(arr1));
//        System.out.println(entity.isValidSudoku(arr2));
        System.out.println(entity.isValidSudoku(arr3));
    }

    public boolean isValidSudoku(char[][] board) {
        final int SIZE = 9;
        final int SIZE_SMALL = 3;
        boolean[] appears = new boolean[SIZE];

        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(appears, false);
            for (int j = 0; j < SIZE; j++) {
                if (!check(board[i][j], appears)) {
                    return false;
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(appears, false);
            for (int j = 0; j < SIZE; j++) {
                if (!check(board[j][i], appears)) {
                    return false;
                }
            }
        }
        for (int i = 0; i < SIZE; i = i + 3) {
            for (int j = 0; j < SIZE; j = j + 3) {
                Arrays.fill(appears, false);
                for (int a = i; a < i + SIZE_SMALL; a++) {
                    for (int b = j; b < j + SIZE_SMALL; b++) {
                        if (!check(board[a][b], appears)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean check(char c, boolean[] appears) {
        final char EMPTY = '.';
        final int num = c - '1';
        if (c == EMPTY) {
            // skip
        } else if (appears[num]) {
            return false;
        } else {
            appears[num] = true;
        }
        return true;
    }
}
