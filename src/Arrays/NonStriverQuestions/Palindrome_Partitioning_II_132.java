package Arrays.NonStriverQuestions;

public class Palindrome_Partitioning_II_132 {
    public int minCut(String s) {
        int n = s.length();

        if (n <= 1) return 0;

        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = i - 1;
        }

        for (int center = 0; center < n; center++) {

            for (int l = center, r = center;
                 l >= 0 && r < n && s.charAt(l) == s.charAt(r);
                 l--, r++) {

                dp[r + 1] = Math.min(dp[r + 1], dp[l] + 1);
            }

            for (int l = center, r = center + 1;
                 l >= 0 && r < n && s.charAt(l) == s.charAt(r);
                 l--, r++) {

                dp[r + 1] = Math.min(dp[r + 1], dp[l] + 1);
            }
        }

        return dp[n];
    }
}
