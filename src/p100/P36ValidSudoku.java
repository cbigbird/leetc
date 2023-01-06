package p100;

import java.util.*;

public class P36ValidSudoku {
    public static void main(String[] args) {
        P36ValidSudoku entity = new P36ValidSudoku();
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
        System.out.println(entity.isValidSudoku(arr1));
        System.out.println(entity.isValidSudoku(arr2));
        System.out.println(entity.isValidSudoku(arr3));
        System.out.println();
        System.out.println(entity.isValidSudoku2(arr1));
        System.out.println(entity.isValidSudoku2(arr2));
        System.out.println(entity.isValidSudoku2(arr3));
        System.out.println();
        System.out.println(entity.isValidSudoku3(arr1));
        System.out.println(entity.isValidSudoku3(arr2));
        System.out.println(entity.isValidSudoku3(arr3));
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

    public boolean isValidSudoku2(char[][] board) {
        Map<String, Boolean> seen = new HashMap<>();
        char c;
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                c = board[i][j];
                if (c == '.') {
                    // do nothing
                } else if (seen.getOrDefault(c + "@row" + i, false)
                        || seen.getOrDefault(c + "@col" + j, false)
                        || seen.getOrDefault(c + "@box" + (i / 3) + "" + (j / 3), false)) {
                    return false;
                } else {
                    seen.put(c + "@row" + i, true);
                    seen.put(c + "@col" + j, true);
                    seen.put(c + "@box" + (i / 3) + "" + (j / 3), true);
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku3(char[][] board) {
        Set<String> seen = new HashSet<>();
        char c;
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                c = board[i][j];
                if (c != '.' && !(seen.add(c + "@row" + i)
                        && seen.add(c + "@col" + j)
                        && seen.add(c + "@box" + (i / 3) + "" + (j / 3)))) {
                    return false;
                }
            }
        }
        return true;
    }
}
