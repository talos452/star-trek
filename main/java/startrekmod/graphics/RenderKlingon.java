package com.vulcanforge.startrekmod.graphics;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderKlingon extends RenderBiped
{
	public RenderKlingon()
	{
		super(new ModelBiped(), 0.5F);
	}
	
	@Override
	public ResourceLocation getEntityTexture(EntityLiving entity)
	{
		return new ResourceLocation("startrekmod:textures/entity/klingon.png");
	}
}
