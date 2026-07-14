// Last updated: 7/14/2026, 2:40:22 PM
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        int original = x;
        int rnum = 0;
        while(x != 0){
            int ld = x % 10;
            rnum = rnum * 10 + ld;
            x = x / 10;
        }
        return rnum == original;
    }
}