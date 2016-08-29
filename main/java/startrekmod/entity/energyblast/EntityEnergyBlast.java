package startrekmod.entity.energyblast;

import startrekmod.entity.EntityProjectile;

import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.awt.Color;
import java.util.UUID;

public abstract class EntityEnergyBlast extends EntityProjectile
{
	protected EntityEnergyBlast (World world)
	{
		super (world);
	}

	protected EntityEnergyBlast (World world, UUID sourceID)
	{
		super (world, sourceID, 5);
	}

	protected abstract void damageBlock (int posX, int posY, int posZ);

	protected abstract void damageEntity (Entity entity);

	public abstract Color getBeamColour ();

	@Override
	protected final void onImpact (MovingObjectPosition info)
	{
		switch (info.typeOfHit)
		{
			case BLOCK:
				damageBlock (info.blockX, info.blockY, info.blockZ);
				setDead ();
				break;
			case ENTITY:
				if (!info.entityHit.isEntityInvulnerable ())
					damageEntity (info.entityHit);
				setDead ();
				break;
		}
	}

	@Override
	public void onUpdate ()
	{
		super.onUpdate ();

		if (ticksExisted > 99)
			setDead ();
	}
}
