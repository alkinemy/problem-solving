package codejam2017.practice.understudies;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		double[] results = new double[testCount];
		for (int i = 0; i < testCount; i++) {
			int role = scanner.nextInt();

			double[] unavailable = new double[role * 2];
			for (int j = 0; j < role * 2; j++) {
				unavailable[j] = scanner.nextDouble();
			}

			double p = solve(role, unavailable);
			results[i] = p;
		}

		for (int i = 0; i < results.length; i++) {
			System.out.printf("Case #%d: %.6f\n", (i + 1), results[i]);
		}
	}

	private static double solve(int role, double[] unavailable) {
		double result = 1;
		Arrays.sort(unavailable);
		for (int i = 0; i < role; i++) {
			double primary = unavailable[i];
			double secondary = unavailable[unavailable.length - i - 1];
			result *= (1 - primary * secondary);
		}
		return result;
	}

}
