

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        // 1. THE FOUNDATION: Sorting
        // Sorting is what makes the Two-Pointer logic possible. 
        // It allows us to move left/right predictably and skip duplicates easily.
        Arrays.sort(nums);

        // 2. OUTER LAYER: Fix the 1st number (i)
        // We leave room for 3 more numbers (j, left, right), so we stop at n-3.
        for (int i = 0; i < n - 3; i++) {
            
            // DUPLICATE CHECK: If this 'i' is the same as the previous 'i', skip it.
            // This prevents us from starting a set of quadruplets we've already found.
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 3. MIDDLE LAYER: Fix the 2nd number (j)
            // 'j' starts right after 'i'. We leave room for 2 more numbers.
            for (int j = i + 1; j < n - 2; j++) {
                
                // DUPLICATE CHECK: If this 'j' is the same as the previous 'j', skip it.
                // Note: j > i + 1 ensures we don't skip the very first 'j' in this loop.
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // 4. INNER LAYER: Two Pointers (left and right)
                // This is exactly the same logic as "Two Sum II" or "3Sum".
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    // CRITICAL: Use 'long' for the sum.
                    // On LeetCode, adding four large integers can exceed 2,147,483,647.
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        // Found a match! Add it to our list.
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // 5. INNER DUPLICATE CHECK: 
                        // Move pointers past any identical numbers so we don't get the 
                        // exact same 4-number combo again.
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        // Move both pointers inward to keep looking.
                        left++;
                        right--;
                    } 
                    else if (sum < target) {
                        // The sum is too small. Since the array is sorted, 
                        // moving 'left' forward is the only way to get a larger sum.
                        left++;
                    } 
                    else {
                        // The sum is too large. Move 'right' backward to get a smaller sum.
                        right--;
                    }
                }
            }
        }
        // Return all unique quadruplets found.
        return result;
    }
}