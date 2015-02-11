

public class RouletteDriver {

	public static void main(String[] args) {
		RouletteGame game = new AmericanRoulette();
		Dealer dealer = new Dealer();
		dealer.setGame(game);
		
		game.setPlayer(new NormalPlayer("Test 1"), 0);
		game.setPlayer(new NormalPlayer("Test 2"), 1);
		game.setPlayer(new VIP("VIP test"), 2);
		
		System.out.println(game);
		
		do {
			dealer.inputBets();
			dealer.turnWheel();
		} while(game.getRound() < 10);
		
	}

}
