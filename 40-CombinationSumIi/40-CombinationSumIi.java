// Last updated: 7/14/2026, 2:50:53 PM
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Sort the array to facilitate skipping duplicates
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }
    
    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> results) {
        if (target == 0) {
            // If the target is zero, we found a valid combination
            results.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            // If the current number is greater than the target, no point in continuing
            if (candidates[i] > target) break;
            
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            
            // Include the current number and move forward
            current.add(candidates[i]);
            // Recur with updated target and starting index
            backtrack(candidates, target - candidates[i], i + 1, current, results);
            // Backtrack by removing the number
            current.remove(current.size() - 1);
        }
    }
}
