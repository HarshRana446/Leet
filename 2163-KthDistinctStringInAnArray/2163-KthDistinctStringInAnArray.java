// Last updated: 7/14/2026, 2:49:06 PM
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        // Count occurrences of each string in the array
        for (String str : arr) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }

        // Traverse the array to find the kth distinct string
        int distinctCount = 0;
        for (String str : arr) {
            if (frequencyMap.get(str) == 1) {
                distinctCount++;
                if (distinctCount == k) {
                    return str;
                }
            }
        }

        // If there is no kth distinct string, return an empty string
        return "";
    }
}
