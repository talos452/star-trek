package startrekmod;

import startrekmod.generation.*;

import cpw.mods.fml.common.registry.GameRegistry;

public class STGeneration
{
    public static void init ()
    {
        GameRegistry.registerWorldGenerator (new GenerateDuranium (), 0);
        GameRegistry.registerWorldGenerator (new GenerateDilithium (), 1);
        GameRegistry.registerWorldGenerator (new GenerateLatinum (), 2);
    }
}
