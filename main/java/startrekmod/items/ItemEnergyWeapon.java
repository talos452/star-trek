package startrekmod.items;

import startrekmod.STItem;
import startrekmod.entity.energyblast.EntityEnergyBlast;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEnergyWeapon extends STItem
{
	Class shotType;
	
	public ItemEnergyWeapon(String textureName, Class shotType, int maxDamage)
	{
		super(textureName);
		
		setMaxDamage(maxDamage);
		if(EntityEnergyBlast.class.isAssignableFrom(shotType))
			this.shotType = shotType;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if(stack.getItemDamage() == stack.getMaxDamage())
		{
			//weapon is empty, play click sound
			world.playSoundAtEntity(player, "fire.ignite", 1F, 1F);
			return stack;
		}
		
		if(world.isRemote) return stack;
		
		fireShot(world, player);		
		world.playSoundAtEntity(player, "startrekmod:phaser_blast", 1F, 1F);
		
		if(!player.capabilities.isCreativeMode)
			stack.damageItem(1, player);
		
		return stack;
	}
	
	//this is the price we pay for automated blast/weapon matching (rolls eyes)
	public void fireShot(World world, EntityLivingBase player)
	{
		try
		{
			EntityEnergyBlast blast = (EntityEnergyBlast)shotType
				.getConstructor(World.class, EntityLivingBase.class)
				.newInstance(world, player);
		
			world.spawnEntityInWorld(blast);
		}
		catch(Exception e) {} //can't rethrow for some Java reason. C# ftw
	}
}
