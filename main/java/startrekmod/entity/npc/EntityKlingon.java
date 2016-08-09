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
	protected void entityInit()
	{
		//without this call, DataWatcher throws a NullPointerException of some sort
		super.entityInit();
		
		speechBanks = new String[]
		{
			"bIHegh jIH",
			"ghargh vISop bongIlchugh?",
			"mInDu'wIj HoS DIvI'",
			"tlhIngan wo' SuvwI'",
			"SoHvaD laH moDbej. vabDot Saj targh",
			"largh SoH rur chal quvHa'",
			"tlhInganpu' 'ach HoS Segh lutu'lu'be'chugh."
		};
	}
	
	@Override
	public void setupAI()
	{
		super.setupAI();
		targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.6, true));
	}
	
	@Override
	public void attackEntity(Entity entity, float damage)
	{
		entity.attackEntityFrom(DamageSource.causeMobDamage(this), damage);
	}
	
	//required for AI
	@Override
	public boolean attackEntityAsMob(Entity target)
	{
		attackEntity(target, 4);
		return true;
	}

	@Override
	public void performInteract(EntityPlayer player) {}
}
