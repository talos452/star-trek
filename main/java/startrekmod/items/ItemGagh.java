package startrekmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.*;
import net.minecraft.world.World;

public class ItemGagh extends STItemFood
{
	public ItemGagh()
	{
		super("gagh", 6, .6F);
		setPotionEffect(Potion.confusion.id, 10, 0, 1F);
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		PotionEffect effect = new PotionEffect(9, 200); //9 is Nausea effect, 200 is 10 seconds
		player.addPotionEffect(effect);
		return super.onEaten(stack, world, player);
	}
}
