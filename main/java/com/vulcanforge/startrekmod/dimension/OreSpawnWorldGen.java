package com.vulcanforge.startrekmod.dimension;

import java.util.Random;

import com.vulcanforge.startrekmod.blocks.STBlock;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class OreSpawnWorldGen implements IWorldGenerator 
{
	public static WorldGenMinable dilithium = new WorldGenMinable(STBlock.dilithiumOre, 8);
	public static WorldGenMinable latinum = new WorldGenMinable(STBlock.latinumOre, 8);
	public static WorldGenMinable duranium = new WorldGenMinable(STBlock.duraniumOre, 12);
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		if(world.provider.dimensionId != 0)
			return;
		
		for(int i = 0; i < 4; i++)
			dilithium.generate(world, random, 
					chunkX * 16 + random.nextInt(16), 8 + random.nextInt(4), chunkZ * 16 + random.nextInt(16));
		
		for(int i = 0; i < 16; i++)
			duranium.generate(world, random,
					chunkX * 16 + random.nextInt(16), 8 + random.nextInt(56), chunkZ * 16 + random.nextInt(16));
		
		for(int i = 0; i < 4; i++)
			latinum.generate(world, random,
					chunkX * 16 + random.nextInt(16), 8 + random.nextInt(24), chunkZ * 16 + random.nextInt(16));
	}
}
