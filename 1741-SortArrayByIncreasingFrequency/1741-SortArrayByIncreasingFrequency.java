// Last updated: 7/14/2026, 2:49:16 PM
import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort the elements by frequency and by value in decreasing order if frequencies are the same
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        
        Collections.sort(numList, (a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);
            if (freqA != freqB) {
                return freqA - freqB; // Increasing order of frequency
            } else {
                return b - a; // Decreasing order of value if frequencies are the same
            }
        });

        // Step 3: Convert the sorted list back to an array
        int[] result = new int[nums.length];
        for (int i = 0; i < numList.size(); i++) {
            result[i] = numList.get(i);
        }
        
        return result;
    }
}
