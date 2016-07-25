package startrekmod.entity.npc;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
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
		//guessing that .4 refers to blocks per second? I have no idea.
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4);
		//same for this value
		tasks.addTask(10, new EntityAIWander(this, 0.6));
        tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	}
	
	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
}
