package startrekmod.entity.phaserblast;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class EntityPhaserBlastKill extends EntityPhaserBlast {

	public EntityPhaserBlastKill(World world) 
	{
		super(world);
	}

	public EntityPhaserBlastKill(World world, EntityLivingBase player) 
	{
		super(world, player);
	}

	@Override
	public void onImpact(MovingObjectPosition hitInfo)
	{
		//safety check
		if(operator == null)
		{
			setDead();
			return;
		}
		
		if(hitInfo.entityHit != null && hitInfo.entityHit instanceof EntityLivingBase)
		{
			EntityLivingBase shotEntity = (EntityLivingBase)hitInfo.entityHit;
			shotEntity.attackEntityFrom(DamageSource.causeMobDamage(operator), 15F);
		}
		else
			worldObj.createExplosion(operator, posX, posY, posZ, 2.0F, true);
		
		setDead();
	}
}
