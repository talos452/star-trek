package startrekmod;

import startrekmod.graphics.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy
{
	@Override
	public void init()
	{
		super.init();
		STGraphics.init();
	}	
}
