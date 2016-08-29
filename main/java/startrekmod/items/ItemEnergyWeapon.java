package startrekmod.items;

import startrekmod.STItem;
import startrekmod.entity.energyblast.EntityEnergyBlast;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.common.FMLLog;

import java.lang.reflect.Constructor;
import java.util.UUID;

import org.apache.logging.log4j.Level;

public class ItemEnergyWeapon extends STItem
{
	Class shotType;

	public ItemEnergyWeapon (String textureName, Class shotType, int maxDamage)
	{
		super (textureName);

		setMaxDamage (maxDamage);

		if (EntityEnergyBlast.class.isAssignableFrom (shotType))
			this.shotType = shotType;
		else
			throw new IllegalArgumentException ("shotType is not derived from EntityEnergyBlast.");
	}

	@Override
	public ItemStack onItemRightClick (ItemStack stack, World world, EntityPlayer player)
	{
		if (!world.isRemote)
		{
			if (stack.getItemDamage () == stack.getMaxDamage ())
				world.playSoundAtEntity (player, "fire.ignite", 1F, 1F);
			else
			{
				fireShot (world, player);
				world.playSoundAtEntity (player, "startrekmod:phaser_blast", 1F, 1F);

				if (!player.capabilities.isCreativeMode)
					stack.damageItem (1, player);
			}
		}

		return stack;
	}

	public void fireShot (World world, EntityLivingBase player)
	{
		try
		{
			Constructor constructor = shotType.getConstructor (World.class, UUID.class);
			EntityEnergyBlast blast = (EntityEnergyBlast) constructor.newInstance (world, player.getPersistentID ());
			world.spawnEntityInWorld (blast);
		}
		catch (Exception e)
		{
			FMLLog.log (Level.ERROR, e, "Error invoking EntityEnergyBlast constructor.", null);
		}
	}
}
