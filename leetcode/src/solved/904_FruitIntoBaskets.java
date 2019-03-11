/**
 * https://leetcode.com/problems/fruit-into-baskets/
 */

class Solution {

    public int totalFruit(int[] tree) {
		if (tree.length == 0) {
			return 0;
		}

		int max = 0;
		int accumulated = 0;
		int previousFruit = tree[0];
		int previousCount = 0;
		int currentFruit = tree[0];
		int currentCount = 0;
		for (int i = 0; i < tree.length; i++) {
			int fruitType = tree[i];
			if (currentFruitType == fruitType) {
				currentCount++;
			} else if (previousFruitType == fruitType) {
				accumulated += previousCount;
				previousCount = currentCount;
				previousFruit = currentFruit;
				currentFruit = fruitType;
				currentCount = 1;
			} else {
				int currentMax = accumulated + previousCount + currentCount;
				if (max < currentMax) {
					max = currentMax;
				}
				accumulated = 0;
				previousCount = currentCount;
				previousFruit = currentFruit;
				currentFruit = fruitType;
				currentCount = 1;
			}
		}
		int lastMax = accumulated + previousCount + currentCount;
		if (max < lastMax) {
			max = lastMax;
		}

		return max;
    }

}
