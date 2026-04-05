class Solution {
    public int trap(int[] height) {
        // Two pointers meeting in the middle
        int left = 0;
        int right = height.length - 1;
        
        // These track the tallest wall we've seen from each side so far
        int leftMax = 0;
        int rightMax = 0;
        
        int totalWater = 0;

        while (left < right) {
           // The shorter side determines the max water we can trap at that point
            if (height[left] < height[right]) {
                
                // If current bar is taller than our left record, update the record
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // If current height is smaller, water can be trapped using leftMax
                    // Water trapped = (Tallest wall so far) - (Current bar height)
                    totalWater += leftMax - height[left];
                }
                left++; // Move inward
                
            } else {
                // Same logic for the right side
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--; // Move inward
            }
        }
        return totalWater;
    }
}