// Last updated: 7/18/2026, 2:41:59 PM
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxi = weights[0];
        for(int i = 0; i < weights.length; i++){
            maxi = Math.max(maxi, weights[i]);
        }
        int sum = 0;
        for(int i = 0; i < weights.length; i++){
            sum = sum + weights[i];
        }
        int low = maxi; int high = sum;
        while(low <= high){
            int mid = (low + high) / 2;
            int numD = findDays(weights, mid);
            if(numD <= days){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    int findDays(int[] arr, int cap){
        int days = 1; int load = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] + load > cap){
                days += 1;
                load = arr[i];
            }else{
                load += arr[i];
            }
        }
        return days;
    }
}