package startrekmod.entity;

import startrekmod.STCelestialData;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityCelestial extends Entity
{
	STCelestialData data;
	float orbitAngle;

	public EntityCelestial(World world)
	{
		super(world);
	}

	public EntityCelestial(World world, STCelestialData data)
	{
		super(world);
		this.data = data;
		setPosition(data.posX, data.posY, data.posZ);
		dataWatcher.updateObject(2, data.name);
	}

	@Override
	protected void entityInit()
	{
		dataWatcher.addObject(2, "");
		orbitAngle = 0;
	}

	public STCelestialData getCelestialData()
	{
		if (data == null)
		{
			data = STCelestialData.getCelestialByName(dataWatcher.getWatchableObjectString(2));

			if (data == null)
			{
				setDead();
				return null;
			}

			setSize(data.size, data.size);
			setPosition(data.posX, data.posY, data.posZ);
		}

		return data;
	}

	@Override
	public void onUpdate()
	{
		if (worldObj.isRemote)
			return;

		if (getCelestialData() == null)
			return;

		int orbit = getCelestialData().orbitRadius;
		double orbitSpeed = getCelestialData().orbitSpeed;
		STCelestialData orbiting = getCelestialData().orbiting;

		if (orbiting == null)
			return;

		orbitAngle += orbitSpeed;

		if (orbitAngle == 2 * Math.PI)
			orbitAngle -= 2 * Math.PI;

		setPosition(Math.sin(orbitAngle) * orbit + orbiting.posX, posY, Math.cos(orbitAngle) * orbit + orbiting.posZ);
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound data)
	{
		this.data = STCelestialData.getCelestialByName(data.getString("Name"));

		if (this.data == null)
			return;

		setSize(this.data.size, this.data.size);
		setPosition(this.data.posX, this.data.posY, this.data.posZ);
		dataWatcher.updateObject(2, this.data.name);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound data)
	{
		data.setString("Name", this.data.name);
	}
}
