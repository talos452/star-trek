package startrekmod;

import startrekmod.entity.*;

import net.minecraft.world.World;

import java.util.*;

public class STCelestialData
{
	public int dimensionID;
	public String name;
	public STCelestialData orbiting;
	public int orbitRadius;
	public double orbitSpeed;
	public double posX, posY, posZ;
	public int size;

	public static List<STCelestialData> bodyList;

	public STCelestialData(String name, double posX, double posY, double posZ, int size)
	{
		this(name, -1, posX, posY, posZ, size, null, 0, 0);
	}

	public STCelestialData(String name, int dimensionID, double posX, double posY, double posZ, int size, STCelestialData orbiting, int orbit, double orbitSpeed)
	{
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.dimensionID = dimensionID;
		this.size = size;
		this.orbiting = orbiting;
		this.orbitRadius = orbit;
		this.orbitSpeed = orbitSpeed;

		bodyList.add(this);
	}

	public STCelestialData(String name, int dimensionID, int size, STCelestialData orbiting, int orbit, double orbitSpeed)
	{
		this(name, dimensionID, orbiting.posX, orbiting.posY + orbiting.size / 2 - size, orbiting.posZ + orbit, size, orbiting, orbit, orbitSpeed);
	}

	public STCelestialData(String name, int size, STCelestialData orbiting, int orbit, double orbitSpeed)
	{
		this(name, -1, orbiting.posX, orbiting.posY + orbiting.size / 2 - size, orbiting.posZ + orbit, size, orbiting, orbit, orbitSpeed);
	}

	public static EntityCelestial createEntityForCelestial(STCelestialData celestial, World world)
	{
		EntityCelestial entity;

		if (celestial.dimensionID == -1)
			entity = new EntityCelestial(world, celestial);
		else
			entity = new EntityPlanet(world, celestial);

		return entity;
	}

	public static STCelestialData getCelestialByName(String name)
	{
		for (STCelestialData celestial : bodyList)
			if (celestial.name.equals(name))
				return celestial;

		return null;
	}

	public static void init()
	{
		bodyList = new ArrayList<STCelestialData>();
		int yCenter = 32767;

		STCelestialData sol = new STCelestialData("sol", 0, yCenter - 8, 0, 16);
		STCelestialData mercury = new STCelestialData("mercury", 1, sol, 32, 2 * Math.PI / 600.0);
		STCelestialData venus = new STCelestialData("venus", 4, sol, 48, 2 * Math.PI / 900.0);
		STCelestialData earth = new STCelestialData("earth", 0, 4, sol, 64, 2 * Math.PI / 1200.0);
		STCelestialData mars = new STCelestialData("mars", STGeneration.marsDimensionID, 2, sol, 92, 2 * Math.PI / 1800.0);
		STCelestialData jupiter = new STCelestialData("jupiter", 8, sol, 128, 2 * Math.PI / 2400.0);
		STCelestialData saturn = new STCelestialData("saturn", 8, sol, 192, 2 * Math.PI / 4800.0);
		STCelestialData uranus = new STCelestialData("uranus", 6, sol, 256, 2 * Math.PI / 9600.0);
		STCelestialData neptune = new STCelestialData("neptune", 6, sol, 512, 2 * Math.PI / 19200.0);
	}
}
