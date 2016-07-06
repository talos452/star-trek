package com.vulcanforge.startrekmod.entity.phaserblast;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public abstract class EntityPhaserBlast extends EntityThrowable
{
	int ticksInAir = 0;
	
	public EntityPhaserBlast(World world)
	{
		super(world);
	}
	
	protected EntityPhaserBlast(World world, EntityLivingBase player) 
	{
		super(world, player);
		setVelocity(motionX * 3, motionY * 3, motionZ * 3);
	}
	
	@Override
	protected float getGravityVelocity()
	{
		return 0F;
	}

	@Override
	protected abstract void onImpact(MovingObjectPosition hitInfo) ;
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();
		
		if(++this.ticksInAir >= 100)
			this.setDead();
	}
}
