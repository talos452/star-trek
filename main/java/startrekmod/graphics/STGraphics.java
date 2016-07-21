package startrekmod.graphics;

import net.minecraft.entity.Entity;
import cpw.mods.fml.client.registry.*;

import startrekmod.entity.*;
import startrekmod.entity.npc.*;
import startrekmod.entity.phaserblast.*;

public class STGraphics
{
	public static void init()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityPhaserDrill.class,
			new RenderPhaserDrill());
		RenderingRegistry.registerEntityRenderingHandler(EntityPhaserBlastStun.class,
			new RenderPhaserBlast());
		RenderingRegistry.registerEntityRenderingHandler(EntityPhaserBlastKill.class,
			new RenderPhaserBlast());
		RenderingRegistry.registerEntityRenderingHandler(EntityPhaserBlastDrill.class,
			new RenderPhaserBlast());
		
		initNPCs();
	}
	
	public static void initNPCs()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityKlingon.class,
			new RenderKlingon());
	}
}