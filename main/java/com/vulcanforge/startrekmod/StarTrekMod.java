package com.vulcanforge.startrekmod;

import com.vulcanforge.startrekmod.blocks.*;
import com.vulcanforge.startrekmod.entity.Entities;
import com.vulcanforge.startrekmod.generation.OreSpawnWorldGen;
import com.vulcanforge.startrekmod.items.*;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = StarTrekMod.MODID, version = StarTrekMod.VERSION, name = StarTrekMod.NAME)
public class StarTrekMod
{
    public static final String MODID = "startrekmod";
    public static final String VERSION = "1.4.1";
    public static final String NAME = "Star Trek Mod";
    
    @SidedProxy(clientSide = "com.vulcanforge.startrekmod.ClientProxy",
    	serverSide = "com.vulcanforge.startrekmod.ServerProxy")
    public static CommonProxy proxy;
    
    @Instance
    public static StarTrekMod instance;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		STBlock.init();
		STItem.init();
		CraftingRecipes.init();
		Entities.init();
		proxy.init();
		GameRegistry.registerWorldGenerator(new OreSpawnWorldGen(), 0);
		MinecraftForge.EVENT_BUS.register(new STEventHandler());
    }
}
