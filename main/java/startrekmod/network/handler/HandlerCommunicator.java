package startrekmod.network.handler;

import startrekmod.generation.STTeleporter;
import startrekmod.network.packet.PacketCommunicator;

import net.minecraft.entity.player.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.WorldServer;

import cpw.mods.fml.common.network.simpleimpl.*;

public class HandlerCommunicator implements IMessageHandler<PacketCommunicator, IMessage>
{
	//default constructor required
	public HandlerCommunicator() {}

	@Override
	public IMessage onMessage(PacketCommunicator message, MessageContext ctx)
	{
		EntityPlayer operator = ctx.getServerHandler().playerEntity;
		WorldServer world = MinecraftServer.getServer().worldServerForDimension(operator.dimension);
		WorldServer newWorld = MinecraftServer.getServer().worldServerForDimension(message.dimensionID);
		
		if(message.isTransport)
			MinecraftServer.getServer().getConfigurationManager()
				.transferPlayerToDimension((EntityPlayerMP)operator, message.dimensionID, new STTeleporter(newWorld));
		else
		{
			EntityPlayer recipient = (EntityPlayer)world.getEntityByID(message.playerID);
			recipient.addChatComponentMessage(new ChatComponentText(message.message));
		}
		
		return null;
	}
}
