package Arrays.NonStriverQuestions;

public class Cracking_the_safe_753 {
    public String crackSafe(int n, int k) {
        int states = 1;
        for (int i = 1; i < n; i++) states *= k;

        boolean[] used = new boolean[states * k];
        StringBuilder ans = new StringBuilder(states * k + n - 1);

        dfs(0, states, k, used, ans);

        ans.append("0".repeat(n - 1));
        return ans.toString();
    }

    private void dfs(int node, int states, int k, boolean[] used, StringBuilder ans) {
        for (int digit = 0; digit < k; digit++) {
            int edge = node * k + digit;

            if (!used[edge]) {
                used[edge] = true;
                dfs((node * k + digit) % states, states, k, used, ans);
                ans.append((char) ('0' + digit));
            }
        }
    }
}
