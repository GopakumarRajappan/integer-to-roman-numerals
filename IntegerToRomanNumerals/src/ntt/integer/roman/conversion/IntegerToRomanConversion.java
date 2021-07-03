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