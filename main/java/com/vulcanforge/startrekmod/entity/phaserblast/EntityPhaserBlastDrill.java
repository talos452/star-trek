package com.vulcanforge.startrekmod.entity.phaserblast;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPhaserBlastDrill extends EntityPhaserBlast {

	public EntityPhaserBlastDrill(World world) 
	{
		super(world);
	}

	public EntityPhaserBlastDrill(World world, EntityLivingBase player) 
	{
		super(world, player);
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
