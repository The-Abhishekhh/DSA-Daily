package Arrays.NonStriverQuestions;
import java.util.*;

public class Group_Anagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            int[] count = new int[26];

            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();

            for (int num : count) {
                key.append('#').append(num);
            }

            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
