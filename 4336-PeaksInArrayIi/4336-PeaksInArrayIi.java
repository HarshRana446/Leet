// Last updated: 8/9/2026, 1:42:19 PM
class Solution {
    public long[] countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        int[][] trevolimna = queries;

        TreeSet<Integer> peaks = new TreeSet<>();
        Fenwick bit = new Fenwick(n);

        for (int i = 1; i < n - 1; i++) {
            if (isPeak(nums, i)) {
                addPeak(peaks, bit, i);
            }
        }

        List<Long> result = new ArrayList<>();

        for (int[] query : trevolimna) {
            if (query[0] == 1) {
                int l = query[1];
                int r = query[2];

                result.add(countPeaksInRange(peaks, bit, l, r));
            } else {
                int index = query[1];
                int value = query[2];

                int left = Math.max(1, index - 1);
                int right = Math.min(n - 2, index + 1);

                for (int i = left; i <= right; i++) {
                    if (isPeak(nums, i)) {
                        removePeak(peaks, bit, i);
                    }
                }

                nums[index] = value;

                for (int i = left; i <= right; i++) {
                    if (isPeak(nums, i)) {
                        addPeak(peaks, bit, i);
                    }
                }
            }
        }

        long[] answer = new long[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private long countPeaksInRange(
            TreeSet<Integer> peaks,
            Fenwick bit,
            int l,
            int r) {

        long total = triangle(r - l);

        Integer first = peaks.higher(l);
        Integer last = peaks.lower(r);

        if (first == null || last == null || first > last) {
            return 0L;
        }

        long noPeak = triangle(first - l);
        noPeak += triangle(r - last);

        if (first < last) {
            noPeak += bit.rangeSum(first, last - 1);
        }

        return total - noPeak;
    }

    private long triangle(long d) {
        if (d < 2) {
            return 0L;
        }

        return d * (d - 1) / 2;
    }

    private boolean isPeak(int[] nums, int i) {
        return i > 0
                && i < nums.length - 1
                && nums[i] > nums[i - 1]
                && nums[i] > nums[i + 1];
    }

    private void addPeak(
            TreeSet<Integer> peaks,
            Fenwick bit,
            int p) {

        Integer prev = peaks.lower(p);
        Integer next = peaks.higher(p);

        if (prev != null && next != null) {
            bit.add(prev, -triangle(next - prev));
        }

        peaks.add(p);

        if (next != null) {
            bit.add(p, triangle(next - p));
        }

        if (prev != null) {
            bit.add(prev, triangle(p - prev));
        }
    }

    private void removePeak(
            TreeSet<Integer> peaks,
            Fenwick bit,
            int p) {

        Integer prev = peaks.lower(p);
        Integer next = peaks.higher(p);

        if (prev != null) {
            bit.add(prev, -triangle(p - prev));
        }

        if (next != null) {
            bit.add(p, -triangle(next - p));
        }

        if (prev != null && next != null) {
            bit.add(prev, triangle(next - prev));
        }

        peaks.remove(p);
    }

    static class Fenwick {
        private final long[] tree;

        Fenwick(int n) {
            tree = new long[n + 1];
        }

        void add(int index, long value) {
            index++;

            while (index < tree.length) {
                tree[index] += value;
                index += index & -index;
            }
        }

        long prefixSum(int index) {
            if (index < 0) {
                return 0L;
            }

            index++;

            long sum = 0L;

            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }

            return sum;
        }

        long rangeSum(int left, int right) {
            if (left > right) {
                return 0L;
            }

            return prefixSum(right) - prefixSum(left - 1);
        }
    }
}