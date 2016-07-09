package com.vulcanforge.startrekmod.graphics;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderPhaserDrill extends Render
{
	static ModelPhaserCannon mpc = new ModelPhaserCannon();
	
	@Override
	public void doRender(Entity entity,
			double transX, double transY, double transZ,
			float p_76986_8_, float p_76986_9_)
	{
		GL11.glPushMatrix();
		bindTexture(getEntityTexture(entity));
		GL11.glTranslated(transX, transY + 3, transZ);
		GL11.glScaled(1, 1, 1);
		GL11.glRotated(entity.rotationYaw, 0, -1, 0);
		GL11.glRotated(180, 0, 0, 1); //fix upside down model
		mpc.render(.125F); //render at reasonable size
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return new ResourceLocation("startrekmod:textures/entity/phaser_cannon.png");
	}

}
