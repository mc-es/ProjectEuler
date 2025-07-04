import java.util.Arrays;

/*
@author: mc-es

Problem 38
Take the number 192 and multiply it by each of 1, 2, and 3:

192 × 1 = 192
192 × 2 = 384
192 × 3 = 576

By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192
and (1, 2, 3).
The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the
concatenated product of 9 and (1, 2, 3, 4, 5).
What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with
(1, 2, ..., n) where n > 1?

Answer: 932718654
*/

public class Main {
	public static boolean isPandigital(String s) {
		char[] digits = s.toCharArray();
		Arrays.sort(digits);
		return new String(digits).equals("123456789");
	}

	public static void main(String[] args) {
		int maxPandigital = 0;

		for (int num = 1; num < 10000; num++) {
			StringBuilder concatenated = new StringBuilder();
			int n = 1;
			while (concatenated.length() < 9) {
				concatenated.append(num * n);
				n++;
			}

			if (concatenated.length() == 9 && isPandigital(concatenated.toString())) {
				maxPandigital = Math.max(maxPandigital, Integer.parseInt(concatenated.toString()));
			}
		}

		System.out.println("En büyük pandijital sayı: " + maxPandigital);
	}
}
