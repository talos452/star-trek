package startrekmod;

import startrekmod.entity.EntityPhaserDrill;
import startrekmod.gui.*;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;

/**
 * Provides GUI/Container lookup functionality.
 * Initializes components required on both sides.
 */
public abstract class STCommonProxy implements IGuiHandler
{
	//GUI IDs for registration purposes
	public static final int GUI_PHASER_DRILL = 0;
	public static final int GUI_COMMUNICATOR = 1;
	
	/**
	 * Currently unimplemented.
	 */
	public void init() {}
	
	/*
	 * x, y, and z usually refer to tile entity coordinates when the below methods are called from tile entities.
	 * They can be used to enter any kind of data in other cases, or simply fed 0.
	 */
	
	/**
	 * Returns a container registered to ID if any exists.
	 */
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
		int x, int y, int z)
	{
		switch(ID)
		{
		case GUI_PHASER_DRILL:
			return null;
		case GUI_COMMUNICATOR:
			return null;
		}
		
		return null;
	}

	/**
	 * Returns a GUI registered to ID if any exists
	 */
	@Override
	public STGui getClientGuiElement(int ID, EntityPlayer player, World world,
		int x, int y, int z)
	{
		switch(ID)
		{
		case GUI_PHASER_DRILL:
			//GuiPhaserDrill only utilizes the first parameter
			return new GuiPhaserDrill((EntityPhaserDrill)world.getEntityByID(x), player);
		case GUI_COMMUNICATOR:
			//GuiCommunicator utilizes no parameters
			return new GuiCommunicator(player);
		}
		
		return null;
	}
}
