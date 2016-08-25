package startrekmod.entity.energyblast;

import startrekmod.entity.EntityPhaserDrill;

import net.minecraft.entity.*;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.awt.Color;

public class EntityDrillBlast extends EntityEnergyBlast
{
	public EntityDrillBlast(World world)
	{
		super (world);
	}

	public EntityDrillBlast(World world, EntityLivingBase player, EntityPhaserDrill source)
	{
		super (world, player, source);
		setPosition (posX, posY + 3, posZ);
	}

	@Override
	public void damageBlock(int posX, int posY, int posZ)
	{
		worldObj.setBlockToAir (posX, posY, posZ);
		worldObj.createExplosion (operator, posX, posY, posZ, 4F, true);
	}

	@Override
	public void damageEntity(Entity entity)
	{
		entity.attackEntityFrom (DamageSource.onFire, 100F);
	}

	@Override
	public Color getBeamColour()
	{
		return new Color (0.5F, 0.125F, 1F);
	}
}
