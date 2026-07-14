// Last updated: 7/14/2026, 2:40:24 PM
class Solution {
    public int reverse(int x) {
        long rnum = 0;
        while(x != 0){
            int lastDigit = x % 10;
            rnum = (rnum * 10) + lastDigit;
            x = x / 10;
        }
        if(rnum > Integer.MAX_VALUE || rnum < Integer.MIN_VALUE){
            return 0;
        }
        return (int)rnum;
    }
}