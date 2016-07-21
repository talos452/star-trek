package startrekmod.graphics;

import org.lwjgl.opengl.GL11;
import startrekmod.entity.phaserblast.EntityPhaserBlast;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderPhaserBlast extends Render 
{
	static ModelPhaserBlast model = new ModelPhaserBlast();
	
	@Override
	public void doRender(Entity entity,
			double transX, double transY, double transZ,
			float f1, float f2)
	{
		GL11.glPushMatrix();
		bindTexture(getEntityTexture(entity));
		GL11.glTranslated(transX, transY, transZ);
		GL11.glScaled(1, 1, 1);
		//rotates around vector specified by 3 values
		GL11.glRotated(entity.rotationYaw + 90, 0, 1, 0);
		//first call to glRotated rotates complete coordinate set
		//no need for trigonometric re-calculation of axes
		GL11.glRotated(entity.rotationPitch, 0, 0, -1);
		//texture assigns one pixel per block side
		//.0625 is 1/16. The argument is the scaling factor
		model.render(.0625F);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return new ResourceLocation("startrekmod:textures/entity/phaser_blast.png");
	}

}
