package com.vulcanforge.startrekmod.graphics;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPhaserBlast extends ModelBase	
{
	ModelRenderer Beam;	
		
	public ModelPhaserBlast()
	{
		textureWidth = 64;
		textureHeight = 32;
		
		Beam = new ModelRenderer(this, 0, 0);
		Beam.addBox(0F, -1F, -1F, 32, 2, 2);
		Beam.setRotationPoint(-8F, -1F, 0F);
		Beam.setTextureSize(64, 32);
		Beam.mirror = true;
		setRotation(Beam, 0F, 0F, 0F);
	}
	
	public void render(float scale)
	{
		Beam.render(scale);
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
