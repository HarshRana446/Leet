// Last updated: 7/14/2026, 2:37:29 PM
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> subarraySums = new ArrayList<>();

        // Generate all subarray sums
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                subarraySums.add(sum);
            }
        }

        // Sort the subarray sums
        Collections.sort(subarraySums);

        // Calculate the range sum from left to right (1-based indexing)
        int result = 0;
        int mod = 1000000007;
        for (int k = left - 1; k < right; k++) {
            result = (result + subarraySums.get(k)) % mod;
        }

        return result;
    }
}
