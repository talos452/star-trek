package startrekmod.entity.phaserblast;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class EntityPhaserBlastStun extends EntityPhaserBlast {

	public EntityPhaserBlastStun(World world) 
	{
		super(world);
	}

	public EntityPhaserBlastStun(World world, EntityLivingBase player) 
	{
		super(world, player);
	}

	@Override
	protected void onImpact(MovingObjectPosition hitInfo)
	{
		if(getThrower() == null || hitInfo.typeOfHit == MovingObjectType.BLOCK)
		{
			setDead();
			return;
		}
		
		Entity entityHit = hitInfo.entityHit;
		
		if(!(entityHit instanceof EntityLivingBase))
		{
			setDead();
			return;
		}
		
		EntityLivingBase stunnedEntity = (EntityLivingBase)entityHit;
		stunnedEntity.attackEntityFrom(DamageSource.onFire, 1F);
		PotionEffect stun = new PotionEffect(Potion.moveSlowdown.id, 200);
		stunnedEntity.addPotionEffect(stun);
	}
}
