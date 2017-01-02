package startrekmod.entity.npc;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public abstract class STEntityNPC extends EntityCreature
{
    int lastSpeechIndex;
    static String[] speechBanks;

    protected STEntityNPC (World world)
    {
        super (world);
        setupAI ();
        lastSpeechIndex = 0;
    }

    @Override
    protected boolean interact (EntityPlayer player)
    {
        if (!worldObj.isRemote)
        {
            speakToPlayer (player);
            return true;
        }

        return false;
    }

    protected void speakToPlayer (EntityPlayer player)
    {
        int index = rand.nextInt (speechBanks.length);

        if (lastSpeechIndex == index)
            index = (index + 1) % speechBanks.length;

        lastSpeechIndex = index;
        player.addChatComponentMessage (new ChatComponentText (speechBanks[index]));
    }

    protected void setupAI ()
    {
        getEntityAttribute (SharedMonsterAttributes.movementSpeed).setBaseValue (0.6);
        tasks.addTask (10, new EntityAIWander (this, 0.6));
        tasks.addTask (5, new EntityAIWatchClosest (this, EntityPlayer.class, 8.0F));
        tasks.addTask (10, new EntityAISwimming (this));
    }

    protected abstract void performInteract (EntityPlayer player);

    @Override
    final protected boolean isAIEnabled ()
    {
        return true;
    }
}
