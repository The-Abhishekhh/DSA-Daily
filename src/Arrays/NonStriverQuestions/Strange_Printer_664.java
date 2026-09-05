package Arrays.NonStriverQuestions;

public class Strange_Printer_664 {
    public int strangePrinter(String s) {
        int n = s.length();
        if (n == 0) return 0;

        char[] a = new char[n];
        int m = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0 || s.charAt(i) != s.charAt(i - 1))
                a[m++] = s.charAt(i);
        }

        int[][] dp = new int[m][m];

        for (int i = 0; i < m; i++)
            dp[i][i] = 1;

        for (int len = 2; len <= m; len++) {
            for (int l = 0; l + len <= m; l++) {
                int r = l + len - 1;
                dp[l][r] = dp[l + 1][r] + 1;

                for (int k = l + 1; k <= r; k++) {
                    if (a[l] == a[k]) {
                        int middle = k == l + 1 ? 0 : dp[l + 1][k - 1];
                        dp[l][r] = Math.min(dp[l][r], middle + dp[k][r]);
                    }
                }
            }
        }

        return dp[0][m - 1];
    }
}
