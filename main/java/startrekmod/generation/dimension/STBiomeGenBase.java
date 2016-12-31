package startrekmod.generation.dimension;

import net.minecraft.world.biome.BiomeGenBase;

import java.util.ArrayList;

public class STBiomeGenBase extends BiomeGenBase
{
	static int biomeID = 0;
	static ArrayList starTrekBiomeList = new ArrayList ();

	public STBiomeGenBase ()
	{
		super (getUniqueBiomeID () + 40, true);
		starTrekBiomeList.add (this);
		spawnableMonsterList.clear ();
		spawnableCreatureList.clear ();
		spawnableWaterCreatureList.clear ();
		spawnableCaveCreatureList.clear ();
	}

	static int getUniqueBiomeID ()
	{
		return biomeID++;
	}
}
