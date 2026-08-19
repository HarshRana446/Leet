// Last updated: 8/19/2026, 6:47:42 PM
import java.util.*;

class Solution {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        // Store reserved seats for each row.
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.computeIfAbsent(row, k -> new HashSet<>()).add(col);
        }

        // Every completely empty row can fit 2 families.
        long ans = 2L * (n - map.size());

        // Process only rows having reserved seats.
        for (Set<Integer> seats : map.values()) {

            boolean left = true;   // 2,3,4,5
            boolean middle = true; // 4,5,6,7
            boolean right = true;  // 6,7,8,9

            // Check left block: 2,3,4,5
            for (int seat = 2; seat <= 5; seat++) {
                if (seats.contains(seat)) {
                    left = false;
                    break;
                }
            }

            // Check middle block: 4,5,6,7
            for (int seat = 4; seat <= 7; seat++) {
                if (seats.contains(seat)) {
                    middle = false;
                    break;
                }
            }

            // Check right block: 6,7,8,9
            for (int seat = 6; seat <= 9; seat++) {
                if (seats.contains(seat)) {
                    right = false;
                    break;
                }
            }

            if (left && right) {
                // Two non-overlapping groups can sit.
                ans += 2;
            } else if (left || middle || right) {
                // At least one group can sit.
                ans += 1;
            }
        }

        return (int) ans;
    }
}