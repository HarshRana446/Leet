// Last updated: 8/24/2026, 5:00:15 PM
import java.util.*;

class Solution {

    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        // first[c] = first occurrence of character c
        // last[c]  = last occurrence of character c
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        // ---------------------------------------------
        // STEP 1: Find first and last occurrence
        // ---------------------------------------------
        for (int i = 0; i < n; i++) {

            int c = s.charAt(i) - 'a';

            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        // Store valid intervals
        List<int[]> intervals = new ArrayList<>();

        // ---------------------------------------------
        // STEP 2: Find smallest valid interval
        //         for every character
        // ---------------------------------------------
        for (int c = 0; c < 26; c++) {

            // Character doesn't exist
            if (last[c] == -1) {
                continue;
            }

            int left = first[c];
            int right = last[c];

            boolean valid = true;

            /*
             * Scan the current interval.
             *
             * If a character inside this interval has an
             * occurrence before 'left', then this interval
             * cannot be valid.
             *
             * If its last occurrence is after 'right',
             * expand the interval.
             */
            for (int i = left; i <= right; i++) {

                int current = s.charAt(i) - 'a';

                // Character occurs before our interval
                if (first[current] < left) {
                    valid = false;
                    break;
                }

                // Need to include all occurrences
                right = Math.max(right, last[current]);
            }

            if (valid) {
                intervals.add(new int[]{left, right});
            }
        }

        // ---------------------------------------------
        // STEP 3: Sort by ending position
        // ---------------------------------------------
        intervals.sort((a, b) -> {

            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        // ---------------------------------------------
        // STEP 4: Greedily select non-overlapping
        //         intervals
        // ---------------------------------------------
        List<String> result = new ArrayList<>();

        int previousEnd = -1;

        for (int[] interval : intervals) {

            int left = interval[0];
            int right = interval[1];

            if (left > previousEnd) {

                result.add(s.substring(left, right + 1));

                previousEnd = right;
            }
        }

        return result;
    }
}