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
	EntityPlayer ep;
	int ticksInAir = 100;
	
	public EntityPhaserBlast(World w)
	{
		super(w);
	}
	
	public EntityPhaserBlast(World w, EntityLivingBase player, boolean rifle) 
	{
		super(w, player);
		setRotation(player.rotationYawHead, player.rotationPitch);
		setVelocity(motionX * 3, motionY * 3, motionZ * 3);
		isRifle = rifle;
		ep = (EntityPlayer)player;
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

	protected void onImpact(MovingObjectPosition hitInfo) 
	{
		if(isRifle)
			if(hitInfo.typeOfHit == MovingObjectType.BLOCK)
				worldObj.createExplosion(ep, hitInfo.blockX, hitInfo.blockY, hitInfo.blockZ, 4.0F, true);
			else
				worldObj.createExplosion(ep, hitInfo.entityHit.posX, hitInfo.entityHit.posY, hitInfo.entityHit.posZ, 4.0F, true);
		
		if(hitInfo.entityHit != null)
			if(isRifle)
				hitInfo.entityHit.attackEntityFrom(DamageSource.causePlayerDamage(ep), 100);
			else
				hitInfo.entityHit.attackEntityFrom(DamageSource.causePlayerDamage(ep), 12);
		
		setDead();
	}

	@Override
	public void setThrowableHeading(double x, double y,
			double z, float speed, float dummy) 
	{
		this.motionX = x * Math.sqrt(speed);
		this.motionY = y * Math.sqrt(speed);
		this.motionZ = z * Math.sqrt(speed);
	}
}
