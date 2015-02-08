
public abstract class RouletteGame 
{
	private String[] layout;
	public double tableWinnings;
	
	public void addWinnings(double winningsThisRound)
	{
		this.tableWinnings=+winningsThisRound;
	}
	public RouletteGame()
	{
		tableWinnings=0;
	}
	
	public void displayTable() {
		for (String item : layout) {
			System.out.print(item + " ");
		}
		System.out.println();
	}
	
	public abstract String[] getLayout();
	
	public abstract void spin();
}
