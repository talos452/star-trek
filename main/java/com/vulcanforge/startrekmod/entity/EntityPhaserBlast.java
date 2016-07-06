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

public abstract class EntityPhaserBlast extends EntityThrowable
{
	int ticksInAir = 0;
	
	public EntityPhaserBlast(World w)
	{
		super(w);
	}
	
	protected EntityPhaserBlast(World w, EntityLivingBase player) 
	{
		super(w, player);
		setVelocity(motionX * 3, motionY * 3, motionZ * 3);
	}
	
	@Override
	protected float getGravityVelocity()
	{
		return 0F;
	}

	@Override
	protected abstract void onImpact(MovingObjectPosition hitInfo) ;
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();
		
		if(++this.ticksInAir >= 100)
			this.setDead();
	}
}
