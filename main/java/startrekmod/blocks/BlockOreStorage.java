package startrekmod.blocks;

import startrekmod.STBlock;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockOreStorage extends STBlock
{
	public Item ingot;

	public BlockOreStorage(String textureName, Item ingot)
	{
		super (Material.iron, textureName);
		this.ingot = ingot;
	}
}
