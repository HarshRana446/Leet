// Last updated: 9/7/2026, 2:40:55 PM
class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        int candidate = sum;

        while (true) {
            boolean exists = false;

            for (int num : nums) {
                if (num == candidate) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                return candidate;
            }

            candidate++;
        }
    }
}