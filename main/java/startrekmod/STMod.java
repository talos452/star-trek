package startrekmod;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = STMod.MODID, version = STMod.VERSION, name = STMod.NAME)
public class STMod 
{
	public static final String MODID = "startrekmod";
	public static final String VERSION = "1.5.0";
	public static final String NAME = "Star Trek mod";
	
	@Instance
	public static STMod INSTANCE = new STMod();
	
	@SidedProxy (clientSide = "startrekmod.STClientProxy",
			serverSide = "startrekmod.STServerProxy")
	public static STCommonProxy PROXY;
	
	/*
	 * Guidelines for preinit and init methods.
	 * Obviously, they should always be static.
	 * They should belong to ST-something classes.
	 * preinit() should do nothing but initialize static variables.
	 * init() should set up their properties.
	 */
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		STBlock.preinit();
		STItem.preinit();
		STCreativeTabs.preinit();
		
		PROXY.init();
		STBlock.init();
		STItem.init();
		STCrafting.init();
		STEntity.init();
		STNetwork.init();
		STEventHandler.init();
		STGeneration.init();
	}
}
