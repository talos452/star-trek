package startrekmod.network.handler;

import startrekmod.network.packet.PacketPhaserDrill;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import startrekmod.entity.EntityPhaserDrill;
import startrekmod.network.packet.*;
import cpw.mods.fml.common.network.simpleimpl.*;

public class HandlerPhaserDrill implements IMessageHandler<PacketPhaserDrill, IMessage>
{
	public HandlerPhaserDrill() {} //required for processing
	
	@Override
	public IMessage onMessage(PacketPhaserDrill message, MessageContext ctx)
	{
		World world = ctx.getServerHandler().playerEntity.worldObj;
		Entity entity = world.getEntityByID(message.drillID);
		
		if(!(entity instanceof EntityPhaserDrill)) return null;
		
		EntityPhaserDrill drill = (EntityPhaserDrill)entity;
		drill.operator = (EntityPlayer)world.getEntityByID(message.playerID);
		
		if(message.direction == null)
			drill.countdownTicks = 100;
		else
			drill.setDirection(message.direction);
		
		return null;
	}
}
