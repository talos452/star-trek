package startrekmod.entity.energyblast;

import startrekmod.util.EntityProjectile;

import net.minecraft.entity.*;
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
		//5 refers to projectile speed
		this(world, operator, operator);
	}
	
	public EntityEnergyBlast(World world, EntityLivingBase operator, Entity source)
	{
		super(world, operator, source, 5);
	}
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();
		
		//delete blast after 5 seconds
		if(++ticksInAir >= 100)
			setDead();
	}
	
	//using function avoids odd sync problems
	public abstract Color getBeamColour();
}
