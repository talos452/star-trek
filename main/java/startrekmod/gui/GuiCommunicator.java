package startrekmod.gui;

import startrekmod.*;
import startrekmod.network.packet.PacketTransport;

import net.minecraft.client.gui.GuiButton;

public class GuiCommunicator extends STGui
{
    GuiButton transport;
    int transporteeID;
    int dimensionID;

    public GuiCommunicator (int transporteeID, int dimensionID)
    {
        super ("guiTransporter");
        this.transporteeID = transporteeID;
        this.dimensionID = dimensionID;
    }

    @Override
    public void initGui ()
    {
        super.initGui ();
        transport = new GuiButton (0, posX + 28, posY + 118, "Transport");
        buttonList.add (transport);
    }

    @Override
    protected void actionPerformed (GuiButton clicked)
    {
        mc.displayGuiScreen (null);
        int space = STDimension.dimensionTable.get ("space").getDimensionID ();

        if (dimensionID != space)
            STNetwork.network.sendToServer (new PacketTransport (space, dimensionID));
        else STNetwork.network.sendToServer (new PacketTransport (0, space));
    }
}
