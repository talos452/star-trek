package com.vulcanforge.startrekmod.items;

import vulcanforge.startrekmod.STMod;

import com.vulcanforge.startrekmod.blocks.STBlock;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class STItem extends Item
{
	public static ToolMaterial BATLETH = EnumHelper
			.addToolMaterial("BATLETH", 0, 1024 * 1024, 1.0F, 11F, 0);
	
    public static final CreativeTabs tabSTItems = new CreativeTabs("tabSTItems")
    {
    	@Override
    	@SideOnly(Side.CLIENT)
    	public Item getTabIconItem()
    	{
    		return phaser; //sets icon for STItems tab
    	}
    };
    
	public static Item phaser = new ItemPhaser("phaser");
	public static Item phaserRifle = new ItemPhaserRifle("phaserRifle");
	public static Item powerCell = new STItem("powerCell");
	public static Item duraniumIngot = new STItem("duraniumIngot");
	public static Item latinumIngot = new STItem("latinumIngot");
	public static Item dilithiumCrystal = new STItem("dilithiumCrystal");
	public static Item goldLatinum = new STItem("goldLatinum");
	public static Item batleth = new ItemSword(BATLETH)
		.setTextureName(STMod.MODID + ":batleth").setUnlocalizedName("batleth");
	public static Item phaserDrill = new ItemPhaserDrill("phaserDrill");
	public static Item gagh = new ItemGagh();
	
	public STItem(String texturename)
	{
		super();
		setTextureName(STMod.MODID + ":" + texturename);
		setUnlocalizedName(texturename);
		GameRegistry.registerItem(this, texturename);
	}
	
	public static void init()
	{
		phaser.setCreativeTab(tabSTItems);
		phaserRifle.setCreativeTab(tabSTItems);
		batleth.setCreativeTab(tabSTItems);
		powerCell.setCreativeTab(tabSTItems);
		duraniumIngot.setCreativeTab(tabSTItems);
		latinumIngot.setCreativeTab(tabSTItems);
		dilithiumCrystal.setCreativeTab(tabSTItems);
		goldLatinum.setCreativeTab(tabSTItems);
		phaserDrill.setCreativeTab(tabSTItems);
		gagh.setCreativeTab(tabSTItems);
		
		GameRegistry.registerItem(batleth, "batleth");
		GameRegistry.registerItem(gagh, "gagh");
	}
}
