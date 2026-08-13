package Arrays.NonStriverQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Substring_with_Concatenation_of_All_Words_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        int n = s.length();

        if (n < totalLen) {
            return result;
        }

        Map<String, Integer> targetCounts = new HashMap<>();
        for (String word : words) {
            targetCounts.put(word, targetCounts.getOrDefault(word, 0) + 1);
        }


        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> seen = new HashMap<>();

            while (right + wordLen <= n) {

                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (targetCounts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;


                    while (seen.get(word) > targetCounts.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }


                    if (count == wordCount) {
                        result.add(left);

                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                } else {

                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}
