package startrekmod.network.packet;

import startrekmod.entity.EntityPhaserDrill;
import startrekmod.util.DirectionMode;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.*;

public class PacketPhaserDrill implements IMessage
{
	public DirectionMode direction;
	public int drillID;
	
	public PacketPhaserDrill() {} //required for processing
	
	public PacketPhaserDrill(DirectionMode direction, EntityPhaserDrill drill)
	{
		this.direction = direction;
		drillID = drill.getEntityId();
	}

	@Override
	public void fromBytes(ByteBuf data)
	{
		int angle = data.readInt();
		direction = (angle != 1) ? DirectionMode.fromAngle(angle) : null;
		drillID = data.readInt();
	}

	@Override
	public void toBytes(ByteBuf data)
	{
		data.writeInt((direction != null) ? direction.angle : 1);
		data.writeInt(drillID);
	}
}