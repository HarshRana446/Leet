// Last updated: 8/24/2026, 4:59:31 PM
class Solution {

    public boolean sumGame(String num) {

        int n = num.length();
        int half = n / 2;

        int leftSum = 0;
        int rightSum = 0;

        int leftQ = 0;
        int rightQ = 0;

        // Left half
        for (int i = 0; i < half; i++) {

            char ch = num.charAt(i);

            if (ch == '?') {
                leftQ++;
            } else {
                leftSum += ch - '0';
            }
        }

        // Right half
        for (int i = half; i < n; i++) {

            char ch = num.charAt(i);

            if (ch == '?') {
                rightQ++;
            } else {
                rightSum += ch - '0';
            }
        }

        int diff = leftSum - rightSum;
        int qDiff = leftQ - rightQ;

        /*
         * If number of '?' is odd, Alice makes the
         * final move and can force inequality.
         */
        if (Math.abs(qDiff) % 2 == 1) {
            return true;
        }

        /*
         * Equal number of '?'.
         *
         * Bob can mirror Alice's moves.
         *
         * If the existing sums are already equal,
         * Bob wins.
         *
         * Otherwise Alice wins.
         */
        if (qDiff == 0) {
            return diff != 0;
        }

        /*
         * qDiff is even and non-zero.
         *
         * Bob can win only when the existing difference
         * can exactly compensate for the extra '?'s.
         *
         * Each extra pair can create a difference of 9.
         */
        if (diff == -9 * qDiff / 2) {
            return false;
        }

        return true;
    }
}