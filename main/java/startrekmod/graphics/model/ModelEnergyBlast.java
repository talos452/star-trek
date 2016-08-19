package startrekmod.graphics.model;

import net.minecraft.client.model.ModelRenderer;

public class ModelEnergyBlast extends STModel
{
	public ModelEnergyBlast()
	{
		ModelRenderer beam = new ModelRenderer(this, 0, 0);

		addRenderers(beam);

		beam.addBox(-16F, -1F, -1F, 32, 2, 2);
		beam.setRotationPoint(0F, 0F, 0F);
		beam.setTextureSize(64, 32);
		beam.mirror = true;
		setRotation(beam, 0F, 0F, 0F);
	}
}
