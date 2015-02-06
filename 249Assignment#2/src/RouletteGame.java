
public abstract class RouletteGame 
{
	public final int[] TABLELAYOUT=null;
	public double tableWinnings;
	
	public void addWinnings(double winningsThisRound)
	{
		this.tableWinnings=+winningsThisRound;
	}
	public RouletteGame()
	{
		tableWinnings=0;
	}
}
