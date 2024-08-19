package Module1;

import java.util.Scanner;

class RomanToInteger {

    public static int romanToInt(String s) {
        // Map to store the values of Roman numerals
        java.util.Map<Character, Integer> romanToIntMap = new java.util.HashMap<>();
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);

        // Initialize the result to store the final integer value
        int result = 0;
        // Get the length of the input string
        int length = s.length();

        // Iterate through each character in the string
        for (int i = 0; i < length; i++) {
        	
            // Get the integer value of the current Roman numeral character 
            int currentValue = romanToIntMap.get(s.charAt(i));
            
            
            // Get the integer value of the next Roman numeral character if it exists
            // If there is no next character, set nextValue to 0
            int nextValue = (i + 1 < length) ? romanToIntMap.get(s.charAt(i + 1)) : 0;

            // If the current value is less than the next value, it indicates a subtractive combination
            if (currentValue < nextValue) {
                // Subtract the current value from the result
                result -= currentValue;
            } else {
                // Otherwise, add the current value to the result
                result += currentValue;
            }
        }

        // Return the final integer value
        return result;
    }

    public static void main(String[] args) {
        // Test cases to demonstrate the functionality of the romanToInt method
//        System.out.println(romanToInt("III"));    // Output: 3
//        System.out.println(romanToInt("IV"));     // Output: 4
//        System.out.println(romanToInt("IX"));     // Output: 9
//        System.out.println(romanToInt("LVIII"));  // Output: 58
//        System.out.println(romanToInt("MCMXCIV"));// Output: 1994
    	
    	Scanner sc = new Scanner(System.in);
    	
    	while (true) {
            System.out.print("Enter your Roman numeral or type 'exit' to Exit: ");
            String input = sc.nextLine();

            // Check if the user wants to exit
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            // Convert the Roman numeral to an integer and print the result
            int output = romanToInt(input);
            System.out.println("Converted Integer: " + output);
        }

        sc.close();
    	   	
    }
        
}
