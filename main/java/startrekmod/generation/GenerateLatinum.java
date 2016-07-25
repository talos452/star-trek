package startrekmod.generation;

import startrekmod.STBlock;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import cpw.mods.fml.common.IWorldGenerator;

import java.util.Random;

public class GenerateLatinum implements IWorldGenerator
{
	public static WorldGenMinable latinum = new WorldGenMinable(STBlock.latinumOre, 8);
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		for(int i = 0; i < 16; i++)
			latinum.generate(world, random,
				chunkX * 16 + random.nextInt(16), 8 + random.nextInt(56),
				chunkZ * 16 + random.nextInt(16));
	}
}
