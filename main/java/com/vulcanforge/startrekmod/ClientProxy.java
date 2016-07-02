package com.vulcanforge.startrekmod;

import com.vulcanforge.startrekmod.entity.EntityPhaserBlast;
import com.vulcanforge.startrekmod.entity.RenderPhaserBlast;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void init()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityPhaserBlast.class, new RenderPhaserBlast());
	}
}
