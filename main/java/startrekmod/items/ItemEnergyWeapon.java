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
		super (textureName);

		setMaxDamage (maxDamage);
		if (EntityEnergyBlast.class.isAssignableFrom (shotType)) this.shotType = shotType;
	}

	public void fireShot(World world, EntityLivingBase player)
	{
		try
		{
			EntityEnergyBlast blast = (EntityEnergyBlast) shotType.getConstructor (World.class, EntityLivingBase.class).newInstance (world, player);

			world.spawnEntityInWorld (blast);
		}
		catch (Exception e)
		{}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (world.isRemote) return stack;

		if (stack.getItemDamage () == stack.getMaxDamage ())
		{
			world.playSoundAtEntity (player, "fire.ignite", 1F, 1F);
			return stack;
		}

		fireShot (world, player);
		world.playSoundAtEntity (player, "startrekmod:phaser_blast", 1F, 1F);

		if (!player.capabilities.isCreativeMode) stack.damageItem (1, player);

		return stack;
	}
}
