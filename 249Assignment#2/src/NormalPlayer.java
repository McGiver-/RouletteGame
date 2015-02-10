
public class NormalPlayer extends Player
{
	final int TOKEN_WORTH=5;
	private String name;
	
	public NormalPlayer(String name)
	{

		super(name);
		token=TOKEN_WORTH;
	}
	
	public boolean equals(Player p) {
		// TODO equal method work for NormalPlayer
		if (this.name.equals(p.getName())) {
			return true;
		}
		
		return false;
	}
}
