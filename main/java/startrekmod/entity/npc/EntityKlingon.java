package com.vulcanforge.startrekmod.entity.npc;

import com.vulcanforge.startrekmod.items.STItem;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityKlingon extends EntitySTNPC
{
	public EntityKlingon(World world)
	{
		super(world);
		setCurrentItemOrArmor(0, new ItemStack(STItem.batleth));
	}
	
	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
	
	@Override
	protected void attackEntity(Entity entity, float damage)
	{
		entity.attackEntityFrom(DamageSource.causeMobDamage(this), 2);
	}
}
