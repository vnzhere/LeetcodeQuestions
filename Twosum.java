
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

 

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].


class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a map to store the value and its index
        // Key: the number, Value: the index of that number
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // Calculate what number we need to reach the target
            int complement = target - nums[i];

            // If the complement is already in our map, we found the pair!
            if (seen.containsKey(complement)) {
                // Return the index of the complement and current index
                return new int[] { seen.get(complement), i };
            }

            // If not found, add the current number and index to the map
            seen.put(nums[i], i);
        }

        // Return empty array if no solution is found
        return new int[] {};
    }
}
        
  