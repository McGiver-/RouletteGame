import java.util.Random;

/**
 * Abstract class that defines a RouletteGame and holds its players, and other useful variables.
 * @author Mario, George
 *
 */

public abstract class RouletteGame {
	private static Random rand = new Random();
	private int tableWinnings; // holds the total 'payouts'
	private int tableBets; // holds the total bets by players
	private Player[] players; // players at the table
	private int round; // current round
	public static final int MAX_PLAYERS = 6;
	public static final int MAX_STRAIGHT_NUMBERS = 5;

	public RouletteGame() {
		tableWinnings = 0;
		round = 1;
		players = new Player[MAX_PLAYERS];
	}
	
	/**
	 * Adds the winnings from this round to the total winnings
	 * @param winningsThisRound Winnings to add to the total
	 */
	public void addWinnings(int winningsThisRound) {
		tableWinnings += winningsThisRound;
	}
	
	/**
	 * Adds number of bets to the tracker
	 * @param totalRoundBets Number of bets made in this round
	 */
	public void addBets(int totalRoundBets) {
		tableBets += totalRoundBets;
	}

	public String toString() {
		String output = "ROULETTE TABLE\n";
		output += "-------------\n";
		
		output += "Layout: ";
		for (String item : getLayout()) {
			output += item + " ";
		}
		
		output += "\n\nPlayers:\n";
		for (int i = 0; i < players.length; i++) {
			output += "Player " + i + ": ";
			if (players[i] == null) {
				output += "empty";
			} else {
				output += players[i].getName();
			}
			output += "\n";
		}
		
		output += "\nTotal Winnings ($): " + tableWinnings + "\n";
		output += "Total Bets: " + tableBets + "\n";

		output += "\n";
		return output;
	}
	
	/**
	 * Compares two RouletteGame objects
	 * @param otherGame
	 * @return True if the two roulette games come from the same class, have the same winnings,
	 *    number of bets, and same players at the table. Returns false otherwise.
	 */
	public boolean equals(RouletteGame otherGame) {
		if (otherGame.getClass().equals(this.getClass())) {
			if (otherGame.getRound() == getRound() && otherGame.getTableWinnings() == getTableWinnings() 
					&& otherGame.getTableBets() == getTableBets()) {
				Player[] players = otherGame.getPlayers();
				
				for (int i = 0; i < players.length; i++) {
					if (!players[i].equals(getPlayers()[i])) {
						return false;
					}
				}
				
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Changes the reference of a player
	 * @param player Player New player to add
	 * @param index int Place to add the player (must be in the right range)
	 */
	public void setPlayer(Player player, int index) {
		if (index < 0 || index >= players.length) throw new IndexOutOfBoundsException();
		
		players[index] = player;
	}

	/**
	 * Removes a player from the table and returns its instance
	 * @param index Index of the player at the table
	 * @return The player removed from the table
	 */
	public Player removePlayer(int index) {
		if (index < 0 || index >= players.length)  throw new IndexOutOfBoundsException();
		
		Player player = players[index];
		players[index] = null;
		
		return player;
	}

	public Player[] getPlayers() {
		return players;
	}

	/**
	 * Returns the layout of the game
	 * @return An array containing all strings in the roulette layout
	 */
	public abstract String[] getLayout();

	/**
	 * Generates a random number in the table
	 * @return The random number generated
	 */
	public int spin() {
		return rand.nextInt(getLayout().length);
	}
	
	public int getRound() {
		return round;
	}
	
	public void nextRound() {
		round++;
	}

	
	/**
	 * Resets all the bets of the players at the table
	 */
	public void resetBets() {
		// go through all players
		for (int i = 0; i < players.length; i++) {
			// if there is a player seated at that spot
			if (players[i] != null) {
				// fill the bets array with the appropriate flag
				for (int token = 0; token < RouletteGame.MAX_STRAIGHT_NUMBERS; token++) {
					players[i].setToken(token, Player.EMPTY_BET_FILLER);
				}
				
			}
		}
		
	}
	
	public int getTableWinnings() {
		return tableWinnings;
	}

	public void setTableWinnings(int tableWinnings) {
		this.tableWinnings = tableWinnings;
	}

	public int getTableBets() {
		return tableBets;
	}

	public void setTableBets(int tableBets) {
		this.tableBets = tableBets;
	}
	
	public abstract String stringToStraightNumber(String straight);
}
