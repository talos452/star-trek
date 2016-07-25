package startrekmod.util;

import net.minecraft.entity.*;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.List;

public abstract class EntityProjectile extends Entity implements IProjectile
{
	public EntityLivingBase operator;
	public Entity source;
	public double speed;
	
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
		
		//if the source is the operator, fire from the operator's head
		posY = (source == operator) ? operator.posY + 1.5 : source.posY;
		posZ = source.posZ;
		setPosition(posX, posY, posZ); //sets up bounding box
		
		//fire the direction the player is looking, not square to
		rotationYaw = (source == operator) ? operator.rotationYawHead : source.rotationYaw;
		rotationPitch = source.rotationPitch; //rotationPitch refers to EntityLivingBase's head
		this.speed = speed;
		setThrowableHeading(0, 0, 0, 0, 0); //garbage params
	}

	@Override
	public void setThrowableHeading(double motionX, double motionY, double motionZ,
		float speed, float deviation)
	{
		//all stolen from EntityThrowable()...but math isn't copyrighted
		//and I know where these formulas come from
		this.motionX = (double)(-MathHelper.sin(rotationYaw / 180.0F * (float)Math.PI)
			* MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
		this.motionZ = (double)(MathHelper.cos(rotationYaw / 180.0F * (float)Math.PI)
			* MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
		this.motionY = (double)(-MathHelper.sin(rotationPitch / 180.0F * (float)Math.PI));
		
		//and this part is my own smart brain
		this.motionX *= MathHelper.sqrt_double(this.speed);
		this.motionY *= MathHelper.sqrt_double(this.speed);
		this.motionZ *= MathHelper.sqrt_double(this.speed);
	}

	@Override
	protected void entityInit()
	{
		//not even going to get into it, so don't ask
		setSize(.25F, .25F);
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound reader)
	{
		//don't bother re-initializing from world save
		setDead();
	}

	//see above
	@Override
	protected void writeEntityToNBT(NBTTagCompound writer) {}

	@Override
	public void onUpdate()
	{
		//for rendering purposes?
		lastTickPosX = posX;
		lastTickPosY = posY;
		lastTickPosZ = posZ;
		
		//presumably creates a box to check block collisions in?
		Vec3 pos = Vec3.createVectorHelper(posX, posY, posZ);
		Vec3 projectedPos = Vec3.createVectorHelper(posX + motionX, posY + motionY, posZ + motionZ);
		MovingObjectPosition movingobjectposition = worldObj.rayTraceBlocks(pos, projectedPos);
		pos = Vec3.createVectorHelper(posX, posY, posZ);
		projectedPos = Vec3.createVectorHelper(posX + motionX, posY + motionY, posZ + motionZ);
		
		//now projectedPos is hijacked to hold block location
		if (movingobjectposition != null)
			projectedPos = Vec3.createVectorHelper(
				movingobjectposition.hitVec.xCoord,
				movingobjectposition.hitVec.yCoord,
				movingobjectposition.hitVec.zCoord);
		
		if (!worldObj.isRemote)
		{
			Entity entity = null;
			
			//expand bounding box to optimistically hit entities
			List nearby = worldObj.getEntitiesWithinAABBExcludingEntity(this,
				this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ)
				.expand(1.0D, 1.0D, 1.0D));
			
			//algorithm updates this to find closest entity
			double closestDistance = 0.0D;

			for (int j = 0; j < nearby.size(); ++j)
			{
				Entity candidate = (Entity)nearby.get(j);

				if (candidate.canBeCollidedWith() && (candidate != operator))
				{
					AxisAlignedBB axisalignedbb = candidate.boundingBox.expand(.3, .3, .3);
					
					//check to see if near miss is in fact a graze
					MovingObjectPosition movingobjectposition1
						= axisalignedbb.calculateIntercept(pos, projectedPos);

					if (movingobjectposition1 != null)
					{
						//iterate through all distances, find closest entity
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
		
		//basic motion update
		posX += motionX;
		posY += motionY;
		posZ += motionZ;
		
		setPosition(posX, posY, posZ); //resets bounding box. Extremely important!
	}

	public abstract void onImpact(MovingObjectPosition movingobjectposition);
}
