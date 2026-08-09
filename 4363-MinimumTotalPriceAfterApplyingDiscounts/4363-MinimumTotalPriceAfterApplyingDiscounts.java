// Last updated: 8/9/2026, 1:42:21 PM
class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int n = prices.length;
        int m = discounts.length;

        int k = Math.min(n, m);

        long totalPrice = 0;

        for (int price : prices) {
            totalPrice += price;
        }

        long totalSavingsProduct = 0;

        for (int i = 0; i < k; i++) {
            int price = prices[n - 1 - i];
            int discount = discounts[m - 1 - i];

            totalSavingsProduct += (long) price * discount;
        }

        double totalSavings = totalSavingsProduct / 100.0;

        return totalPrice - totalSavings;

    }
}