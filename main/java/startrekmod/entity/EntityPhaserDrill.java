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
	//timer for fire event
	public int countdownTicks = -1;
	public EntityPlayer operator;
	public float angle;
	
	public EntityPhaserDrill(World world)
	{
		super(world);
	}
	
	public EntityPhaserDrill(World world, EntityPlayer operator, double posX, double posY, double posZ)
	{
		super(world);
		setPosition(posX, posY, posZ);
		this.operator = operator;
	}
	
	@Override
	public boolean interactFirst(EntityPlayer player)
	{
		if(!worldObj.isRemote) return false;
		
		//pass in entity ID, no other params needed
		player.openGui(STMod.INSTANCE, STCommonProxy.GUI_PHASER_DRILL, worldObj,
			getEntityId(), 0, 0);
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
	//EXTREMELY IMPORTANT for any entity that can be left or right clicked.
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
		
		//count down from five
		if(countdownTicks % 20 == 0)
			operator.addChatComponentMessage(new ChatComponentText("Firing in " + (countdownTicks / 20)));
		
		if(countdownTicks-- != 0) return;
		
		worldObj.playSoundAtEntity(this, "startrekmod:phaser_blast", 1, 1);
		Entity blast = new EntityDrillBlast(worldObj, operator, this);
		worldObj.spawnEntityInWorld(blast);
	}

	//be warned that timer will stop on relog until
	//a player has interacted with the drill again
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
}
