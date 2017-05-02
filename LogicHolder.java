import java.io.*;
import java.util.*;
import java.net.*;
import java.nio.*;
import java.math.BigInteger;

public class LogicHolder
{
/*Functions to contain:
-Decimal to binary convert ...done
-Decimal to octal convert ...done
-Decimal to Hex convert ...done
-Binary to decimal convert ...done
-Octal to decimal convert ...done
-Hex to decimal convert ...done

-Roman to integer convert ...done
-Intger to Roman convert ...done

-Encode URL ...done
-Decode URL ...done

******ALL LOGIC HERE********

Functions for all combinations of the bases Binary(2), Octal(8), Decimal(10) and Hexadecimal(16) are to be here.
=> 4 x 3 = 12 functions for Number System converter

+

2 (Roman-Integer)

+

2 (Encoder/Decoder)

= 16 functions total;
oh yeah oh yeah

*/
//////// back  fucntions///////////////////
//###########Decimal to binary###############
public static String toBinary(double d, int precision) {
    long wholePart = (long) d;
    return wholeToBinary(wholePart) + '.' + fractionalToBinary(d - wholePart, precision);
}

private static String wholeToBinary(long l) {
    return Long.toBinaryString(l);
}

private static String fractionalToBinary(double num, int precision) {
    StringBuilder binary = new StringBuilder();
    while (num > 0 && binary.length() < precision) {
        double r = num * 2;
        if (r >= 1) {
            binary.append(1);
            num = r - 1;
        } else {
            binary.append(0);
            num = r;
        }
    }
    return binary.toString();
}

//###########Decimal to octal and Hex are shorthand###############

//###########All to Decimal are Shorthand###############

//###############Integer to ROMAN numeral##############
public static String CnvrtIntegerToRoman(int number)
 {
    number = Math.min(3999, Math.max(1, number));
    String asRomanNumerals = "";
	
    String[] RN = {"I", "V", "X", "L", "C", "D", "M" };
    int i = 0; 
    while (number > 0)
	{
        switch(number % 10) {
        case 1: asRomanNumerals = RN[i] + asRomanNumerals; break;
        case 2: asRomanNumerals = RN[i] + RN[i] + asRomanNumerals; break;
        case 3: asRomanNumerals = RN[i] + RN[i] + RN[i] + asRomanNumerals; break;
        case 4: asRomanNumerals = RN[i] + RN[i + 1] + asRomanNumerals; break;
        case 5: asRomanNumerals = RN[i + 1] + asRomanNumerals; break;
        case 6: asRomanNumerals = RN[i + 1] + RN[i] + asRomanNumerals; break;
        case 7: asRomanNumerals = RN[i + 1] + RN[i] + RN[i] + asRomanNumerals; break;
        case 8: asRomanNumerals = RN[i + 1] + RN[i] + RN[i] + RN[i] +asRomanNumerals; break;
        case 9: asRomanNumerals = RN[i] + RN[i + 2] + asRomanNumerals; break;
        }
        number = (int) number / 10;
        i += 2;
    }
    return asRomanNumerals;
 }
 
 //###############ROMAN numeral to Integer ##############
       
        public static int CnvrtRomanToInteger(String romanNumeral) {
		
                romanNumeral = romanNumeral.toUpperCase();
                int decimalNum=0;        
                int l=  romanNumeral.length();
				
				for (int invalidChecker=l-1;invalidChecker>=0;invalidChecker--)
				if(romanNumeral.charAt(invalidChecker)!='M' && romanNumeral.charAt(invalidChecker)!='D' && romanNumeral.charAt(invalidChecker)!='C' && romanNumeral.charAt(invalidChecker)!='L' && romanNumeral.charAt(invalidChecker)!='X' && romanNumeral.charAt(invalidChecker)!='V' && romanNumeral.charAt(invalidChecker)!='I'){
				System.out.println("Roman numbers exist only within 1 - 3999.");
				break;}
                int num=0;
                int previousnum = 0;
                for (int i=l-1;i>=0;i--)
                { 
                        char x =  romanNumeral.charAt(i);
                        x = Character.toUpperCase(x);
                        switch(x)
                        {  
                                case 'I':
                                previousnum = num;
                                num = 1;
                                break;
                             case 'V':
                                     previousnum = num;
                                num = 5;
                                break;
                                case 'X':
                                        previousnum = num;
                                num = 10;
                                break;
                                case 'L':
                                        previousnum = num;
                                num = 50;
                                break;
                                case 'C':
                                        previousnum = num;
                                num = 100;
                                break;
                                case 'D':
                                        previousnum = num;
                                num = 500;
                                break;
                                case 'M':
                                        previousnum = num;
                                num = 1000;
                                break;
                        }           
                        if (num<previousnum)
                        {decimalNum= decimalNum-num;}
                         else
                        decimalNum= decimalNum+num;
                }
				return decimalNum;
        }
    
 //###############URL ENCODER##############

public static String EncodeURL(String ToBeConverted)
{
try{
 URL url= new URL(ToBeConverted);
    URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
	 ToBeConverted=uri.toASCIIString();
		
	}
	catch(Exception e){}
	return ToBeConverted;
	   
}

//###############URL DECODER##############
public static String DecodeURL(String ToBeConverted)
{String returner="";
try{
		 returner= URLDecoder.decode(ToBeConverted,"UTF-8");}
		 catch(Exception e){}
		return returner;
		
}





// ---------------Front functions---------------
//===============Decimal to binary=================
public static String CnvrtDecimalToBinary(double ToBeConverted)
{
return toBinary(ToBeConverted,50);
}
//===============Decimal to Octal=================
public static String CnvrtDecimalToOctal(long ToBeConverted)
{
return Long.toOctalString(ToBeConverted);
}
//===============Decimal to Hex=================
public static String CnvrtDecimalToHex(long ToBeConverted)
{
return Long.toHexString(ToBeConverted).toUpperCase();
}
//===============Binary to Decimal=================
public static long CnvrtBinaryToDecimal(String ToBeConverted)
{
return Long.parseLong(ToBeConverted,2);
}
//===============Octal to Decimal=================
public static long CnvrtOctalToDecimal(String ToBeConverted)
{
return Long.parseLong(ToBeConverted,8);
}
//===============Hex to Decimal=================
public static long CnvrtHexToDecimal(String ToBeConverted)
{
return Long.parseLong(ToBeConverted,16);
}

//===============Binary to Octal=================
public static String CnvrtBinaryToOctal(String ToBeConverted)
{
return CnvrtDecimalToOctal((long)CnvrtBinaryToDecimal(ToBeConverted));
}

//===============Binary to Hex=================
public static String CnvrtBinaryToHex(String ToBeConverted)
{
return CnvrtDecimalToHex((long)CnvrtBinaryToDecimal(ToBeConverted)).toUpperCase();
}

//===============Octal to Binary=================
public static String CnvrtOctalToBinary(String ToBeConverted)
{
return CnvrtDecimalToBinary(CnvrtOctalToDecimal(ToBeConverted)).toString();
}

//===============Octal to Hex=================
public static String CnvrtOctalToHex(String ToBeConverted)
{
return CnvrtDecimalToHex(CnvrtOctalToDecimal(ToBeConverted)).toUpperCase();
}

//===============Hex to Binary=================
public static String CnvrtHexToBinary(String ToBeConverted)
{
return CnvrtDecimalToBinary((double)CnvrtHexToDecimal(ToBeConverted));
}

//===============Hex to Octal=================
public static String CnvrtHexToOctal(String ToBeConverted)
{
return CnvrtDecimalToOctal(CnvrtHexToDecimal(ToBeConverted));
}


}




























