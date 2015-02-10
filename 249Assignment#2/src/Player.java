
public abstract class Player {

	private double currentValue = 0;
	private double percentOfWinnings;
	private int[] betSpots;
	private final int timesBet = 35;
	private int tokenValue = 0;

	private String name;
	public static final int EMPTY_BET_FILLER = -1;


	public int addCurrentValue()
	{
		currentValue= currentValue+timesBet*tokenValue;
		
		return timesBet*tokenValue;
	}
	
	public Player(String name)
	{
		currentValue =0;
		percentOfWinnings=0;
		betSpots = new int[RouletteGame.MAX_STRAIGHT_NUMBERS];
		tokenValue=0;
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
		int betsCount = 0;
		
		// count the number of non-empty bets
		for (int i = 0; i < betSpots.length; i++) {
			if (betSpots[i] != EMPTY_BET_FILLER) {
				betsCount++;
			}
		}
		
		int[] bets = new int[betsCount];
		int betCounter = 0;
		for (int i = 0; i < betSpots.length; i++) {
			if (betSpots[i] != EMPTY_BET_FILLER) {
				bets[betCounter] = betSpots[i];
				betCounter++;
			}
		}
		
		return bets;
	}
	
	public int getTokenValue() {
		return tokenValue;
	}

	public void setTokenValue(int tokenValue) {
		this.tokenValue = tokenValue;
	}

	public int getTimesBet() {
		return timesBet;
	}

	public double getPercentOfWinnings() {
		return percentOfWinnings;
	}

	public void setPercentOfWinnings(double percentOfWinnings) {
		this.percentOfWinnings = percentOfWinnings;
	}

	public double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}
	public boolean equals(Player p)
	{
		boolean sameBets =false;
		for (int i=0;i<this.getBets().length;i++)
			{
			 if (this.getBets()[i]==p.getBets()[i])
				 sameBets=true;
			}
		return (this.getCurrentValue()==p.getCurrentValue()
				&&this.getTimesBet()==p.getTimesBet()
				&&sameBets
				&&this.getName().equals(getName()));
	}
}
