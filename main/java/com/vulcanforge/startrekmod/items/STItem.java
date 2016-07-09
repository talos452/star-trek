package com.vulcanforge.startrekmod.items;

import com.vulcanforge.startrekmod.StarTrekMod;
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
			.setTextureName(StarTrekMod.MODID + ":batleth").setUnlocalizedName("batleth");
	public static Item phaserDrill = new ItemPhaserDrill("phaserDrill");
	public static Item gagh = new ItemGagh();
	
	public STItem(String texturename)
	{
		super();
		setTextureName(StarTrekMod.MODID + ":" + texturename);
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
		
		GameRegistry.addShapelessRecipe(new ItemStack(phaser), new Object[] {new ItemStack(phaser, 0, phaser.getMaxDamage()), powerCell});
		GameRegistry.addShapelessRecipe(new ItemStack(phaserRifle), new Object[] {new ItemStack(phaserRifle, 0, phaserRifle.getMaxDamage()), powerCell});
		GameRegistry.addRecipe(new ItemStack(phaser, 1, phaser.getMaxDamage()), new Object[] {"DTU", 'D', dilithiumCrystal, 'T', Blocks.stone_button, 'U', duraniumIngot});
		GameRegistry.addRecipe(new ItemStack(phaserRifle, 1, phaserRifle.getMaxDamage()), new Object[] {"DUU", " TU", 'D', dilithiumCrystal, 'T', Blocks.stone_button, 'U', duraniumIngot});
		GameRegistry.addRecipe(new ItemStack(batleth), new Object[] {"  D", " DS", "DS ", 'D', duraniumIngot, 'S', Items.stick});
		GameRegistry.addShapelessRecipe(new ItemStack(powerCell), new Object[] {duraniumIngot, Items.redstone});
		GameRegistry.addShapelessRecipe(new ItemStack(goldLatinum, 2), new Object[] {latinumIngot, Items.gold_ingot});
		GameRegistry.addRecipe(new ItemStack(phaserDrill), new Object[] {"DUC", " UU", " UU", 'D', dilithiumCrystal, 'U', duraniumIngot, 'C', Items.compass});
		GameRegistry.addRecipe(new ItemStack(gagh), new Object[] {"D", "B", 'D', Blocks.dirt, 'B', Items.bowl});
		
		GameRegistry.addSmelting(STBlock.dilithiumOre, new ItemStack(dilithiumCrystal), 0);
		GameRegistry.addSmelting(STBlock.duraniumOre, new ItemStack(duraniumIngot), 0);
		GameRegistry.addSmelting(STBlock.latinumOre, new ItemStack(latinumIngot), 0);
	}
}
