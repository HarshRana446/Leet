// Last updated: 11/6/2026, 7:54:16 PM

import java.util.*;

class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        int m = n - x + 1;

        // Step 1: Calculate cost of every window of size x
        long[] cost = new long[m];

        SlidingMedian median = new SlidingMedian();

        for (int i = 0; i < x; i++) {
            median.add(nums[i]);
        }

        cost[0] = median.getCost();

        for (int i = x; i < n; i++) {
            median.remove(nums[i - x]);
            median.add(nums[i]);

            cost[i - x + 1] = median.getCost();
        }

        // Step 2: DP
        // dp[j][i] = minimum cost to select exactly j
        // non-overlapping subarrays from first i elements.

        long INF = Long.MAX_VALUE / 4;

        long[] dp = new long[n + 1];

        // Selecting zero subarrays costs 0 for every prefix.
        Arrays.fill(dp, 0);

        for (int j = 1; j <= k; j++) {

            long[] next = new long[n + 1];
            Arrays.fill(next, INF);

            for (int i = 1; i <= n; i++) {

                // Option 1: Skip current element
                next[i] = next[i - 1];

                // Option 2: Select a subarray of size x
                if (i >= x && dp[i - x] != INF) {

                    long candidate =
                        dp[i - x] + cost[i - x];

                    next[i] = Math.min(next[i], candidate);
                }
            }

            dp = next;
        }

        return dp[n];
    }

    static class SlidingMedian {

        TreeMap<Integer, Integer> lower = new TreeMap<>();
        TreeMap<Integer, Integer> upper = new TreeMap<>();

        int lowerSize = 0;
        int upperSize = 0;

        long lowerSum = 0;
        long upperSum = 0;

        void add(int num) {

            if (lower.isEmpty() || num <= lower.lastKey()) {
                addToMap(lower, num);
                lowerSize++;
                lowerSum += num;
            } else {
                addToMap(upper, num);
                upperSize++;
                upperSum += num;
            }

            rebalance();
        }

        void remove(int num) {

            if (lower.containsKey(num)) {
                removeFromMap(lower, num);
                lowerSize--;
                lowerSum -= num;
            } else {
                removeFromMap(upper, num);
                upperSize--;
                upperSum -= num;
            }

            rebalance();
        }

        void rebalance() {

            while (lowerSize > upperSize + 1) {

                int value = lower.lastKey();

                removeFromMap(lower, value);
                lowerSize--;
                lowerSum -= value;

                addToMap(upper, value);
                upperSize++;
                upperSum += value;
            }

            while (lowerSize < upperSize) {

                int value = upper.firstKey();

                removeFromMap(upper, value);
                upperSize--;
                upperSum -= value;

                addToMap(lower, value);
                lowerSize++;
                lowerSum += value;
            }
        }

        long getCost() {

            int median = lower.lastKey();

            long leftCost =
                (long) median * lowerSize - lowerSum;

            long rightCost =
                upperSum - (long) median * upperSize;

            return leftCost + rightCost;
        }

        private void addToMap(
            TreeMap<Integer, Integer> map,
            int value
        ) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        private void removeFromMap(
            TreeMap<Integer, Integer> map,
            int value
        ) {
            int count = map.get(value);

            if (count == 1) {
                map.remove(value);
            } else {
                map.put(value, count - 1);
            }
        }
    }
}
