package startrekmod;

import java.util.ArrayList;
import java.util.List;
import startrekmod.entity.EntityPhaserDrill;
import startrekmod.gui.GuiPhaserDrill;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.*;

public abstract class CommonProxy implements IGuiHandler
{
	public static final int GUI_PHASER_DRILL = 0;
	
	public void init() {}
	
		@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
		int x, int y, int z)
	{
		switch(ID)
		{
		case GUI_PHASER_DRILL:
			return null;
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
		int x, int y, int z)
	{
		switch(ID)
		{
		case GUI_PHASER_DRILL:
			return new GuiPhaserDrill((EntityPhaserDrill)world.getEntityByID(x));
		}
		
		return null;
	}
}
