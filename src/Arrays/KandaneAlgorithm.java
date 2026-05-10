package Arrays;

import java.util.*;

class Solution1 {
    // Function to find maximum sum of subarrays
    public int maxSubArray(int[] nums) {

        // Maximum sum
        long maxi = Long.MIN_VALUE;

        // Current sum of subarray
        long sum = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {

            // Add current element to the sum
            sum += nums[i];

            // Update maxi if current sum is greater
            if (sum > maxi) {
                maxi = sum;
            }

            // Reset sum to 0 if it becomes negative
            if (sum < 0) {
                sum = 0;
            }
        }

        // Return the maximum subarray sum found
        return (int) maxi;
    }
}

// Separate Main class in same file
public class KandaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        // Create an instance of Solution class
        Solution1 sol = new Solution1();

        int maxSum = sol.maxSubArray(arr);

        // Print the max subarray sum
        System.out.println("The maximum subarray sum is: " + maxSum);
    }
}

