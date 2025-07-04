"""
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
"""

def isPandigital(s):
    return "".join(sorted(s)) == "123456789"


maxPandigital = 0

for num in range(1, 10000):
    concatenated = ""
    n = 1
    while len(concatenated) < 9:
        concatenated += str(num * n)
        n += 1

    if len(concatenated) == 9 and isPandigital(concatenated):
        maxPandigital = max(maxPandigital, int(concatenated))

print("En büyük pandijital sayı:", maxPandigital)
