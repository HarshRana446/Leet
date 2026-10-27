// Last updated: 10/27/2026, 2:54:15 PM
class Solution {
    public String[] createGrid(int m, int n) {
        var res = new String[m];
        var sb = new StringBuilder();
        for (var i = 0; i < n; i++) {
            sb.append(".");
        }
        res[0] = sb.toString();

        sb = new StringBuilder();
        for (var i = 1; i < n; i++) {
            sb.append("#");
        }
        sb.append(".");

        for (var i = 1; i < m; i++) {
            res[i] = sb.toString();
        }

        return res;
    }
}