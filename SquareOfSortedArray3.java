class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Two pointers: one at the start, one at the end
        int left = 0;
        int right = n - 1;
        
        // We fill the result array from the back (largest to smallest)
        for (int i = n - 1; i >= 0; i--) {
            // Square both numbers
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            // Pick the larger one and move that pointer
            if (leftSquare > rightSquare) {
                result[i] = leftSquare;
                left++;
            } else {
                result[i] = rightSquare;
                right--;
            }
        }
        
        return result;
    }
}