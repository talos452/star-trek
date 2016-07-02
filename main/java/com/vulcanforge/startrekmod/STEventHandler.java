package com.vulcanforge.startrekmod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class STEventHandler 
{
	@SubscribeEvent
	public void interceptRifleThrowback(LivingAttackEvent e)
	{
		if(e.entityLiving instanceof EntityPlayer)
			if(e.source.isExplosion())
				if(e.source.getSourceOfDamage() == e.entityLiving )
					e.setCanceled(true);
	}
}
