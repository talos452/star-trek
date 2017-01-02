package startrekmod.network.handler;

import startrekmod.entity.EntityPhaserDrill;
import startrekmod.network.packet.PacketPhaserDrill;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.simpleimpl.*;

public class HandlerPhaserDrill implements IMessageHandler<PacketPhaserDrill, IMessage>
{
    @Override
    public IMessage onMessage (PacketPhaserDrill message, MessageContext ctx)
    {
        EntityPlayer player = ctx.getServerHandler ().playerEntity;
        World world = ctx.getServerHandler ().playerEntity.worldObj;
        Entity entity = world.getEntityByID (message.drillID);
        EntityPhaserDrill drill = (EntityPhaserDrill) entity;

        if (message.angle == -1F)
            drill.initiateSequence (100);
        else drill.rotationYaw = message.angle;

        return null;
    }
}
