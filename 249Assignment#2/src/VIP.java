/**
 * 
 * @author Mario, George
 * This class is a child of the Player class
 * this class get more winnings than other players 
 * with a token worth more and percentages.
 * @see Player
 *
 */
public class VIP extends Player
{

	final double VIP_Percent = .10;
	final double PERCENT_TOTAL_WINNINGS = .05;
	final int TOKEN_WORTH=10;
	private double currentFakeVal=0;
	
	/**
	 * Constructor
	 * @param name
	 */
	public VIP(String name)
	{
		super(name);
		setPercentOfWinnings(VIP_Percent);
		setTokenValue(TOKEN_WORTH);
		this.setCurrentFakeVal(0);
		this.setStatus("vip");
	}
	/**
	 * Adds to the fake Value 
	 */
	public void addFakeVal()
	{// this is dependent on whether getbets.lenght gives me the number of bets the player placed
		currentFakeVal=currentFakeVal+getTimesBet()*VIP_Percent+getBets().length*PERCENT_TOTAL_WINNINGS;
	}
	
	/**
	 * add to the current value with a different token value than other players
	 * @return CurrentValue
	 */
	public int addCurrentValue()
	{
		setCurrentValue(getCurrentValue() + getTimesBet()*TOKEN_WORTH);
		addFakeVal();
		
		return getTimesBet()*TOKEN_WORTH;
	}
	// not sure if take vip or player as argument
	/**
	 * checks if the object and variables are the same 
	 * @param p
	 * @return
	 */
	public boolean equals(VIP p)
	{
		return (super.equals(p)
				&&this.getCurrentFakeVal()==p.getCurrentFakeVal()
				&&this.getPERCENT_TOTAL_WINNINGS()==p.getPERCENT_TOTAL_WINNINGS()
				&&this.getTOKEN_WORTH()==p.getTOKEN_WORTH()
				&&this.getVIP_Percent()==p.getVIP_Percent());
	}
	/**
	 * get the current fake value 
	 * @return currentfakeval
	 */
	public double getCurrentFakeVal() {
		return currentFakeVal;
	}
	/**
	 * set current value of fake money
	 * @param currentFakeVal
	 */
	public void setCurrentFakeVal(double currentFakeVal) {
		this.currentFakeVal = currentFakeVal;
	}
	/**
	 * get the vip percent which is a constant
	 * @return VIP_Percent
	 */
	public double getVIP_Percent() {
		return VIP_Percent;
	}
	/**
	 * get percent of total winnings which is a constant
	 * @return PERCENT_TOTAL_WINNINGS
	 */
	public double getPERCENT_TOTAL_WINNINGS() {
		return PERCENT_TOTAL_WINNINGS;
	}
	/**
	 * get token worth which is a constant
	 * @return TOKEN_WORTH
	 */
	public int getTOKEN_WORTH() {
		return TOKEN_WORTH;
	}
	/**
	 * announces the variables
	 */
	public String toString()
	{
		return super.toString()+"\nDifferent Money winnings so far:"+this.getCurrentFakeVal();
	}
	
}