package startrekmod.entity;

import startrekmod.*;
import startrekmod.entity.energyblast.EntityDrillBlast;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class EntityPhaserDrill extends Entity
{
	public int firingSequenceTicks = -1;
	public int operatorID;

	public EntityPhaserDrill(World world)
	{
		super(world);
	}

	public EntityPhaserDrill(World world, double posX, double posY, double posZ)
	{
		super(world);
		setPosition(posX, posY, posZ);
	}

	@Override
	public boolean attackEntityFrom(DamageSource damage, float damageLevel)
	{
		if (worldObj.isRemote)
			return false;
		if (damage.isExplosion())
			return false;

		dropItem(STItem.phaserDrill, 1);
		setDead();
		return true;
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return true;
	}

	@Override
	public boolean interactFirst(EntityPlayer player)
	{
		if (!worldObj.isRemote)
			return false;

		player.openGui(STMod.INSTANCE, STCommonProxy.GUI_PHASER_DRILL, worldObj, getEntityId(), 0, 0);
		return true;
	}

	@Override
	public void onUpdate()
	{
		Entity temp = worldObj.getEntityByID(operatorID);
		EntityPlayer operator;

		if (temp instanceof EntityPlayer)
			operator = (EntityPlayer)temp;
		else
			return;

		if (firingSequenceTicks == -1)
			return;

		if (firingSequenceTicks % 20 == 0)
			operator.addChatComponentMessage(new ChatComponentText("Firing in " + (firingSequenceTicks / 20)));

		if (firingSequenceTicks-- != 0)
			return;

		worldObj.playSoundAtEntity(this, "startrekmod:phaser_blast", 1, 1);
		Entity blast = new EntityDrillBlast(worldObj, operator, this);
		worldObj.spawnEntityInWorld(blast);
	}

	@Override
	protected void entityInit()
	{
		setSize(2F, 2F);
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound reader)
	{}

	@Override
	protected void writeEntityToNBT(NBTTagCompound writer)
	{}
}
