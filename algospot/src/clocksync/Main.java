package clocksync;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		for (int i = 0; i < testCount; i++) {
			int[] clockPointers = new int[16];
			for (int j = 0; j < 16; j++) {
				clockPointers[j] = scanner.nextInt() % 12;
			}
			int minCount = findMinimumCount(clockPointers);
			System.out.println(minCount);
		}
	}

	static final int[][] SWITCH_MAPPINGS = {
		{0, 1, 2},
		{3, 7, 9, 11},
		{4, 10, 14, 15},
		{0, 4, 5, 6, 7},
		{6, 7, 8, 10, 12},
		{0, 2, 14, 15},
		{3, 14, 15},
		{4, 5, 7, 14, 15},
		{1, 2, 3, 4, 5},
		{3, 4, 5, 9, 13}
	};

	private static int findMinimumCount(int[] clockPointers) {
		int count = findMinimumCount(clockPointers, 0, 0);
		if (count == Integer.MAX_VALUE) {
			return -1;
		} else {
			return count;
		}
	}

	private static int findMinimumCount(int[] clockPointers, int currentSwitchIndex, int totalPushCount) {
		if (isAllClockPointMidnight(clockPointers)) {
			return totalPushCount;
		}
		if (currentSwitchIndex >= 10) {
			return Integer.MAX_VALUE;
		}

		int result = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			int pushed = findMinimumCount(clockPointers, currentSwitchIndex + 1, totalPushCount + i);
			result = Math.min(result, pushed);
			pushSwitch(clockPointers, currentSwitchIndex);
		}

		return result;
	}

	private static void pushSwitch(int[] clockPointers, int currentSwitchIndex) {
		int[] currentSwitch = SWITCH_MAPPINGS[currentSwitchIndex];
		for (int i = 0; i < currentSwitch.length; i++) {
			int clock = currentSwitch[i];
			clockPointers[clock] = (clockPointers[clock] + 3) % 12;
		}
	}

	private static boolean isAllClockPointMidnight(int[] clockPointers) {
		for (int pointer : clockPointers) {
			if (pointer != 0) {
				return false;
			}
		}
		return true;
	}

}
