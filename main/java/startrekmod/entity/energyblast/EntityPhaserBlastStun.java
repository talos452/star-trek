package startrekmod.entity.energyblast;

import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

import java.awt.Color;

public class EntityPhaserBlastStun extends EntityEnergyBlast
{
	public EntityPhaserBlastStun(World world) 
	{
		super(world);
	}

	public EntityPhaserBlastStun(World world, EntityLivingBase operator) 
	{
		super(world, operator);
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
		//simple knockback effect
		entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, operator), 0);
		
		if(!(entityHit instanceof EntityLivingBase))
		{
			setDead();
			return;
		}
		
		EntityLivingBase stunnedEntity = (EntityLivingBase)entityHit;
		PotionEffect stun = new PotionEffect(Potion.moveSlowdown.id, 200, 1);
		PotionEffect nausea = new PotionEffect(Potion.confusion.id, 600, 0);
		stunnedEntity.addPotionEffect(stun);
		stunnedEntity.addPotionEffect(nausea);		
		setDead();
	}
	
	@Override
	public Color getBeamColour()
	{
		return new Color(1F, 0.25F, 0F);
	}
}
