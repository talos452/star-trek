package com.vulcanforge.startrekmod.entity;

import com.vulcanforge.startrekmod.StarTrekMod;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Entities 
{
	public static void init()
	{
		EntityRegistry.registerModEntity(EntityPhaserBlastStun.class, "PhaserBlastStun", EntityRegistry.findGlobalUniqueEntityId(), StarTrekMod.instance, 64, Integer.MAX_VALUE, true);
		EntityRegistry.registerModEntity(EntityPhaserBlastKill.class, "PhaserBlastKill", EntityRegistry.findGlobalUniqueEntityId(), StarTrekMod.instance, 64, Integer.MAX_VALUE, true);
		EntityRegistry.registerModEntity(EntityPhaserBlastDrill.class, "PhaserBlastDrill", EntityRegistry.findGlobalUniqueEntityId(), StarTrekMod.instance, 64, Integer.MAX_VALUE, true);
	}
}
