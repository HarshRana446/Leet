// Last updated: 8/16/2026, 6:19:58 PM
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