package startrekmod.network.packet;

import cpw.mods.fml.common.network.simpleimpl.IMessage;

import io.netty.buffer.ByteBuf;

public class PacketTransport implements IMessage
{
	public int dimensionFrom;
	public int dimensionTo;

	public PacketTransport ()
	{}

	public PacketTransport (int dimensionTo, int dimensionFrom)
	{
		this.dimensionTo = dimensionTo;
		this.dimensionFrom = dimensionFrom;
	}

	@Override
	public void fromBytes (ByteBuf data)
	{
		dimensionTo = data.readInt ();
		dimensionFrom = data.readInt ();
	}

	@Override
	public void toBytes (ByteBuf data)
	{
		data.writeInt (dimensionTo);
		data.writeInt (dimensionFrom);
	}
}
