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
	DirectionMode direction;
	
	public EntityPhaserBlastDrill(World world) 
	{
		super(world);
	}

	public EntityPhaserBlastDrill(World world, EntityLivingBase player, EntityPhaserDrill source) 
	{
		super(world, player, source);
		setPosition(posX, posY + 3, posZ);
	}

	@Override
	public void onImpact(MovingObjectPosition hitInfo) 
	{
		if(operator == null) return;
		
		if(hitInfo.entityHit == source) return;
		
		if(hitInfo.entityHit != null)
		{
			hitInfo.entityHit.setDead();
			return;
		}
		
		worldObj.createExplosion(operator, posX, posY, posZ, 4.0F, true);
		setDead();
	}
}
