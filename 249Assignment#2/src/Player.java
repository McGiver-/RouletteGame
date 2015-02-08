
public class Player {
	public double currentValue = 0;
	public double percentOfWinnings;
	public int token;
	

	public void addCurrentValue(double myWinningsThisRound)
	{
		currentValue= currentValue+myWinningsThisRound*percentOfWinnings;
	}
	
	public Player()
	{
		currentValue =0;
		percentOfWinnings=0;
	}
	public Player(double percentOfWinnings)
	{
		this.percentOfWinnings=percentOfWinnings;
	}
	public void setToken(int token)
	{
		this.token=token;
	}
}
