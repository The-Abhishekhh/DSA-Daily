package Arrays.NonStriverQuestions;

public class Burst_Balloons_312 {
    public int maxCoins(int[] nums) {

        int n = nums.length;

        int[] a = new int[n + 2];

        a[0] = 1;
        a[n + 1] = 1;

        System.arraycopy(nums, 0, a, 1, n);

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 1; len <= n; len++) {

            for (int left = 1; left + len - 1 <= n; left++) {

                int right = left + len - 1;

                int best = 0;

                for (int k = left; k <= right; k++) {

                    int coins =
                            dp[left][k - 1]
                                    + a[left - 1] * a[k] * a[right + 1]
                                    + dp[k + 1][right];

                    if (coins > best) {
                        best = coins;
                    }
                }

                dp[left][right] = best;
            }
        }

        return dp[1][n];
    }
}
