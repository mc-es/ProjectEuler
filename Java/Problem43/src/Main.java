import java.util.ArrayList;
import java.util.List;

/*
@author: mc-es

Problem 43
The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also
has a rather interesting sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
* d2d3d4=406 is divisible by 2
* d3d4d5=063 is divisible by 3
* d4d5d6=635 is divisible by 5
* d5d6d7=357 is divisible by 7
* d6d7d8=572 is divisible by 11
* d7d8d9=728 is divisible by 13
* d8d9d10=289 is divisible by 17

Find the sum of all 0 to 9 pandigital numbers with this property.

Answer: 16695334890
*/

public class Main {
    public static void main(String[] args) {
        long total = 0;
        List<String> permutations = generatePermutations("0123456789");

        for (String number : permutations) {
            if (isValid(number)) {
                total += Long.parseLong(number);
            }
        }

        System.out.println("Result: " + total);
    }

    private static boolean isValid(String number) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17};

        for (int i = 0; i < primes.length; i++) {
            int subNumber = Integer.parseInt(number.substring(i + 1, i + 4));
            if (subNumber % primes[i] != 0) {
                return false;
            }
        }

        return true;
    }

    private static List<String> generatePermutations(String input) {
        List<String> result = new ArrayList<>();
        permute("", input, result);
        return result;
    }

    private static void permute(String prefix, String remaining, List<String> result) {
        int n = remaining.length();

        if (n == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permute(prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1, n),
                        result);
            }
        }
    }
}
