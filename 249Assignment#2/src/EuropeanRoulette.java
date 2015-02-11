/**
 * Implementation of the RouletteGame class using the layout and rules of a 
 * european roulette game.
 * @author Mario
 *
 */
public class EuropeanRoulette extends RouletteGame {
	private static final String[] LAYOUT = { "0", "32", "15", "19", "4", "21",
			"2", "25", "17", "34", "6", "27", "13", "36", "11", "30", "8", "23", "10", "5",
			"24", "16", "33", "1", "20", "14", "31", "9", "22", "18", "29",
			"7", "28", "12", "35", "3", "26" };

	public EuropeanRoulette() {
		super();
	}

	@Override
	public String[] getLayout() {
		return LAYOUT;
	}

	/**
	 * Fills the need to implement the abstract method. No need to change
	 * the input since all numbers in LAYOUT are distinct numbers.
	 */
	@Override
	public String stringToStraightNumber(String straight) {
		return straight;
	}
}
