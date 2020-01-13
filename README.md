# Edit-Distance

![screenshot](https://sun9-54.userapi.com/c205820/v205820368/3a288/spustRX7tHc.jpg)

## A classic Dynamic Programming problem.

### Problem Statement:
Given two strings find the minimum number of operations required to convert one into another

Available operations on strings:

1) Insert a character
2) Remove a character
3) Replace a character

Example:

To convert "moon" to "mood" we need one operation (replace 'n' with 'd')

### Approach:

The problem is not really about actual replacements, insertions or removals, it is rather about counting.

Let n and m be the lengths of the input strings respectively.

First, we need an 2D array that will store the result for every substring combination. (int[][] table = new int[n+1][m+1])
That means for every substring of the first string we are going to compute the subresults in respects with the every substring in the second string.

#### How the table is built:

Let i and j be the iterator variables of the input strings respectively.

*if one of the strings length is 0 the result is the length of the second string*
("", "mood" -> the only way to convert first empty string into the second is to copy all the characters of the second string into the first)

*if characters are equal then no operation required (table[i][j] = table[i-1][j-1])*

If characters are different, then take the minimum price of the mentioned above operations and add 1 to it:
**1 + min (**
1) replace -> table[i-1][j-1]
("word", "lord"; replace 'w' with 'l')
2) remove -> table[i-1][j]
("lemons", "lemon"; remove 's')
3) insert -> table [i][j-1]
("sin", "sink"; insert 'k')
 **)**
