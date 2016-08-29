package startrekmod;

import startrekmod.network.handler.*;
import startrekmod.network.packet.*;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class STNetwork
{
	static int discriminator = 0;
	public static SimpleNetworkWrapper network;

	static int getUniqueDiscriminator ()
	{
		return discriminator++;
	}

	public static void init ()
	{
		network = NetworkRegistry.INSTANCE.newSimpleChannel ("startrekmod");
		NetworkRegistry.INSTANCE.registerGuiHandler (STMod.INSTANCE, STMod.PROXY);

		network.registerMessage (HandlerPhaserDrill.class, PacketPhaserDrill.class,
			getUniqueDiscriminator (), Side.SERVER);
		network.registerMessage (HandlerCommunicator.class, PacketCommunicator.class,
			getUniqueDiscriminator (), Side.SERVER);
		network.registerMessage (HandlerTransport.class, PacketTransport.class,
			getUniqueDiscriminator (), Side.SERVER);
	}
}
