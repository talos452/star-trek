package startrekmod;

public class STClientProxy extends STCommonProxy
{
	@Override
	public void init ()
	{
		super.init ();
		STGraphics.init ();
	}
}
