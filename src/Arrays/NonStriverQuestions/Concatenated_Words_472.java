package Arrays.NonStriverQuestions;

import java.util.*;

public class Concatenated_Words_472 {
    static class Trie {
        Trie[] child = new Trie[26];
        boolean end;
    }

    private Trie root;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new Trie();

        for (String word : words) {
            if (!word.isEmpty()) {
                insert(word);
            }
        }

        List<String> ans = new ArrayList<>();

        for (String word : words) {
            if (word.isEmpty()) continue;

            if (canForm(word)) {
                ans.add(word);
            }
        }

        return ans;
    }

    private void insert(String word) {
        Trie node = root;

        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';

            if (node.child[c] == null) {
                node.child[c] = new Trie();
            }

            node = node.child[c];
        }

        node.end = true;
    }

    private boolean canForm(String word) {
        int n = word.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == -1) continue;

            Trie node = root;

            for (int j = i; j < n; j++) {
                node = node.child[word.charAt(j) - 'a'];

                if (node == null) break;

                if (node.end) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[i] + 1);
                }
            }
        }

        return dp[n] > 1;
    }
}
