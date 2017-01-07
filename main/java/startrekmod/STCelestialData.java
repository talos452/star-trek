package startrekmod;

import startrekmod.celestial.OrbitalGovernor;
import startrekmod.celestial.StationaryGovernor;
import startrekmod.celestial.PhysicsGovernor;
import startrekmod.entity.EntityCelestial;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;

import java.util.Hashtable;

public class STCelestialData
{
    public String name;
    public int dimensionID;
    public int size;
    public PhysicsGovernor governor;

    public static Hashtable<String, STCelestialData> bodyList;

    public STCelestialData (String name, int size, PhysicsGovernor governor)
    {
        this.name = name;
        this.size = size;
        this.governor = governor;
        this.dimensionID = getDimension (name);

        bodyList.put (name, this);
    }

    public static void init ()
    {
        bodyList = new Hashtable<String, STCelestialData> ();

        PhysicsGovernor sol = new StationaryGovernor (0, 0, 8);
        PhysicsGovernor mercury = new OrbitalGovernor (16, .01F, sol);
        PhysicsGovernor venus = new OrbitalGovernor (24, .02F, sol);
        PhysicsGovernor earth = new OrbitalGovernor (36, .04F, sol);
        PhysicsGovernor moon = new OrbitalGovernor (6, .01F, sol);
        PhysicsGovernor mars = new OrbitalGovernor (54, .06F, sol);

        new STCelestialData ("sol", 8, sol);
        new STCelestialData ("mercury", 1, mercury);
        new STCelestialData ("venus", 2, venus);
        new STCelestialData ("earth", 2, earth);
        new STCelestialData ("moon", 1, moon);
        new STCelestialData ("mars", 2, mars);
    }

    public static STCelestialData getCelestialByName (String name)
    {
        return bodyList.get (name);
    }

    static int getDimension (String name)
    {
        if (name.equals ("earth"))
            return 0;

        STDimension dimension = STDimension.dimensionTable.get (name);

        if (dimension == null)
            return -1;
        else return dimension.dimensionID;
    }
}
