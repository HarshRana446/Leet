// Last updated: 8/24/2026, 4:59:42 PM
class Solution {

    public int stoneGameVIII(int[] stones) {

        int n = stones.length;

        long[] prefix = new long[n];

        // ---------------------------------------------
        // Build prefix sums
        // ---------------------------------------------
        prefix[0] = stones[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        /*
         * Initially, the only possible final merge is
         * represented by the total sum.
         *
         * We start from prefix[n - 1].
         */
        long best = prefix[n - 1];

        /*
         * Try every possible point where the current
         * player can merge the prefix.
         *
         * i starts from n - 2 and goes down to 1
         * because at least 2 original stones must be
         * merged.
         */
        for (int i = n - 2; i >= 1; i--) {

            /*
             * Current player chooses:
             *
             * prefix[i] - best
             *
             * or keep the previous best option.
             */
            best = Math.max(best, prefix[i] - best);
        }

        return (int) best;
    }
}