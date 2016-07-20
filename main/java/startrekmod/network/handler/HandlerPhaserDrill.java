package com.vulcanforge.startrekmod.network.handler;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import com.vulcanforge.startrekmod.entity.EntityPhaserDrill;
import com.vulcanforge.startrekmod.network.packet.*;

import cpw.mods.fml.common.network.simpleimpl.*;

public class HandlerPhaserDrill implements IMessageHandler<PacketPhaserDrill, IMessage>
{
	@Override
	public IMessage onMessage(PacketPhaserDrill message, MessageContext ctx)
	{
		World world = ctx.getServerHandler().playerEntity.worldObj;
		Entity entity = world.getEntityByID(message.drillID);
		
		if(!(entity instanceof EntityPhaserDrill)) return null;
		
		EntityPhaserDrill drill = (EntityPhaserDrill)entity;
		
		if(message.isFireEvent)
			drill.countdownTicks = 100;
		else
			drill.setLocationAndAngles(drill.posX, drill.posY, drill.posZ, message.rotation, 0);
		
		return null;
	}
}
