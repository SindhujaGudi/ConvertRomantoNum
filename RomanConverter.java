import java.util.Scanner;


public class RomanConverter
{  
int n;
String roman;
RomanConverter(int num)
{
this.n=num;
}
RomanConverter(String num)
{
this.roman=num;
}
  
public String toString()
{

StringBuilder sb = new StringBuilder();
int times = 0;
String[] romans = new String[] { "I", "IV", "V", "IX", "X", "XL", "L","XC", "C", "CD", "D", "CM", "M" };
int[] ints = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500,900, 1000 };
  
for (int i = ints.length - 1; i >= 0; i--) {
times = n / ints[i];
n %= ints[i];
while (times > 0) {
sb.append(romans[i]);
times--;
}
}
return sb.toString();

}
public int toInt()
{
roman=roman.toUpperCase(); 
int sum=0, max=roman.length(), i=0;
while(i<max)
{
if ((i+1)<max && valueOf(roman.charAt(i+1))>valueOf(roman.charAt(i)))   
{
sum+=valueOf(roman.charAt(i+1)) - valueOf(roman.charAt(i));
i+=2;
}
else
{
sum+=valueOf(roman.charAt(i));
i+=1;
}
}
return sum;  
}
  
private int valueOf(Character c)
{
char aux = Character.toUpperCase(c);
switch(aux)
{
case 'I':
return 1;
case 'V':
return 5;
case 'X':
return 10;
case 'L':
return 50;
case 'C':
return 100;
case 'D':
return 500;
case 'M':
return 1000;
default:
return 0;
}
}

public static void main(String s[]) {
        Scanner in = new Scanner(System.in);
String num;
RomanNumeral R;   
  
System.out.println("Enter Roman Numeral");
num=in.next();

try {
System.out.println(num);
int n=Integer.valueOf(num);
R=new RomanNumeral(n);
System.out.println(R);
} catch(NumberFormatException e) {
R=new RomanNumeral(num);
System.out.println(R.toInt());
  
} catch(NullPointerException e) {

e.printStackTrace();
  
}
}
}
