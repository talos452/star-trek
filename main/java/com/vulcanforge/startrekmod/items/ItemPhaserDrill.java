package com.vulcanforge.startrekmod.items;

import com.vulcanforge.startrekmod.entity.EntityPhaserDrill;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPhaserDrill extends STItem
{
	public ItemPhaserDrill(String texturename)
	{
		super(texturename);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int blockPosX, int blockPosY, int blockPosZ, int side,
			float innerPosX, float innerPosY, float innerPosZ)
			{
				if(side == 1 && !world.isRemote)
				{
					EntityPhaserDrill drill = new EntityPhaserDrill(world, player, blockPosX, blockPosY, blockPosZ);
					world.spawnEntityInWorld(drill);
				}
				
				return true;
			}
}
