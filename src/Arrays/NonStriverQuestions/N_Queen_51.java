package Arrays.NonStriverQuestions;

import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;

public class N_Queen_51 {
    class Solution {
        private List<List<String>> result = new ArrayList<>();
        private int n;

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            char[][] board = new char[n][n];

            for (char[] row : board)
                java.util.Arrays.fill(row, '.');

            backtrack(0, 0, 0, 0, board);
            return result;
        }

        private void backtrack(int row, int cols, int diag1, int diag2, char[][] board) {
            if (row == n) {
                List<String> solution = new ArrayList<>(n);
                for (char[] r : board)
                    solution.add(new String(r));
                result.add(solution);
                return;
            }

            int available = ((1 << n) - 1) & ~(cols | diag1 | diag2);

            while (available != 0) {
                int bit = available & -available;
                available -= bit;

                int col = Integer.numberOfTrailingZeros(bit);
                board[row][col] = 'Q';

                backtrack(
                        row + 1,
                        cols | bit,
                        (diag1 | bit) << 1,
                        (diag2 | bit) >> 1,
                        board
                );

                board[row][col] = '.';
            }
        }
    }
}
