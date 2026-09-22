// Last updated: 9/22/2026, 7:52:03 PM
class Solution {
    public int minimumDifference(int[] nums) {

        int n = nums.length / 2;

        int totalSum = 0;

        for (int x : nums) {

            totalSum += x;
        }

        int[][] comb = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {

            comb[i][0] = 1;

            for (int j = 1; j <= i; j++) {

                comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
            }
        }

        int[][] leftSums = new int[n + 1][];

        int[][] rightSums = new int[n + 1][];

        int[] leftPtr = new int[n + 1];

        int[] rightPtr = new int[n + 1];

        for (int k = 0; k <= n; k++) {

            leftSums[k] = new int[comb[n][k]];

            rightSums[k] = new int[comb[n][k]];
        }

        generateSums(nums, 0, n, 0, 0, leftSums, leftPtr);
        generateSums(nums, n, 2 * n, 0, 0, rightSums, rightPtr);

        int minDiff = Integer.MAX_VALUE;

        for (int k = 0; k <= n; k++) {

            int[] leftArr = leftSums[k];

            int[] rightArr = rightSums[n - k];

            Arrays.sort(leftArr);

            Arrays.sort(rightArr);

            int i = 0;

            int j = rightArr.length - 1;

            while (i < leftArr.length && j >= 0) {

                int sum = leftArr[i] + rightArr[j];

                int diff = totalSum - 2 * sum;

                minDiff = Math.min(minDiff, Math.abs(diff));

                if (minDiff == 0)
                    return 0;

                if (2 * sum < totalSum) {

                    i++;
                }

                else {

                    j--;
                }

            }

        }

        return minDiff;

    }

    private void generateSums(int[] nums, int start, int end, int count, int currentSum, int[][] target, int[] ptr) {

        if (start == end) {

            target[count][ptr[count]++] = currentSum;

            return;
        }

        generateSums(nums, start + 1, end, count, currentSum, target, ptr);

        generateSums(nums, start + 1, end, count + 1, currentSum + nums[start], target, ptr);
    }
}