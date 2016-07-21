package startrekmod.entity.phaserblast;

import startrekmod.entity.EntityPhaserDrill;
import startrekmod.util.DirectionMode;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPhaserBlastDrill extends EntityPhaserBlast
{
	EntityPhaserDrill blastSource;
	DirectionMode direction;
	
	public EntityPhaserBlastDrill(World world) 
	{
		super(world);
	}

	public EntityPhaserBlastDrill(World world, EntityLivingBase player, EntityPhaserDrill source) 
	{
		super(world, player);
		blastSource = source;
		setPosition(source.posX, source.posY + 2, source.posZ);
		direction = source.direction;
		setThrowableHeading();
	}

	@Override
	protected void onImpact(MovingObjectPosition hitInfo) 
	{
		if(getThrower() == null) return;
		
		if(hitInfo.entityHit == blastSource) return;
		
		if(hitInfo.entityHit != null)
		{
			hitInfo.entityHit.setDead();
			return;
		}
		
		worldObj.createExplosion(getThrower(), posX, posY, posZ, 4.0F, true);
		setDead();
	}
	
	public void setThrowableHeading()
	{
		rotationYaw = blastSource.rotationYaw;
		
		switch(direction)
		{
		case NORTH:
			motionX = 0;
			motionZ = -.05;
			break;
		case SOUTH:
			motionX = 0;
			motionZ = .05;
			break;
		case EAST:
			motionX = .05;
			motionZ = 0;
			break;
		case WEST:
			motionX = -.05;
			motionZ = 0;
			break;
		}
		
		motionY = 0;
	}
}
