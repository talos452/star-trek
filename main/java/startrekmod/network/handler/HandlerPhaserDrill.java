package startrekmod.network.handler;

import startrekmod.entity.EntityPhaserDrill;
import startrekmod.network.packet.PacketPhaserDrill;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.simpleimpl.*;

public class HandlerPhaserDrill implements IMessageHandler<PacketPhaserDrill, IMessage>
{
	//typically, a default constructor required
	public HandlerPhaserDrill() {}
	
	@Override
	public IMessage onMessage(PacketPhaserDrill message, MessageContext ctx)
	{
		World world = ctx.getServerHandler().playerEntity.worldObj;
		Entity entity = world.getEntityByID(message.drillID);
		
		if(!(entity instanceof EntityPhaserDrill)) return null;
		//but if entity is not an EntityPhaserDrill, I don't know what the hell it is
		
		EntityPhaserDrill drill = (EntityPhaserDrill)entity;
		drill.operator = (EntityPlayer)world.getEntityByID(message.playerID);
		
		//-1 is a code to fire rather than rotate
		if(message.angle == -1F)
			drill.countdownTicks = 100;
		else
			drill.rotationYaw = message.angle;		
		return null;
	}
}
