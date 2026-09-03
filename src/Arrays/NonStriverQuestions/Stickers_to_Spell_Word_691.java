package Arrays.NonStriverQuestions;

import java.util.*;

public class Stickers_to_Spell_Word_691 {
    private int[][] stickers;
    private int targetLength;
    private Map<String, Integer> memo;

    public int minStickers(String[] stickers, String target) {

        int n = stickers.length;

        this.stickers = new int[n][26];
        this.targetLength = target.length();
        this.memo = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (char c : stickers[i].toCharArray()) {
                this.stickers[i][c - 'a']++;
            }
        }

        memo.put("", 0);

        int ans = dfs(target);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int dfs(String target) {

        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        int[] need = new int[26];

        for (char c : target.toCharArray()) {
            need[c - 'a']++;
        }

        int first = target.charAt(0) - 'a';
        int best = Integer.MAX_VALUE;

        for (int[] sticker : stickers) {

            if (sticker[first] == 0) {
                continue;
            }

            StringBuilder next = new StringBuilder();

            for (int c = 0; c < 26; c++) {

                int remaining = need[c] - sticker[c];

                while (remaining > 0) {
                    next.append((char) ('a' + c));
                    remaining--;
                }
            }

            int sub = dfs(next.toString());

            if (sub != Integer.MAX_VALUE) {
                best = Math.min(best, sub + 1);
            }
        }

        memo.put(target, best);

        return best;
    }
}
