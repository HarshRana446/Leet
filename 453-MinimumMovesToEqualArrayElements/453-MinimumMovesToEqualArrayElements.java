// Last updated: 11/6/2026, 7:56:42 PM

class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        long sum = 0;

        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }

        return (int) (sum - (long) min * nums.length);
    }
}
