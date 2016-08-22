package startrekmod.graphics.model;

import net.minecraft.client.model.ModelRenderer;

public class ModelEnergyBlast extends STModel
{
	public ModelEnergyBlast()
	{
		ModelRenderer beam = new STModelRenderer(this, 0, 0);
		textureWidth = 64;
		textureHeight = 32;

		beam.addBox(-16F, -1F, -1F, 32, 2, 2);
		beam.setRotationPoint(0F, 0F, 0F);
		beam.mirror = true;
		setRotation(beam, 0F, 0F, 0F);
	}
}
