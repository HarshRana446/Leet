// Last updated: 10/6/2026, 12:04:54 PM
class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int ans = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    ans++;
                }
            }
        }

        return ans + open;
    }
}