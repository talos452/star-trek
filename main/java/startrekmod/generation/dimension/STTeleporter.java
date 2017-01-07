package startrekmod.generation.dimension;

import startrekmod.STDimension;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.world.*;

public class STTeleporter extends Teleporter
{
    int dimensionID;

    public STTeleporter (WorldServer world)
    {
        super (world);
        dimensionID = world.provider.dimensionId;
    }

    @Override
    public void placeInPortal (Entity entity, double x, double y, double z, float yaw)
    {
        MinecraftServer mc = MinecraftServer.getServer ();
        ServerConfigurationManager manager = mc.getConfigurationManager ();
        World world = mc.worldServerForDimension (dimensionID);

        if (dimensionID == STDimension.dimensionTable.get ("Space").getDimensionID ())
        {
            entity.setPosition (0, 160, 0);
        }
        else
        {
            int topYCoordinate = topBlock (0, 0, world);
            entity.setPosition (0, topYCoordinate + 2, 0);
        }
    }

    int topBlock (int x, int z, World world)
    {
        for (int i = 1; i < 256; i++)
            if (world.getBlock (x, i, z) == Blocks.air)
                return i;

        return 256;
    }
}
