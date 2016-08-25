package startrekmod.network.handler;

import startrekmod.network.packet.PacketCommunicator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

import cpw.mods.fml.common.network.simpleimpl.*;

public class HandlerCommunicator implements IMessageHandler <PacketCommunicator, IMessage>
{
	public HandlerCommunicator()
	{}

	@Override
	public IMessage onMessage(PacketCommunicator message, MessageContext ctx)
	{
		EntityPlayer operator = ctx.getServerHandler ().playerEntity;
		EntityPlayer recipient = (EntityPlayer) operator.worldObj.getEntityByID (message.recipientID);
		recipient.addChatComponentMessage (new ChatComponentText (message.message));
		return null;
	}
}
