package startrekmod;

import startrekmod.generation.dimension.mars.WorldProviderMars;
import startrekmod.generation.dimension.space.WorldProviderSpace;

import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

public class STDimension
{
    String name;
    int dimensionID;
    Class<? extends WorldProvider> provider;

    public static Hashtable<String, STDimension> dimensionTable;

    public STDimension (String name, Class<? extends WorldProvider> provider)
    {
        this.name = name;
        this.provider = provider;

        registerDimension ();

        dimensionTable.put (name, this);
    }

    public int getDimensionID ()
    {
        return dimensionID;
    }

    void registerDimension ()
    {
        dimensionID = DimensionManager.getNextFreeDimId ();
        DimensionManager.registerProviderType (dimensionID, provider, false);
        DimensionManager.registerDimension (dimensionID, dimensionID);
    }

    public static void init ()
    {
        dimensionTable = new Hashtable<String, STDimension> ();

        new STDimension ("Space", WorldProviderSpace.class);
        new STDimension ("Mars", WorldProviderMars.class);
    }
    
    public static Iterator<Entry<String, STDimension>> tableIterator ()
    {
        return dimensionTable.entrySet ().iterator ();
    }
}
