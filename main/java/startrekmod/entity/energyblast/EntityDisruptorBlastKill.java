package startrekmod.entity.energyblast;

import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.awt.Color;
import java.util.UUID;

public class EntityDisruptorBlastKill extends EntityEnergyBlast
{
	public EntityDisruptorBlastKill (World world)
	{
		super (world);
	}

	public EntityDisruptorBlastKill (World world, UUID playerID)
	{
		super (world, playerID);
	}

	@Override
	protected void damageBlock (int posX, int posY, int posZ)
	{
		worldObj.setBlock (posX, posY, posZ, Blocks.fire);
	}

	@Override
	protected void damageEntity (Entity entity)
	{
		entity.attackEntityFrom (DamageSource.causePlayerDamage (getSourceOperator ()), 10F);
		entity.setFire (3);
	}

	@Override
	public Color getBeamColour ()
	{
		return new Color (1F, 0.25F, 0F);
	}
}
