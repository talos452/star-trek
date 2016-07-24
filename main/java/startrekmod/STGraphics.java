package startrekmod;

import startrekmod.entity.EntityPhaserDrill;
import startrekmod.entity.npc.EntityKlingon;
import startrekmod.entity.phaserblast.*;
import startrekmod.graphics.render.*;

import cpw.mods.fml.client.registry.RenderingRegistry;

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