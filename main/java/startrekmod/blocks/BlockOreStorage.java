package startrekmod.blocks;

import startrekmod.STBlock;

import net.minecraft.block.material.Material;
import net.minecraft.item.*;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockOreStorage extends STBlock
{
	Item ingot;
	
	public BlockOreStorage(String textureName, Item ingot)
	{
		super(Material.iron, textureName);
		this.ingot = ingot;
	}
	
	public void initRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(this),
			new Object[] {"III", "III", "III",
			'I', ingot});
		
		GameRegistry.addShapelessRecipe(new ItemStack(ingot, 9),
			new Object[] {this});
	}
}
