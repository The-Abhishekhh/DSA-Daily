package Arrays.NonStriverQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.*;
public class Word_Ladder_2_126 {
    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {

        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return new ArrayList<>();
        }

        // child -> all possible parents on shortest paths
        Map<String, List<String>> parents = new HashMap<>();

        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);

        boolean found = false;

        while (!currentLevel.isEmpty() && !found) {

            // Remove words only after finishing the current level.
            // This allows multiple parents from the same level.
            words.removeAll(currentLevel);

            Set<String> nextLevel = new HashSet<>();

            for (String word : currentLevel) {

                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {

                    char original = chars[i];

                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == original) {
                            continue;
                        }

                        chars[i] = c;

                        String next = new String(chars);

                        if (!words.contains(next)) {
                            continue;
                        }

                        // next can have multiple parents
                        parents
                                .computeIfAbsent(next, k -> new ArrayList<>())
                                .add(word);

                        nextLevel.add(next);

                        if (next.equals(endWord)) {
                            found = true;
                        }
                    }

                    chars[i] = original;
                }
            }

            currentLevel = nextLevel;
        }

        if (!found) {
            return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();

        List<String> path = new ArrayList<>();
        path.add(endWord);

        buildPaths(endWord, beginWord, parents, path, result);

        return result;
    }

    private void buildPaths(
            String word,
            String beginWord,
            Map<String, List<String>> parents,
            List<String> path,
            List<List<String>> result) {

        if (word.equals(beginWord)) {

            List<String> sequence = new ArrayList<>(path);
            Collections.reverse(sequence);

            result.add(sequence);

            return;
        }

        for (String parent : parents.getOrDefault(word, Collections.emptyList())) {

            path.add(parent);

            buildPaths(parent, beginWord, parents, path, result);

            path.remove(path.size() - 1);
        }
    }
}
