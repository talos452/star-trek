package startrekmod.network.packet;

import cpw.mods.fml.common.network.simpleimpl.IMessage;

import io.netty.buffer.ByteBuf;

public class PacketCommunicator implements IMessage
{
	//if true, packet represents a transport signal
	//if false, packet represents a message
	public boolean isTransport;
	public int dimensionID; //dimension to teleport player to
	public String message; //message to send to player
	public int playerID; //ID of player to send message to
	
	public PacketCommunicator() {}
	
	public PacketCommunicator(int dimensionID)
	{
		isTransport = true;
		this.dimensionID = dimensionID;
	}
	
	public PacketCommunicator(String message, int playerID)
	{
		isTransport = false;
		this.message = message;
		this.playerID = playerID;
	}

	@Override
	public void fromBytes(ByteBuf data)
	{
		isTransport = data.readBoolean();
		
		if(isTransport)
			dimensionID = data.readInt();
		else
		{
			playerID = data.readInt();
			message = data.readBytes(data.readableBytes()).toString();
		}
	}

	@Override
	public void toBytes(ByteBuf data)
	{
		if(isTransport)
		{
			data.writeBoolean(true);
			data.writeInt(dimensionID);
		}
		else
		{
			data.writeBoolean(false);
			data.writeInt(playerID);
			data.writeBytes(message.getBytes());
		}
	}

}
