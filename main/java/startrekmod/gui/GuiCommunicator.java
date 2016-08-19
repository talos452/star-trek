package startrekmod.gui;

import startrekmod.STNetwork;
import startrekmod.network.packet.PacketCommunicator;

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
	public void initGui()
	{
		super.initGui();
		transport = new GuiButton(0, posX + 28, posY + 118, "Transport");
		buttonList.add(transport);
	}

	@Override
	protected void actionPerformed(GuiButton clicked)
	{
		int dimension = transportee.dimension == 0 ? 2 : 0;
		PacketCommunicator packet = new PacketCommunicator(dimension);
		STNetwork.network.sendToServer(packet);
		mc.displayGuiScreen(null);
	}
}
