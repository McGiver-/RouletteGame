
public class RouletteDriver {

	public static void main(String[] args) {
		RouletteGame game = new EuropeanRoulette();
		Dealer dealer = new Dealer();
		dealer.setRouletteGame(game);
		
		game.displayTable();
	}

}
