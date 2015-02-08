
public class Player {
	public double currentValue = 0;
	public double currentFakeVal=0;
	public double percentOfWinnings;
	int[] betSpots = new int[5];
	public final int timesBet = 35;
	public int token =0;

	public void addCurrentValue(double myWinningsThisRound)
	{
		currentValue= currentValue+myWinningsThisRound*percentOfWinnings;
	}
	
	public Player()
	{
		currentFakeVal =0;
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
