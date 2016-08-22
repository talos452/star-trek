package startrekmod.graphics.model;

import net.minecraft.client.model.*;

public class STModelRenderer extends ModelRenderer
{
	public STModelRenderer(ModelBase model, int offsetX, int offsetY)
	{
		super(model, offsetX, offsetY);
		mirror = true;
	}
}
