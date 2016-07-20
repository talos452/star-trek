package com.vulcanforge.startrekmod.network.packet;

import com.vulcanforge.startrekmod.entity.EntityPhaserDrill;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.*;

public class PacketPhaserDrill implements IMessage
{
	public boolean isFireEvent;
	public float rotation;
	public int drillID;
	
	public static final int NORTH = 1;
	public static final int SOUTH = 3;
	public static final int EAST = 2;
	public static final int WEST = 4;
	
	public PacketPhaserDrill(boolean isFireEvent, int code, EntityPhaserDrill drill)
	{
		this.isFireEvent = isFireEvent;
		
		switch(code)
		{
		case NORTH:
			rotation = 180;
			break;
		case SOUTH:
			rotation = 0;
			break;
		case EAST:
			rotation = 90;
			break;
		case WEST:
			rotation = 270;
			break;
		}
		
		drillID = drill.getEntityId();
	}

	@Override
	public void fromBytes(ByteBuf data)
	{
		isFireEvent = data.readBoolean();
		rotation = data.readFloat();
		drillID = data.readInt();
	}

	@Override
	public void toBytes(ByteBuf data)
	{
		data.writeBoolean(isFireEvent);
		data.writeFloat(rotation);
		data.writeInt(drillID);
	}
}
