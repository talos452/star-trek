package startrekmod.entity.energyblast;

import net.minecraft.entity.*;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
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
	public void damageBlock(int posX, int posY, int posZ)
	{
		worldObj.setBlock(posX, posY, posZ, Blocks.fire);
	}

	@Override
	public void damageEntity(Entity entity)
	{
		entity.attackEntityFrom(DamageSource.onFire, 10F);
		entity.setFire(3);
	}

	@Override
	public Color getBeamColour()
	{
		return new Color(1F, 0.25F, 0F);
	}
}
