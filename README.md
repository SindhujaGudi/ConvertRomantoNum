# ConvertRomantoNum

Write a program to convert roman numerals into their arabic equivalent.


INPUT REQUIREMENTS


Read one or more roman numerals from standard input. Process one line at a time. Each input line contains only one roman numeral, starting in column one. Assume the characters are all upper case with no embedded blanks.


OUTPUT REQUIREMENTS


The arabic equivalent of each input roman numeral is displayed on standard output, starting in column one.


FUNCTIONAL REQUIREMENTS


Here are the arabic equivalents for roman symbols:


The "basic" roman symbols                                 The "auxiliary" roman symbols 
 


 I         X      C       M                                           V     L      D
1        10     100    1000                                      5     50     500



Convert the roman numeral to arabic processing the symbols from left to right according to the following rules:


1. A symbol following one of greater or equal value adds to its value. (E.g., XII = 12)
2. A symbol preceding one of greater value subtracts its value.(E.g., IV = 4; XL = 40)



ERROR HANDLING REQUIREMENTS


In each of the error conditions below, display the given message and skip the numeral and continue processing the next line.


"Invalid character in input. Valid characters are I,V,X,L,C,D,M."


Only the listed characters are valid.

"Invalid numeral: can't subtract auxiliary symbol."

It is not permitted to subtract an "auxiliary" symbol. (CML, not LM = 950; XLV not VL, = 45).

"Invalid numeral: two consecutive subtractions."

Can't do two subtractions in a row, thus LIVX is illegal.

"Invalid numeral: additions don't decrease."

Additions must decrease, as you go from left to right. Thus, each symbol added must have a value equal or less than the last symbol which was added. Thus, LIIX is wrong, cause we added L, added I, subtracted I, then try to add X.
