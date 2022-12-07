import java.util.*;

public class P37 {
    public static void main(String[] args) {
        P37 entity = new P37();
        char[][] arr1 = new char[][]{
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        char[][] arr2 = new char[][]{
                new char[]{'.','.','9','7','4','8','.','.','.'},
                new char[]{'7','.','.','.','.','.','.','.','.'},
                new char[]{'.','2','.','1','.','9','.','.','.'},
                new char[]{'.','.','7','.','.','.','2','4','.'},
                new char[]{'.','6','4','.','1','.','5','9','.'},
                new char[]{'.','9','8','.','.','.','3','.','.'},
                new char[]{'.','.','.','8','.','3','.','2','.'},
                new char[]{'.','.','.','.','.','.','.','.','6'},
                new char[]{'.','.','.','2','7','5','9','.','.'}
        };
        char[][] arr3 = new char[][]{
                new char[]{'.','.','.','2','.','.','.','6','3'},
                new char[]{'3','.','.','.','.','5','4','.','1'},
                new char[]{'.','.','1','.','.','3','9','8','.'},
                new char[]{'.','.','.','.','.','.','.','9','.'},
                new char[]{'.','.','.','5','3','8','.','.','.'},
                new char[]{'.','3','.','.','.','.','.','.','.'},
                new char[]{'.','2','6','3','.','.','5','.','.'},
                new char[]{'5','.','3','7','.','.','.','.','8'},
                new char[]{'4','7','.','.','.','1','.','.','.'}
        };
        System.out.println();
        entity.solveSudoku(arr1);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(arr1[i]));
        }
        System.out.println();
        entity.solveSudoku(arr2);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(arr2[i]));
        }
        System.out.println();
        entity.solveSudoku(arr3);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(arr3[i]));
        }
    }

    public void solveSudoku(char[][] board) {
        dfs(board, 0);
    }

    private boolean dfs(char[][] board, int index) {
        if (index == 81) {
            return true;
        } else {
            final int row = index / 9;
            final int col = index % 9;
            if (board[row][col] == '.') {
                for (char c : candidates(board, row, col)) {
                    board[row][col] = c;
                    if (dfs(board, index + 1)) {
                        return true;
                    }
                    board[row][col] = '.'; // notice here
                }
                return false;
            } else {
                return dfs(board, index + 1);
            }
        }
    }

    private List<Character> candidates(char[][] board, int row, int col) {
        boolean[] exist = new boolean[10];
        for (int i = 0; i < 9; i++) {
            exist[toNumber(board[i][col])] = true;
            exist[toNumber(board[row][i])] = true;
            exist[toNumber(board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3])] = true;
        }
        List<Character> result = new ArrayList<>();
        for (int i = 1; i < exist.length; i++) {
            if (!exist[i]) {
                result.add((char) ('0' + i));
            }
        }
        return result;
    }

    private int toNumber(char c) {
        return c == '.' ? 0 : c - '0';
    }
}
