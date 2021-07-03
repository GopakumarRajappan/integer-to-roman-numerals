/**
 * @author Gopakumar Rajappan
 * @date   03-07-2021
 */

package ntt.integer.roman.conversion;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class IntegerToRomanConversion {

	public static void main(String[] args) {
		
		/**
		 * HashMap used to store the key-value pairs since speed of operation 
		 * is the constraint than order.
		 **/
		Map<Integer,String> integerRomanMap = new HashMap<Integer, String>();
		integerRomanMap.put(1, "I");
		integerRomanMap.put(5, "V");
		integerRomanMap.put(10, "X");
		integerRomanMap.put(50, "L");
		integerRomanMap.put(100, "C");
		integerRomanMap.put(500, "D");
		integerRomanMap.put(1000, "M");
		
		System.out.print("Enter Integer to be converted to Roman numeral: ");
		Scanner scan = new Scanner(System.in);		
		int userIntegerInput = scan.nextInt();

		String romanNumeral = "";
		

		/**
	    * while loop is used to exit the loop based on exit condition.
	    * Valid user input is verified against the standard "key" mentioned in
	    * the integerRomanMap. Also special cases for each valid key is considered.
		**/		
		int quotient, remainder;
		
		while (userIntegerInput != 0) {			
			if (userIntegerInput/1000 != 0) {
				quotient = userIntegerInput / 1000;
				remainder = userIntegerInput % 1000;				
				for (int iterator=0; iterator < quotient; iterator ++) {
					romanNumeral+= integerRomanMap.get(1000);				
				}				
				userIntegerInput = remainder;	
			}else if (userIntegerInput >=900) {
				quotient = userIntegerInput/900;
				remainder = userIntegerInput % 900;
				romanNumeral = romanNumeral + integerRomanMap.get(100) + integerRomanMap.get(1000);
				userIntegerInput = remainder;
			} else if (userIntegerInput/500 != 0){
				quotient = userIntegerInput/500;
				remainder = userIntegerInput%500;
				romanNumeral+= integerRomanMap.get(500);				
				userIntegerInput = remainder;
			}
			else if (userIntegerInput >= 400){
				quotient = userIntegerInput/400;
				remainder = userIntegerInput%400;
				romanNumeral+=  integerRomanMap.get(100) + integerRomanMap.get(500);	
				userIntegerInput = remainder;
			}
					
			else if (userIntegerInput/100 != 0) {
				quotient = userIntegerInput/100;
				remainder = userIntegerInput%100;				
				for (int iterator=0; iterator < quotient; iterator ++) {
					romanNumeral+= integerRomanMap.get(100);				
				}				
				userIntegerInput = remainder;			
			}else if (userIntegerInput >=90) {
				quotient = userIntegerInput/90;
				remainder = userIntegerInput%90;
				romanNumeral = romanNumeral + integerRomanMap.get(10) + integerRomanMap.get(100);
				userIntegerInput = remainder;
			} else if (userIntegerInput/50 != 0){
				quotient = userIntegerInput/50;
				remainder = userIntegerInput%50;

				romanNumeral+= integerRomanMap.get(50);				
				userIntegerInput = remainder;
			}
			else if (userIntegerInput >=40){
				quotient = userIntegerInput/40;
				remainder = userIntegerInput%40;				
				romanNumeral+=  integerRomanMap.get(10) + integerRomanMap.get(50);	
				userIntegerInput = remainder;
			}
						
			else if (userIntegerInput/10 != 0) {
				quotient = userIntegerInput/10;
				remainder = userIntegerInput%10;				
				for (int iterator=0; iterator < quotient; iterator ++) {
					romanNumeral+= integerRomanMap.get(10);				
				}				
				userIntegerInput = remainder;			
			}else if (userIntegerInput >=9) {
				quotient = userIntegerInput/9;
				remainder = userIntegerInput%9;
				romanNumeral+= integerRomanMap.get(1) + integerRomanMap.get(10);
				userIntegerInput = remainder;
			} else if (userIntegerInput/5 != 0){
				quotient = userIntegerInput/5;
				remainder = userIntegerInput%5;
				romanNumeral+= integerRomanMap.get(5);				
				userIntegerInput = remainder;
			}
			else if (userIntegerInput > 4){
				quotient = userIntegerInput/4;
				remainder = userIntegerInput%4;				
				romanNumeral+=  integerRomanMap.get(1) + integerRomanMap.get(5);	
				userIntegerInput = remainder;
			}
			
			else if (userIntegerInput/1 != 0) {
				quotient = userIntegerInput/1;
				remainder = userIntegerInput%1;
				
				for (int iterator=0; iterator < quotient; iterator ++) {
					romanNumeral+= integerRomanMap.get(1);				
				}				
				userIntegerInput = remainder;			
			}
		}
		System.out.println("Roman numeral equivalent of the given input is: " + romanNumeral);
	}
}