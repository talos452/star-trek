package startrekmod;

import net.minecraft.world.ChunkCoordIntPair;

import java.util.Hashtable;

public class STCelestialData
{
	public String name;

	public double posX, posY, posZ;
	public int size;

	public STCelestialData orbiting;
	public int orbitRadius;
	public double orbitPeriod;

	public int dimensionID;

	public static Hashtable <ChunkCoordIntPair, STCelestialData> bodyList;

	public STCelestialData (String name, int dimensionID,
		double posX, double posY, double posZ, int size,
		STCelestialData orbiting, int orbit, double orbitPeriod)
	{
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.dimensionID = dimensionID;
		this.size = size;
		this.orbiting = orbiting;
		this.orbitRadius = orbit;
		this.orbitPeriod = orbitPeriod;

		bodyList.put (new ChunkCoordIntPair ((int) posX, (int) posZ), this);
	}

	public STCelestialData (String name,
		double posX, double posY, double posZ, int size)
	{
		this (name, -1, posX, posY, posZ, size, null, 0, 0);
	}

	public STCelestialData (String name, int dimensionID, int size,
		STCelestialData orbiting, int orbit, double orbitPeriod)
	{
		this (name, dimensionID,
			orbiting.posX, orbiting.posY + orbiting.size / 2 - size, orbiting.posZ + orbit,
			size, orbiting, orbit, orbitPeriod);
	}

	public STCelestialData (String name, int size,
		STCelestialData orbiting, int orbit, double orbitPeriod)
	{
		this (name, -1,
			orbiting.posX, orbiting.posY + orbiting.size / 2 - size, orbiting.posZ + orbit,
			size, orbiting, orbit, orbitPeriod);
	}

	public static void init ()
	{
		bodyList = new Hashtable <ChunkCoordIntPair, STCelestialData> ();

		int yCenter = 32767;

		STCelestialData sol = new STCelestialData ("sol", 0, yCenter - 8, 0, 16);
		new STCelestialData ("mercury", 1, sol, 32, 450);
		new STCelestialData ("venus", 4, sol, 48, 2400);
		new STCelestialData ("earth", 0, 4, sol, 64, 3600);
		new STCelestialData ("mars", getDimension ("mars"), 2, sol, 92, 7200);
		new STCelestialData ("jupiter", 8, sol, 128, 45000);
		new STCelestialData ("saturn", 8, sol, 192, 90000);
		new STCelestialData ("uranus", 6, sol, 256, 270000);
		new STCelestialData ("neptune", 6, sol, 512, 540000);
	}

	public static STCelestialData getCelestialByName (String name)
	{
		return bodyList.get (name);
	}

	static int getDimension (String name)
	{
		return STDimension.dimensionTable.get (name).dimensionID;
	}
}
