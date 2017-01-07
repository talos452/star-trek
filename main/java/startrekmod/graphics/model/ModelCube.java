package startrekmod.graphics.model;

import net.minecraft.client.model.ModelRenderer;

public class ModelCube extends STModel
{
    public ModelCube ()
    {
        textureWidth = 256;
        textureHeight = 128;
        new ModelRenderer (this, 0, 0).addBox (-32, -32, -32, 64, 64, 64);
    }
}
