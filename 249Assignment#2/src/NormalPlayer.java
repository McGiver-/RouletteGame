
public class NormalPlayer extends Player
{
	final int TOKEN_WORTH=5;
	private String name;
	
	public NormalPlayer(String name)
	{

		super(name);
		setTokenValue(TOKEN_WORTH);
	}
	
	public boolean equals(Player p) {
		// TODO equal method work for NormalPlayer
		if (this.name.equals(p.getName())) {
			return true;
		}
		
		return false;
	}
	public boolean equals(NormalPlayer p)
	{
		return (super.equals(p)
				&&this.getTOKEN_WORTH()==p.getTOKEN_WORTH());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTOKEN_WORTH() {
		return TOKEN_WORTH;
	}
}
