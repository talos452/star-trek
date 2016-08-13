package startrekmod.generation;

import net.minecraft.world.biome.BiomeGenBase;

import java.util.ArrayList;

public class STBiome extends BiomeGenBase
{
	static int biomeID = 0; //starts at 40 because vanilla goes from 0 to 39
	static ArrayList starTrekBiomeList = new ArrayList();
	
	public STBiome()
	{
		super(getUniqueBiomeID(), false);
		starTrekBiomeList.add(this);
		spawnableMonsterList.clear();
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
	}
	
	public static int getUniqueBiomeID()
	{
		return biomeID++;
	}
}
