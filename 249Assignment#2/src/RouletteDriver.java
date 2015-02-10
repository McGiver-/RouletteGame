

public class RouletteDriver {

	public static void main(String[] args) {
		RouletteGame game = new AmericanRoulette();
		Dealer dealer = new Dealer();
		dealer.setRouletteGame(game);
		
		game.setPlayer(new Player("Test 1"), 0);
		game.setPlayer(new Player("Test 2"), 1);
		game.setPlayer(new VIP("VIP test"), 2);
		
		System.out.println(game);
		
		do {
			dealer.inputBets();
			dealer.turnWheel();
			dealer.announceWinnings();
		} while(game.getRound() < 10);
		
	}

}
