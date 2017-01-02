package startrekmod;

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
    public EntityCelestial associated;

    public static Hashtable<String, STCelestialData> bodyList;

    public STCelestialData (String name, int size, PhysicsGovernor governor)
    {
        this.name = name;
        this.size = size;
        this.governor = governor;
        this.dimensionID = getDimension (name);

        bodyList.put (name, this);
    }

    public void writeToNBT (NBTTagCompound data)
    {
        if (governor instanceof OrbitGovernor)
            data.setDouble ("Angle", ((OrbitGovernor) governor).angle);
    }

    public void readFromNBT (NBTTagCompound data)
    {
        if (governor instanceof OrbitGovernor)
            ((OrbitGovernor) governor).angle = data.getDouble ("Angle");
    }

    public static void init ()
    {
        bodyList = new Hashtable<String, STCelestialData> ();

        PhysicsGovernor sol = new StationaryGovernor (0, 0, 8);
        PhysicsGovernor mercury = new OrbitGovernor (sol, 16, 1200, 1);
        PhysicsGovernor venus = new OrbitGovernor (sol, 24, 1800, 2);
        PhysicsGovernor earth = new OrbitGovernor (sol, 36, 2700, 2);
        PhysicsGovernor moon = new OrbitGovernor (earth, 6, 1200, 1);
        PhysicsGovernor mars = new OrbitGovernor (sol, 54, 4050, 2);

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

    public static abstract class PhysicsGovernor
    {
        public double posX, posZ;
        public int size;

        public abstract void updatePosition (Entity entity);
    }

    public static class StationaryGovernor extends PhysicsGovernor
    {
        public StationaryGovernor (double posX, double posZ, int size)
        {
            this.posX = posX;
            this.posZ = posZ;
            this.size = size;
        }

        @Override
        public void updatePosition (Entity entity)
        {
            entity.setPosition (posX, 127 - size / 2.0, posZ);
        }
    }

    public static class OrbitGovernor extends PhysicsGovernor
    {
        PhysicsGovernor center;
        double radius, increment;
        double angle;

        public OrbitGovernor (PhysicsGovernor center, double radius, double period, int size)
        {
            this.center = center;
            this.radius = Math.abs (radius);
            this.increment = 2 * Math.PI / period;
            this.size = size;
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

            entity.setPosition (posX, 127 - size / 2.0, posZ);
        }
    }
}
