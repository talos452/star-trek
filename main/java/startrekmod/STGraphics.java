package startrekmod;

import startrekmod.entity.*;
import startrekmod.entity.energyblast.*;
import startrekmod.entity.npc.EntityKlingon;
import startrekmod.graphics.render.*;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class STGraphics
{
	public static void init()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityPhaserDrill.class, new RenderPhaserDrill());
		RenderingRegistry.registerEntityRenderingHandler(EntityPhaserBlastStun.class, new RenderEnergyBlast());
		RenderingRegistry.registerEntityRenderingHandler(EntityPhaserBlastKill.class, new RenderEnergyBlast());
		RenderingRegistry.registerEntityRenderingHandler(EntityDrillBlast.class, new RenderEnergyBlast());
		RenderingRegistry.registerEntityRenderingHandler(EntityDisruptorBlastKill.class, new RenderEnergyBlast());
		RenderingRegistry.registerEntityRenderingHandler(EntityCelestial.class, new RenderCelestial());

		initNPCs();
	}

	static void initNPCs()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityKlingon.class, new RenderKlingon());
	}
}