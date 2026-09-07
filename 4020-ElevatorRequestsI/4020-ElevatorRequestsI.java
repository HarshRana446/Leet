// Last updated: 9/7/2026, 2:39:55 PM
class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int total = 0;
        int floor = 0;

        for(int req : requests){
            total += Math.abs(req - floor);
            floor = req;
        }
        return total;
    }
}