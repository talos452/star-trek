package startrekmod.graphics.model;

import net.minecraft.client.model.*;

import scala.actors.threadpool.Arrays;

public abstract class STModel extends ModelBase
{
	public void render(float scale)
	{
		for (Object renderer : boxList)
			((ModelRenderer)renderer).render(scale);
	}

	void addRenderers(ModelRenderer... modelRenderers)
	{
		boxList.addAll(Arrays.asList(modelRenderers));
	}

	void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
