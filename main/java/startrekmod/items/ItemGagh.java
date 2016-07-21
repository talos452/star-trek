package startrekmod.items;

import startrekmod.STMod;
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
		setTextureName(STMod.MODID + ":" + "gagh");
		setUnlocalizedName("gagh");
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		PotionEffect effect = new PotionEffect(9, 200); //9 is Nausea effect, 200 is 10 seconds
		player.addPotionEffect(effect);
		return super.onEaten(stack, world, player);
	}
}
