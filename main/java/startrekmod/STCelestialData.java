package startrekmod;

import net.minecraft.entity.Entity;
import net.minecraft.world.ChunkCoordIntPair;

import java.util.Hashtable;

public class STCelestialData
{
	public String name;
	public int dimensionID;
	public int size;
	public PhysicsGovernor governor;

	public static Hashtable <ChunkCoordIntPair, STCelestialData> bodyList;

	public STCelestialData (String name, int dimensionID, int size, PhysicsGovernor governor)
	{
		this.name = name;
		this.dimensionID = dimensionID;
		this.size = size;
		this.governor = governor;
	}

	public static void init ()
	{
		bodyList = new Hashtable <ChunkCoordIntPair, STCelestialData> ();

		PhysicsGovernor sol = new StationaryGovernor (0, 0);
		PhysicsGovernor mercury = new OrbitGovernor (sol, 16, 1200);
		PhysicsGovernor venus = new OrbitGovernor (sol, 24, 1800);
		PhysicsGovernor earth = new OrbitGovernor (sol, 36, 2700);
		PhysicsGovernor moon = new OrbitGovernor (earth, 6, 1200);
		PhysicsGovernor mars = new OrbitGovernor (sol, 54, 4050);
	}

	public static STCelestialData getCelestialByName (String name)
	{
		return bodyList.get (name);
	}

	static int getDimension (String name)
	{
		return STDimension.dimensionTable.get (name).dimensionID;
	}

	public static abstract class PhysicsGovernor
	{
		public double posX, posZ;

		public abstract void updatePosition (Entity entity);
	}

	public static class StationaryGovernor extends PhysicsGovernor
	{
		public StationaryGovernor (double posX, double posZ)
		{
			this.posX = posX;
			this.posZ = posZ;
		}

		@Override
		public void updatePosition (Entity entity)
		{
			entity.setPosition (posX, 127, posZ);
		}
	}

	public static class OrbitGovernor extends PhysicsGovernor
	{
		PhysicsGovernor center;
		double radius, increment;
		double angle;

		public OrbitGovernor (PhysicsGovernor center, double radius, double period)
		{
			this.center = center;
			this.radius = Math.abs (radius);
			this.increment = 2 * Math.PI / period;
			posX = center.posX + radius;
			posZ = center.posZ;
			angle = 0;
		}

		@Override
		public void updatePosition (Entity entity)
		{
			angle += increment;
			posX = center.posX + Math.cos (angle) * radius;
			posZ = center.posZ + Math.sin (angle) * radius;

			entity.setPosition (posX, 127, posZ);
		}
	}
}
