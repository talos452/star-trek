package startrekmod.gui;

import startrekmod.*;
import startrekmod.network.packet.PacketTransport;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;

public class GuiCommunicator extends STGui
{
	GuiButton transport;
	EntityPlayer transportee;

	public GuiCommunicator (EntityPlayer transportee)
	{
		super ("guiTransporter");
		this.transportee = transportee;
	}

	@Override
	protected void actionPerformed (GuiButton clicked)
	{
		mc.displayGuiScreen (null);
		int space = STDimension.dimensionTable.get ("space").getDimensionID ();

		if (transportee.dimension == space) return;

		STNetwork.network.sendToServer (new PacketTransport (space, transportee.dimension));
	}

	@Override
	public void initGui ()
	{
		super.initGui ();
		transport = new GuiButton (0, posX + 28, posY + 118, "Transport");
		buttonList.add (transport);
	}
}
