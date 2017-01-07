package startrekmod.gui;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

import startrekmod.*;
import startrekmod.network.packet.PacketTransport;

import net.minecraft.client.gui.GuiButton;

public class GuiCommunicator extends STGui
{
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
        
        GuiButton[] transport = new GuiButton[STDimension.dimensionTable.size () + 1];
        Iterator<Entry<String, STDimension>> dimensions = STDimension.tableIterator ();
        
        for (int i = 1; i < transport.length; i++)
        {
            transport[i] = new GuiButton (i, posX + 28, i * 25, dimensions.next ().getKey ());
            buttonList.add (transport[i]);
        }
        
        transport[0] = new GuiButton (0, posX + 28, 0, "Earth");
        buttonList.add (transport[0]);
    }

    @Override
    protected void actionPerformed (GuiButton clicked)
    {
        mc.displayGuiScreen (null);
        
        if (clicked.id == 0)
            STNetwork.network.sendToServer (new PacketTransport (0, dimensionID));
        else
            STNetwork.network.sendToServer (new PacketTransport (STDimension.dimensionTable.get (clicked.displayString).getDimensionID (), dimensionID));
    }
}
