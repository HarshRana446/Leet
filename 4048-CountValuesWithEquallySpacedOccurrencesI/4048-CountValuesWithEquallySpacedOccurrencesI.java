// Last updated: 9/13/2026, 5:04:41 PM
class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> ind = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            ind.putIfAbsent(nums[i], new ArrayList<>());
            ind.get(nums[i]).add(i);
        }
        int specialCount = 0;
        for(List<Integer> indi :ind.values()){
            if(indi.size() == 3){
                int i1 = indi.get(0);
                int i2 = indi.get(1);
                int i3 = indi.get(2);

                if(i2 - i1 == i3 - i2){
                    specialCount++;
                }
            }
        }
        return specialCount;
    }
}