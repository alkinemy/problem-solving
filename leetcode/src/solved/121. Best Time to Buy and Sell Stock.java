/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

class Solution {
    public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}

		int[] max = new int[prices.length];
		max[prices.length - 1] = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			if (prices[i] > max[i + 1]) {
				max[i] = prices[i];
			} else {
				max[i] = max[i + 1];
			}
		}

		int profit = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			if (min < prices[i]) {
				continue;
			}
			min = prices[i];
			if (i + 1 < prices.length && max[i + 1] > min) {
				profit = Math.max(profit, max[i + 1] - min);
			}
		}
		return profit;
    }
}
