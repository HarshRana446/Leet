// Last updated: 8/21/2026, 5:37:51 PM
import java.util.*;

class Solution {

    private long[] lcms;
    private int[] signs;
    private int totalSubsets;

    public long findKthSmallest(int[] coins, int k) {

        int n = coins.length;

        totalSubsets = (1 << n) - 1;

        lcms = new long[totalSubsets + 1];
        signs = new int[totalSubsets + 1];

        /*
         * Precompute LCM for every subset.
         *
         * mask:
         * 1      -> coin 0
         * 2      -> coin 1
         * 3      -> coin 0 + coin 1
         * ...
         */
        for (int mask = 1; mask <= totalSubsets; mask++) {

            int bit = Integer.numberOfTrailingZeros(mask);

            int previousMask = mask & (mask - 1);

            if (previousMask == 0) {
                lcms[mask] = coins[bit];
            } else {
                lcms[mask] = lcm(lcms[previousMask], coins[bit]);
            }

            // Odd number of elements -> add
            // Even number of elements -> subtract
            int bits = Integer.bitCount(mask);

            if ((bits & 1) == 1) {
                signs[mask] = 1;
            } else {
                signs[mask] = -1;
            }
        }

        /*
         * The answer cannot be greater than:
         *
         * smallest coin * k
         *
         * because using the smallest coin we can always
         * generate k multiples.
         */
        long minCoin = coins[0];

        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }

        long low = 1;
        long high = minCoin * (long) k;

        /*
         * Binary Search
         */
        while (low < high) {

            long mid = low + (high - low) / 2;

            long count = countAmounts(mid);

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    /*
     * Returns how many distinct amounts <= x
     * are divisible by at least one coin.
     */
    private long countAmounts(long x) {

        long count = 0;

        for (int mask = 1; mask <= totalSubsets; mask++) {

            long lcmValue = lcms[mask];

            /*
             * Number of multiples of LCM <= x
             */
            long multiples = x / lcmValue;

            count += signs[mask] * multiples;
        }

        return count;
    }

    /*
     * Calculate LCM safely.
     */
    private long lcm(long a, long b) {

        return (a / gcd(a, b)) * b;
    }

    /*
     * Greatest Common Divisor
     */
    private long gcd(long a, long b) {

        while (b != 0) {

            long temp = a % b;

            a = b;
            b = temp;
        }

        return a;
    }
}