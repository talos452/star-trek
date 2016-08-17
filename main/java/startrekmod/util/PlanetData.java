package startrekmod.util;

import java.util.*;

public class PlanetData
{
	public String name;
	public int xCoord;
	public int zCoord;
	public int dimensionID;
	
	public PlanetData(String name, int xCoord, int zCoord, int dimensionID)
	{
		this.name = name;
		this.xCoord = xCoord;
		this.zCoord = zCoord;
		this.dimensionID = dimensionID;
		
		planets.add(this);
	}
	
	public static PlanetData earth = new PlanetData("Earth", 0, 0, 0);
	public static PlanetData mars = new PlanetData("Mars", 0, 50, 3);
	
	public static List<PlanetData> planets = new ArrayList<PlanetData>();
}
