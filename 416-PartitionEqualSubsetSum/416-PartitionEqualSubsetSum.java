// Last updated: 9/22/2026, 7:53:41 PM
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totSum = 0;
        for (int i = 0; i < n; i++)
            totSum += nums[i];
        if (totSum % 2 != 0)
            return false;
        int target = totSum / 2;
        return subsetSumToK(n, target, nums);
    }

    boolean subsetSumToK(int n, int k, int arr[]) {
        boolean[] dp = new boolean[k + 1];

        dp[0] = true;

        for (int num : arr) {
            for (int sum = k; sum >= num; sum--) {
                dp[sum] = dp[sum] || dp[sum - num];
            }
        }

        return dp[k];
    }
}