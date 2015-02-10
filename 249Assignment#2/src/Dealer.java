

public class Dealer
{
	private double winningsPersonThisRound;
	private RouletteGame game;
	private String winningsAnnouncement;
	
	public void calculateWinnings(final int winningNumber) {
		int totalRoundWinnings = 0;
		int totalRoundBets = 0;
		
		Player[] players = game.getPlayers();
		for (int playerIndex = 0; playerIndex < players.length; playerIndex++) {
			if (players[playerIndex] != null) {
				int[] bets = players[playerIndex].getBets();
				totalRoundBets += bets.length;
				
				for (int betIndex = 0; betIndex < bets.length; betIndex++) {
					if (bets[betIndex] == winningNumber) {
						int playerWinnings = players[playerIndex].addCurrentValue();
						totalRoundWinnings += playerWinnings;
						winningsAnnouncement += "Player " + playerIndex + " wins " + playerWinnings;
						break;
					}
				}
			}
		}
		
		game.addWinnings(totalRoundWinnings);
		game.addBets(totalRoundBets);
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
		game.resetBets();
	}
	

	public void inputBets() {
		System.out.println();
		System.out.println("Round #" + game.getRound());
		Player[] players = game.getPlayers();
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
				int[] bets = InputHelper.inputBets("Player " + i + ": ", game);
				
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
