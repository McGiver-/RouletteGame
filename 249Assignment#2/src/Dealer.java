import java.util.Random;
public class Dealer
{
	Random rand = new Random();
	private int round=0;
	private double winningsPersonThisRound;
	private RouletteGame game;
	
	public Dealer()
	{
		round=0;
	}
	public int spin(RouletteGame wheel)
	{
		return rand.nextInt(wheel.getLayout().length);
	}
	
	public void setRouletteGame(RouletteGame rg) {
		game = rg;
	}
	
	public void spinRoulette() {
		game.spin();
	}
}
