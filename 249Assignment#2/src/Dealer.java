

public class Dealer
{
	private double winningsPersonThisRound;
	private RouletteGame game;
	private String winningsAnnouncement;
	
	
	public void calculateWinnings(final int winningNumber) {
		Player[] players = game.getPlayers();
		for (int playerIndex = 0; playerIndex < players.length; playerIndex++) {
			if (players[playerIndex] != null) {
				int[] bets = players[playerIndex].getBets();
				
				for (int betIndex = 0; betIndex < bets.length; betIndex++) {
					if (bets[betIndex] == winningNumber) {
						winningsAnnouncement += "Player " + playerIndex + " wins x";
						break;
					}
				}
			}
		}
	}
	
	public void setRouletteGame(RouletteGame rg) {
		game = rg;
	}
	
	public void turnWheel() {
		if (game == null) {
			System.out.println("This dealer is not in charge of any roulette game");
			return;
		}
		
		winningsAnnouncement = "";
		int winningNumber = game.spin();
		winningsAnnouncement += winningNumber + " is the winning number.";
		calculateWinnings(winningNumber);
	}

	public void inputBets() {
		System.out.println();
		System.out.println("Round #" + game.getRound());
		Player[] players = game.getPlayers();
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
				int[] bets = InputHelper.inputMaxNumbers("Player " + i + ": ", RouletteGame.MAX_STRAIGHT_NUMBERS);
				
				for (int tokenSpot = 0; tokenSpot < bets.length; tokenSpot++) {
					players[i].setToken(tokenSpot, bets[tokenSpot]);
				}
			}
		}
	}

	public void announceWinnings() {
		System.out.println("Winnings");
		System.out.println("----------");
		System.out.println(winningsAnnouncement);
	}
	
	public String toString() {
		// TODO Dealer string representation
		return "";
	}
}
