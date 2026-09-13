// Last updated: 9/13/2026, 5:04:43 PM
class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> ind = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            ind.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int specialCount = 0;
        for(Map.Entry<Integer, List<Integer>> entry: ind.entrySet()){
            List<Integer> indi = entry.getValue();
            if(indi.size() < 3){
                continue;
            }
            int diff = indi.get(1) - indi.get(0);
            boolean isE = true;

            for(int i = 2; i < indi.size(); i++){
                if(indi.get(i) - indi.get(i - 1) != diff){
                    isE = false;
                    break;
                }
            }
            if(isE){
                specialCount++;
            }
        }
        return specialCount;
    }
}