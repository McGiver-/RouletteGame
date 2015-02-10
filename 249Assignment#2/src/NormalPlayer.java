
public class NormalPlayer extends Player
{
	final int TOKEN_WORTH=5;
	public NormalPlayer()
	{
		super();
		this.setToken(TOKEN_WORTH);
	}
	public int getTOKEN_WORTH() {
		return TOKEN_WORTH;
	}
	
}
