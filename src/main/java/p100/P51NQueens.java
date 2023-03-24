package main.java.p100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P51NQueens {
    public static void main(String[] args) {
        P52NQueensII entity = new P52NQueensII();
        System.out.println();
        print(entity.solveNQueens(5));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] b : board) {
            Arrays.fill(b, '.');
        }
        solve(board, 0, n, result);
        return result;
    }

    private void solve(char[][] board, int start, int num, List<List<String>> result) {
        int len = board.length;
        if (num == 0) {
            result.add(Arrays.stream(board)
                            .map(r -> String.valueOf(r))
                            .collect(Collectors.toList()));
        } else if (start < len * len) {
            int x = start / len;
            int y = start % len;
            boolean available = true;
            for (int i = 0; i < len && available; i++) {
                available = available
                        && board[x][i] != 'Q'
                        && board[i][y] != 'Q'
                        && (x - i < 0 || y - i < 0 || board[x - i][y - i] != 'Q')
                        && (x - i < 0 || y + i > len - 1 || board[x - i][y + i] != 'Q')
                        && (x + i > len - 1 || y - i < 0 || board[x + i][y - i] != 'Q')
                        && (x + i > len - 1 || y + i > len - 1 || board[x + i][y + i] != 'Q')
                ;
            }
            if (available) {
                board[x][y] = 'Q';
                solve(board, start + 1, num - 1, result);
                board[x][y] = '.';
            }
            solve(board, start + 1, num, result);
        }
    }

    public static void print(List<List<String>> board) {
        for (List<String> list : board) {
            System.out.println(list);
        }
    }
}
