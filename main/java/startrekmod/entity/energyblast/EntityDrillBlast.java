package startrekmod.entity.energyblast;

import startrekmod.entity.EntityPhaserDrill;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.*;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

import java.awt.Color;

public class EntityDrillBlast extends EntityEnergyBlast
{
	int impactsLeft = 4;
	
	public EntityDrillBlast(World world) 
	{
		super(world);
	}

	public EntityDrillBlast(World world, EntityLivingBase player, EntityPhaserDrill source) 
	{
		super(world, player, source);
		//spawn the entity at the drill emitter rather than base
		setPosition(posX, posY + 3, posZ);
	}

	@Override
	public void onImpact(MovingObjectPosition hitInfo) 
	{
		if(operator == null)
		{
			setDead();
			return;
		}
		
		if(hitInfo.typeOfHit == MovingObjectType.BLOCK)
		{
			worldObj.setBlockToAir(hitInfo.blockX, hitInfo.blockY, hitInfo.blockZ);
			impactsLeft--;
		}
		else
		{
			hitInfo.entityHit.attackEntityFrom(DamageSource.onFire, 50);
			impactsLeft--;
		}
		
		if(impactsLeft == 0)
			setDead();
	}

	@Override
	public Color getBeamColour()
	{
		return new Color(0.5F, 0.125F, 1F);
	}
}
