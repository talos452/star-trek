package com.vulcanforge.startrekmod.entity;

import com.vulcanforge.startrekmod.StarTrekMod;
import com.vulcanforge.startrekmod.entity.phaserblast.EntityPhaserBlastDrill;
import com.vulcanforge.startrekmod.entity.phaserblast.EntityPhaserBlastKill;
import com.vulcanforge.startrekmod.entity.phaserblast.EntityPhaserBlastStun;

import cpw.mods.fml.common.registry.EntityRegistry;

public class Entities 
{
	public static void init()
	{
		EntityRegistry.registerModEntity(EntityPhaserBlastStun.class, "PhaserBlastStun", EntityRegistry.findGlobalUniqueEntityId(), StarTrekMod.instance, 64, Integer.MAX_VALUE, true);
		EntityRegistry.registerModEntity(EntityPhaserBlastKill.class, "PhaserBlastKill", EntityRegistry.findGlobalUniqueEntityId(), StarTrekMod.instance, 64, Integer.MAX_VALUE, true);
		EntityRegistry.registerModEntity(EntityPhaserBlastDrill.class, "PhaserBlastDrill", EntityRegistry.findGlobalUniqueEntityId(), StarTrekMod.instance, 64, Integer.MAX_VALUE, true);
	}
}
