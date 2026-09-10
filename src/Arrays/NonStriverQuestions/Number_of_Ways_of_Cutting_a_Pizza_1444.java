package Arrays.NonStriverQuestions;

import java.util.*;

public class Number_of_Ways_of_Cutting_a_Pizza_1444 {
    static final int MOD = 1_000_000_007;
    int[][] pre;
    int[][][] dp;
    int m, n;

    public int ways(String[] pizza, int k) {
        m = pizza.length;
        n = pizza[0].length();

        pre = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                pre[i][j] = (pizza[i].charAt(j) == 'A' ? 1 : 0)
                        + pre[i + 1][j]
                        + pre[i][j + 1]
                        - pre[i + 1][j + 1];
            }
        }

        dp = new int[m][n][k];
        for (int[][] row : dp)
            for (int[] col : row)
                Arrays.fill(col, -1);

        return dfs(0, 0, k - 1);
    }

    private int dfs(int r, int c, int cuts) {
        if (pre[r][c] == 0) return 0;
        if (cuts == 0) return 1;
        if (dp[r][c][cuts] != -1) return dp[r][c][cuts];

        long ans = 0;

        for (int nr = r + 1; nr < m; nr++) {
            if (pre[r][c] - pre[nr][c] > 0) {
                ans += dfs(nr, c, cuts - 1);
                if (ans >= MOD) ans -= MOD;
            }
        }

        for (int nc = c + 1; nc < n; nc++) {
            if (pre[r][c] - pre[r][nc] > 0) {
                ans += dfs(r, nc, cuts - 1);
                if (ans >= MOD) ans -= MOD;
            }
        }

        return dp[r][c][cuts] = (int) ans;
    }
}
