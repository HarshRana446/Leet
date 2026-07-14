// Last updated: 7/14/2026, 2:50:07 PM
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 0){
            return false;
        }
        while(n % 3 == 0){
            n = n / 3;
        }
        return n == 1;
    }
}