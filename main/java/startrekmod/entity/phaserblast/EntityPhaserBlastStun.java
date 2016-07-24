package startrekmod.entity.phaserblast;

import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
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
	public void onImpact(MovingObjectPosition hitInfo)
	{
		if(operator == null || hitInfo.typeOfHit == MovingObjectType.BLOCK)
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
