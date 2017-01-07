package startrekmod.entity;

import startrekmod.STUtilities;

import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.*;

public abstract class EntityProjectile extends Entity implements IProjectile
{
    UUID sourceID;
    double speed;

    protected EntityProjectile (World world)
    {
        super (world);
    }

    protected EntityProjectile (World world, UUID sourceID, double speed)
    {
        super (world);
        this.sourceID = sourceID;

        Entity source = getProjectileSource ();

        posX = source.posX;
        posZ = source.posZ;
        posY = (source instanceof EntityPlayer) ? source.posY + 1.5 : source.posY;
        setPosition (posX, posY, posZ);

        rotationYaw = (source instanceof EntityPlayer) ? ((EntityPlayer) source).rotationYawHead : source.rotationYaw;
        rotationPitch = source.rotationPitch;

        this.speed = speed;
        setThrowableHeading (0, 0, 0, 0, 0);
    }

    @Override
    protected void entityInit ()
    {
        setSize (.25F, .25F);
    }

    @Override
    public void onUpdate ()
    {
        lastTickPosX = posX;
        lastTickPosY = posY;
        lastTickPosZ = posZ;

        Vec3 pos = Vec3.createVectorHelper (posX, posY, posZ);
        Vec3 projectedPos = Vec3.createVectorHelper (posX + motionX, posY + motionY, posZ + motionZ);
        MovingObjectPosition movingobjectposition = worldObj.rayTraceBlocks (pos, projectedPos);
        pos = Vec3.createVectorHelper (posX, posY, posZ);
        projectedPos = Vec3.createVectorHelper (posX + motionX, posY + motionY, posZ + motionZ);

        if (movingobjectposition != null)
            projectedPos = Vec3.createVectorHelper (movingobjectposition.hitVec.xCoord,
                            movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);

        if (!worldObj.isRemote)
        {
            Entity entity = null;

            List nearby = worldObj.getEntitiesWithinAABBExcludingEntity (
                            this,
                            this.boundingBox.addCoord (this.motionX, this.motionY, this.motionZ).expand (1.0D, 1.0D,
                                            1.0D));

            double closestDistance = 0.0D;

            for (int j = 0; j < nearby.size (); ++j)
            {
                Entity candidate = (Entity) nearby.get (j);

                if (candidate.canBeCollidedWith () && (candidate != getSourceOperator ())
                                && (candidate != getProjectileSource ()))
                {
                    AxisAlignedBB axisalignedbb = candidate.boundingBox.expand (.3, .3, .3);

                    MovingObjectPosition movingobjectposition1 = axisalignedbb.calculateIntercept (pos, projectedPos);

                    if (movingobjectposition1 != null)
                    {
                        double distance = pos.distanceTo (movingobjectposition1.hitVec);

                        if (distance < closestDistance || closestDistance == 0.0D)
                        {
                            entity = candidate;
                            closestDistance = distance;
                        }
                    }
                }
            }

            if (entity != null)
            {
                movingobjectposition = new MovingObjectPosition (entity);
            }

            if (movingobjectposition != null)
            {
                if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK
                                && this.worldObj.getBlock (movingobjectposition.blockX, movingobjectposition.blockY,
                                                movingobjectposition.blockZ) == Blocks.portal)
                {
                    setInPortal ();
                }
                else
                {
                    onImpact (movingobjectposition);
                }
            }
        }

        posX += motionX;
        posY += motionY;
        posZ += motionZ;

        setPosition (posX, posY, posZ);
    }

    @Override
    public void setThrowableHeading (double motionX, double motionY, double motionZ, float speed, float deviation)
    {
        this.motionX = -MathHelper.sin (rotationYaw / 180.0F * (float) Math.PI)
                        * MathHelper.cos (this.rotationPitch / 180.0F * (float) Math.PI);
        this.motionZ = MathHelper.cos (rotationYaw / 180.0F * (float) Math.PI)
                        * MathHelper.cos (this.rotationPitch / 180.0F * (float) Math.PI);
        this.motionY = (-MathHelper.sin (rotationPitch / 180.0F * (float) Math.PI));

        this.motionX *= MathHelper.sqrt_double (this.speed);
        this.motionY *= MathHelper.sqrt_double (this.speed);
        this.motionZ *= MathHelper.sqrt_double (this.speed);
    }

    protected abstract void onImpact (MovingObjectPosition info);

    public Entity getProjectileSource ()
    {
        return STUtilities.getEntityByUUID (sourceID, worldObj);
    }

    public EntityPlayer getSourceOperator ()
    {
        Entity entity = getProjectileSource ();

        if (entity instanceof EntityPlayer)
            return (EntityPlayer) entity;
        else if (entity instanceof EntityPhaserDrill)
            return ((EntityPhaserDrill) entity).getLastOperator ();

        return null;
    }

    @Override
    protected void readEntityFromNBT (NBTTagCompound reader)
    {
        setDead ();
    }

    @Override
    protected void writeEntityToNBT (NBTTagCompound writer)
    {
    }
}
