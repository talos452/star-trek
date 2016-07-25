package startrekmod.generation;

import startrekmod.STBlock;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import cpw.mods.fml.common.IWorldGenerator;

import java.util.Random;

public class GenerateDilithium implements IWorldGenerator
{
	public static WorldGenMinable dilithium = new WorldGenMinable(STBlock.dilithiumOre, 8);
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		for(int i = 0; i < 4; i++)
			dilithium.generate(world, random,
				chunkX * 16 + random.nextInt(16), 8 + random.nextInt(24),
				chunkZ * 16 + random.nextInt(16));
	}
}
