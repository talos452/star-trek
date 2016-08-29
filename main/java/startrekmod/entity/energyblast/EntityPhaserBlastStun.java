package startrekmod.entity.energyblast;

import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.awt.Color;
import java.util.UUID;

public class EntityPhaserBlastStun extends EntityEnergyBlast
{
	public EntityPhaserBlastStun (World world)
	{
		super (world);
	}

	public EntityPhaserBlastStun (World world, UUID playerID)
	{
		super (world, playerID);
	}

	@Override
	protected void damageBlock (int posX, int posY, int posZ)
	{
		if (worldObj.getBlock (posX, posY, posZ).getBlockHardness (worldObj, posX, posY, posZ) < 1.5F)
			worldObj.setBlockToAir (posX, posY, posZ);
	}

	@Override
	protected void damageEntity (Entity entity)
	{
		entity.attackEntityFrom (DamageSource.causePlayerDamage (getSourceOperator ()), 2);

		if (entity instanceof EntityLiving)
		{

			EntityLiving victim = (EntityLiving) entity;
			PotionEffect nausea = new PotionEffect (Potion.confusion.id, 600);
			PotionEffect slowness = new PotionEffect (Potion.moveSlowdown.id, 600);
			victim.addPotionEffect (nausea);
			victim.addPotionEffect (slowness);
		}
	}

	@Override
	public Color getBeamColour ()
	{
		return new Color (1F, 0.25F, 0F);
	}
}
