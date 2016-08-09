package startrekmod;

import startrekmod.entity.EntityPhaserDrill;
import startrekmod.entity.energyblast.*;
import startrekmod.entity.npc.EntityKlingon;
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
		RenderingRegistry.registerEntityRenderingHandler(EntityDrillBlast.class,
			new RenderPhaserBlast());
		RenderingRegistry.registerEntityRenderingHandler(EntityDisruptorBlastKill.class,
			new RenderPhaserBlast());
		
		initNPCs();
	}
	
	/*
	 * Just in case I want to do something special with NPCs later,
	 * I put this here to make it more convenient/readable.
	 */
	public static void initNPCs()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityKlingon.class,
			new RenderKlingon());
	}
}