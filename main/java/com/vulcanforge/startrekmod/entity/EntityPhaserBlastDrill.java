package com.vulcanforge.startrekmod.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPhaserBlastDrill extends EntityPhaserBlast {

	public EntityPhaserBlastDrill(World w) 
	{
		super(w);
	}

	public EntityPhaserBlastDrill(World w, EntityLivingBase player) 
	{
		super(w, player);
	}

	@Override
	protected void onImpact(MovingObjectPosition hitInfo) 
	{
		if(getThrower() == null) return;
		
		if(hitInfo.entityHit != null)
		{
			hitInfo.entityHit.setDead();
			return;
		}
		
		worldObj.createExplosion(getThrower(), posX, posY, posZ, 4.0F, true);
		setDead();
	}
}
