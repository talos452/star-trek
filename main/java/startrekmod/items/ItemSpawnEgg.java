package startrekmod.items;

import startrekmod.*;

import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSpawnEgg extends STItem
{
	String entityName;
	
	public ItemSpawnEgg(String entityName)
	{
		//eggKlingon, eggHuman, and so on
		super("egg" + entityName);
		//startrekmod.Klingon, startrekmod.Romulan, and so on
		this.entityName = STMod.MODID + '.' + entityName;
		setCreativeTab(STCreativeTabs.tabSTEggs);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int blockPosX, int blockPosY, int blockPosZ, int side,
			float innerPosX, float innerPosY, float innerPosZ)
	{
		if(world.isRemote) return true;
		
		stack.stackSize--;
		//obviously totally unsuitable for entities with custom constructors
		Entity entity = EntityList.createEntityByName(entityName, world);
		entity.setPosition(blockPosX, blockPosY + 1, blockPosZ);
		world.spawnEntityInWorld(entity);
		return true;
	}
}
