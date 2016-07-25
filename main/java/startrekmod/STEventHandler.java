package startrekmod;

import startrekmod.items.STItemSword;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class STEventHandler 
{
	public static STEventHandler INSTANCE;
	
	public static void init()
	{
		INSTANCE = new STEventHandler();
		MinecraftForge.EVENT_BUS.register(INSTANCE);
	}
	
	@SubscribeEvent
	public void interceptRifleThrowback(LivingAttackEvent event)
	{
		//stops shooter from taking explosion damage
		if(event.entityLiving instanceof EntityLivingBase)
			if(event.source.isExplosion())
				if(event.source.getSourceOfDamage() == event.entityLiving )
					event.setCanceled(true);
	}
	
	@SubscribeEvent
	public void interceptSwordBreakingBlock(BreakEvent event)
	{
		EntityPlayer player = event.getPlayer();
		Item breakingItem = player.getCurrentEquippedItem().getItem();
		
		if(player.capabilities.isCreativeMode && breakingItem instanceof STItemSword)
			event.setCanceled(true);
	}
}

