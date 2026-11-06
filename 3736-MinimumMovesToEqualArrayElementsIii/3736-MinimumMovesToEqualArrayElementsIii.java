// Last updated: 11/6/2026, 7:53:53 PM
class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        int sum = 0;

        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        return max * nums.length - sum;
    }
}
