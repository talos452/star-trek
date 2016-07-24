package startrekmod.network.packet;

import startrekmod.entity.EntityPhaserDrill;
import startrekmod.util.DirectionMode;

import net.minecraft.entity.player.EntityPlayer;

import cpw.mods.fml.common.network.simpleimpl.IMessage;

import io.netty.buffer.ByteBuf;

public class PacketPhaserDrill implements IMessage
{
	public DirectionMode direction;
	public int drillID;
	public int playerID;
	
	public PacketPhaserDrill() {} //required for processing
	
	public PacketPhaserDrill(DirectionMode direction, EntityPhaserDrill drill, EntityPlayer player)
	{
		this.direction = direction;
		drillID = drill.getEntityId();
		playerID = player.getEntityId();
	}

	@Override
	public void fromBytes(ByteBuf data)
	{
		int angle = data.readInt();
		direction = (angle != 1) ? DirectionMode.fromAngle(angle) : null;
		drillID = data.readInt();
		playerID = data.readInt();
	}

	@Override
	public void toBytes(ByteBuf data)
	{
		data.writeInt((direction != null) ? direction.angle : 1);
		data.writeInt(drillID);
		data.writeInt(playerID);
	}
}
