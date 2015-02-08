public class VIP extends Player
{
	final double VIP_Percent = .10;
	final int TOKEN_WORTH=10;
	public double currentFakeVal=0;
	public VIP()
	{
		super();
		percentOfWinnings=VIP_Percent;
		token=TOKEN_WORTH;
		currentFakeVal=0;
	}
	public void addFakeVal(double toAdd)
	{
		currentFakeVal=currentFakeVal+toAdd;
	}
}