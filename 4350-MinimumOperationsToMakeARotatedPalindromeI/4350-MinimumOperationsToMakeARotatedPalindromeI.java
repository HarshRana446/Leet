// Last updated: 8/16/2026, 6:19:55 PM
class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int min = Integer.MAX_VALUE;

        for(int k = 0; k < n; k++){
            int ops = k;
            for(int i = 0; i < n / 2; i++){
                char c1 = s.charAt((i + k) % n);
                char c2 = s.charAt((n - 1 - i + k) % n);

                int cos1 = (c2 - c1 + 26) % 26;
                int cos2 = (c1 - c2 + 26) % 26;

                ops += Math.min(cos1, cos2);
            }
            if(ops < min){
                min = ops;
            }
        }
        return min;
    }
}