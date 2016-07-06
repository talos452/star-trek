package com.vulcanforge.startrekmod.blocks;

import com.vulcanforge.startrekmod.StarTrekMod;
import com.vulcanforge.startrekmod.items.STItem;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class STBlock extends Block
{
    public static final CreativeTabs tabSTBlocks = new CreativeTabs("tabSTBlocks")
    {
    	@Override
    	@SideOnly(Side.CLIENT)
    	public Item getTabIconItem()
    	{
    		return Item.getItemFromBlock(dilithiumOre);
    	}
    };
    
	public static Block dilithiumOre = new STBlock(Material.rock, "dilithiumOre");
	public static Block latinumOre = new STBlock(Material.rock, "latinumOre");
	public static Block duraniumOre = new STBlock(Material.rock, "duraniumOre");
	
	public STBlock(Material material, String texturename)
	{
		super(material);
		setBlockTextureName(StarTrekMod.MODID + ":" + texturename);
		setBlockName(texturename);
	}
	
	public static void init()
	{
		dilithiumOre.setHardness(3F).setResistance(2000F).setCreativeTab(tabSTBlocks);
		latinumOre.setHardness(2F).setResistance(0F).setCreativeTab(tabSTBlocks);
		duraniumOre.setHardness(5F).setResistance(2000F).setCreativeTab(tabSTBlocks);
		
		GameRegistry.registerBlock(dilithiumOre, "dilithiumOre");
		GameRegistry.registerBlock(latinumOre, "latinumOre");
		GameRegistry.registerBlock(duraniumOre, "duraniumOre");
	}
}
