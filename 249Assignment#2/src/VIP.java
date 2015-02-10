public class VIP extends Player
{

	final double VIP_Percent = .10;
	final double PERCENT_TOTAL_WINNINGS = .05;
	final int TOKEN_WORTH=10;
	public double currentFakeVal=0;
	public VIP(String name)
	{
		super(name);
		percentOfWinnings=VIP_Percent;
		token=TOKEN_WORTH;
		currentFakeVal=0;
	}
	public void addFakeVal()
	{// this is dependent on whether getbets.lenght gives me the number of bets the player placed
		currentFakeVal=currentFakeVal+timesBet*VIP_Percent+getBets().length*PERCENT_TOTAL_WINNINGS;
	}
	public void addCurrentValue()
	{
		currentValue= currentValue+timesBet*TOKEN_WORTH;
	}
}