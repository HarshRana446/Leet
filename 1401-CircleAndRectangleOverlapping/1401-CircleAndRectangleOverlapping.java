// Last updated: 9/19/2026, 6:42:36 PM
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {

        int dx = Math.max(x1, Math.min(xCenter, x2)) - xCenter;
        int dy = Math.max(y1, Math.min(yCenter, y2)) - yCenter;

        return dx * dx + dy * dy <= radius * radius;
    }
}