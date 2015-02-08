

public class RouletteDriver {

	public static void main(String[] args) {
		RouletteGame game = new AmericanRoulette();
		Dealer dealer = new Dealer();
		dealer.setRouletteGame(game);
		
		System.out.println(game);
	}

}
