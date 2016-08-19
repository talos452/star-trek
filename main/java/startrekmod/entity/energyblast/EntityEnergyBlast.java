package startrekmod.entity.energyblast;

import startrekmod.util.EntityProjectile;

import net.minecraft.entity.*;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.awt.Color;

public abstract class EntityEnergyBlast extends EntityProjectile
{
	int ticksInAir = 0;

	public EntityEnergyBlast(World world)
	{
		super(world);
	}

	public EntityEnergyBlast(World world, EntityLivingBase operator)
	{
		this(world, operator, operator);
	}

	public EntityEnergyBlast(World world, EntityLivingBase operator, Entity source)
	{
		super(world, operator, source, 5);
	}

	public abstract void damageBlock(int posX, int posY, int posZ);

	public abstract void damageEntity(Entity entity);

	public abstract Color getBeamColour();

	@Override
	public final void onImpact(MovingObjectPosition info)
	{
		switch (info.typeOfHit)
		{
			case BLOCK:
				damageBlock(info.blockX, info.blockY, info.blockZ);
				setDead();
				break;
			case ENTITY:
				if (!info.entityHit.isEntityInvulnerable())
					damageEntity(info.entityHit);
				setDead();
				break;
		}
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (++ticksInAir >= 100)
			setDead();
	}
}
