"""
@author: mc-es

Problem 21
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.

Answer: 31626
"""

# Calculate the sum of proper divisors of n


def d(n):
    divisors = [1]
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            divisors.append(i)
            if i != n // i:
                divisors.append(n // i)
    return sum(divisors)


# Find all amicable numbers under 10000
amicables = set()
amicableSum = 0

for i in range(1, 10000):
    if i in amicables:
        continue
    b = d(i)
    if d(b) == i and b != i:
        amicables.add(i)
        amicables.add(b)
        amicableSum += i + b

print(amicableSum)
