/**
 * https://leetcode.com/problems/trapping-rain-water/
 */

//first solution O(n^2)?
class Solution {
    public int trap(int[] height) {
		int[] trap = new int[height.length];

		for (int i = 1; i < height.length; i++) {
			int previous = height[i - 1];
			int current = height[i];
			if (previous < current) { //높이 처리
				int maxHeight = -1;
				int maxHeightIndex = -1;
				for (int j = i - 2; j >= 0; j--) {
					int heightPointer = height[j];
					int afterHeightPointer = height[j + 1];
					if (heightPointer >= current) { //높이가 같거나 크면 탐색을 멈춘다
						maxHeight = current;
						maxHeightIndex = j;
						break;
					} else {
						if (heightPointer > afterHeightPointer && maxHeight < heightPointer) {
							maxHeight = heightPointer;
							maxHeightIndex = j;
						}
					}
				}
				if (maxHeightIndex != -1) {
					for (int j = maxHeightIndex + 1; j < i; j++) {
						int assumed = maxHeight - height[j];
						if (assumed > 0) {
							trap[j] = assumed;
						}
					}
				}
				
			}
		}

		int result = 0;
		for (int i = 0; i < height.length; i++) {
			result += trap[i];
		}
		return result;
    }
}

//second solution(cheated) O(n^2)
class Solution {
	public int trap(int[] height) {
		int trap = 0;

		for(int i = 1; i < height.length - 1; i++) {
			int leftMax = 0;
			int rightMax = 0;
			for (int j = i; j >= 0; j--) { //left
				leftMax = Math.max(leftMax, height[j]);
			}
			for (int j = i; j < height.length; j++) {
				rightMax = Math.max(rightMax, height[j]);
			}
			trap += Math.min(leftMax, rightMax) - height[i];			
		}
		return trap;
	}
}

//third solution(chated) O(n)
class Solution {
	public int trap(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int trap = 0;
		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];
		leftMax[0] = height[0];
		for (int i = 1; i < height.length; i++) {
			leftMax[i] = Math.max(height[i], leftMax[i - 1]);
		}
		rightMax[height.length - 1] = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(height[i], rightMax[i + 1]);
		}

		for(int i = 1; i < height.length - 1; i++) {
			int h = Math.min(leftMax[i], rightMax[i]);
			trap += h - height[i];
		}
		return trap;
	}
}


//fourth solution(chated) O(n)
class Solution {
	public int trap(int[] height) {
	}
}
