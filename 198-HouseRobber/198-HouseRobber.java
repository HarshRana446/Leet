// Last updated: 9/10/2026, 5:46:09 PM
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int prev2 = 0;
        int prev1 = nums[0];

        for (int i = 1; i < n; i++) {
            int take = prev2 + nums[i];
            int skip = prev1;

            int current = Math.max(take, skip);

            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}