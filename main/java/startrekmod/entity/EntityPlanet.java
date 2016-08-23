package startrekmod.entity;

import startrekmod.STGeneration;
import startrekmod.generation.STTeleporter;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.*;

import cpw.mods.fml.relauncher.*;

public class EntityPlanet extends Entity
{
	public int associatedDimension;
	String name;

	public EntityPlanet(World world)
	{
		super(world);

		if (world.provider.dimensionId != STGeneration.spaceDimensionID)
			setDead();
	}

	public EntityPlanet(World world, String name, int dimension, int posX, int posY, int posZ)
	{
		super(world);
		this.name = name;
		this.setPosition(posX, posY, posZ);
		associatedDimension = dimension;
		dataWatcher.updateObject(2, name);
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return true;
	}

	@Override
	protected void entityInit()
	{
		setSize(6F, 6F);
		dataWatcher.addObject(2, "");
	}

	@SideOnly(Side.CLIENT)
	public String getPlanetName()
	{
		return dataWatcher.getWatchableObjectString(2);
	}

	@Override
	public boolean interactFirst(EntityPlayer player)
	{
		if (!(player instanceof EntityPlayerMP))
			return false;

		WorldServer world = MinecraftServer.getServer().worldServerForDimension(associatedDimension);
		MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)player, associatedDimension, new STTeleporter(world));
		return true;
	}

	@Override
	public void onUpdate()
	{}

	@Override
	protected void readEntityFromNBT(NBTTagCompound data)
	{
		name = data.getString("Name");
		associatedDimension = data.getInteger("AssociatedDimension");
		dataWatcher.updateObject(2, name);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound data)
	{
		data.setString("Name", name);
		data.setInteger("AssociatedDimension", associatedDimension);
	}
}
