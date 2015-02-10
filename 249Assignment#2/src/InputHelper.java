import java.util.Scanner;


public class InputHelper {
	private static Scanner keyboard = new Scanner(System.in);
	
	private static boolean validateMaxRangeIntegers(String[] numbers, int expectedLength, int low, int high) {
		// if the array is not a right size, just return false now
		if (numbers.length > expectedLength) return false;
		
		// try to parse all the strings to integer
		try {
			for (String num : numbers) {
				int number = Integer.parseInt(num);
				if (number > high || number < low) {
					return false;
				}
			}
		} catch (NumberFormatException e) {
			// if one of them is not an integer, return false
			return false;
		}
		
		// they are all integers, so return true
		return true;
	}
	
	public static int[] inputBets(String inputText, RouletteGame game) {
		int maxBets = RouletteGame.MAX_STRAIGHT_NUMBERS;
		
		// input all the numbers as strings
		String[] inputs;
		do {
			System.out.print(inputText);
			inputs = keyboard.nextLine().split(" ");
			
			for (int i = 0; i < inputs.length; i++) {
				inputs[i] = game.stringToStraightNumber(inputs[i]);
			}
			
			// make sure they are integers
			if (validateMaxRangeIntegers(inputs, maxBets, 0, game.getLayout().length-1)) {
				break;
			} else {
				System.out.println("Bad input");
				continue;
			}
			
		} while(true);
		
		// we know the 'inputs' array contains only integers
		// so, parse them
		int[] numbers = new int[maxBets];
		for (int i = 0; i < inputs.length; i++) {
			numbers[i] = Integer.parseInt(inputs[i]);
		}
		
		if (inputs.length < maxBets) {
			for (int i = inputs.length; i < maxBets; i++) {
				numbers[i] = Player.EMPTY_BET_FILLER;
			}
		}
		
		return numbers;
	}
}
