package startrekmod.network.packet;

import cpw.mods.fml.common.network.simpleimpl.IMessage;

import io.netty.buffer.ByteBuf;

public class PacketCommunicator implements IMessage
{
	public String message;
	public int recipientID;

	public PacketCommunicator()
	{}

	public PacketCommunicator(String message, int recipientID)
	{
		this.message = message;
		this.recipientID = recipientID;
	}

	@Override
	public void fromBytes(ByteBuf data)
	{
		recipientID = data.readInt();
		message = data.readBytes(data.readableBytes()).toString();
	}

	@Override
	public void toBytes(ByteBuf data)
	{
		data.writeInt(recipientID);
		data.writeBytes(message.getBytes());
	}
}
