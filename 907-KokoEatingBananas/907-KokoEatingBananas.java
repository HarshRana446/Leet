// Last updated: 7/17/2026, 2:50:04 PM
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1; int high = findMax(piles);
        while(low <= high){
            int mid = low + (high - low) / 2;
            long totalH = calHours(piles, mid);
            if(totalH <= h){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    int findMax(int[] arr){
        int Maxi = Integer.MIN_VALUE;
        int n = arr.length - 1;
        for(int i = 0; i <= n; i++){
            Maxi = Math.max(Maxi, arr[i]); 
        }
        return Maxi;
    }
    long calHours(int[] nums, int hours){
        long totalHours = 0;
        int n = nums.length - 1;
        for(int i = 0; i <= n; i++){
            totalHours += (int) Math.ceil((double) nums[i]/ hours);
        }
        return totalHours;
    }
}