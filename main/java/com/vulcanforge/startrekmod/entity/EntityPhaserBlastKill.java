package com.vulcanforge.startrekmod.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPhaserBlastKill extends EntityPhaserBlast {

	public EntityPhaserBlastKill(World w) 
	{
		super(w);
	}

	public EntityPhaserBlastKill(World w, EntityLivingBase player) 
	{
		super(w, player);
	}

	@Override
	protected void onImpact(MovingObjectPosition hitInfo)
	{
		if(getThrower() == null)
		{
			setDead();
			return;
		}
		
		if(hitInfo.entityHit != null && hitInfo.entityHit instanceof EntityLivingBase)
		{
			EntityLivingBase shotEntity = (EntityLivingBase)hitInfo.entityHit;
			shotEntity.attackEntityFrom(DamageSource.inFire, 15F);
		}
		else
		{
			worldObj.createExplosion(getThrower(), posX, posY, posZ, 2.0F, true);
		}
		
		setDead();
	}
}
