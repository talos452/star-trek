package startrekmod;

import startrekmod.blocks.BlockOreStorage;

import net.minecraft.init.*;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;

public final class STRecipes
{
	public static void init()
	{
		initRecipes();
		initShapelessRecipes();
		initSmeltingRecipes();
		initOreStorageRecipes();
	}

	static void initOreStorageRecipes()
	{
		for (BlockOreStorage block : STBlock.oreList)
		{
			GameRegistry.addRecipe(new ItemStack(block), new Object[]
			{"III", "III", "III", 'I', block.ingot});
			GameRegistry.addShapelessRecipe(new ItemStack(block.ingot, 9), new Object[]
			{block});
		}
	}

	static void initRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(STItem.phaserII, 1, STItem.phaserII.getMaxDamage()), new Object[]
		{"DTU", 'D', STItem.dilithiumCrystal, 'T', Blocks.stone_button, 'U', STItem.duraniumIngot});
		GameRegistry.addRecipe(new ItemStack(STItem.phaserIII, 1, STItem.phaserIII.getMaxDamage()), new Object[]
		{"DUU", " TU", 'D', STItem.dilithiumCrystal, 'T', Blocks.stone_button, 'U', STItem.duraniumIngot});
		GameRegistry.addRecipe(new ItemStack(STItem.batleth), new Object[]
		{"  D", " DS", "DS ", 'D', STItem.duraniumIngot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(STItem.phaserDrill), new Object[]
		{"DUC", " UU", " UU", 'D', STItem.dilithiumCrystal, 'U', STItem.duraniumIngot, 'C', Items.compass});
		GameRegistry.addRecipe(new ItemStack(STItem.gagh), new Object[]
		{"D", "B", 'D', Blocks.dirt, 'B', Items.bowl});
	}

	static void initShapelessRecipes()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(STItem.phaserII), new Object[]
		{new ItemStack(STItem.phaserII, 0, STItem.phaserII.getMaxDamage()), STItem.powerCell});
		GameRegistry.addShapelessRecipe(new ItemStack(STItem.phaserIII), new Object[]
		{new ItemStack(STItem.phaserIII, 0, STItem.phaserIII.getMaxDamage()), STItem.powerCell});
		GameRegistry.addShapelessRecipe(new ItemStack(STItem.powerCell), new Object[]
		{STItem.duraniumIngot, Items.redstone});
		GameRegistry.addShapelessRecipe(new ItemStack(STItem.goldLatinum, 2), new Object[]
		{STItem.latinumIngot, Items.gold_ingot});
	}

	static void initSmeltingRecipes()
	{
		GameRegistry.addSmelting(STBlock.dilithiumOre, new ItemStack(STItem.dilithiumCrystal), 0);
		GameRegistry.addSmelting(STBlock.duraniumOre, new ItemStack(STItem.duraniumIngot), 0);
		GameRegistry.addSmelting(STBlock.latinumOre, new ItemStack(STItem.latinumIngot), 0);
	}
}
