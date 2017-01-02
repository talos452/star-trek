package startrekmod.graphics.model;

import net.minecraft.client.model.ModelRenderer;

public class ModelPhaserDrill extends STModel
{
    public ModelPhaserDrill ()
    {
        textureWidth = 128;
        textureHeight = 256;

        ModelRenderer Cannon4 = new ModelRenderer (this, 103, 15);
        Cannon4.addBox (-1F, -13.5F, 21F, 2, 2, 5);
        Cannon4.setRotationPoint (0F, 16F, 0F);

        ModelRenderer Cannon3 = new ModelRenderer (this, 79, 15);
        Cannon3.addBox (-2F, -14.5F, 11F, 4, 4, 6);
        Cannon3.setRotationPoint (0F, 16F, 0F);

        ModelRenderer Cannon2 = new ModelRenderer (this, 57, 15);
        Cannon2.addBox (-2.5F, -15F, 7F, 5, 5, 4);
        Cannon2.setRotationPoint (0F, 16F, 0F);

        ModelRenderer Cannon1 = new ModelRenderer (this, 57, 15);
        Cannon1.addBox (-2.5F, -15F, 17F, 5, 5, 4);
        Cannon1.setRotationPoint (0F, 16F, 0F);

        ModelRenderer Arm6 = new ModelRenderer (this, 25, 18);
        Arm6.addBox (-1F, -20F, 6.4F, 2, 4, 1);
        Arm6.setRotationPoint (0F, 16F, 0F);
        setRotation (Arm6, -0.7063936F, 0F, 0F);

        ModelRenderer Arm5 = new ModelRenderer (this, 25, 17);
        Arm5.addBox (-1F, -2F, 14F, 2, 4, 1);
        Arm5.setRotationPoint (0F, 16F, 0F);
        setRotation (Arm5, 0.7063936F, 0F, 0F);

        ModelRenderer Arm4 = new ModelRenderer (this, 22, 17);
        Arm4.addBox (-1.5F, -8F, 12F, 3, 4, 4);
        Arm4.setRotationPoint (0F, 16F, 0F);

        ModelRenderer Arm3 = new ModelRenderer (this, 23, 5);
        Arm3.addBox (-2F, -5F, 13F, 4, 4, 2);
        Arm3.setRotationPoint (0F, 16F, 0F);

        ModelRenderer Arm2 = new ModelRenderer (this, 23, 16);
        Arm2.addBox (-2F, 0F, 3F, 4, 3, 3);
        Arm2.setRotationPoint (0F, 16F, 0F);

        ModelRenderer Arm1 = new ModelRenderer (this, 17, 14);
        Arm1.addBox (-2F, 1F, 5F, 4, 2, 9);
        Arm1.setRotationPoint (0F, 16F, 0F);
        setRotation (Arm1, 0.2602503F, 0F, 0F);

        ModelRenderer Target5 = new ModelRenderer (this, 31, 32);
        Target5.addBox (-2.5F, -9.5F, -1F, 1, 3, 0);
        Target5.setRotationPoint (0F, 16F, 0F);

        ModelRenderer Target4 = new ModelRenderer (this, 28, 33);
        Target4.addBox (-1.5F, -10.5F, -1F, 3, 1, 0);
        Target4.setRotationPoint (0F, 16F, 0F);

        ModelRenderer Target3 = new ModelRenderer (this, 32, 30);
        Target3.addBox (1.5F, -9.5F, -1F, 1, 3, 0);
        Target3.setRotationPoint (0F, 16F, 0F);

        ModelRenderer Target2 = new ModelRenderer (this, 26, 32);
        Target2.addBox (-1.5F, -6F, -1F, 3, 1, 0);
        Target2.setRotationPoint (0F, 16F, 0F);

        ModelRenderer Target1 = new ModelRenderer (this, 26, 32);
        Target1.addBox (-2F, -10F, -1F, 4, 4, 0);
        Target1.setRotationPoint (0F, 16F, 0F);

        ModelRenderer Top = new ModelRenderer (this, 12, 40);
        Top.addBox (-7F, -5F, -3F, 14, 1, 8);
        Top.setRotationPoint (0F, 16F, 0F);

        ModelRenderer PanelSide2 = new ModelRenderer (this, 26, 65);
        PanelSide2.addBox (-4F, -3F, -6F, 0, 8, 3);
        PanelSide2.setRotationPoint (0F, 16F, 0F);

        ModelRenderer PanelSide1 = new ModelRenderer (this, 26, 65);
        PanelSide1.addBox (4F, -3F, -6F, 0, 8, 3);
        PanelSide1.setRotationPoint (0F, 16F, 0F);

        ModelRenderer Control = new ModelRenderer (this, 24, 53);
        Control.addBox (-4F, -0.5F, -4F, 8, 5, 1);
        Control.setRotationPoint (0F, 16F, 0F);
        setRotation (Control, -0.669215F, 0F, 0F);

        ModelRenderer Base5 = new ModelRenderer (this, 27, 64);
        Base5.addBox (6F, -4F, 3F, 1, 9, 5);
        Base5.setRotationPoint (0F, 16F, 0F);

        ModelRenderer Base4 = new ModelRenderer (this, 27, 64);
        Base4.addBox (-7F, -4F, 3F, 1, 9, 5);
        Base4.setRotationPoint (0F, 16F, 0F);

        ModelRenderer Base3 = new ModelRenderer (this, 69, 65);
        Base3.addBox (-7F, -4F, -3F, 14, 9, 6);
        Base3.setRotationPoint (0F, 16F, 0F);

        ModelRenderer Base2 = new ModelRenderer (this, 24, 64);
        Base2.addBox (-4F, 1F, -6F, 8, 4, 1);
        Base2.setRotationPoint (0F, 16F, 0F);

        ModelRenderer Base = new ModelRenderer (this, 0, 62);
        Base.addBox (-8F, 5F, -8F, 16, 3, 16);
        Base.setRotationPoint (0F, 16F, 0F);
    }
}