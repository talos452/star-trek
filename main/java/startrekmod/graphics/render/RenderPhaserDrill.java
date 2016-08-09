package startrekmod.graphics.render;

import startrekmod.graphics.model.ModelPhaserDrill;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderPhaserDrill extends Render
{
	static ModelPhaserDrill model = new ModelPhaserDrill();
	
	@Override
	public void doRender(Entity entity,
			double transX, double transY, double transZ,
			float p_76986_8_, float p_76986_9_)
	{
		GL11.glPushMatrix();
		bindTexture(getEntityTexture(entity));
		//render at proper above-ground position
		GL11.glTranslated(transX, transY + 3, transZ);
		GL11.glScaled(1, 1, 1);
		GL11.glRotated(entity.rotationYaw, 0, -1, 0);
		GL11.glRotated(180, 0, 0, 1); //fix upside down model
		model.render(.125F); //render at reasonable size
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return new ResourceLocation("startrekmod:textures/entity/phaser_cannon.png");
	}

}
