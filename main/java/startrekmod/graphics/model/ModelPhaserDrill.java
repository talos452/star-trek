package startrekmod.graphics.model;

import net.minecraft.client.model.ModelRenderer;

public class ModelPhaserDrill extends STModel
{
	public ModelPhaserDrill()
	{
		ModelRenderer arm1 = new ModelRenderer(this, 17, 14);
		ModelRenderer arm2 = new ModelRenderer(this, 23, 16);
		ModelRenderer arm3 = new ModelRenderer(this, 23, 5);
		ModelRenderer arm4 = new ModelRenderer(this, 22, 17);
		ModelRenderer arm5 = new ModelRenderer(this, 25, 17);
		ModelRenderer arm6 = new ModelRenderer(this, 25, 18);
		ModelRenderer base = new ModelRenderer(this, 0, 62);
		ModelRenderer base2 = new ModelRenderer(this, 24, 64);
		ModelRenderer base3 = new ModelRenderer(this, 69, 65);
		ModelRenderer base4 = new ModelRenderer(this, 27, 64);
		ModelRenderer base5 = new ModelRenderer(this, 27, 64);
		ModelRenderer cannon1 = new ModelRenderer(this, 57, 15);
		ModelRenderer cannon2 = new ModelRenderer(this, 57, 15);
		ModelRenderer cannon3 = new ModelRenderer(this, 79, 15);
		ModelRenderer cannon4 = new ModelRenderer(this, 103, 15);
		ModelRenderer control = new ModelRenderer(this, 24, 53);
		ModelRenderer panelSide1 = new ModelRenderer(this, 26, 65);
		ModelRenderer panelSide2 = new ModelRenderer(this, 26, 65);
		ModelRenderer target1 = new ModelRenderer(this, 26, 32);
		ModelRenderer target2 = new ModelRenderer(this, 26, 32);
		ModelRenderer target3 = new ModelRenderer(this, 32, 30);
		ModelRenderer target4 = new ModelRenderer(this, 28, 33);
		ModelRenderer target5 = new ModelRenderer(this, 31, 32);
		ModelRenderer top = new ModelRenderer(this, 12, 40);

		addRenderers(arm1, arm2, arm3, arm4, arm5, arm6, base, base2, base3, base4, base5, cannon1, cannon2, cannon3, cannon4, control, panelSide1, panelSide2, target1, target2, target3, target4, target5, top);
		textureWidth = 128;
		textureHeight = 256;

		cannon4.addBox(-1F, -13.5F, 21F, 2, 2, 5);
		cannon4.setRotationPoint(0F, 16F, 0F);
		cannon4.mirror = true;
		setRotation(cannon4, 0F, 0F, 0F);

		cannon3.addBox(-2F, -14.5F, 11F, 4, 4, 6);
		cannon3.setRotationPoint(0F, 16F, 0F);
		cannon3.mirror = true;
		setRotation(cannon3, 0F, 0F, 0F);

		cannon2.addBox(-2.5F, -15F, 7F, 5, 5, 4);
		cannon2.setRotationPoint(0F, 16F, 0F);
		cannon2.mirror = true;
		setRotation(cannon2, 0F, 0F, 0F);

		cannon1.addBox(-2.5F, -15F, 17F, 5, 5, 4);
		cannon1.setRotationPoint(0F, 16F, 0F);
		cannon1.mirror = true;
		setRotation(cannon1, 0F, 0F, 0F);

		arm6.addBox(-1F, -20F, 6.4F, 2, 4, 1);
		arm6.setRotationPoint(0F, 16F, 0F);
		arm6.mirror = true;
		setRotation(arm6, -0.7063936F, 0F, 0F);

		arm5.addBox(-1F, -2F, 14F, 2, 4, 1);
		arm5.setRotationPoint(0F, 16F, 0F);
		arm5.mirror = true;
		setRotation(arm5, 0.7063936F, 0F, 0F);

		arm4.addBox(-1.5F, -8F, 12F, 3, 4, 4);
		arm4.setRotationPoint(0F, 16F, 0F);
		arm5.mirror = true;
		setRotation(arm4, 0F, 0F, 0F);

		arm3.addBox(-2F, -5F, 13F, 4, 4, 2);
		arm3.setRotationPoint(0F, 16F, 0F);
		arm3.mirror = true;
		setRotation(arm3, 0F, 0F, 0F);

		arm2.addBox(-2F, 0F, 3F, 4, 3, 3);
		arm2.setRotationPoint(0F, 16F, 0F);
		arm2.mirror = true;
		setRotation(arm2, 0F, 0F, 0F);

		arm1.addBox(-2F, 1F, 5F, 4, 2, 9);
		arm1.setRotationPoint(0F, 16F, 0F);
		arm1.mirror = true;
		setRotation(arm1, 0.2602503F, 0F, 0F);

		target5.addBox(-2.5F, -9.5F, -1F, 1, 3, 0);
		target5.setRotationPoint(0F, 16F, 0F);
		target5.mirror = true;
		setRotation(target5, 0F, 0F, 0F);

		target4.addBox(-1.5F, -10.5F, -1F, 3, 1, 0);
		target4.setRotationPoint(0F, 16F, 0F);
		target4.mirror = true;
		setRotation(target4, 0F, 0F, 0F);

		target3.addBox(1.5F, -9.5F, -1F, 1, 3, 0);
		target3.setRotationPoint(0F, 16F, 0F);
		target3.mirror = true;
		setRotation(target3, 0F, 0F, 0F);

		target2.addBox(-1.5F, -6F, -1F, 3, 1, 0);
		target2.setRotationPoint(0F, 16F, 0F);
		target2.mirror = true;
		setRotation(target2, 0F, 0F, 0F);

		target1.addBox(-2F, -10F, -1F, 4, 4, 0);
		target1.setRotationPoint(0F, 16F, 0F);
		target1.mirror = true;
		setRotation(target1, 0F, 0F, 0F);

		top.addBox(-7F, -5F, -3F, 14, 1, 8);
		top.setRotationPoint(0F, 16F, 0F);
		top.mirror = true;
		setRotation(top, 0F, 0F, 0F);

		panelSide2.addBox(-4F, -3F, -6F, 0, 8, 3);
		panelSide2.setRotationPoint(0F, 16F, 0F);
		panelSide2.mirror = true;
		setRotation(panelSide2, 0F, 0F, 0F);

		panelSide1.addBox(4F, -3F, -6F, 0, 8, 3);
		panelSide1.setRotationPoint(0F, 16F, 0F);
		panelSide1.mirror = true;
		setRotation(panelSide1, 0F, 0F, 0F);

		control.addBox(-4F, -0.5F, -4F, 8, 5, 1);
		control.setRotationPoint(0F, 16F, 0F);
		control.mirror = true;
		setRotation(control, -0.669215F, 0F, 0F);

		base5.addBox(6F, -4F, 3F, 1, 9, 5);
		base5.setRotationPoint(0F, 16F, 0F);
		base5.mirror = true;
		setRotation(base5, 0F, 0F, 0F);

		base4.addBox(-7F, -4F, 3F, 1, 9, 5);
		base4.setRotationPoint(0F, 16F, 0F);
		base4.mirror = true;
		setRotation(base4, 0F, 0F, 0F);

		base3.addBox(-7F, -4F, -3F, 14, 9, 6);
		base3.setRotationPoint(0F, 16F, 0F);
		base3.mirror = true;
		setRotation(base3, 0F, 0F, 0F);

		base2.addBox(-4F, 1F, -6F, 8, 4, 1);
		base2.setRotationPoint(0F, 16F, 0F);
		base2.mirror = true;
		setRotation(base2, 0F, 0F, 0F);

		base.addBox(-8F, 5F, -8F, 16, 3, 16);
		base.setRotationPoint(0F, 16F, 0F);
		base.mirror = true;
		setRotation(base, 0F, 0F, 0F);
	}
}
