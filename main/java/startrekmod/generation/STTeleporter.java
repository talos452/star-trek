package startrekmod.generation;

import net.minecraft.entity.Entity;
import net.minecraft.world.*;

public class STTeleporter extends Teleporter
{
	public STTeleporter(WorldServer world)
	{
		super(world);
	}

	//no need to create any sort of portal
	//simply spawn entity in at 0, 128, 0
	@Override
	public void placeInPortal(Entity entity, double x, double y, double z, float yaw)
	{
		entity.setLocationAndAngles(0, 128, 0, yaw, entity.rotationPitch);
	}
}
