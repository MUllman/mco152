package ullman.maxSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MaxSum {

	private int start;
	private int finish;

	public int getStart() {
		return start;
	}

	public int getFinish() {
		return finish;
	}

	public int maxSubArraySum(int array[]) {
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		int i;
		start = 0;
		for (i = 0; i < array.length; ++i) {
			sum += array[i];
			if (sum < 0) {
				sum = 0;
				start = i + 1;
			} else if (sum > maxSum) {
				maxSum = sum;
				finish = i;
			}
		}
		return maxSum;
	}

	public void findmaxSum(String values) {
		ArrayList<String> numbers = new ArrayList<String>();
		for (String token : values.split(" ")) {
			numbers.add(token);
		}

		int size = Integer.valueOf(numbers.get(0));
		int[][] m = new int[size][size];
		int k = 1;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				m[i][j] = Integer.valueOf(numbers.get(k));
				k++;
			}
		}
		int maxSum = 0;
		int finalLeft;
		int finalRight;
		int finalTop;
		int finalBottom;

		int left;
		int right;
		int temp[] = new int[m.length];
		int sum;
		for (left = 0; left < m[0].length; ++left) {
			Arrays.fill(temp, 0);
			for (right = left; right < m[0].length; ++right) {
				for (int i = 0; i < m.length; ++i) {
					temp[i] += m[i][right];
				}
				sum = maxSubArraySum(temp);
				if (sum > maxSum) {
					maxSum = sum;
					finalLeft = left;
					finalRight = right;
					finalTop = start;
					finalBottom = finish;
				}
			}
		}
		System.out.println("max sum is: " + maxSum);
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		System.out.println("enter size followed by numbers");
		int size = scanner.nextInt();
		int amount = size * size;
		sb.append(size);
		int num = 0;
		sb.append(" ");
		while (num < amount) {
			num++;
			String numbers = scanner.next();
			sb.append(numbers);
			sb.append(" ");
		}
		new MaxSum().findmaxSum(sb.toString());
	}
}
