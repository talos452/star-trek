package com.vulcanforge.startrekmod;

import com.vulcanforge.startrekmod.blocks.*;
import com.vulcanforge.startrekmod.items.*;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public final class CraftingRecipes
{
	public static void init()
	{
		initRecipes();
		initShapelessRecipes();
		initSmeltingRecipes();
	}
	
	static void initRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(STItem.phaser, 1,
			STItem.phaser.getMaxDamage()),
			new Object[] {"DTU",
			'D', STItem.dilithiumCrystal,
			'T', Blocks.stone_button,
			'U', STItem.duraniumIngot});
		GameRegistry.addRecipe(new ItemStack(STItem.phaserRifle, 1,
			STItem.phaserRifle.getMaxDamage()),
			new Object[] {"DUU", " TU",
			'D', STItem.dilithiumCrystal,
			'T', Blocks.stone_button,
			'U', STItem.duraniumIngot});
		GameRegistry.addRecipe(new ItemStack(STItem.batleth),
			new Object[] {"  D", " DS", "DS ",
			'D', STItem.duraniumIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(STItem.phaserDrill),
			new Object[] {"DUC", " UU", " UU",
			'D', STItem.dilithiumCrystal,
			'U', STItem.duraniumIngot,
			'C', Items.compass});
		GameRegistry.addRecipe(new ItemStack(STItem.gagh),
			new Object[] {"D", "B",
			'D', Blocks.dirt, 'B', Items.bowl});
		GameRegistry.addRecipe(new ItemStack(STBlock.duraniumBlock),
			new Object[] {"DDD", "DDD", "DDD",
			'D', STItem.duraniumIngot});
	}
	
	static void initShapelessRecipes()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(STItem.phaser),
			new Object[] {new ItemStack(STItem.phaser, 0, STItem.phaser.getMaxDamage()),
			STItem.powerCell});
		GameRegistry.addShapelessRecipe(new ItemStack(STItem.phaserRifle),
			new Object[] {new ItemStack(STItem.phaserRifle, 0,
			STItem.phaserRifle.getMaxDamage()), STItem.powerCell});
		GameRegistry.addShapelessRecipe(new ItemStack(STItem.powerCell),
			new Object[] {STItem.duraniumIngot, Items.redstone});
		GameRegistry.addShapelessRecipe(new ItemStack(STItem.goldLatinum, 2),
			new Object[] {STItem.latinumIngot, Items.gold_ingot});
	}
	
	static void initSmeltingRecipes()
	{
		GameRegistry.addSmelting(STBlock.dilithiumOre,
			new ItemStack(STItem.dilithiumCrystal), 0);
		GameRegistry.addSmelting(STBlock.duraniumOre,
			new ItemStack(STItem.duraniumIngot), 0);
		GameRegistry.addSmelting(STBlock.latinumOre,
			new ItemStack(STItem.latinumIngot), 0);
	}
}
