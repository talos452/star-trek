package startrekmod.entity;

import startrekmod.util.PlanetData;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityPlanet extends Entity
{
	public PlanetData planetData;
	
	public EntityPlanet(World world)
	{
		super(world);
	}
	
	public EntityPlanet(World world, PlanetData planetData)
	{
		super(world);
		this.planetData = planetData;
		this.setPosition(planetData.xCoord, 128, planetData.zCoord);
	}

	@Override
	protected void entityInit()
	{
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound p_70037_1_)
	{
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound p_70014_1_)
	{
		
	}
}
