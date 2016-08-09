package startrekmod.entity.energyblast;

import net.minecraft.entity.*;
import net.minecraft.init.Blocks;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

import java.awt.Color;

public class EntityDisruptorBlastKill extends EntityEnergyBlast
{
	public EntityDisruptorBlastKill(World world)
	{
		super(world);
	}

	public EntityDisruptorBlastKill(World world, EntityLivingBase operator)
	{
		super(world, operator, operator);
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
				worldObj.setBlock(hitInfo.blockX, hitInfo.blockY, hitInfo.blockZ, Blocks.fire);
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
		entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, operator), 10);
		
		if(!(entityHit instanceof EntityLivingBase))
		{
			setDead();
			return;
		}
		
		EntityLivingBase stunnedEntity = (EntityLivingBase)entityHit;
		PotionEffect consume = new PotionEffect(Potion.poison.id, 200, 1);
		stunnedEntity.addPotionEffect(consume);		
		setDead();
	}

	@Override
	public Color getBeamColour()
	{
		return new Color(1F, 0.25F, 0F);
	}
}
