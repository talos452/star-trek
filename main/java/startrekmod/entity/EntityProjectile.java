package startrekmod.entity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class EntityProjectile extends Entity implements IProjectile
{
	EntityLivingBase operator;
	Entity source;
	double speed;
	
	public EntityProjectile(World world)
	{
		super(world);
	}
	
	public EntityProjectile(World world, EntityLivingBase source, double speed)
	{
		this(world, source, source, speed);
	}
	
	public EntityProjectile(World world, EntityLivingBase operator, Entity source, double speed)
	{
		super(world);
		this.operator = operator;
		this.source = source;
		posX = source.posX;
		posY = source.posY;
		posZ = source.posZ;
		
		//fire from the player's head, don't shoot from the hip
		rotationYaw = (source == operator) ? operator.rotationYawHead : source.rotationYaw;
		rotationPitch = source.rotationPitch;
		this.speed = speed;
		setThrowableHeading(0, 0, 0, 0, 0); //garbage params
	}

	@Override
	public void setThrowableHeading(double motionX, double motionY, double motionZ,
		float speed, float deviation)
	{
		//all stolen from EntityThrowable()...but math isn't copyrighted
        motionX = (double)(-MathHelper.sin(rotationYaw / 180.0F * (float)Math.PI)
        	* MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        motionZ = (double)(MathHelper.cos(rotationYaw / 180.0F * (float)Math.PI)
        	* MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        motionY = (double)(-MathHelper.sin(rotationPitch / 180.0F * (float)Math.PI));
        
        //and this part is my own smart brain
        motionX *= MathHelper.sqrt_double(speed);
        motionY *= MathHelper.sqrt_double(speed);
        motionZ *= MathHelper.sqrt_double(speed);
	}

	@Override
	protected void entityInit() {} //nothing to do and no one to do it to

	@Override
	protected void readEntityFromNBT(NBTTagCompound reader)
	{
		setDead(); //don't bother re-initializing from world save
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound writer) {} //see above

	@Override
	public void onUpdate()
	{
		lastTickPosX = posX;
		lastTickPosY = posY;
		lastTickPosZ = posZ;
		
		Vec3 pos = Vec3.createVectorHelper(posX, posY, posZ);
        Vec3 projectedPos = Vec3.createVectorHelper(posX + motionX, posY + motionY, posZ + motionZ);
        MovingObjectPosition movingobjectposition = worldObj.rayTraceBlocks(pos, projectedPos);
        pos = Vec3.createVectorHelper(posX, posY, posZ);
        projectedPos = Vec3.createVectorHelper(posX + motionX, posY + motionY, posZ + motionZ);
        
        if (movingobjectposition != null)
            projectedPos = Vec3.createVectorHelper(
            	movingobjectposition.hitVec.xCoord,
            	movingobjectposition.hitVec.yCoord,
            	movingobjectposition.hitVec.zCoord);
        
        if (!worldObj.isRemote)
        {
            Entity entity = null;
            
            List nearby = worldObj.getEntitiesWithinAABBExcludingEntity(this,
            	this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ)
            	.expand(1.0D, 1.0D, 1.0D));
            
            double closestDistance = 0.0D;

            for (int j = 0; j < nearby.size(); ++j)
            {
                Entity candidate = (Entity)nearby.get(j);

                if (candidate.canBeCollidedWith() && (candidate != operator))
                {
                    AxisAlignedBB axisalignedbb = candidate.boundingBox.expand(.3, .3, .3);
                    
                    MovingObjectPosition movingobjectposition1
                    	= axisalignedbb.calculateIntercept(pos, projectedPos);

                    if (movingobjectposition1 != null)
                    {
                        double distance = pos.distanceTo(movingobjectposition1.hitVec);

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
                movingobjectposition = new MovingObjectPosition(entity);
            }
        }

        if (movingobjectposition != null)
        {
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK
            	&& this.worldObj.getBlock(
            	movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ)
            	== Blocks.portal)
            {
                setInPortal();
            }
            else
            {
                onImpact(movingobjectposition);
            }
        }
		
		posX += motionX;
		posY += motionY;
		posZ += motionZ;
	}

	public abstract void onImpact(MovingObjectPosition movingobjectposition);
}
