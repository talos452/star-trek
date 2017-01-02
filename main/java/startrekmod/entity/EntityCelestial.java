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
    STCelestialData data;

    public EntityCelestial (World world)
    {
        super (world);
    }

    public EntityCelestial (World world, STCelestialData data)
    {
        super (world);
        this.data = data;
        this.setPosition (data.governor.posX, 128, data.governor.posZ);
        dataWatcher.updateObject (2, data.name);
        setSize (data.size, data.size);

        if (data.associated != null)
            setDead ();
        else data.associated = this;
    }

    @SideOnly(Side.CLIENT)
    public STCelestialData getCelestialData ()
    {
        if (data == null)
        {
            data = STCelestialData.getCelestialByName (dataWatcher.getWatchableObjectString (2));
            setSize (data.size, data.size);
        }

        return data;
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
        data = STCelestialData.getCelestialByName (reader.getString ("Celestial Data"));

        if (data.associated != null)
            setDead ();
        else
        {
            data.associated = this;
            data.readFromNBT (reader);
            dataWatcher.updateObject (2, data.name);
        }
    }

    @Override
    protected void writeEntityToNBT (NBTTagCompound writer)
    {
        writer.setString ("Celestial Data", data.name);
        data.writeToNBT (writer);
        data.associated = null;
    }

    @Override
    public boolean canBeCollidedWith ()
    {
        return true;
    }
}
