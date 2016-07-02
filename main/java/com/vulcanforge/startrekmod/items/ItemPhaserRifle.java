package com.vulcanforge.startrekmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.vulcanforge.startrekmod.entity.EntityPhaserBlast;

public class ItemPhaserRifle extends ItemPhaser 
{
	public ItemPhaserRifle(String texturename) 
	{
		super(texturename);
		setMaxDamage(256);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack i, World w, EntityPlayer ep)
	{
		if(i.getItemDamage() == i.getMaxDamage())
		{
			w.playSoundEffect(ep.posX + 0.5, ep.posY + 0.5, ep.posZ + 0.5, "fire.ignite", 1.0F, 1.0F);
			return i;
		}
		
		if(!w.isRemote)
		{
			EntityPhaserBlast epb = new EntityPhaserBlast(w, ep, true);
			w.spawnEntityInWorld(epb);
		}
		
		if(!ep.capabilities.isCreativeMode)
			i.damageItem(1, ep);
		
		return i;
	}
}
