package com.vulcanforge.startrekmod.items;

import com.vulcanforge.startrekmod.StarTrekMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemGagh extends ItemFood
{
	public ItemGagh()
	{
		super(6, true);
		setTextureName(StarTrekMod.MODID + ":" + "gagh");
		setUnlocalizedName("gagh");
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		PotionEffect effect = new PotionEffect(9, 200);
		player.addPotionEffect(effect);
		return super.onEaten(stack, world, player);
	}
}