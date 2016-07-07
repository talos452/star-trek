package com.vulcanforge.startrekmod.entity;

import com.vulcanforge.startrekmod.StarTrekMod;
import com.vulcanforge.startrekmod.entity.phaserblast.EntityPhaserBlastDrill;
import com.vulcanforge.startrekmod.entity.phaserblast.EntityPhaserBlastKill;
import com.vulcanforge.startrekmod.entity.phaserblast.EntityPhaserBlastStun;

import cpw.mods.fml.common.registry.EntityRegistry;

public class Entities 
{
	static int counter = 0; //yes, this is some very screwy code :(
	
	public static void init()
	{
		EntityRegistry.registerModEntity(EntityPhaserBlastStun.class, "PhaserBlastStun", getNextID(), StarTrekMod.instance, 64, Integer.MAX_VALUE, true);
		EntityRegistry.registerModEntity(EntityPhaserBlastKill.class, "PhaserBlastKill", getNextID(), StarTrekMod.instance, 64, Integer.MAX_VALUE, true);
		EntityRegistry.registerModEntity(EntityPhaserBlastDrill.class, "PhaserBlastDrill", getNextID(), StarTrekMod.instance, 64, Integer.MAX_VALUE, true);
		EntityRegistry.registerModEntity(EntityPhaserDrill.class, "PhaserDrill", getNextID(), StarTrekMod.instance, 64, 20, false);
	}
	
	public static int getNextID()
	{
		return counter++;
	}
}
