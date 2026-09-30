// Last updated: 9/30/2026, 7:08:20 PM
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] answer = new int[n];
        int depth = 0;
        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                depth++;
                answer[i] = depth % 2;
            } else {
                answer[i] = depth % 2;
                depth--;
            }
        }
        return answer;
    }
}