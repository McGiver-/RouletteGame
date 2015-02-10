
public class NormalPlayer extends Player
{
	final int TOKEN_WORTH=5;
	private String name;
	private final String status = "normal";

	
	public String getStatus() {
		return status;
	}

	public NormalPlayer(String name)
	{

		super(name);
		setTokenValue(TOKEN_WORTH);
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
	//toString is the same as the parent class
}
