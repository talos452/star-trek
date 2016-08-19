package startrekmod;

import startrekmod.entity.EntityPhaserDrill;
import startrekmod.gui.*;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;

public abstract class STCommonProxy implements IGuiHandler
{
	public static final int GUI_COMMUNICATOR = 1;
	public static final int GUI_PHASER_DRILL = 0;

	@Override
	public STGui getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		switch (ID)
		{
			case GUI_PHASER_DRILL:
				return new GuiPhaserDrill((EntityPhaserDrill)world.getEntityByID(x), player);
			case GUI_COMMUNICATOR:
				return new GuiCommunicator(player);
		}

		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		switch (ID)
		{
			case GUI_PHASER_DRILL:
				return null;
			case GUI_COMMUNICATOR:
				return null;
		}

		return null;
	}

	public void init()
	{}
}
