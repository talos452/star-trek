package startrekmod.gui;

import startrekmod.*;
import startrekmod.network.packet.PacketTransport;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;

public class GuiCommunicator extends STGui
{
	GuiButton transport;
	EntityPlayer transportee;

	public GuiCommunicator(EntityPlayer transportee)
	{
		super("guiTransporter");
		this.transportee = transportee;
	}

	@Override
	protected void actionPerformed(GuiButton clicked)
	{
		STNetwork.network.sendToServer(new PacketTransport(STGeneration.spaceDimensionID, transportee.dimension));
		mc.displayGuiScreen(null);
	}

	@Override
	public void initGui()
	{
		super.initGui();
		transport = new GuiButton(0, posX + 28, posY + 118, "Transport");
		buttonList.add(transport);
	}
}
