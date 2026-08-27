// Last updated: 8/27/2026, 11:41:36 AM
class Solution {

    public String shortestBeautifulSubstring(String s, int k) {

        int n = s.length();

        int left = 0;
        int ones = 0;

        int bestStart = -1;
        int bestEnd = -1;
        int bestLength = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {

            // Add current character
            if (s.charAt(right) == '1') {
                ones++;
            }

            // Too many ones -> move left
            while (ones > k) {

                if (s.charAt(left) == '1') {
                    ones--;
                }

                left++;
            }

            // Exactly k ones
            if (ones == k) {

                // Remove unnecessary leading zeros
                while (s.charAt(left) == '0') {
                    left++;
                }

                int currentLength = right - left + 1;

                // First valid answer or shorter answer
                if (currentLength < bestLength) {

                    bestLength = currentLength;
                    bestStart = left;
                    bestEnd = right;
                }

                // Same length -> lexicographically smaller
                else if (currentLength == bestLength) {

                    if (isSmaller(s, left, right, bestStart, bestEnd)) {

                        bestStart = left;
                        bestEnd = right;
                    }
                }
            }
        }

        // No beautiful substring
        if (bestStart == -1) {
            return "";
        }

        return s.substring(bestStart, bestEnd + 1);
    }

    /*
     * Compare:
     *
     * s[left1 ... right1]
     *
     * with
     *
     * s[left2 ... right2]
     *
     * Both substrings have the same length.
     */
    private boolean isSmaller(
            String s,
            int left1,
            int right1,
            int left2,
            int right2) {

        int length = right1 - left1 + 1;

        for (int i = 0; i < length; i++) {

            char a = s.charAt(left1 + i);
            char b = s.charAt(left2 + i);

            if (a < b) {
                return true;
            }

            if (a > b) {
                return false;
            }
        }

        return false;
    }
}