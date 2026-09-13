// Last updated: 9/13/2026, 5:04:54 PM
class Solution {
    public long distantSubarrays(int[] nums, int goal, int k) {
        int n = nums.length;
        int[] mireqovalt = nums;
        if(k == 0){
            return (long) n * (n + 1) / 2;
        }
        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + nums[i];
        }

        long[] unique = pref.clone();
        Arrays.sort(unique);
        int m = 0;
        for (int i = 0; i < unique.length; i++) {
            if (i == 0 || unique[i] != unique[i - 1]) {
                unique[m++] = unique[i];
            }
        }

        BIT bit = new BIT(m);
        long count = 0;

        for (int i = 0; i <= n; i++) {
            long currentSum = pref[i];

            if (k == 0) {
                count += i;
            } else {
                long target1 = currentSum - goal - k;
                int idx1 = upperIndex(unique, m, target1);
                if (idx1 >= 0) {
                    count += bit.query(idx1 + 1);
                }
                long target2 = currentSum - goal + k;
                int idx2 = lowerIndex(unique, m, target2);
                if (idx2 < m) {
                    count += bit.query(m) - bit.query(idx2);
                }
            }

            int curIdx = Arrays.binarySearch(unique, 0, m, currentSum);
            bit.update(curIdx + 1, 1);
        }

        return count;
    }

    private int upperIndex(long[] arr, int len, long target) {
        int low = 0, high = len - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private int lowerIndex(long[] arr, int len, long target) {
        int low = 0, high = len - 1;
        int ans = len;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static class BIT {
        int size;
        int[] tree;

        BIT(int size) {
            this.size = size;
            this.tree = new int[size + 1];
        }

        void update(int idx, int val) {
            while (idx <= size) {
                tree[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += tree[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }
}