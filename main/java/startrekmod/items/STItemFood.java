package startrekmod.items;

import startrekmod.STMod;

import net.minecraft.item.ItemFood;

import cpw.mods.fml.common.registry.GameRegistry;

public class STItemFood extends ItemFood
{
	public STItemFood(String textureName, int bars, float saturation)
	{
		super (bars, saturation, false);
		setTextureName (STMod.MODID + ":" + textureName);
		setUnlocalizedName (textureName);
		GameRegistry.registerItem (this, textureName);
	}
}
