public class VIP extends Player
{
	private final double VIP_Percent = .10;
	private final int TOKEN_WORTH=10;
	private double currentFakeVal=0;
	public VIP()
	{
		super();
		this.setPercentOfWinnings(VIP_Percent);
		this.setToken(TOKEN_WORTH);
		currentFakeVal=0;
	}
	public void addFakeVal(double toAdd)
	{
		currentFakeVal=currentFakeVal+toAdd;
	}
}