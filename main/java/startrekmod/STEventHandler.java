package startrekmod;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

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
}

