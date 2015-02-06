import java.util.Random;
public class Dealer
{
	Random rand = new Random();
	private int round=0;
	private double winningsPersonThisRound;
	public Dealer()
	{
		round=0;
	}
	public int spin(RouletteGame wheel)
	{
		return rand.nextInt(wheel.TABLELAYOUT.length);
	}
}
