package startrekmod;

import startrekmod.blocks.BlockOreStorage;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import cpw.mods.fml.common.registry.GameRegistry;

public class STBlock extends Block
{
    public static Block dilithiumOre;
	public static Block latinumOre;
	public static Block duraniumOre;
	public static BlockOreStorage duraniumBlock;
	public static BlockOreStorage dilithiumBlock;
	
	public STBlock(Material material, String textureName)
	{
		super(material);
		setBlockTextureName(STMod.MODID + ':' + textureName);
		setBlockName(textureName);
		GameRegistry.registerBlock(this, textureName);
	}
	
	public static void preinit()
	{
		dilithiumOre = new STBlock(Material.rock, "dilithium_ore");
		latinumOre = new STBlock(Material.rock, "latinum_ore");
		duraniumOre = new STBlock(Material.rock, "duranium_ore");
		duraniumBlock = new BlockOreStorage("duranium_block", STItem.duraniumIngot);
		dilithiumBlock = new BlockOreStorage("dilithium_block", STItem.dilithiumCrystal);
	}
	
	public static void init()
	{
		dilithiumOre.setHardness(3F).setResistance(5F).setCreativeTab(STCreativeTabs.tabSTBlocks);
		latinumOre.setHardness(3F).setResistance(5F).setCreativeTab(STCreativeTabs.tabSTBlocks);
		duraniumOre.setHardness(3F).setResistance(5F).setCreativeTab(STCreativeTabs.tabSTBlocks);
		duraniumBlock.setHardness(5F).setResistance(10F).setCreativeTab(STCreativeTabs.tabSTBlocks);
		dilithiumBlock.setHardness(5F).setResistance(10F).setCreativeTab(STCreativeTabs.tabSTBlocks);
		
		duraniumBlock.initRecipes();
		dilithiumBlock.initRecipes();
	}
}
