package startrekmod.entity.energyblast;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.awt.Color;
import java.util.UUID;

public class EntityDrillBlast extends EntityEnergyBlast
{
	public EntityDrillBlast (World world)
	{
		super (world);
	}

	public EntityDrillBlast (World world, UUID drillID)
	{
		super (world, drillID);
		setPosition (posX, posY + 3, posZ);
	}

	@Override
	protected void damageBlock (int posX, int posY, int posZ)
	{
		worldObj.setBlockToAir (posX, posY, posZ);
		worldObj.createExplosion (getSourceOperator (), posX, posY, posZ, 4F, true);
	}

	@Override
	protected void damageEntity (Entity entity)
	{
		entity.attackEntityFrom (DamageSource.onFire, 100F);
	}

	@Override
	public Color getBeamColour ()
	{
		return new Color (0.5F, 0.125F, 1F);
	}
}
