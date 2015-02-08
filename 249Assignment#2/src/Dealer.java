

public class Dealer
{
	private double winningsPersonThisRound;
	private RouletteGame game;
	
	
	public Dealer() {
	}
	
	public void calculateWinnings(final int winningNumber) {
		Player[] players = game.getPlayers();
		for (int playerIndex = 0; playerIndex < players.length; playerIndex++) {
			if (players[playerIndex] != null) {
				// TODO Make this work once player class is finished
				/*int[] bets = players[playerIndex].getBets();
				
				for (int betIndex = 0; betIndex < bets.length; betIndex++) {
					if (bets[betIndex] == winningNumber) {
						System.out.println("Player " + playerIndex + " wins x");
						break;
					}
				}*/
			}
		}
	}
	
	public void setRouletteGame(RouletteGame rg) {
		game = rg;
	}
	
	public void turnWheel() {
		int winningNumber = game.spin();
		calculateWinnings(winningNumber);
	}
}
