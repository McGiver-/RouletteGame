

public class RouletteDriver {

	public static void main(String[] args) {
		RouletteGame game = new AmericanRoulette();
		Dealer dealer = new Dealer();
		dealer.setGame(game);
		
		game.setPlayer(new NormalPlayer("Walter White"), 0);
		game.setPlayer(new NormalPlayer("Joe Blow"), 1);
		game.setPlayer(new VIP("Bill Gates"), 2);
		game.setPlayer(new VIP("Barack Obama"), 3);
		game.setPlayer(new VIP("Mark Zuckerberg"), 4);
		game.setPlayer(new NormalPlayer("Saul Goodman"), 5);
		
		System.out.println(game);
		
		do {
			dealer.inputBets();
			dealer.turnWheel();
		} while(game.getRound() < 10);
		
	}

}
