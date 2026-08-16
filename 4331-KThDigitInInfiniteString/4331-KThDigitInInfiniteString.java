// Last updated: 8/16/2026, 6:20:04 PM
class Solution {
    public int kthDigit(long k) {
        if(k <= 9){
            return (int) k;
        }

        k -= 9;
        long start = 1;
        for(int len = 2; len <= 18; len++){
            long blocks = start * 9;
            long dig = blocks * 10 * len;

            if(k <= dig){
                long b = start + (k - 1) / (10 * len);
                long pos = (k - 1) % (10 * len);

                long i = pos / len;
                int digit = (int) (pos % len);
                long number;
                if(b % 2 == 0){
                    number = b * 10 + i;
                } else {
                    number = b * 10 + 9 - i;
                }
                return String.valueOf(number).charAt(digit) - '0';
            }
            k -= dig;
            start *= 10;
        }
        return -1;
    }
}