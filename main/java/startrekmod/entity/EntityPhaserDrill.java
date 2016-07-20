package com.vulcanforge.startrekmod.entity;

import vulcanforge.startrekmod.STMod;

import com.vulcanforge.startrekmod.entity.phaserblast.EntityPhaserBlastDrill;
import com.vulcanforge.startrekmod.items.STItem;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityPhaserDrill extends Entity
{
	public int countdownTicks = -1;
	EntityPlayer operator;
	
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
		
		player.openGui(STMod.instance, 0, worldObj, getEntityId(), 0, 0);
		return true;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource damage, float damageLevel)
	{
		if(worldObj.isRemote) return false;
		
		dropItem(STItem.phaserDrill, 1);
		setDead();
		return true;
	}
	
	//required to return true for player to punch or right-click
	@Override
	public boolean canBeCollidedWith()
	{
		return true;
	}

	//makes bounding box large enough
	@Override
	protected void entityInit()
	{
		setSize(4F, 3F);		
	}
	
	@Override
	public void onUpdate()
	{
		if(countdownTicks == -1) return;
		else if(countdownTicks-- != 0) return;
		
		EntityPhaserBlastDrill blast = new EntityPhaserBlastDrill(worldObj, operator, this);
		worldObj.spawnEntityInWorld(blast);
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound reader) {}

	@Override
	protected void writeEntityToNBT(NBTTagCompound writer) {}
}
