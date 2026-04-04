class Solution {
    public int removeDuplicates(int[] nums) {
        // Edge case: If the array is empty, return 0
        if (nums.length == 0) return 0;

        // 'i' is our "Writer" pointer. 
        // It tracks the position of the last unique element found.
        int i = 0;

        // 'j' is our "Reader" pointer.
        // It starts at 1 and scans the rest of the array.
        for (int j = 1; j < nums.length; j++) {
            // If the current element is NOT a duplicate of the last unique element...
            if (nums[j] != nums[i]) {
                // Move the Writer forward
                i++;
                // Update the Writer's position with the new unique value
                nums[i] = nums[j];
            }
        }

        // The number of unique elements is index + 1 (since index starts at 0)
        return i + 1;
    }
}