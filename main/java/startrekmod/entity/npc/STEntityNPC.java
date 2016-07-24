package startrekmod.entity.npc;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.world.World;

public abstract class STEntityNPC extends EntityCreature
{
	public STEntityNPC(World world)
	{
		super(world);
		setupAI();
	}
	
	public void setupAI()
	{
		tasks.addTask(10, new EntityAIWander(this, 0.2));
	}
	
	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
}
