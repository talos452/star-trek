package startrekmod.graphics.render;

import startrekmod.entity.energyblast.EntityEnergyBlast;
import startrekmod.graphics.model.ModelEnergyBlast;

import net.minecraft.entity.Entity;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

public class RenderEnergyBlast extends STRender
{
	public RenderEnergyBlast ()
	{
		super ("phaser_blast");
		model = new ModelEnergyBlast ();
	}

	@Override
	void render (Entity entity, double translationX, double translationY, double translationZ, float yaw, float pitch)
	{
		Color beamColour = ((EntityEnergyBlast) entity).getBeamColour ();
		GL11.glColor3f (beamColour.getRed () / 255F, beamColour.getGreen () / 255F, beamColour.getBlue () / 255F);
		model.render (.0625F);
	}
}
