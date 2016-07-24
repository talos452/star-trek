package startrekmod;

import startrekmod.network.handler.HandlerPhaserDrill;
import startrekmod.network.packet.PacketPhaserDrill;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class STNetwork
{
	public static SimpleNetworkWrapper network
		= NetworkRegistry.INSTANCE.newSimpleChannel("startrekmod");
	
	static int discriminator = 0;
	
	public static void init()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(STMod.INSTANCE, STMod.PROXY);
		
		network.registerMessage(HandlerPhaserDrill.class, PacketPhaserDrill.class,
			getUniqueDiscriminator(), Side.SERVER);
	}
	
	public static int getUniqueDiscriminator()
	{
		return discriminator++;
	}
}
