// Last updated: 8/20/2026, 6:40:26 PM
import java.util.*;

class Solution {
    public int[] resultArray(int[] nums) {

        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        // First operation
        arr1.add(nums[0]);

        // Second operation
        arr2.add(nums[1]);

        // Remaining elements
        for (int i = 2; i < nums.length; i++) {

            int last1 = arr1.get(arr1.size() - 1);
            int last2 = arr2.get(arr2.size() - 1);

            if (last1 > last2) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        // Create result array
        int[] result = new int[nums.length];

        int index = 0;

        // Add arr1
        for (int num : arr1) {
            result[index++] = num;
        }

        // Add arr2
        for (int num : arr2) {
            result[index++] = num;
        }

        return result;
    }
}