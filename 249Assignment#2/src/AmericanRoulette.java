
public class AmericanRoulette extends RouletteGame 
{
	private static final String[] LAYOUT = 
		{"0","28","9","26","30","11","7","20","32","17","5","22",
		 "34","15","3","24","36","13","1","37","27","10","25","29",
		 "12","8","19","31","18","6","21","33","16","4","23","35","14","2"};

	public AmericanRoulette()
	{
		super();
	}

	@Override
	public void spin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getLayout() {
		return LAYOUT;
	}

}
