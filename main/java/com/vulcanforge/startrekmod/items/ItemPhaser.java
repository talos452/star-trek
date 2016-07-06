package com.vulcanforge.startrekmod.items;

import com.vulcanforge.startrekmod.entity.EntityPhaserBlast;
import com.vulcanforge.startrekmod.entity.EntityPhaserBlastStun;

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
	public ItemStack onItemRightClick(ItemStack i, World w, EntityPlayer ep)
	{
		if(i.getItemDamage() == i.getMaxDamage())
		{
			w.playSoundEffect(ep.posX + 0.5, ep.posY + 0.5, ep.posZ + 0.5, "fire.ignite", 1.0F, 1.0F);
			return i;
		}
		
		if(!w.isRemote)
		{
			EntityPhaserBlastStun blast = new EntityPhaserBlastStun(w, ep);
			w.spawnEntityInWorld(blast);
		
			if(!ep.capabilities.isCreativeMode)
				i.damageItem(1, ep);
			
			w.playSoundAtEntity(ep, "startrekmod:phaser_blast", 1, 1);
		}
		
		return i;
	}
}
