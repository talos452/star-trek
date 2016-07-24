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
		super("egg");
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
		Entity entity = EntityList.createEntityByName(entityName, world);
		entity.setPosition(blockPosX, blockPosY + 1, blockPosZ);
		world.spawnEntityInWorld(entity);
		return true;
	}
}
