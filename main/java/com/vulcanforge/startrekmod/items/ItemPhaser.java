package com.vulcanforge.startrekmod.items;

import com.vulcanforge.startrekmod.entity.*;
import com.vulcanforge.startrekmod.entity.phaserblast.EntityPhaserBlastStun;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPhaser extends STItem
{
	public ItemPhaser(String texturename) 
	{
		super(texturename);
		setMaxStackSize(1);
		setMaxDamage(1024);
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
			EntityPhaserBlastStun blast = new EntityPhaserBlastStun(world, player);
			world.spawnEntityInWorld(blast);
		
			if(!player.capabilities.isCreativeMode)
				stack.damageItem(1, player);
			
			world.playSoundAtEntity(player, "startrekmod:phaser_blast", 1, 1);
		}
		
		return stack;
	}
}
