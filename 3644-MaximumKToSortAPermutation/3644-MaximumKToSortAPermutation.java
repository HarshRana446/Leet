// Last updated: 10/24/2026, 11:46:30 AM
class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int k = (1 << 17) - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == i)
                continue;
            k &= nums[i];
        }
        return k == ((1 << 17) - 1) ? 0 : k;
    }
}