package startrekmod.entity;

import startrekmod.*;
import startrekmod.generation.dimension.STTeleporter;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.*;

import cpw.mods.fml.relauncher.*;

public class EntityCelestial extends Entity
{
    public STCelestialData data;

    public EntityCelestial (World world)
    {
        super (world);
    }

    public EntityCelestial (World world, STCelestialData data)
    {
        super (world);
        this.data = data;
        
        dataWatcher.updateObject (2, data.name);
        
        setSize (data.size, data.size);
    }

    @Override
    protected void entityInit ()
    {
        dataWatcher.addObject (2, "");
    }

    @Override
    public boolean interactFirst (EntityPlayer player)
    {
        if (!worldObj.isRemote && data.dimensionID != -1)
        {
            WorldServer world = STUtilities.getServer ().worldServerForDimension (data.dimensionID);
            STUtilities.getManager ().transferPlayerToDimension ((EntityPlayerMP) player,
                            data.dimensionID, new STTeleporter (world));
            return true;
        }

        return false;
    }

    @Override
    public void onUpdate ()
    {
        if (!worldObj.isRemote)
            data.governor.updatePosition (this);
    }

    @Override
    protected void readEntityFromNBT (NBTTagCompound reader)
    {
        data = STCelestialData.getCelestialByName (reader.getString ("CelestialData"));
        dataWatcher.updateObject (2, data.name);
    }

    @Override
    protected void writeEntityToNBT (NBTTagCompound writer)
    {
        writer.setString ("CelestialData", data.name);
    }

    @Override
    public boolean canBeCollidedWith ()
    {
        return true;
    }
}
