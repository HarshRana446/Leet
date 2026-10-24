// Last updated: 10/24/2026, 11:47:03 AM
class Solution {
    private static final int[] DAYS_IN_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aStart = toDayOfYear(arriveAlice);
        int aEnd = toDayOfYear(leaveAlice);
        int bStart = toDayOfYear(arriveBob);
        int bEnd = toDayOfYear(leaveBob);

        int overlapStart = Math.max(aStart, bStart);
        int overlapEnd = Math.min(aEnd, bEnd);

        return Math.max(0, overlapEnd - overlapStart + 1);
    }

    private int toDayOfYear(String date) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int dayOfYear = 0;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += DAYS_IN_MONTH[i];
        }
        return dayOfYear + day;
    }
}