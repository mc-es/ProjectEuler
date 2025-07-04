/*
@author: mc-es

Problem 45
Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:
    Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
    Pentagonal	 	Pn=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
    Hexagonal	 	Hn=n(2n−1)	 	1, 6, 15, 28, 45, ...

It can be verified that T285 = P165 = H143 = 40755.

Find the next triangle number that is also pentagonal and hexagonal.

Answer: 1533776805
*/

public class Main {
    public static void main(String[] args) {
        long result = findNextTriPentHex();
        System.out.println("The next triangular, pentagonal, and hexagonal number is: " + result);
    }

    public static boolean isPentagonal(long num) {
        double n = (Math.sqrt(24 * num + 1) + 1) / 6;
        return n == (long) n;
    }

    public static boolean isHexagonal(long num) {
        double n = (Math.sqrt(8 * num + 1) + 1) / 4;
        return n == (long) n;
    }

    public static long findNextTriPentHex() {
        long n = 286;

        while (true) {
            long triangle = n * (n + 1) / 2;
            if (isPentagonal(triangle) && isHexagonal(triangle)) {
                return triangle;
            }
            n++;
        }
    }
}
