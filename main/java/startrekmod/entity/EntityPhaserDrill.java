package startrekmod.entity;

import java.util.UUID;

import startrekmod.CommonProxy;
import startrekmod.STMod;
import startrekmod.entity.phaserblast.EntityPhaserBlastDrill;
import startrekmod.items.STItem;
import startrekmod.util.DirectionMode;
import cpw.mods.fml.common.FMLLog;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityPhaserDrill extends Entity
{
	public int countdownTicks = -1;
	EntityPlayer operator;
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
		
		player.openGui(STMod.INSTANCE, CommonProxy.GUI_PHASER_DRILL, worldObj, getEntityId(), 0, 0);
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
		setSize(2.75F, 2.25F);		
	}
	
	@Override
	public void onUpdate()
	{
		if(operator == null && !worldObj.isRemote)
		{
			setDead();
			return;
		}
		
		if(countdownTicks == -1) return;		
		if(countdownTicks % 20 == 0)
			operator.addChatComponentMessage(new ChatComponentText("Firing in " + (countdownTicks / 20)));		
		if(countdownTicks-- != 0) return;
		
		Entity blast = new EntityPhaserBlastDrill(worldObj, operator, this);
		worldObj.spawnEntityInWorld(blast);
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound reader)
	{
		countdownTicks = reader.getInteger("FireTick");
		String uuid = reader.getString("OperatorUUID");
		
		if(!uuid.isEmpty())
			//func_152378_a returns the player with given UUID
			operator = worldObj.func_152378_a(UUID.fromString(uuid));
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound writer)
	{
		writer.setInteger("FireTick", countdownTicks);
		
		if(operator != null)
			writer.setString("OperatorUUID", operator.getUniqueID().toString());
	}
	
	public void setDirection(DirectionMode direction)
	{
		rotationYaw = direction.angle; //for rendering purposes
		this.direction = direction; //for firing purposes
	}
}
