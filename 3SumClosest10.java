class Solution {
    public int threeSumClosest(int[] nums, int target) {

        // 1. Sort to make the Two-Pointer movement logical
        Arrays.sort(nums);
        
        // Start with a very large difference or just the first possible sum
        int closestSum = nums[0] + nums[1] + nums[2];

        // 2. Fix the first number
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // 3. Update closestSum if the new currentSum is nearer to target
                // Math.abs gives us the "distance" from the target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // 4. Standard Two-Pointer movement
                if (currentSum < target) {
                    // Need a bigger sum? Move the left pointer
                    left++;
                } else if (currentSum > target) {
                    // Need a smaller sum? Move the right pointer
                    right--;
                } else {
                    // If sum == target, it's impossible to get closer!
                    return currentSum;
                }
            }
        }
        return closestSum;
        
    }
}