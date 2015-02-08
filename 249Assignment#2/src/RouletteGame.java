import java.util.Random;

public abstract class RouletteGame {
	private static Random rand = new Random();
	public double tableWinnings;
	private Player[] players;
	private int round;

	public void addWinnings(double winningsThisRound) {
		this.tableWinnings = +winningsThisRound;
	}

	public RouletteGame() {
		tableWinnings = 0;
		round = 1;
		players = new Player[6];
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
}
