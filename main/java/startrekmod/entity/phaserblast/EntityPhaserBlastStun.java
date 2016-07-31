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
		if(hitInfo.typeOfHit == MovingObjectType.BLOCK)
		{
			//test if block can be shot through
			if(!worldObj.getBlock(hitInfo.blockX, hitInfo.blockY, hitInfo.blockZ).isOpaqueCube())
				return;
			else
			{
				setDead();
				return;
			}
		}
		
		//safety check
		if(operator == null)
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
		stunnedEntity.attackEntityFrom(DamageSource.causeMobDamage(operator), 1F);
		PotionEffect stun = new PotionEffect(Potion.moveSlowdown.id, 200, 1);
		stunnedEntity.addPotionEffect(stun);
	}
}
