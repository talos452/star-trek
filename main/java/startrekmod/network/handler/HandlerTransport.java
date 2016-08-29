package startrekmod.network.handler;

import startrekmod.STUtilities;
import startrekmod.generation.dimension.STTeleporter;
import startrekmod.network.packet.PacketTransport;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldServer;

import cpw.mods.fml.common.network.simpleimpl.*;

public class HandlerTransport implements IMessageHandler <PacketTransport, IMessage>
{
	@Override
	public IMessage onMessage (PacketTransport message, MessageContext ctx)
	{
		EntityPlayerMP player = ctx.getServerHandler ().playerEntity;
		WorldServer world = STUtilities.getServer ().worldServerForDimension (message.dimensionTo);
		STUtilities.getManager ().transferPlayerToDimension (player,
			message.dimensionTo, new STTeleporter (world));
		return null;
	}
}
