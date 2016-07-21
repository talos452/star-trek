package startrekmod;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.event.*;
import startrekmod.blocks.STBlock;
import startrekmod.entity.STEntity;
import startrekmod.items.STItem;
import startrekmod.network.STNetwork;

@Mod(modid = STMod.MODID, version = STMod.VERSION, name = STMod.NAME)
public class STMod 
{
	public static final String MODID = "startrekmod";
	public static final String VERSION = "1.5.0";
	public static final String NAME = "Star Trek mod";
	
	@Instance
	public static STMod INSTANCE = new STMod();
	
	@SidedProxy (clientSide = "startrekmod.ClientProxy",
			serverSide = "startrekmod.ServerProxy")
	public static CommonProxy PROXY;
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		PROXY.init();
		STBlock.init();
		STItem.init();
		STCrafting.init();
		STEntity.init();
		STNetwork.init();
		STEventHandler.init();
	}
}
