package Arrays.NonStriverQuestions;
import java.util.*;

class K_Radius_Subarray_Averages_2090 {
    public int[] getAverages(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n];

        Arrays.fill(ans, -1);

        int windowSize = 2 * k + 1;

        if (windowSize > n)
            return ans;

        long windowSum = 0;

        // First window
        for (int i = 0; i < windowSize; i++) {
            windowSum += nums[i];
        }

        ans[k] = (int) (windowSum / windowSize);

        // Slide the window
        for (int right = windowSize; right < n; right++) {

            windowSum += nums[right];
            windowSum -= nums[right - windowSize];

            int center = right - k;

            ans[center] = (int) (windowSum / windowSize);
        }

        return ans;
    }
}
