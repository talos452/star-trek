package startrekmod;

import startrekmod.network.handler.*;
import startrekmod.network.packet.*;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

/**
 * Creates a network channel, registers a GUI handler, and registers all packet types.
 */
public class STNetwork
{
	//all mod packets go through this wrapper
	public static SimpleNetworkWrapper network;
	//used by getUniqueDiscriminator()
	static int discriminator = 0;
	
	/**
	 * Creates a network channel, registers a GUI handler, and registers all packet types.
	 */
	public static void init()
	{
		network = NetworkRegistry.INSTANCE.newSimpleChannel("startrekmod");
		//required for GUI to get called through CommonProxy GUI handlers
		NetworkRegistry.INSTANCE.registerGuiHandler(STMod.INSTANCE, STMod.PROXY);
		
		//register all packets and handlers
		network.registerMessage(HandlerPhaserDrill.class, PacketPhaserDrill.class, getUniqueDiscriminator(), Side.SERVER);
		network.registerMessage(HandlerCommunicator.class, PacketCommunicator.class, getUniqueDiscriminator(), Side.SERVER);
	}
	
	/**
	 * @return A unique discriminator to register messages with.
	 */
	static int getUniqueDiscriminator()
	{
		return discriminator++;
	}
}
