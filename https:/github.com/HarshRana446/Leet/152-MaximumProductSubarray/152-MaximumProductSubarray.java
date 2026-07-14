// Last updated: 7/14/2026, 2:39:10 PM
class Solution {
    public int maxProduct(int[] nums) {
        long prefix = 1; 
        long suffix = 1;
        long ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;
            prefix = (long) prefix * nums[i];
            suffix = (long) suffix * nums[nums.length - i - 1];
            ans = Math.max(ans, Math.max(prefix,suffix));
        }
        return (int) ans;
    }
}