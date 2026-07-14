// Last updated: 7/14/2026, 2:50:40 PM
class Solution {
    public int mySqrt(int x) {
                int ans = 0;
        if(x == 0){
            return 0;
        } else if (x==1){
            return 1;
        }
        else {
        int left = 0;
        int right = x;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if ((long) mid * mid == x){
                return mid;
            }
            else if ((long)mid * mid < x){
                ans = mid;
                left = mid + 1;
            }
            else if ((long)mid * mid > x){
                right = mid - 1;
            }
        }
        }
        return ans;
    }
}