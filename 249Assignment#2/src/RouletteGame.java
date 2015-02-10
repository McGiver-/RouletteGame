import java.util.Random;

public abstract class RouletteGame {
	private static Random rand = new Random();
	private int tableWinnings;
	private int tableBets;
	private Player[] players;
	private int round;
	public static final int MAX_PLAYERS = 6;
	public static final int MAX_STRAIGHT_NUMBERS = 5;

	public void addWinnings(int winningsThisRound) {
		tableWinnings += winningsThisRound;
	}

	public RouletteGame() {
		tableWinnings = 0;
		round = 1;
		players = new Player[MAX_PLAYERS];
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

	public void setPlayer(Player player, int index) {
		players[index] = player;
	}

	public void removePlayer(int index) {
		players[index] = null;
	}

	public Player[] getPlayers() {
		return players;
	}

	public abstract String[] getLayout();

	public int spin() {
		round++;
		return /*rand.nextInt(getLayout().length)*/0;
	}
	
	public int getRound() {
		return round;
	}

	public void addBets(int totalRoundBets) {
		tableBets += totalRoundBets;
	}

	public void resetBets() {
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
				for (int token = 0; token < RouletteGame.MAX_STRAIGHT_NUMBERS; token++)
				players[i].setToken(token, Player.EMPTY_BET_FILLER);
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
