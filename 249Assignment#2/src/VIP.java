public class VIP extends Player
{

	final double VIP_Percent = .10;
	final double PERCENT_TOTAL_WINNINGS = .05;
	final int TOKEN_WORTH=10;
	private double currentFakeVal=0;
	private final String status = "vip";
	
	public String getStatus() {
		return status;
	}
	public VIP(String name)
	{
		super(name);
		setPercentOfWinnings(VIP_Percent);
		setTokenValue(TOKEN_WORTH);
		currentFakeVal=0;
	}
	public void addFakeVal()
	{// this is dependent on whether getbets.lenght gives me the number of bets the player placed
		currentFakeVal=currentFakeVal+getTimesBet()*VIP_Percent+getBets().length*PERCENT_TOTAL_WINNINGS;
	}
	public int addCurrentValue()
	{
		setCurrentValue(getCurrentValue() + getTimesBet()*TOKEN_WORTH);
		addFakeVal();
		
		return getTimesBet()*TOKEN_WORTH;
	}
	// not sure if take vip or player as argument
	public boolean equals(VIP p)
	{
		return (super.equals(p)
				&&this.getCurrentFakeVal()==p.getCurrentFakeVal()
				&&this.getPERCENT_TOTAL_WINNINGS()==p.getPERCENT_TOTAL_WINNINGS()
				&&this.getTOKEN_WORTH()==p.getTOKEN_WORTH()
				&&this.getVIP_Percent()==p.getVIP_Percent());
	}
	public double getCurrentFakeVal() {
		return currentFakeVal;
	}
	public void setCurrentFakeVal(double currentFakeVal) {
		this.currentFakeVal = currentFakeVal;
	}
	public double getVIP_Percent() {
		return VIP_Percent;
	}
	public double getPERCENT_TOTAL_WINNINGS() {
		return PERCENT_TOTAL_WINNINGS;
	}
	public int getTOKEN_WORTH() {
		return TOKEN_WORTH;
	}
	public String toString()
	{
		return super.toString()+"\nDifferent Money winnings so far:"+this.getCurrentFakeVal();
	}
	
}