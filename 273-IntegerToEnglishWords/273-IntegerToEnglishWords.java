// Last updated: 7/14/2026, 2:50:11 PM
class Solution {

    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    private String helper(int num) {
        if (num == 0) return "";
        if (num < 20) return LESS_THAN_20[num];
        if (num < 100) return TENS[num / 10] + (num % 10 != 0 ? " " + LESS_THAN_20[num % 10] : "");
        return LESS_THAN_20[num / 100] + " Hundred" + (num % 100 != 0 ? " " + helper(num % 100) : "");
    }

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        String result = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                result = helper(num % 1000) + (THOUSANDS[i].isEmpty() ? "" : " " + THOUSANDS[i]) + (result.isEmpty() ? "" : " " + result);
            }
            num /= 1000;
            i++;
        }

        return result.trim();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberToWords(1234567891)); // Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
    }
}
