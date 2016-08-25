package startrekmod.items;

import startrekmod.STItem;

import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemPainStick extends STItem
{
	public ItemPainStick()
	{
		super("pain_stik");
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
	{
		if (!(entity instanceof EntityLivingBase))
			return false;

		entity.setFire(5);
		return true;
	}
}
