package startrekmod.graphics.render;

import startrekmod.entity.energyblast.EntityEnergyBlast;
import startrekmod.graphics.model.ModelEnergyBlast;

import net.minecraft.entity.Entity;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

public class RenderEnergyBlast extends STRender
{
	public RenderEnergyBlast()
	{
		super("phaser_blast");
		model = new ModelEnergyBlast();
	}

	@Override
	public void doRender(Entity entity, double transX, double transY, double transZ, float f1, float f2)
	{
		GL11.glPushMatrix();
		bindTexture(getEntityTexture(entity));
		Color beamColour = ((EntityEnergyBlast)entity).getBeamColour();
		GL11.glColor3f(beamColour.getRed() / 255F, beamColour.getGreen() / 255F, beamColour.getBlue() / 255F);
		GL11.glTranslated(transX, transY, transZ);
		GL11.glScaled(1, 1, 1);
		GL11.glRotated(entity.rotationYaw + 90, 0, -1, 0);
		GL11.glRotated(entity.rotationPitch, 0, 0, -1);
		model.render(.0625F);
		GL11.glPopMatrix();
	}
}
