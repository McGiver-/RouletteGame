/**
 * 
 * @author Mario, George
 * is a child of the Player class
 *@see Player
 */
public class NormalPlayer extends Player
{
	final int TOKEN_WORTH=5;

	/**
	 * constructor
	 * @param name
	 */
	public NormalPlayer(String name)
	{
		super(name);
		setTokenValue(TOKEN_WORTH);
		this.setStatus("normal");
	}
	
	/**
	 * checks to see if object and variables are the same
	 * @param p
	 * @return
	 */
	public boolean equals(NormalPlayer p)
	{
		return (super.equals(p)
				&&this.getTOKEN_WORTH()==p.getTOKEN_WORTH());
	}
	
/**
 * get token worth which is a constant
 * @return TOKEN_WORTH
 */
	public int getTOKEN_WORTH() {
		return TOKEN_WORTH;
	}
	//toString is the same as the parent class
}
