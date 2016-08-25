package startrekmod.network.handler;

import startrekmod.entity.EntityPhaserDrill;
import startrekmod.network.packet.PacketPhaserDrill;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.simpleimpl.*;

public class HandlerPhaserDrill implements IMessageHandler <PacketPhaserDrill, IMessage>
{
	public HandlerPhaserDrill()
	{}

	@Override
	public IMessage onMessage(PacketPhaserDrill message, MessageContext ctx)
	{
		World world = ctx.getServerHandler ().playerEntity.worldObj;
		Entity entity = world.getEntityByID (message.drillID);

		if (!(entity instanceof EntityPhaserDrill)) return null;

		EntityPhaserDrill drill = (EntityPhaserDrill) entity;
		drill.operatorID = message.playerID;

		if (message.angle == -1F) drill.firingSequenceTicks = 100;
		else drill.rotationYaw = message.angle;
		return null;
	}
}
