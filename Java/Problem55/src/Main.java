import java.math.BigInteger;

/*
@author: mc-es

Problem 55
If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
Not all numbers produce palindromes so quickly. For example,
      349 + 943 = 1292,
      1292 + 2921 = 4213,
      4213 + 3124 = 7337
That is, 349 took three iterations to arrive at a palindrome.

Although no one has proved it yet, it is thought that some numbers, like 196, never produce a palindrome. A number that never forms a palindrome through
the reverse and add process is called a Lychrel number. Due to the theoretical nature of these numbers, and for the purpose of this problem, we shall assume
that a number is Lychrel until proven otherwise. In addition you are given that for every number below ten-thousand, it will either (i) become a palindrome
in less than fifty iterations, or, (ii) no one, with all the computing power that exists, has managed so far to map it to a palindrome. In fact, 10677 is the
first number to be shown to require over fifty iterations before producing a palindrome: 4668731596684224866951378664 (53 iterations, 28-digits).

Surprisingly, there are palindromic numbers that are themselves Lychrel numbers; the first example is 4994.
How many Lychrel numbers are there below ten-thousand?

Answer: 249
*/

public class Main {
  public static void main(String[] args) {
    int limit = 10_000;
    int lychrelCount = countLychrelNumbers(limit);
    System.out.println("Number of Lychrel numbers below " + limit + ": " + lychrelCount);
  }

  public static boolean isPalindrome(BigInteger n) {
    String s = n.toString();
    String reversed = new StringBuilder(s).reverse().toString();
    return s.equals(reversed);
  }

  public static boolean isLychrel(BigInteger n, int maxIterations) {
    for (int i = 0; i < maxIterations; i++) {
      BigInteger reversed = new BigInteger(new StringBuilder(n.toString()).reverse().toString());
      n = n.add(reversed);
      if (isPalindrome(n)) {
        return false;
      }
    }
    return true;
  }

  public static int countLychrelNumbers(int limit) {
    int count = 0;
    for (int i = 0; i < limit; i++) {
      if (isLychrel(BigInteger.valueOf(i), 50)) {
        count++;
      }
    }
    return count;
  }
}
