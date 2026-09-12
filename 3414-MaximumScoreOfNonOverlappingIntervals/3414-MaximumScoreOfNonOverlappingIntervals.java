// Last updated: 9/12/2026, 2:27:46 PM
import java.util.*;

class Solution {
    static class State {
        long score;
        int[] indices;

        State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        int[][] a = new int[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }

        Arrays.sort(a, (p, q) -> {
            if (p[0] != q[0]) {
                return Integer.compare(p[0], q[0]);
            }
            if (p[1] != q[1]) {
                return Integer.compare(p[1], q[1]);
            }
            return Integer.compare(p[3], q[3]);
        });

        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            int lo = i + 1;
            int hi = n;

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                if (a[mid][0] > a[i][1]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }

            next[i] = lo;
        }

        State[][] dp = new State[n + 1][5];

        for (int c = 0; c <= 4; c++) {
            if (c == 0) {
                dp[n][c] = new State(0, new int[0]);
            } else {
                dp[n][c] = null;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int c = 0; c <= 4; c++) {

                State best = dp[i + 1][c];

                if (c > 0 && dp[next[i]][c - 1] != null) {
                    State suffix = dp[next[i]][c - 1];

                    int[] indices = addAndSort(
                            suffix.indices,
                            a[i][3]);

                    State take = new State(
                            a[i][2] + suffix.score,
                            indices);

                    best = better(best, take);
                }

                dp[i][c] = best;
            }
        }

        State answer = dp[0][0];

        for (int c = 1; c <= 4; c++) {
            answer = better(answer, dp[0][c]);
        }

        return answer.indices;
    }

    private State better(State a, State b) {
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        return compareLexicographically(a.indices, b.indices) <= 0
                ? a
                : b;
    }

    private int[] addAndSort(int[] arr, int value) {
        int[] result = Arrays.copyOf(arr, arr.length + 1);

        result[arr.length] = value;

        Arrays.sort(result);

        return result;
    }

    private int compareLexicographically(int[] a, int[] b) {
        int len = Math.min(a.length, b.length);

        for (int i = 0; i < len; i++) {
            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
        }

        return Integer.compare(a.length, b.length);
    }
}