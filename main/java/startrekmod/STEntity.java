package startrekmod;

import startrekmod.entity.EntityPhaserDrill;
import startrekmod.entity.npc.EntityKlingon;
import startrekmod.entity.phaserblast.*;

import cpw.mods.fml.common.registry.EntityRegistry;

public class STEntity 
{
	static int counter = 0;
	static STMod instance = STMod.INSTANCE;
	
	public static void init()
	{
		initEntities();
		initNPCs();
	}
	
	public static void initEntities()
	{
		EntityRegistry.registerModEntity(EntityPhaserDrill.class, "PhaserDrill",
			getNextID(), instance, 64, 3, false);
		EntityRegistry.registerModEntity(EntityPhaserBlastStun.class, "PhaserBlastStun",
			getNextID(), instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityPhaserBlastKill.class, "PhaserBlastKill",
			getNextID(), instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityPhaserBlastDrill.class, "PhaserBlastDrill",
			getNextID(), instance, 64, 3, true);		
	}
	
	public static void initNPCs()
	{
		EntityRegistry.registerModEntity(EntityKlingon.class, "Klingon",
			getNextID(), STMod.INSTANCE, 64, 1, true);
	}
	
	/*
	 * Returns a unique ID to register an entity.
	 */
	public static int getNextID()
	{
		return counter++;
	}
}
