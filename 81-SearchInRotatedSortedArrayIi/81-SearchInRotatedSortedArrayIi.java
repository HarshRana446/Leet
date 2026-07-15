// Last updated: 7/15/2026, 12:49:45 PM
class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0; 
        int high = n - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target) return true;
            if(nums[low] == nums[mid] && nums[high] == nums[mid]){
                low++;
                high--;
                continue;
            }
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }else {
                if(nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}