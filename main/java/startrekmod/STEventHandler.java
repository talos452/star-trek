package startrekmod;

import startrekmod.entity.EntityCelestial;
import startrekmod.items.STItemSword;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.*;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.ChunkEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class STEventHandler
{
	public static STEventHandler INSTANCE;

	@SubscribeEvent
	public void interceptRifleThrowback (LivingAttackEvent event)
	{
		if (event.source.isExplosion ())
			if (event.source.getSourceOfDamage () == event.entityLiving)
				event.setCanceled (true);
	}

	@SubscribeEvent
	public void interceptSwordBreakingBlock (BreakEvent event)
	{
		EntityPlayer player = event.getPlayer ();
		ItemStack breakingItem = player.getCurrentEquippedItem ();

		if (breakingItem != null)
			if (breakingItem.getItem () instanceof STItemSword)
				if (player.capabilities.isCreativeMode)
					event.setCanceled (true);
	}

	@SubscribeEvent
	public void updateCelestialEntities (ChunkEvent.Load event)
	{
		World world = event.world;

		if (world.isRemote)
			return;

		WorldProvider provider = world.provider;
		Chunk chunk = event.getChunk ();
		int dimensionID = STDimension.dimensionTable.get ("space").dimensionID;

		if (provider.dimensionId == dimensionID)
			for (STCelestialData data : STCelestialData.bodyList.values ())
				if (STUtilities.fallsWithinChunk (chunk, data.governor.posX, data.governor.posZ))
					if (data.associated == null)
					{
						EntityCelestial entity = new EntityCelestial (world, data);
						world.spawnEntityInWorld (entity);
					}
	}

	public static void init ()
	{
		INSTANCE = new STEventHandler ();
		MinecraftForge.EVENT_BUS.register (INSTANCE);
	}
}
