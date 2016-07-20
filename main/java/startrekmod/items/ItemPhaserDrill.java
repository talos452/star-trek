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
				//side == 1 tests for placement on top of a block
				if(side == 1 && !world.isRemote &&
						player.inventory.consumeInventoryItem(STItem.phaserDrill))
				{
					EntityPhaserDrill drill = new EntityPhaserDrill(world, player,
							blockPosX, blockPosY + 1, blockPosZ);
					world.spawnEntityInWorld(drill);
				}
				
				return true;
			}
}
