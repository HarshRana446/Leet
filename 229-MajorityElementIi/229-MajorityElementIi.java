// Last updated: 7/14/2026, 2:50:20 PM
class Solution {
    public List<Integer> majorityElement(int[] nums) {
    int count1 = 0; int count2 = 0;
    int el1 = Integer.MIN_VALUE;
    int el2 = Integer.MIN_VALUE;
    for(int i = 0; i < nums.length; i++){
        if(count1 == 0 && el2 != nums[i]){
            count1 = 1;
            el1 = nums[i];
        }
        else if(count2 == 0 && el1 != nums[i]){
            count2 = 1;
            el2 = nums[i];
        }
        else if(nums[i] == el1) count1++;
        else if(nums[i] == el2) count2++;
        else{
            count1--;
            count2--;
        }
    }
    ArrayList<Integer> list = new ArrayList<>();
    count1= 0; count2 = 0;
    for(int i = 0; i< nums.length; i++){
        if(el1 == nums[i]) count1++;
        if(el2 == nums[i]) count2++;
    }
    int mini = (int) nums.length / 3 + 1;
    if(count1 >= mini) list.add(el1);
    if(count2 >= mini) list.add(el2);
    Collections.sort(list);
    return list;
    }
}