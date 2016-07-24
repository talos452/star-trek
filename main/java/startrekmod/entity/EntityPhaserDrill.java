package startrekmod.entity;

import startrekmod.*;
import startrekmod.entity.phaserblast.EntityPhaserBlastDrill;
import startrekmod.util.DirectionMode;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class EntityPhaserDrill extends Entity
{
	public int countdownTicks = -1;
	public EntityPlayer operator;
	public DirectionMode direction;
	
	public EntityPhaserDrill(World world)
	{
		super(world);
	}
	
	public EntityPhaserDrill(World world, EntityPlayer operator, double posX, double posY, double posZ)
	{
		super(world);
		setPosition(posX, posY, posZ);
		this.operator = operator;
		direction = direction.SOUTH;
	}
	
	@Override
	public boolean interactFirst(EntityPlayer player)
	{
		if(!worldObj.isRemote) return false;
		
		player.openGui(STMod.INSTANCE, STCommonProxy.GUI_PHASER_DRILL, worldObj,
			getEntityId(), player.getEntityId(), 0);
		return true;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource damage, float damageLevel)
	{
		if(worldObj.isRemote) return false;		
		if(damage.isExplosion()) return false;
		
		dropItem(STItem.phaserDrill, 1);
		setDead();
		return true;
	}
	
	//players can only interact if this returns true
	@Override
	public boolean canBeCollidedWith()
	{
		return true;
	}

	//makes bounding box fit entity
	@Override
	protected void entityInit()
	{
		setSize(2F, 2F);		
	}
	
	@Override
	public void onUpdate()
	{
		if(operator == null) return;
		if(countdownTicks == -1) return;
		
		if(countdownTicks % 20 == 0)
			operator.addChatComponentMessage(new ChatComponentText("Firing in " + (countdownTicks / 20)));
		
		if(countdownTicks-- != 0) return;
		
		worldObj.playSoundAtEntity(this, "startrekmod:phaser_blast", 1, 1);
		Entity blast = new EntityPhaserBlastDrill(worldObj, operator, this);
		worldObj.spawnEntityInWorld(blast);
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound reader)
	{
		countdownTicks = reader.getInteger("FireTick");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound writer)
	{
		writer.setInteger("FireTick", countdownTicks);
	}
	
	public void setDirection(DirectionMode direction)
	{
		rotationYaw = direction.angle; //for rendering purposes
		this.direction = direction; //for firing purposes
	}
}
