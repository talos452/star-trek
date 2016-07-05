package com.vulcanforge.startrekmod.entity;

import java.util.List;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityPhaserBlast extends EntityThrowable
{
	boolean hitOnce;
	boolean isRifle;
	int ticksInAir = 0;
	
	public EntityPhaserBlast(World w)
	{
		super(w);
	}
	
	public EntityPhaserBlast(World w, EntityLivingBase player, boolean rifle) 
	{
		super(w, player);
		setVelocity(motionX * 3, motionY * 3, motionZ * 3);
		isRifle = rifle;
	}
	
	public EntityPhaserBlast(World w, EntityLivingBase player, Entity drill)
	{
		super(w, player);
	}
	
	@Override
	protected float getGravityVelocity()
	{
		return 0F;
	}

	@Override
	protected void entityInit() {
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onImpact(MovingObjectPosition hitInfo) 
	{
		EntityPlayer shooter = (EntityPlayer)getThrower();
		
		if(shooter == null)
		{
			setDead();
			return;
		}
		
		if(isRifle)
			if(hitInfo.typeOfHit == MovingObjectType.BLOCK && worldObj.getBlock(hitInfo.blockX, hitInfo.blockY, hitInfo.blockZ).isBlockNormalCube())
				worldObj.createExplosion(shooter, hitInfo.blockX, hitInfo.blockY, hitInfo.blockZ, 4.0F, true);
			else if(hitInfo.typeOfHit == MovingObjectType.ENTITY)
				worldObj.createExplosion(shooter, hitInfo.entityHit.posX, hitInfo.entityHit.posY, hitInfo.entityHit.posZ, 4.0F, true);
		
		if(hitInfo.entityHit != null)
			if(isRifle)
				hitInfo.entityHit.attackEntityFrom(DamageSource.causePlayerDamage(shooter), 100);
			else
				hitInfo.entityHit.attackEntityFrom(DamageSource.causePlayerDamage(shooter), 10);
		
		if(hitInfo.typeOfHit == MovingObjectType.ENTITY || worldObj.getBlock(hitInfo.blockX, hitInfo.blockY, hitInfo.blockZ).isBlockNormalCube())
			setDead();
	}
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();
		
		if(++this.ticksInAir >= 100)
			this.setDead();
	}
}
