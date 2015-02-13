package roulette;
/**
 * Dealer class operates an instance of RouletteGame by spinning it, calculating the winnings
 * and paying them out the players as well as making the announcements.
 * @author Mario, George
 *
 */

public class Dealer
{
	private RouletteGame game; // the game that the dealer is in charge of
	private String winningsAnnouncement; // holds the announcements for this round
	
	/**
	 * Will freeze the bets made by players, and then spins the wheel, calculates the winnings
	 * for each player, announces the winnings, and resets the bets.
	 */
	public void turnWheel() {
		if (game == null) {
			System.out.println("This dealer is not in charge of any roulette game");
			return;
		}
		
		winningsAnnouncement = "";
		int winningNumber = game.spin();
		winningsAnnouncement += winningNumber + " is the winning number.";
		calculateWinnings(winningNumber);
		announceWinnings();
		game.resetBets();
		game.nextRound();
	}
	

	/**
	 * Will input the bets for all players
	 */
	public void inputBets() {
		System.out.println();
		System.out.println("Round #" + game.getRound());
		System.out.println("Dealer: Please input a maximum of " + RouletteGame.MAX_STRAIGHT_NUMBERS + " bets (separated by spaces)");
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

	
	public String toString() {
		String output = "";
		output += "Dealer currently associated with table:";
		return output;
	}
	
	public boolean equals(Dealer d) {
		if (d.getGame().equals(this.getClass())) {
			return true;
		} else {
			return false;
		}
	}

	public RouletteGame getGame() {
		return game;
	}

	public void setGame(RouletteGame game) {
		this.game = game;
	}
	
	private void calculateWinnings(final int winningNumber) {
		int totalRoundWinnings = 0;
		int totalRoundBets = 0;
		
		boolean winner = false;
		
		// check all players to see if they win
		Player[] players = game.getPlayers();
		for (int playerIndex = 0; playerIndex < players.length; playerIndex++) {
			if (players[playerIndex] != null) {
				int[] bets = players[playerIndex].getBets();
				totalRoundBets += bets.length;
				
				// check every bet spot to see if it matches the winning number
				for (int betIndex = 0; betIndex < bets.length; betIndex++) {
					if (bets[betIndex] == winningNumber) {
						winner = true;
						int playerWinnings = players[playerIndex].addCurrentValue();
						totalRoundWinnings += playerWinnings;
						winningsAnnouncement += "\nPlayer " + playerIndex + " wins " + playerWinnings;
						break;
					}
				}
			}
		}
		
		if (!winner) {
			winningsAnnouncement += "\nNo winners.";
		}
		
		winningsAnnouncement += "\n";
		
		game.addWinnings(totalRoundWinnings);
		game.addBets(totalRoundBets);
	}
	
	private void announceWinnings() {
		System.out.println();
		System.out.println("Winnings For Round #" + game.getRound());
		System.out.println("------------------------");
		System.out.println(winningsAnnouncement);
	}
}
