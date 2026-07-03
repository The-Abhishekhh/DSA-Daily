package Arrays.NonStriverQuestions;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_560 {
    public int subarraySum(int[] nums, int k) {
        int running = 0;
        int total = 0;

        Map<Integer, Integer> sumFrequency = new HashMap<>();
        sumFrequency.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            running += nums[i];
            int targetSum = running - k;

            if (sumFrequency.containsKey(targetSum)) {
                total += sumFrequency.get(targetSum);
            }

            sumFrequency.put(running, sumFrequency.getOrDefault(running, 0) + 1);
        }

        return total;
    }
}