/**
 * Implementation of the RouletteGame class using the layout and rules of an american roulette game.
 * @author Mario, George
 * @see RouletteGame
 * @see EuropeanRoulette
 */

public class AmericanRoulette extends RouletteGame {
	private static final String[] LAYOUT = { "0", "28", "9", "26", "30", "11",
			"7", "20", "32", "17", "5", "22", "34", "15", "3", "24", "36",
			"13", "1", "00", "27", "10", "25", "29", "12", "8", "19", "31",
			"18", "6", "21", "33", "16", "4", "23", "35", "14", "2" };

	public AmericanRoulette() {
		super();
	}

	@Override
	public String[] getLayout() {
		return LAYOUT;
	}

	/**
	 * This method makes sure that the string 00 is converted to 37 (represents 00)
	 * because 00 would otherwise be converted to 0
	 */
	@Override
	public String stringToStraightNumber(String straight) {
		if (straight.equals("00")) {
			return "37";
		} else {
			return straight;
		}
	}

}
