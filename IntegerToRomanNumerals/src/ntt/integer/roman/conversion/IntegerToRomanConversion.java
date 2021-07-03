/**
 * @author Gopakumar Rajappan
 * @date   03-07-2021
 */

package ntt.integer.roman.conversion;

import java.util.Map;
import java.util.HashMap;

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
	}
}
