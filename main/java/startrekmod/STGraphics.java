package startrekmod;

import startrekmod.entity.EntityPhaserDrill;
import startrekmod.entity.energyblast.*;
import startrekmod.entity.npc.EntityKlingon;
import startrekmod.graphics.render.*;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class STGraphics
{
	/**
	 * Registers rendering handlers for mod entities.
	 */
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
	
	/**
	 * Register rendering handlers for mod NPCs.
	 */
	static void initNPCs()
	{
		//this method is separate in case I need to register NPCs differently at some point.
		RenderingRegistry.registerEntityRenderingHandler(EntityKlingon.class,
			new RenderKlingon());
	}
}