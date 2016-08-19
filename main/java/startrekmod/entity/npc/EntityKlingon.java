package startrekmod.entity.npc;

import startrekmod.STItem;

import net.minecraft.entity.Entity;
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
	public void attackEntity(Entity entity, float damage)
	{
		entity.attackEntityFrom(DamageSource.causeMobDamage(this), damage);
	}

	@Override
	public boolean attackEntityAsMob(Entity target)
	{
		attackEntity(target, 4);
		return true;
	}

	@Override
	public void performInteract(EntityPlayer player)
	{}

	@Override
	public void setupAI()
	{
		super.setupAI();
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();

		speechBanks = new String[] {"bIHegh jIH", "ghargh vISop bongIlchugh?", "mInDu'wIj HoS DIvI'", "tlhIngan wo' SuvwI'", "SoHvaD laH moDbej. vabDot Saj targh", "largh SoH rur chal quvHa'", "tlhInganpu' 'ach HoS Segh lutu'lu'be'chugh."};
	}
}
