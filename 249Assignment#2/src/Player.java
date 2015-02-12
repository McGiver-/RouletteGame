/**
 * 
 * @author Mario, George
 *This is a Player that interacts with the Roulette game and dealer.
 *The Player is capable of holding bets,and calculating his winnings.
 *This is the parent of VIP and NormalPlayer
 *@see Dealer
 *@see RouletteGame
 */
public abstract class Player {

	private double currentValue = 0; // tracks the current winnings
	private double percentOfWinnings; // how much bonus points the player gets
	private int[] betSpots; // stores the bets made by the player
	private final int timesBet = 35; // multiplier per right bet
	private int tokenValue = 0; // value of the token used by the player
	private String status = null; // vip or normal
	private String name; // Name of the player
	public static final int EMPTY_BET_FILLER = -1;
	
	/**
	 * Player constructor
	 * @param name
	 */
	public Player(String name)
	{
		currentValue =0;
		percentOfWinnings=0;
		betSpots = new int[RouletteGame.MAX_STRAIGHT_NUMBERS];
		tokenValue=0;
		this.name = name;
	}
	
	/**
	 * Get the players status
	 * @return status 
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * Set the player's status
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * adds the current winnings to the current value
	 * @return CurrentValue
	 */
	public int addCurrentValue()
	{
		currentValue= currentValue+timesBet*tokenValue;
		
		return timesBet*tokenValue;
	}


	/**
	 * get the name of the player
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * set the name of the player
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * sets the token in his array of possibilities and the spot is the number chosen
	 * @param number
	 * @param spot
	 */
	public void setToken(int number,int spot)
	{
		this.betSpots[number]=spot;
	}
	/**
	 * gets the array of bets 
	 * @return bets array
	 */
	public int[] getBets() {
		int betsCount = 0;
		
		// count the number of non-empty bets
		for (int i = 0; i < betSpots.length; i++) {
			if (betSpots[i] != EMPTY_BET_FILLER) {
				betsCount++;
			}
		}
		
		int[] bets = new int[betsCount];
		int betCounter = 0;
		for (int i = 0; i < betSpots.length; i++) {
			if (betSpots[i] != EMPTY_BET_FILLER) {
				bets[betCounter] = betSpots[i];
				betCounter++;
			}
		}
		
		return bets;
	}
	/**
	 * get the token value 
	 * @return tokenvalue
	 */
	public int getTokenValue() {
		return tokenValue;
	}
	/**
	 * set the token value
	 * @param tokenValue
	 */
	public void setTokenValue(int tokenValue) {
		this.tokenValue = tokenValue;
	}
	/**
	 * get the payout multiplier
	 * @return timesBet
	 */
	public int getTimesBet() {
		return timesBet;
	}
	/**
	 * gets the percentage of the winnings 
	 * @return percentage of winnings 
	 */
	public double getPercentOfWinnings() {
		return percentOfWinnings;
	}
	/**
	 * set teh percentage of winnings 
	 * @param percentOfWinnings
	 */
	public void setPercentOfWinnings(double percentOfWinnings) {
		this.percentOfWinnings = percentOfWinnings;
	}
	/**
	 * get the current value of real money
	 * @return currentvalue
	 */
	public double getCurrentValue() {
		return currentValue;
	}
	/**
	 * set current value of real money
	 * @param currentValue
	 */
	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}
	/**
	 * equals class checks if the same object and variables
	 * @param p
	 * @return
	 */
	public boolean equals(Player p)
	{
		boolean sameBets =false;
		for (int i=0;i<this.getBets().length;i++)
			{
			 if (this.getBets()[i]==p.getBets()[i])
				 sameBets=true;
			}
		return (this.getCurrentValue()==p.getCurrentValue()
				&&this.getTimesBet()==p.getTimesBet()
				&&sameBets
				&&this.getName().equals(getName())
				&&this.getStatus()==p.getStatus());
	}
	/**
	 * will print this out when player object is called
	 */
	public String toString()
	{
		return "Player name:"+this.getName()+"\nStatus:"+this.getStatus()
				+"\n Bets made this round: "+this.getBets()
				+"\n Winnings so far:"+this.getCurrentValue();
	}
}
