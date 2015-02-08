import java.util.List;


public abstract class RouletteGame 
{
	public double tableWinnings;
	private List<Player> players;
	
	public void addWinnings(double winningsThisRound)
	{
		this.tableWinnings=+winningsThisRound;
	}
	public RouletteGame()
	{
		tableWinnings=0;
	}
	
	public String toString() {
		String output = "";
		for (String item : getLayout()) {
			output += item + " ";
		}
		
		output += "\n";
		return output;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public Player removePlayer(int index) {
		return players.remove(index);
	}
	
	public abstract String[] getLayout();
	
	public int spin() {
		return 0;
	}
}
