package startrekmod;

import startrekmod.network.handler.HandlerPhaserDrill;
import startrekmod.network.packet.PacketPhaserDrill;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class STNetwork
{
	//all packets go through this wrapper
	public static SimpleNetworkWrapper network
		= NetworkRegistry.INSTANCE.newSimpleChannel("startrekmod");
	
	static int discriminator = 0;
	
	public static void init()
	{
		//required for GUI to get called through CommonProxy GUI handlers
		NetworkRegistry.INSTANCE.registerGuiHandler(STMod.INSTANCE, STMod.PROXY);
		
		//register all packets and handlers
		network.registerMessage(HandlerPhaserDrill.class, PacketPhaserDrill.class,
			getUniqueDiscriminator(), Side.SERVER);
	}
	
	//slick little wrapper method that makes my logic unambiguously clear...
	//unless you really have no clue about coding
	public static int getUniqueDiscriminator()
	{
		return discriminator++;
	}
}
