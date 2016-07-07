package com.vulcanforge.startrekmod.entity;

import com.vulcanforge.startrekmod.entity.phaserblast.EntityPhaserBlastDrill;
import com.vulcanforge.startrekmod.items.STItem;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityPhaserDrill extends Entity
{
	EntityLivingBase controllingEntity;
	
	public EntityPhaserDrill(World world)
	{
		super(world);
	}
	
	public EntityPhaserDrill(World world, EntityPlayer player, double posX, double posY, double posZ)
	{
		super(world);
		setPosition(posX, posY, posZ);
		controllingEntity = player;
	}
	
	@Override
	public boolean interactFirst(EntityPlayer player)
	{
		if(!worldObj.isRemote)
		{
			EntityPhaserBlastDrill blast = new EntityPhaserBlastDrill(worldObj, player, this);
			worldObj.spawnEntityInWorld(blast);
		}
		
		return true;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource damage, float damageLevel)
	{
		if(!damage.isExplosion()) setDead();
		
		if(!worldObj.isRemote)
			this.dropItem(STItem.phaserDrill, 1);
		
		return true;
	}
	
	@Override
	public boolean canBeCollidedWith()
	{
		return true;
	}

	@Override
	protected void entityInit()
	{
		setSize(4F, 3F);		
	}
	
	@Override
	public void onUpdate()
	{
		if(controllingEntity != null)
			rotationYaw = controllingEntity.rotationYawHead;
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound reader) {}

	@Override
	protected void writeEntityToNBT(NBTTagCompound writer) {}
}
