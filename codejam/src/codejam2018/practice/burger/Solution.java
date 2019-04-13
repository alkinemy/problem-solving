package codejam2018.practice.burger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		int[] results = new int[testCount];
		for(int i = 0; i < testCount; i++) {
			int ingredientCount = scanner.nextInt();
			List<Integer> optimalDistances = new ArrayList<>();
			for (int j = 0; j < ingredientCount; j++) {
				optimalDistances.add(scanner.nextInt());
			}

			//solve
			List<Integer> distances = new ArrayList<>();
			if (ingredientCount % 2 == 0) { //even
				for (int k = 0; k < ingredientCount / 2; k++) {
					distances.add(k);
					distances.add(k);
				}
			} else { //odd
				for (int k = 0; k < ingredientCount / 2; k++) {
					distances.add(k);
					distances.add(k);
				}
				distances.add(ingredientCount / 2);
			}

			Collections.sort(optimalDistances);
			int errorSum = 0;
			for (int k = 0; k < optimalDistances.size(); k++) {
				int difference = (optimalDistances.get(k) - distances.get(k));
				int error = difference * difference;
				errorSum += error;
			}
			results[i] = errorSum;
		}

		for (int i = 0; i < results.length; i++) {
			System.out.println("Case #" + (i + 1) + ": " + results[i]);
		}
	}

}
