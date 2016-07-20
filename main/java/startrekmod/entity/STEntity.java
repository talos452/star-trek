package com.vulcanforge.startrekmod.entity;

import vulcanforge.startrekmod.STMod;

import com.vulcanforge.startrekmod.entity.phaserblast.*;
import com.vulcanforge.startrekmod.entity.npc.*;

import cpw.mods.fml.common.registry.EntityRegistry;

public class STEntity 
{
	static int counter = 0;
	
	public static void init()
	{
		EntityRegistry.registerModEntity(EntityPhaserBlastStun.class, "PhaserBlastStun",
				getNextID(), STMod.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityPhaserBlastKill.class, "PhaserBlastKill",
				getNextID(), STMod.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityPhaserBlastDrill.class, "PhaserBlastDrill",
				getNextID(), STMod.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityPhaserDrill.class, "PhaserDrill",
				getNextID(), STMod.instance, 64, 1, false);
		EntityRegistry.registerModEntity(EntityKlingon.class, "Klingon",
				getNextID(), STMod.instance, 64, 1, true);
	}
	
	//EntityRegistry.findGloballyUniqueEntityID() returns the same value on all calls
	//Forge now stores entities sorted by mod, so unique ID's for this mod
	//will not conflict with any other mod
	public static int getNextID()
	{
		return counter++;
	}
}
