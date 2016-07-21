package startrekmod.entity.phaserblast;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
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
		if(operator == null)
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
			worldObj.createExplosion(operator, posX, posY, posZ, 2.0F, true);
		}
		
		setDead();
	}
}
