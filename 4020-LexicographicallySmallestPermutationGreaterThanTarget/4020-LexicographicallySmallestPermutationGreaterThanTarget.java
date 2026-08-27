// Last updated: 8/27/2026, 11:41:22 AM
import java.util.*;

class Solution {

    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        // Frequency of characters in s
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Characters used to match target's prefix
        int[] used = new int[26];

        // Try to match target from left to right
        int i = 0;

        while (i < n) {

            int c = target.charAt(i) - 'a';

            if (used[c] < freq[c]) {
                used[c]++;
                i++;
            } else {
                break;
            }
        }

        /*
         * We now have matched target[0 ... i-1].
         *
         * We need to find a position where we can make
         * the answer strictly greater.
         *
         * Start from the current position if it exists,
         * otherwise start from the last matched position.
         */
        int pos = i;

        if (pos == n) {
            pos = n - 1;
        }

        while (pos >= 0) {

            /*
             * If pos is a matched position, return its
             * character back to the available pool.
             *
             * If pos == i and i < n, target[pos] was NOT
             * used because it was unavailable, so don't
             * return anything.
             */
            if (pos < i) {
                int c = target.charAt(pos) - 'a';
                used[c]--;
            }

            int current = target.charAt(pos) - 'a';

            /*
             * Find the smallest character greater than
             * target[pos].
             */
            for (int bigger = current + 1; bigger < 26; bigger++) {

                if (used[bigger] < freq[bigger]) {

                    StringBuilder ans = new StringBuilder(n);

                    // Prefix equal to target
                    for (int j = 0; j < pos; j++) {
                        ans.append(target.charAt(j));
                    }

                    // Make this position greater
                    ans.append((char) ('a' + bigger));

                    // Consume the chosen character
                    used[bigger]++;

                    // Fill remaining positions minimally
                    for (int c = 0; c < 26; c++) {

                        int remaining = freq[c] - used[c];

                        while (remaining > 0) {
                            ans.append((char) ('a' + c));
                            remaining--;
                        }
                    }

                    return ans.toString();
                }
            }

            pos--;
        }

        return "";
    }
}