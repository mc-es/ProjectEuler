"""
@author: mc-es

Problem 42
The nth term of the sequence of triangle numbers is given by Tn=n(n+1)/2; so the first ten triangle numbers are:
                                1,3,6,10,15,21,28,36,45,55,...
By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value.
For example, the word value for SKY is 19+11+25=55=10. If the word value is a triangle number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?

Answer: 162
"""


def isTriangleNumber(n):
    x = (-1 + (1 + 8 * n) ** 0.5) / 2
    return x.is_integer()


def calculateWordValue(word):
    return sum(ord(char) - ord("A") + 1 for char in word)


with open("words.txt", "r") as file:
    words = file.read().replace('"', "").split(",")

triangleWords = [word for word in words if isTriangleNumber(calculateWordValue(word))]

print(f"Number of triangle words: {len(triangleWords)}")
