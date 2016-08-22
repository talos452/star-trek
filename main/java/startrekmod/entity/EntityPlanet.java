package startrekmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityPlanet extends Entity
{
	public String name;
	int rotationTimer;

	public EntityPlanet(World world)
	{
		super(world);
		rotationTimer = 0;
	}

	public EntityPlanet(World world, String name, int posX, int posZ)
	{
		super(world);
		this.name = name;
		this.setPosition(posX, 128, posZ);
		rotationTimer = 0;
	}

	@Override
	protected void entityInit()
	{
		setSize(6F, 6F);
	}

	@Override
	public void onUpdate()
	{
		rotationYaw += .15F;
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
