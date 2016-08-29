package startrekmod;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = STMod.MODID, version = STMod.VERSION, name = STMod.NAME)
public class STMod
{
	@Instance
	public static STMod INSTANCE = new STMod ();
	public static final String MODID = "startrekmod";
	public static final String NAME = "Star Trek mod";

	@SidedProxy(clientSide = "startrekmod.STClientProxy", serverSide = "startrekmod.STServerProxy")
	public static STCommonProxy PROXY;

	public static final String VERSION = "1.6.0";

	@EventHandler
	public void init (FMLInitializationEvent event)
	{
		STItem.preinit ();
		STBlock.preinit ();
		STCreativeTabs.preinit ();

		PROXY.init ();
		STBlock.init ();
		STItem.init ();
		STRecipes.init ();
		STEntity.init ();
		STNetwork.init ();
		STDimension.init ();
		STGeneration.init ();
		STEventHandler.init ();
		STCelestialData.init ();
		STUtilities.init ();
	}
}
