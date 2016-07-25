package startrekmod.items;

import startrekmod.entity.phaserblast.EntityPhaserBlastKill;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

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
			//phaser is empty, play click sound
			world.playSoundAtEntity(player, "fire.ignite", 1F, 1F);
			return stack;
		}
		
		if(!world.isRemote)
		{
			EntityPhaserBlastKill blast = new EntityPhaserBlastKill(world, player);
			world.spawnEntityInWorld(blast);
		
			if(!player.capabilities.isCreativeMode)
				stack.damageItem(1, player);
			
			world.playSoundAtEntity(player, "startrekmod:phaser_blast", 1F, 1F);
		}
		
		return stack;
	}
}
