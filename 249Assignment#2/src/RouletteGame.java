import java.util.Random;

public abstract class RouletteGame {
	private static Random rand = new Random();
	public int tableWinnings;
	public int tableBets;
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
		String output = "";
		for (String item : getLayout()) {
			output += item + " ";
		}

		output += "\n";
		return output;
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
		return rand.nextInt(getLayout().length);
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
}
