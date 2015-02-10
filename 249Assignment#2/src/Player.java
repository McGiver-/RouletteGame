
public class Player {

	public double currentValue = 0;
	public double percentOfWinnings;
	int[] betSpots = new int[5];
	public final int timesBet = 35;
	public int token =0;
	private String name;


	public void addCurrentValue()
	{
		currentValue= currentValue+timesBet*token;
	}
	
	public Player(String name)
	{
		currentValue =0;
		percentOfWinnings=0;
		int[] betSpots = new int[5];
		token=0;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setToken(int number,int spot)
	{
		this.betSpots[number]=spot;
	}
	// does this give the right number of bets because they have the option to pick less than 5 numbers
	public int[] getBets() {
		int[] bets = new int[betSpots.length];
		for (int i = 0; i < betSpots.length; i++) {
			bets[i] = betSpots[i];
		}
		return bets;
	}
}
