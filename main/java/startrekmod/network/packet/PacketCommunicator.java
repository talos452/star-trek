package startrekmod.network.packet;

import startrekmod.STUtilities;

import net.minecraft.entity.player.EntityPlayer;

import cpw.mods.fml.common.network.simpleimpl.IMessage;

import io.netty.buffer.ByteBuf;

public class PacketCommunicator implements IMessage
{
    public String message;
    String recipientName;

    public PacketCommunicator ()
    {
    }

    public PacketCommunicator (String message, String recipientName)
    {
        this.message = message;
        this.recipientName = recipientName;
    }

    public EntityPlayer getPlayerRecipient ()
    {
        return STUtilities.getPlayerByName (recipientName);
    }

    @Override
    public void fromBytes (ByteBuf data)
    {
        String[] fields = STUtilities.readStringsFromBuffer (data);
        message = fields[0];
        recipientName = fields[1];
    }

    @Override
    public void toBytes (ByteBuf data)
    {
        STUtilities.writeStringsToBuffer (data, message, recipientName);
    }
}
