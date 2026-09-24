// Last updated: 9/24/2026, 2:13:03 PM
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[] { i + 1, j + 1 };
            } else if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            }
        }
        return new int[0];
    }
}