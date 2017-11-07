public class RomanNumeral {
    
       private final int num;   
      
       private static int[]    numbers = { 1000,  900,  500,  400,  100,   90,  50,   40,   10,    9,    5,    4,    1 };
                                          
       private static String[] letters = { "M",  "CM",  "D",  "CD", "C",  "XC", "L",  "XL",  "X",  "IX", "V",  "IV", "I" };
          
    
       public RomanNumeral(int arabic) {

          if (arabic < 1)
             throw new NumberFormatException("Value of RomanNumeral must be positive.");
          if (arabic > 3999)
             throw new NumberFormatException("Value of RomanNumeral must be 3999 or less.");
          num = arabic;
       }
       
    
       public RomanNumeral(String roman) {
             
          if (roman.length() == 0)
             throw new NumberFormatException("An empty string does not define a Roman numeral.");
             
          roman = roman.toUpperCase();  
          
          if (roman.matches(".*[0-9].*") || !roman.matches("[M|D|C|L|X|V|I]*")) {
        	  throw new NumberFormatException("Invalid character in input. Valid characters are I,V,X,L,C,D,M.");
          }
          
          int i = 0;       
          int arabic = 0;  
          int count1=0;
          int prevNumber = 999999;
          
          while (i < roman.length()) {
          
             char letter = roman.charAt(i);        
             int number = letterToNumber(letter);  
             
             i++;
             
             if (i > 1)
            	 prevNumber = letterToNumber(roman.charAt(i-2));
             
             if (i == roman.length()) {
            	if(number > prevNumber && count1>0 )
            		throw new NumberFormatException("Invalid numeral: two consecutive subtractions.");
                arabic += number;
             }
             else {
                   
                int nextNumber = letterToNumber(roman.charAt(i));
                if (nextNumber > number ) {
                      
                	if (number == 5 || number == 50 || number == 500)
                		throw new NumberFormatException("Invalid numeral: can't subtract auxiliary symbol.");
                	if(count1>0 || nextNumber > prevNumber  )
                		throw new NumberFormatException("Invalid numeral: additions don't decrease.");
                   arabic += (nextNumber - number);
                   
                   count1++;
                   i++;
                }
                else {
                      
                   count1=0;
                   
                   arabic += number;
                }
             }
             
          }  
          
          if (arabic > 3999)
             throw new NumberFormatException("Roman numeral must have value 3999 or less.");
             
          num = arabic;
          
       } 
       
    
       private int letterToNumber(char letter) {
       
          switch (letter) {
             case 'I':  return 1;
             case 'V':  return 5;
             case 'X':  return 10;
             case 'L':  return 50;
             case 'C':  return 100;
             case 'D':  return 500;
             case 'M':  return 1000;
             default:   return -1;
          }
       }
       
    
       public String toString() {
             
          String roman = "";  
          int N = num;       
          for (int i = 0; i < numbers.length; i++) {
             while (N >= numbers[i]) {
                roman += letters[i];
                N -= numbers[i];
             }
          }
          return roman;
       }
       
     
       public int toInt() {
            
          return num;
       }
     
       
    } 
