package startrekmod.entity.energyblast;

import startrekmod.entity.EntityPhaserDrill;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.*;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

import java.awt.Color;

public class EntityDrillBlast extends EntityEnergyBlast
{
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
			worldObj.createExplosion(operator, hitInfo.blockX, hitInfo.blockY, hitInfo.blockZ, 2.0F, true);
		else
			hitInfo.entityHit.attackEntityFrom(DamageSource.onFire, 50);
	}

	@Override
	public Color getBeamColour()
	{
		return new Color(0.5F, 0.125F, 1F);
	}
}
