import java.util.Scanner;


public class InputHelper {
	private static Scanner keyboard = new Scanner(System.in);
	
	private static boolean validateMaxIntegers(String[] numbers, int expectedLength) {
		// if the array is not a right size, just return false now
		if (numbers.length > expectedLength) return false;
		
		// try to parse all the strings to integer
		try {
			for (String num : numbers) {
				Integer.parseInt(num);
			}
		} catch (NumberFormatException e) {
			// if one of them is not an integer, return false
			return false;
		}
		
		// they are all integers, so return true
		return true;
	}
	
	public static int[] inputMaxNumbers(String inputText, int length) {
		
		// input all the numbers as strings
		String[] inputs;
		do {
			System.out.print(inputText);
			inputs = keyboard.nextLine().split(" ");
			
			// make sure they are integers
			if (validateMaxIntegers(inputs, length)) {
				break;
			} else {
				System.out.println("Bad input");
				continue;
			}
			
		} while(true);
		
		// we know the 'inputs' array contains only integers
		// so, parse them
		int[] numbers = new int[inputs.length];
		for (int i = 0; i < inputs.length; i++) {
			numbers[i] = Integer.parseInt(inputs[i]);
		}
		
		return numbers;
	}
}
