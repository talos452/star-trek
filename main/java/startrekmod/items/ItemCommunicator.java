package startrekmod.items;

import startrekmod.*;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCommunicator extends STItem
{
	public ItemCommunicator()
	{
		super("communicator");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		player.openGui(STMod.INSTANCE, STCommonProxy.GUI_COMMUNICATOR, world, 0, 0, 0);
		return stack;
	}
}
