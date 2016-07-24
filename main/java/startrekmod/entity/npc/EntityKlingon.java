package startrekmod.entity.npc;

import startrekmod.STItem;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityKlingon extends STEntityNPC
{
	public EntityKlingon(World world)
	{
		super(world);
		setCurrentItemOrArmor(0, new ItemStack(STItem.batleth));
	}
	
	@Override
	public void setupAI()
	{
		super.setupAI();
		targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.4, true));
        tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	}
	
	@Override
	public void attackEntity(Entity entity, float damage)
	{
		entity.attackEntityFrom(DamageSource.causeMobDamage(this), damage);
	}
	
	@Override
	public Entity findPlayerToAttack()
    {
        EntityPlayer entityplayer = worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
        return entityplayer != null && canEntityBeSeen(entityplayer) ? entityplayer : null;
    }
	
	@Override
	public boolean attackEntityAsMob(Entity target)
	{
		attackEntity(target, 4);
		return true;
	}
}
