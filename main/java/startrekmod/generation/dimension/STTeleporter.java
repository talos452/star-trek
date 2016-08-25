package startrekmod.generation.dimension;

import net.minecraft.entity.Entity;
import net.minecraft.world.*;

public class STTeleporter extends Teleporter
{
	int dimensionID;

	public STTeleporter (WorldServer world)
	{
		super (world);
		dimensionID = world.provider.dimensionId;
	}

	@Override
	public void placeInPortal (Entity entity, double x, double y, double z, float yaw)
	{

	}
}
