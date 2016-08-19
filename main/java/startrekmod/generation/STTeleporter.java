package startrekmod.generation;

import net.minecraft.entity.Entity;
import net.minecraft.world.*;

public class STTeleporter extends Teleporter
{
	public STTeleporter(WorldServer world)
	{
		super(world);
	}

	@Override
	public void placeInPortal(Entity entity, double x, double y, double z, float yaw)
	{
		entity.setLocationAndAngles(0, 128, 0, yaw, entity.rotationPitch);
	}
}
