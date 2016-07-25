package startrekmod;

import startrekmod.entity.EntityPhaserDrill;
import startrekmod.gui.GuiPhaserDrill;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;

public abstract class STCommonProxy implements IGuiHandler
{
	//GUI IDs for registration purposes
	public static final int GUI_PHASER_DRILL = 0;
	
	public void init() {}
	
	/*
	 * x, y, and z usually refer to tile entity coordinates
	 * when the below methods are called from tile entities.
	 * They can be used to enter any kind of data, or
	 * simply ignored.
	 */
	
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
			return new GuiPhaserDrill((EntityPhaserDrill)world.getEntityByID(x), player);
		}
		
		return null;
	}
}
