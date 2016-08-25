package startrekmod;

import startrekmod.items.STItemSword;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class STEventHandler
{
	public static STEventHandler INSTANCE;

	@SubscribeEvent
	public void interceptRifleThrowback(LivingAttackEvent event)
	{
		if (event.source.isExplosion())
			if (event.source.getSourceOfDamage() == event.entityLiving)
				event.setCanceled(true);
	}

	@SubscribeEvent
	public void interceptSwordBreakingBlock(BreakEvent event)
	{
		EntityPlayer player = event.getPlayer();
		ItemStack breakingItem = player.getCurrentEquippedItem();

		if (breakingItem != null)
			if (breakingItem.getItem() instanceof STItemSword)
				if (player.capabilities.isCreativeMode)
					event.setCanceled(true);
	}

	public static void init()
	{
		INSTANCE = new STEventHandler();
		MinecraftForge.EVENT_BUS.register(INSTANCE);
	}
}
