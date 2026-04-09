class Solution {
    public void sortColors(int[] nums) {
        int low = 0;         // Boundary for 0s (front)
        int mid = 0;         // The "Explorer" pointer
        int high = nums.length - 1; // Boundary for 2s (back)

        // We explore until mid crosses high
        while (mid <= high) {
            
            if (nums[mid] == 0) {
                // Found a 0! Swap it with the 'low' boundary
                swap(nums, low, mid);
                low++;
                mid++;
            } 
            else if (nums[mid] == 1) {
                // Found a 1! It's already in the right general area.
                // Just move the explorer forward.
                mid++;
            } 
            else { // nums[mid] == 2
                // Found a 2! Swap it with the 'high' boundary
                swap(nums, mid, high);
                // We move high back, but we DON'T move mid forward yet
                // because the new number swapped from high needs to be checked!
                high--;
            }
        }
    }

    // Simple helper method to swap elements
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}