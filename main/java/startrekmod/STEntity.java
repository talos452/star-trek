package startrekmod;

import startrekmod.entity.*;
import startrekmod.entity.energyblast.*;
import startrekmod.entity.npc.EntityKlingon;

import cpw.mods.fml.common.registry.EntityRegistry;

public class STEntity
{
	static int counter = 0;
	static STMod instance = STMod.INSTANCE;

	public static int getNextID ()
	{
		return counter++;
	}

	public static void init ()
	{
		initEntities ();
		initNPCs ();
	}

	public static void initEntities ()
	{
		EntityRegistry.registerModEntity (EntityPhaserDrill.class, "PhaserDrill",
			getNextID (), instance, 64, 3, false);
		EntityRegistry.registerModEntity (EntityPhaserBlastStun.class, "PhaserBlastStun",
			getNextID (), instance, 64, 3, true);
		EntityRegistry.registerModEntity (EntityPhaserBlastKill.class, "PhaserBlastKill",
			getNextID (), instance, 64, 3, true);
		EntityRegistry.registerModEntity (EntityDrillBlast.class, "PhaserBlastDrill",
			getNextID (), instance, 64, 3, true);
		EntityRegistry.registerModEntity (EntityDisruptorBlastKill.class, "DisruptorBlastKill",
			getNextID (), instance, 64, 3, true);
		EntityRegistry.registerModEntity (EntityCube.class, "Cube",
			getNextID (), instance, 64, 3, false);
		EntityRegistry.registerModEntity (EntityCelestial.class, "Celestial",
			getNextID (), instance, 256, 3, true);
	}

	public static void initNPCs ()
	{
		EntityRegistry.registerModEntity (EntityKlingon.class, "Klingon",
			getNextID (), STMod.INSTANCE, 64, 1, true);
	}
}
