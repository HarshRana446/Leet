// Last updated: 9/28/2026, 9:21:11 PM
class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if (ch == ')') {
                depth--;
            }
        }

        return maxDepth;
    }
}