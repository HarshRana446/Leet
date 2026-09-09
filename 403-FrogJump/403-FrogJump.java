// Last updated: 9/9/2026, 1:28:23 PM
import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;

        if (n == 2) {
            return stones[1] == 1;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }

        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            dp.add(new HashSet<>());
        }

        dp.get(0).add(0);

        for (int i = 0; i < n; i++) {

            for (int k : dp.get(i)) {

                for (int jump = k - 1; jump <= k + 1; jump++) {

                    if (jump <= 0) {
                        continue;
                    }

                    int next = stones[i] + jump;

                    Integer idx = map.get(next);

                    if (idx == null) {
                        continue;
                    }

                    if (idx == n - 1) {
                        return true;
                    }

                    dp.get(idx).add(jump);
                }
            }
        }

        return false;
    }
}