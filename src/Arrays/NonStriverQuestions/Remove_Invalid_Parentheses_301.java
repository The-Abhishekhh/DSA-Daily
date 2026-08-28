package Arrays.NonStriverQuestions;

import java.util.*;

public class Remove_Invalid_Parentheses_301 {
    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        Set<String> current = new HashSet<>();
        current.add(s);

        while (!current.isEmpty()) {

            for (String str : current) {

                if (isValid(str)) {
                    result.add(str);
                }
            }

            if (!result.isEmpty()) {
                return result;
            }

            Set<String> next = new HashSet<>();

            for (String str : current) {

                for (int i = 0; i < str.length(); i++) {

                    if (str.charAt(i) != '(' &&
                            str.charAt(i) != ')') {
                        continue;
                    }

                    if (i > 0 &&
                            str.charAt(i) == str.charAt(i - 1)) {
                        continue;
                    }

                    String nextString =
                            str.substring(0, i) +
                                    str.substring(i + 1);

                    next.add(nextString);
                }
            }

            current = next;
        }

        return result;
    }

    private boolean isValid(String s) {

        int balance = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                balance++;

            } else if (c == ')') {
                balance--;

                if (balance < 0) {
                    return false;
                }
            }
        }

        return balance == 0;
    }
}
