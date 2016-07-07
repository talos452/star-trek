package com.vulcanforge.startrekmod.graphics;

import org.lwjgl.opengl.GL11;

import com.vulcanforge.startrekmod.entity.phaserblast.EntityPhaserBlast;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderPhaserBlast extends Render 
{
	static ModelPhaserBlast mpb = new ModelPhaserBlast();
	
	@Override
	public void doRender(Entity entity,
			double transX, double transY, double transZ,
			float f1, float f2)
	{
		GL11.glPushMatrix();
		bindTexture(getEntityTexture(entity));
		GL11.glTranslated(transX, transY, transZ);
		GL11.glScaled(1, 1, 1);
		GL11.glRotated(entity.rotationYaw + 90, 0, 1, 0);
		GL11.glRotated(entity.rotationPitch, 0, 0, -1);
		mpb.render(.0625F);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return new ResourceLocation("startrekmod:textures/entity/phaser_blast.png");
	}

}
