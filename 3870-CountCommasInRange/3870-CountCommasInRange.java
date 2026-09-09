// Last updated: 9/9/2026, 1:25:34 PM
class Solution {
    public int countCommas(int n) {
        if(n < 1000){
            return 0;
        }
        return n - 999;
    }
}