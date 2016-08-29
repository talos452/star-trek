package startrekmod.entity;

import startrekmod.*;
import startrekmod.entity.energyblast.EntityDrillBlast;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.UUID;

public class EntityPhaserDrill extends Entity
{
	int sequence;
	UUID operatorID;

	public EntityPhaserDrill (World world)
	{
		super (world);
	}

	public EntityPhaserDrill (World world, double posX, double posY, double posZ)
	{
		super (world);
		setPosition (posX, posY, posZ);
	}

	@Override
	protected void entityInit ()
	{
		setSize (2F, 2F);
		sequence = -1;
	}

	@Override
	public boolean interactFirst (EntityPlayer player)
	{
		if (worldObj.isRemote)
		{
			player.openGui (STMod.INSTANCE, STCommonProxy.GUI_PHASER_DRILL, worldObj, getEntityId (), 0, 0);
			return true;
		}
		else
			operatorID = player.getPersistentID ();

		return false;
	}

	@Override
	public void onUpdate ()
	{
		if (sequence > -1)
		{
			countdown ();
			sequence--;

			if (sequence == 0)
				fireDrill ();
		}
	}

	@Override
	public boolean attackEntityFrom (DamageSource damage, float damageLevel)
	{
		if (!worldObj.isRemote)
			if (damage.getEntity () instanceof EntityPlayer)
			{
				dropItem (STItem.phaserDrill, 1);
				setDead ();
				return true;
			}

		return false;
	}

	public void initiateSequence (int ticks)
	{
		sequence = ticks;
	}

	public EntityPlayer getLastOperator ()
	{
		return STUtilities.getPlayerByUUID (operatorID);
	}

	void fireDrill ()
	{
		worldObj.playSoundAtEntity (this, "startrekmod:phaser_blast", 1, 1);
		Entity blast = new EntityDrillBlast (worldObj, this.getPersistentID ());
		worldObj.spawnEntityInWorld (blast);
	}

	void countdown ()
	{
		if (sequence % 20 == 0)
		{
			int seconds = sequence / 20;

			if (seconds == 10 || seconds < 6)
			{
				String colour = EnumChatFormatting.RED.toString ();
				String chat = "Firing in " + seconds + " seconds.";
				IChatComponent message = new ChatComponentText (colour + chat);
				EntityPlayer player = getLastOperator ();

				if (player != null)
					player.addChatComponentMessage (message);
			}
		}
	}

	@Override
	public boolean canBeCollidedWith ()
	{
		return true;
	}

	@Override
	protected void readEntityFromNBT (NBTTagCompound reader)
	{
		sequence = reader.getInteger ("Sequence");
	}

	@Override
	protected void writeEntityToNBT (NBTTagCompound writer)
	{
		writer.setInteger ("Sequence", sequence);
	}
}
