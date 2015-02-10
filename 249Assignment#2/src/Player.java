
public class Player {
	private double currentValue = 0;
	private double percentOfWinnings;
	private int[] betSpots = new int[5];
	private final int timesBet = 35;
	private int token =0;

	public double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}

	public double getPercentOfWinnings() {
		return percentOfWinnings;
	}

	public void setPercentOfWinnings(double percentOfWinnings) {
		this.percentOfWinnings = percentOfWinnings;
	}

	public int[] getBetSpots() {
		return betSpots;
	}

	public void setBetSpots(int[] betSpots) {
		this.betSpots = betSpots;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public int getTimesBet() {
		return timesBet;
	}

	public void addCurrentValue(double myWinningsThisRound)
	{
		currentValue= currentValue+myWinningsThisRound;
	}
	
	public Player()
	{
		currentValue =0;
		percentOfWinnings=0;
		int[] betSpots = new int[5];
		token=0;
	}

	public void setToken(int number,int spot)
	{
		this.betSpots[number]=spot;
	}
}
