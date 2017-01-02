package startrekmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityCube extends Entity
{
    public EntityCube (World world)
    {
        super (world);
    }

    @Override
    protected void entityInit ()
    {
    }

    @Override
    protected void readEntityFromNBT (NBTTagCompound reader)
    {
    }

    @Override
    protected void writeEntityToNBT (NBTTagCompound writer)
    {
    }
}
