package com.vulcanforge.startrekmod.entity;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;

public class RenderPhaserBlast extends Render {

	static ModelPhaserBlast mpb = new ModelPhaserBlast();
	
	@Override
	public void doRender(Entity e, double d1,
			double d2, double d3, float f1,
			float f2) {
		GL11.glPushMatrix();
		bindTexture(getEntityTexture(e));
		GL11.glTranslated(d1, d2, d3);
		GL11.glScaled(1, 1, 1);
		EntityPhaserBlast epb = (EntityPhaserBlast)e;
		GL11.glRotated(epb.rotationYaw + 90, 0, 1, 0);
		mpb.render(.0625F);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		// TODO Auto-generated method stub
		return new ResourceLocation("startrekmod:textures/entity/phaserblast.png");
	}

}
