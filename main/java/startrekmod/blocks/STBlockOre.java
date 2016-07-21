package startrekmod.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class STBlockOre extends STBlock
{
	public Item ingot;
	
	public STBlockOre(Item ingot, String texturename)
	{
		super(Material.iron, texturename);
		this.ingot = ingot;
		STBlock.oreBlockList.add(this);
		setHardness(5F).setResistance(2000F).setCreativeTab(tabSTBlocks);
	}
}
