package startrekmod.network.packet;

import startrekmod.entity.EntityPhaserDrill;

import net.minecraft.entity.player.EntityPlayer;

import cpw.mods.fml.common.network.simpleimpl.IMessage;

import io.netty.buffer.ByteBuf;

public class PacketPhaserDrill implements IMessage
{
	public float angle;
	public int drillID;
	public int playerID;
	
	//typically, a default constructor required
	public PacketPhaserDrill() {}
	
	public PacketPhaserDrill(float angle, EntityPhaserDrill drill, EntityPlayer player)
	{
		this.angle = angle;
		drillID = drill.getEntityId();
		playerID = player.getEntityId();
	}

	@Override
	public void fromBytes(ByteBuf data)
	{
		angle = data.readFloat();
		drillID = data.readInt();
		playerID = data.readInt();
	}

	@Override
	public void toBytes(ByteBuf data)
	{
		data.writeFloat(angle);
		data.writeInt(drillID);
		data.writeInt(playerID);
	}
}
