package com.vulcanforge.startrekmod.graphics;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPhaserCannon extends ModelBase
{	
	ModelRenderer Cannon4;
	ModelRenderer Cannon3;
	ModelRenderer Cannon2;
	ModelRenderer Cannon1;
	ModelRenderer Arm6;
	ModelRenderer Arm5;
	ModelRenderer Arm4;
	ModelRenderer Arm3;
	ModelRenderer Arm2;
	ModelRenderer Arm1;
	ModelRenderer Target5;
	ModelRenderer Target4;
	ModelRenderer Target3;
	ModelRenderer Target2;
	ModelRenderer Target1;
	ModelRenderer Top;
	ModelRenderer PanelSide2;
	ModelRenderer PanelSide1;
	ModelRenderer Control;
	ModelRenderer Base5;
	ModelRenderer Base4;
	ModelRenderer Base3;
	ModelRenderer Base2;
	ModelRenderer Base;
	
	public ModelPhaserCannon()
	{
		textureWidth = 128;
		textureHeight = 256;
	
		Cannon4 = new ModelRenderer(this, 103, 15);
		Cannon4.addBox(-1F, -13.5F, 21F, 2, 2, 5);
		Cannon4.setRotationPoint(0F, 16F, 0F);
		Cannon4.setTextureSize(128, 256);
		Cannon4.mirror = true;
		setRotation(Cannon4, 0F, 0F, 0F);
		Cannon3 = new ModelRenderer(this, 79, 15);
		Cannon3.addBox(-2F, -14.5F, 11F, 4, 4, 6);
		Cannon3.setRotationPoint(0F, 16F, 0F);
		Cannon3.setTextureSize(128, 256);
		Cannon3.mirror = true;
		setRotation(Cannon3, 0F, 0F, 0F);
		Cannon2 = new ModelRenderer(this, 57, 15);
		Cannon2.addBox(-2.5F, -15F, 7F, 5, 5, 4);
		Cannon2.setRotationPoint(0F, 16F, 0F);
		Cannon2.setTextureSize(128, 256);
		Cannon2.mirror = true;
		setRotation(Cannon2, 0F, 0F, 0F);
		Cannon1 = new ModelRenderer(this, 57, 15);
		Cannon1.addBox(-2.5F, -15F, 17F, 5, 5, 4);
		Cannon1.setRotationPoint(0F, 16F, 0F);
		Cannon1.setTextureSize(128, 256);
		Cannon1.mirror = true;
		setRotation(Cannon1, 0F, 0F, 0F);
		Arm6 = new ModelRenderer(this, 25, 18);
		Arm6.addBox(-1F, -20F, 6.4F, 2, 4, 1);
		Arm6.setRotationPoint(0F, 16F, 0F);
		Arm6.setTextureSize(128, 256);
		Arm6.mirror = true;
		setRotation(Arm6, -0.7063936F, 0F, 0F);
		Arm5 = new ModelRenderer(this, 25, 17);
		Arm5.addBox(-1F, -2F, 14F, 2, 4, 1);
		Arm5.setRotationPoint(0F, 16F, 0F);
		Arm5.setTextureSize(128, 256);
		Arm5.mirror = true;
		setRotation(Arm5, 0.7063936F, 0F, 0F);
		Arm4 = new ModelRenderer(this, 22, 17);
		Arm4.addBox(-1.5F, -8F, 12F, 3, 4, 4);
		Arm4.setRotationPoint(0F, 16F, 0F);
		Arm4.setTextureSize(128, 256);
		Arm4.mirror = true;
		setRotation(Arm4, 0F, 0F, 0F);
		Arm3 = new ModelRenderer(this, 23, 5);
		Arm3.addBox(-2F, -5F, 13F, 4, 4, 2);
		Arm3.setRotationPoint(0F, 16F, 0F);
		Arm3.setTextureSize(128, 256);
		Arm3.mirror = true;
		setRotation(Arm3, 0F, 0F, 0F);
		Arm2 = new ModelRenderer(this, 23, 16);
		Arm2.addBox(-2F, 0F, 3F, 4, 3, 3);
		Arm2.setRotationPoint(0F, 16F, 0F);
		Arm2.setTextureSize(128, 256);
		Arm2.mirror = true;
		setRotation(Arm2, 0F, 0F, 0F);
		Arm1 = new ModelRenderer(this, 17, 14);
		Arm1.addBox(-2F, 1F, 5F, 4, 2, 9);
		Arm1.setRotationPoint(0F, 16F, 0F);
		Arm1.setTextureSize(128, 256);
		Arm1.mirror = true;
		setRotation(Arm1, 0.2602503F, 0F, 0F);
		Target5 = new ModelRenderer(this, 31, 32);
		Target5.addBox(-2.5F, -8.5F, -1F, 1, 3, 0);
		Target5.setRotationPoint(0F, 16F, 0F);
		Target5.setTextureSize(128, 256);
		Target5.mirror = true;
		setRotation(Target5, 0F, 0F, 0F);
		Target4 = new ModelRenderer(this, 28, 33);
		Target4.addBox(-1.5F, -9.5F, -1F, 3, 1, 0);
		Target4.setRotationPoint(0F, 16F, 0F);
		Target4.setTextureSize(128, 256);
		Target4.mirror = true;
		setRotation(Target4, 0F, 0F, 0F);
		Target3 = new ModelRenderer(this, 32, 30);
		Target3.addBox(1.5F, -8.5F, -1F, 1, 3, 0);
		Target3.setRotationPoint(0F, 16F, 0F);
		Target3.setTextureSize(128, 256);
		Target3.mirror = true;
		setRotation(Target3, 0F, 0F, 0F);
		Target2 = new ModelRenderer(this, 26, 32);
		Target2.addBox(-1.5F, -5F, -1F, 3, 1, 0);
		Target2.setRotationPoint(0F, 16F, 0F);
		Target2.setTextureSize(128, 256);
		Target2.mirror = true;
		setRotation(Target2, 0F, 0F, 0F);
		Target1 = new ModelRenderer(this, 26, 32);
		Target1.addBox(-2F, -9F, -1F, 4, 4, 0);
		Target1.setRotationPoint(0F, 16F, 0F);
		Target1.setTextureSize(128, 256);
		Target1.mirror = true;
		setRotation(Target1, 0F, 0F, 0F);
		Top = new ModelRenderer(this, 12, 40);
		Top.addBox(-7F, -4.5F, -3F, 14, 1, 8);
		Top.setRotationPoint(0F, 16F, 0F);
		Top.setTextureSize(128, 256);
		Top.mirror = true;
		setRotation(Top, 0F, 0F, 0F);
		PanelSide2 = new ModelRenderer(this, 26, 65);
		PanelSide2.addBox(-4F, -3F, -6F, 0, 8, 3);
		PanelSide2.setRotationPoint(0F, 16F, 0F);
		PanelSide2.setTextureSize(128, 256);
		PanelSide2.mirror = true;
		setRotation(PanelSide2, 0F, 0F, 0F);
		PanelSide1 = new ModelRenderer(this, 26, 65);
		PanelSide1.addBox(4F, -3F, -6F, 0, 8, 3);
		PanelSide1.setRotationPoint(0F, 16F, 0F);
		PanelSide1.setTextureSize(128, 256);
		PanelSide1.mirror = true;
		setRotation(PanelSide1, 0F, 0F, 0F);
		Control = new ModelRenderer(this, 24, 53);
		Control.addBox(-4F, -0.5F, -4F, 8, 5, 1);
		Control.setRotationPoint(0F, 16F, 0F);
		Control.setTextureSize(128, 256);
		Control.mirror = true;
		setRotation(Control, -0.669215F, 0F, 0F);
		Base5 = new ModelRenderer(this, 27, 64);
		Base5.addBox(6F, -4F, 3F, 1, 9, 5);
		Base5.setRotationPoint(0F, 16F, 0F);
		Base5.setTextureSize(128, 256);
		Base5.mirror = true;
		setRotation(Base5, 0F, 0F, 0F);
		Base4 = new ModelRenderer(this, 27, 64);
		Base4.addBox(-7F, -4F, 3F, 1, 9, 5);
		Base4.setRotationPoint(0F, 16F, 0F);
		Base4.setTextureSize(128, 256);
		Base4.mirror = true;
		setRotation(Base4, 0F, 0F, 0F);
		Base3 = new ModelRenderer(this, 69, 65);
		Base3.addBox(-7F, -4F, -3F, 14, 9, 6);
		Base3.setRotationPoint(0F, 16F, 0F);
		Base3.setTextureSize(128, 256);
		Base3.mirror = true;
		setRotation(Base3, 0F, 0F, 0F);
		Base2 = new ModelRenderer(this, 24, 64);
		Base2.addBox(-4F, 1F, -6F, 8, 4, 1);
		Base2.setRotationPoint(0F, 16F, 0F);
		Base2.setTextureSize(128, 256);
		Base2.mirror = true;
		setRotation(Base2, 0F, 0F, 0F);
		Base = new ModelRenderer(this, 0, 62);
		Base.addBox(-8F, 5F, -8F, 16, 3, 16);
		Base.setRotationPoint(0F, 16F, 0F);
		Base.setTextureSize(128, 256);
		Base.mirror = true;
		setRotation(Base, 0F, 0F, 0F);
	}
	
	public void render(float scale)
	{
		Cannon4.render(scale);
		Cannon3.render(scale);
		Cannon2.render(scale);
		Cannon1.render(scale);
		Arm6.render(scale);
		Arm5.render(scale);
		Arm4.render(scale);
		Arm3.render(scale);
		Arm2.render(scale);
		Arm1.render(scale);
		Target5.render(scale);
		Target4.render(scale);
		Target3.render(scale);
		Target2.render(scale);
		Target1.render(scale);
		Top.render(scale);
		PanelSide2.render(scale);
		PanelSide1.render(scale);
		Control.render(scale);
		Base5.render(scale);
		Base4.render(scale);
		Base3.render(scale);
		Base2.render(scale);
		Base.render(scale);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}

}
