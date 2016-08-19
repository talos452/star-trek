package startrekmod.network.packet;

import cpw.mods.fml.common.network.simpleimpl.IMessage;

import io.netty.buffer.ByteBuf;

public class PacketCommunicator implements IMessage
{
	public int dimensionID;
	public boolean isTransport;
	public String message;
	public int recipientID;

	public PacketCommunicator()
	{}

	public PacketCommunicator(int dimensionID)
	{
		isTransport = true;
		this.dimensionID = dimensionID;
	}

	public PacketCommunicator(String message, int recipientID)
	{
		isTransport = false;
		this.message = message;
		this.recipientID = recipientID;
	}

	@Override
	public void fromBytes(ByteBuf data)
	{
		isTransport = data.readBoolean();

		if (isTransport)
			dimensionID = data.readInt();
		else
		{
			recipientID = data.readInt();
			message = data.readBytes(data.readableBytes()).toString();
		}
	}

	@Override
	public void toBytes(ByteBuf data)
	{
		if (isTransport)
		{
			data.writeBoolean(true);
			data.writeInt(dimensionID);
		}
		else
		{
			data.writeBoolean(false);
			data.writeInt(recipientID);
			data.writeBytes(message.getBytes());
		}
	}
}
