package com.vulcanforge.startrekmod;

import com.vulcanforge.startrekmod.entity.*;
import com.vulcanforge.startrekmod.entity.RenderPhaserBlast;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void init()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityPhaserBlastStun.class, new RenderPhaserBlast());
		RenderingRegistry.registerEntityRenderingHandler(EntityPhaserBlastKill.class, new RenderPhaserBlast());
		RenderingRegistry.registerEntityRenderingHandler(EntityPhaserBlastDrill.class, new RenderPhaserBlast());
	}
}
