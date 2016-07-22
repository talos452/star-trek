package startrekmod.entity.phaserblast;

import startrekmod.util.EntityProjectile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public abstract class EntityPhaserBlast extends EntityProjectile
{
	int ticksInAir = 0;
	
	public EntityPhaserBlast(World world)
	{
		super(world);
	}
	
	public EntityPhaserBlast(World world, EntityLivingBase player) 
	{
		super(world, player, 5);
	}
	
	public EntityPhaserBlast(World world, EntityLivingBase player, Entity source)
	{
		super(world, player, source, 5);
	}
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();
		
		if(++ticksInAir >= 100)
			setDead();
	}
}
