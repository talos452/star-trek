package com.vulcanforge.startrekmod.entity.npc;

import net.minecraft.entity.EntityCreature;
import net.minecraft.world.World;

public class EntitySTNPC extends EntityCreature
{
	public EntitySTNPC(World world)
	{
		super(world);
	}
	
	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
}
