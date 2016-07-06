package com.vulcanforge.startrekmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.vulcanforge.startrekmod.entity.*;
import com.vulcanforge.startrekmod.entity.phaserblast.EntityPhaserBlastKill;

public class ItemPhaserRifle extends ItemPhaser 
{
	public ItemPhaserRifle(String texturename) 
	{
		super(texturename);
		setMaxDamage(256);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if(stack.getItemDamage() == stack.getMaxDamage())
		{
			world.playSoundEffect(player.posX + 0.5, player.posY + 0.5, player.posZ + 0.5,
					"fire.ignite", 1.0F, 1.0F);
			return stack;
		}
		
		if(!world.isRemote)
		{
			EntityPhaserBlastKill blast = new EntityPhaserBlastKill(world, player);
			world.spawnEntityInWorld(blast);
		
			if(!player.capabilities.isCreativeMode)
				stack.damageItem(1, player);
			
			world.playSoundAtEntity(player, "startrekmod:phaser_blast", 1, 1);
		}
		
		return stack;
	}
}
