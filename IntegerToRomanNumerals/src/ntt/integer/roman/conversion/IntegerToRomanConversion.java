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
		
		int [] integerValues = {1, 5, 10, 50, 100, 500, 1000};
		String [] romanNumerals = {"I", "V", "X", "L", "C", "D", "M"};
		
		/**
		 * HashMap used to store the key-value pairs since speed of operation 
		 * is the constraint than order.
		 **/
		Map<Integer,String> integerRomanMap = new HashMap<Integer, String>();
		
		/**
		 * 	integerRomanMap is populated based on integer array and roman numeral array.
		 * This design change is done to make the code more generic and scalable by eliminating
		 * hard-coding of key-value pairs.
		 */		
		try {
			if (integerValues.length == romanNumerals.length) {
				for (int iterator = 0; iterator < integerValues.length; iterator++) {
					integerRomanMap.put(integerValues[iterator], romanNumerals[iterator]);
				}
				System.out.println("integerRomanMap: " + integerRomanMap);
			}else {
				throw new Exception();
			}
		}catch (Exception except) {
			System.out.println("please make sure that integerValues array and romanNumerals array mapping is correct");
		}
		
		/**
		 * Accepting user input and closing scanner after use.
		 */
		System.out.print("Enter Integer to be converted to Roman numeral: ");
		Scanner scan = new Scanner(System.in);
		int userIntegerInput;
		try{
			userIntegerInput = scan.nextInt();
		}finally {
			scan.close();
		}
		
		/**
		 * This program accepts integer values from 1 to 5000 and convert it into Roman numerals.
		 * Even though 5000 has a Roman numeral representation of its own, this program represents
		 * the 5000 as 'MMMMM' based on the Roman letter representation provided with the question.
		 */
		try {
			/**
			 * Throw exception for invalid inputs.
			 */
			if (userIntegerInput <1 || userIntegerInput > 5000) {
				throw new Exception();
			}
			
			String romanNumeral = IntegerToRomanConversionHelper.convertIntegerToRoman(userIntegerInput, integerRomanMap);
			if (romanNumeral != null) {
				System.out.println("Roman numeral equivalent of the given input is: " + romanNumeral);	
			}else {
				throw new NullPointerException();
			}

		}
		catch (NullPointerException nullException) {
			System.out.println("Unable to convert given integer to Roman numeral");
		}catch (Exception exception) {
			System.out.println("Enter a valid number from 1 to 5000");
		}
	}
        

}