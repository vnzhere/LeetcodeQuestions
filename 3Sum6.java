import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 1. Create a list to store our found triplets
        List<List<Integer>> result = new ArrayList<>();

        // 2. SORT the array. This is the most important step!
        // It allows us to use two pointers and skip duplicates easily.
        Arrays.sort(nums);

        // 3. Iterate through the array to "fix" the first number (i)
        // We stop at nums.length - 2 because we need at least 2 more numbers for a triplet.
        for (int i = 0; i < nums.length - 2; i++) {
            
            // 4. DUPLICATE CHECK: If the current number is the same as the last one,
            // skip it so we don't get the same triplet twice.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 5. Setup Two Pointers for the remaining part of the array
            int left = i + 1;           // Starts just after our fixed number
            int right = nums.length - 1; // Starts at the very end

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // FOUND A TRIPLET!
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 6. INNER DUPLICATE CHECK: Skip the same numbers to avoid repeats
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // Move both pointers inward after finding a match
                    left++;
                    right--;

                } else if (sum < 0) {
                    // If sum is too small, we need a bigger number. 
                    // Since the array is sorted, we move the 'left' pointer forward.
                    left++;
                } else {
                    // If sum is too big, we need a smaller number.
                    // Move the 'right' pointer backward.
                    right--;
                }
            }
        }

        return result;
    }
}