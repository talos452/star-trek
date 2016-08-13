package startrekmod.generation.dimension.space;

import startrekmod.STGeneration;
import startrekmod.generation.dimension.space.*;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderSpace extends WorldProvider
{
	@Override
	protected void registerWorldChunkManager()
	{
		worldChunkMgr = new WorldChunkManagerHell(new BiomeGenSpace(), 0F);
		dimensionId = STGeneration.spaceDimensionID;
		hasNoSky = true;
	}

	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderSpace();
	}

	@Override
	public String getDimensionName()
	{
		return "Space";
	}
	
	@Override
	public String getSaveFolder()
	{
		return getDimensionName();
	}
	
	@Override
	public String getWelcomeMessage()
	{
		return "Departing planetary atmosphere";
	}
	
	@Override
	public String getDepartMessage()
	{
		return "Entering planetary atmosphere";
	}
	
	@Override
	public boolean shouldMapSpin(String entity, double x, double y, double z)
	{
		return false;
	}
	
	@Override
	public int getRespawnDimension(EntityPlayerMP player)
    {
        throw new UnsupportedOperationException("Add something to find the player's last planet.");
    }
}
