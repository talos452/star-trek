package startrekmod.network.handler;

import startrekmod.network.packet.PacketCommunicator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

import cpw.mods.fml.common.network.simpleimpl.*;

public class HandlerCommunicator implements IMessageHandler<PacketCommunicator, IMessage>
{
    @Override
    public IMessage onMessage (PacketCommunicator message, MessageContext ctx)
    {
        EntityPlayer sender = ctx.getServerHandler ().playerEntity;
        EntityPlayer recipient = message.getPlayerRecipient ();
        recipient.addChatComponentMessage (new ChatComponentText (message.message));
        return null;
    }
}
