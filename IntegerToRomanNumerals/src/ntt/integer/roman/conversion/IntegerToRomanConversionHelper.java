/**
 * This Helper class contains the necessary methods to convert Integer to Roman numerals.
 * This class is created to keep the code modular.
 * 
 * @author Gopakumar Rajappan
 * @date   03-07-2021
 */

package ntt.integer.roman.conversion;

import java.util.Map;

public class IntegerToRomanConversionHelper {
	
	/**
	 * Method to convert Integer to Roman numerals
	 * @param userIntegerInput - int
	 * @param integerRomanMap  - Map<Integer, String>
	 * @return romanNumeral    - String
	 */

	protected static String convertIntegerToRoman (int userIntegerInput, Map<Integer,String> integerRomanMap) {

		/**
		 * This method converts integer to roman numerals by successively dividing the user input
		 * starting with upper limit ( 1000 ) followed by other keys in the integerRomanMap. In addition to this,
		 * if the reminder falls with in 90% of the key values, calculation logic is incorporated to find the roman numeral.
		 * user input is updated with the reminder value in each iteration.
		 * 
		**/		
		int quotient, remainder;
		String romanNumeral = "";
		
		while (userIntegerInput != 0) {	
			int divisor = 1000;
			while (divisor >= 1) {
				if (userIntegerInput == 0) { {
						return romanNumeral;
					}
				}
				if (userIntegerInput/divisor != 0) {
					quotient = userIntegerInput / divisor;
					remainder = userIntegerInput % divisor;				
					for (int iterator=0; iterator < quotient; iterator ++) {
						romanNumeral+= integerRomanMap.get(divisor);				
					}	
					userIntegerInput = remainder;
					break;

				}else if (userIntegerInput >= ((9*divisor)/10)) {
					quotient = userIntegerInput/((9*divisor)/10);
					remainder = userIntegerInput % ((9*divisor)/10);
					romanNumeral = romanNumeral + integerRomanMap.get(divisor/10) + integerRomanMap.get(divisor);
					userIntegerInput = remainder;
				} else if ((userIntegerInput/(divisor/2)) != 0){
					quotient = userIntegerInput/(divisor/2);
					remainder = userIntegerInput%(divisor/2);
					romanNumeral+= integerRomanMap.get((divisor/2));				
					userIntegerInput = remainder;
				}
				else if (userIntegerInput >= ((4*divisor)/10)){
					quotient = userIntegerInput/((4*divisor)/10);
					remainder = userIntegerInput%((4*divisor)/10);
					romanNumeral+=  integerRomanMap.get(divisor/10) + integerRomanMap.get((divisor/2));	
					userIntegerInput = remainder;				
				}
				divisor = divisor/10;
			}
		}
		return romanNumeral;
	}
}