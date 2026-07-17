// Last updated: 7/17/2026, 2:49:52 PM
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            maxi = Math.max(maxi, nums[i]);
        }
        int low = 1; int high = maxi;
        while(low <= high){
            int mid = (low + high) / 2;
            if(sumByD(nums, mid) <= threshold){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    int sumByD(int[] arr, int div){
        int sum = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++){
            sum += Math.ceil((double) arr[i] / div);
        }
        return sum;
    }
}