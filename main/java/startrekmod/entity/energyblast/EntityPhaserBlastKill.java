package startrekmod.entity.energyblast;

import net.minecraft.entity.*;
import net.minecraft.init.Blocks;
import net.minecraft.util.*;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

import java.awt.Color;

public class EntityPhaserBlastKill extends EntityEnergyBlast
{

	public EntityPhaserBlastKill(World world) 
	{
		super(world);
	}

	public EntityPhaserBlastKill(World world, EntityLivingBase operator) 
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
		entityHit.setFire(3);
		setDead();
	}
	
	@Override
	public Color getBeamColour()
	{
		return new Color(1F, 0.25F, 0F);
	}
}
