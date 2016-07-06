package com.vulcanforge.startrekmod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

public class STEventHandler 
{
	@SubscribeEvent
	public void interceptRifleThrowback(LivingAttackEvent event)
	{
		if(event.entityLiving instanceof EntityLivingBase)
			if(event.source.isExplosion())
				if(event.source.getSourceOfDamage() == event.entityLiving )
					event.setCanceled(true);
	}
}
