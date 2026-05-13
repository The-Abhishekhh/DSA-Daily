package Arrays;

class Solution2 {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        // Continue processing until mid crosses high
        while (mid <= high) {
            // If current element is 0, swap with low and move both low and mid forward
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            // If current element is 1, just move mid forward
            else if (nums[mid] == 1) {
                mid++;
            }
            // If current element is 2, swap with high and move only high backward
            else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}

// Driver code
public class SortArraysOf012 {
    public static void main(String[] args) {
        Solution2 obj = new Solution2();
        int[] nums = {2, 0, 2, 1, 1, 0};

        obj.sortColors(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}