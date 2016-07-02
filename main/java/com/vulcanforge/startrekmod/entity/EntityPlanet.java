package com.vulcanforge.startrekmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityPlanet extends Entity 
{
	public String name;
	
	public static Entity earth;
	public static Entity mars;
	
	private EntityPlanet(World w, String name)
	{
		super(w);
		this.name = name;
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
	
	public static void init(World w)
	{
		earth = new EntityPlanet(w, "Earth");
		mars = new EntityPlanet(w, "Mars");
	}

}
