// Last updated: 7/17/2026, 2:49:42 PM
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val = 1L * m * k;
        if(val > bloomDay.length) return -1;
        int mini = bloomDay[0];
        int maxi = bloomDay[0];
        for(int i = 0; i < bloomDay.length; i++){
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }
        int low = mini; int high = maxi;
        while(low <= high){
            int mid = (low + high) / 2;
            if(possible(bloomDay, mid, m, k)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    boolean possible(int[] arr, int day, int m, int k) {
        int count = 0;
        int noOfB = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                count++;
            } else {
                noOfB += (count / k);
                count = 0;
            }
        }
        noOfB += (count / k);
        return noOfB >= m;
    }
}