package startrekmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import cpw.mods.fml.common.registry.GameRegistry;

public class STBlock extends Block
{
    public static Block dilithiumOre;
	public static Block latinumOre;
	public static Block duraniumOre;
	public static Block duraniumBlock;
	public static Block dilithiumBlock;
	
	public STBlock(Material material, String texturename)
	{
		super(material);
		setBlockTextureName(STMod.MODID + ':' + texturename);
		setBlockName(texturename);
		GameRegistry.registerBlock(this, texturename);
	}
	
	public static void preinit()
	{
		dilithiumOre = new STBlock(Material.rock, "dilithium_ore");
		latinumOre = new STBlock(Material.rock, "latinum_ore");
		duraniumOre = new STBlock(Material.rock, "duranium_ore");
		duraniumBlock = new STBlock(Material.rock, "duranium_block");
		dilithiumBlock = new STBlock(Material.rock, "dilithium_block");
	}
	
	public static void init()
	{
		dilithiumOre.setHardness(3F).setResistance(5F).setCreativeTab(STCreativeTabs.tabSTBlocks);
		latinumOre.setHardness(3F).setResistance(5F).setCreativeTab(STCreativeTabs.tabSTBlocks);
		duraniumOre.setHardness(3F).setResistance(5F).setCreativeTab(STCreativeTabs.tabSTBlocks);
		duraniumBlock.setHardness(5F).setResistance(10F).setCreativeTab(STCreativeTabs.tabSTBlocks);
		dilithiumBlock.setHardness(5F).setResistance(10F).setCreativeTab(STCreativeTabs.tabSTBlocks);
	}
}
