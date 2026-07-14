// Last updated: 7/14/2026, 2:51:02 PM
class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            if (nums[end] == val) {
                end--;
            } else if (nums[start] == val) {
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                start++;
                end--;
            } else {
                start++;
            }
        }
        return end+1;
    }
}