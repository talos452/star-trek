package startrekmod.generation;

import startrekmod.STBlock;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import cpw.mods.fml.common.IWorldGenerator;

import java.util.Random;

public class GenerateLatinum implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		WorldGenMinable latinum = new WorldGenMinable(STBlock.latinumOre, 8);

		for (int i = 0; i < 2; i++)
			latinum.generate(world, random, chunkX * 16 + random.nextInt(16), 8 + random.nextInt(8), chunkZ * 16 + random.nextInt(16));
	}
}
