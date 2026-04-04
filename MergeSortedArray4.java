class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // POINTER 1: Points to the last valid number in nums1
        int p1 = m - 1; 
        
        // POINTER 2: Points to the last number in nums2
        int p2 = n - 1; 
        
        // POINTER 3 (The Writer): Points to the very last index of nums1
        // This is where we will "write" the largest numbers first.
        int p = m + n - 1;

        // PATTERN: "The Backward Race"
        // Continue as long as both arrays have numbers left to compare
        while (p1 >= 0 && p2 >= 0) {
            
            // If the number in nums1 is bigger
            if (nums1[p1] > nums2[p2]) {
                // Put the bigger number at the 'writer' position
                nums1[p] = nums1[p1];
                // Move the nums1 pointer back to the next number
                p1--;
            } 
            // Otherwise, the number in nums2 is bigger (or they are equal)
            else {
                // Put the nums2 number at the 'writer' position
                nums1[p] = nums2[p2];
                // Move the nums2 pointer back to the next number
                p2--;
            }
            
            // Every time we write a number, we move our 'writer' back one slot
            p--;
        }

        // THE "LEFTOVER" RULE:
        // If nums2 still has numbers (e.g., nums1 was exhausted first),
        // we must copy the rest of nums2 into the front of nums1.
        // If nums1 has numbers left, we don't need to do anything because 
        // they are already in their correct sorted positions!
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}