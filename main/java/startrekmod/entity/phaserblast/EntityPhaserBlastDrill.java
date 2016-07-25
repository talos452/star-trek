package startrekmod.entity.phaserblast;

import startrekmod.entity.EntityPhaserDrill;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPhaserBlastDrill extends EntityPhaserBlast
{
	public EntityPhaserBlastDrill(World world) 
	{
		super(world);
	}

	public EntityPhaserBlastDrill(World world, EntityLivingBase player, EntityPhaserDrill source) 
	{
		super(world, player, source);
		//spawn the entity at the drill emitter rather than base
		setPosition(posX, posY + 3, posZ);
	}

	@Override
	public void onImpact(MovingObjectPosition hitInfo) 
	{
		if(operator == null) return;
		
		//don't impact with the drill
		if(hitInfo.entityHit == source) return;
		
		//wipe out anything that stands in the way of the drill target
		if(hitInfo.entityHit != null)
		{
			hitInfo.entityHit.setDead();
			return;
		}
		
		//boom!
		worldObj.createExplosion(operator, posX, posY, posZ, 6.0F, true);
		setDead();
	}
}
