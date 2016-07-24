package startrekmod.gui;

import startrekmod.STNetwork;
import startrekmod.entity.EntityPhaserDrill;
import startrekmod.network.packet.PacketPhaserDrill;
import startrekmod.util.DirectionMode;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;

import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class GuiPhaserDrill extends STGui
{
	EntityPhaserDrill drill;
	EntityPlayer operator;
	GuiButton north, east, south, west, fire;
	
	public GuiPhaserDrill(EntityPhaserDrill drill, EntityPlayer operator)
	{
		super("guiPhaserDrill");
		this.drill = drill;
		this.operator = operator;
	}
	
	@Override
	public void initGui()
	{
		super.initGui();
		
		fire = new GuiButton(1, posX + 80, posY + 118, 96, 20, "Firing Sequence");
		north = new GuiButton(180, posX + 80, posY + 88, 96, 20, "Aim North");
		east = new GuiButton(270, posX, posY + 118, 72, 20, "Aim East");
		south = new GuiButton(0, posX + 80, posY + 148, 96, 20, "Aim South");
		west = new GuiButton(90, posX + 184, posY + 118, 72, 20, "Aim West");
		
		buttonList.add(fire);
		buttonList.add(north);
		buttonList.add(east);
		buttonList.add(south);
		buttonList.add(west);
	}
	
	@Override
	public void drawScreen(int mousePosX, int mousePosY, float f3)
	{
		super.drawScreen(mousePosX, mousePosY, f3);
		fontRendererObj.drawString("Targetting Display", posX + 80, posY + 64, 0xFFFFFFFF);
	}
	
	@Override
	public void actionPerformed(GuiButton clicked)
	{
		IMessage packet;
		
		if(clicked.id == 1)
			packet = new PacketPhaserDrill(null, drill, operator);
		else
			packet = new PacketPhaserDrill(DirectionMode.fromAngle(clicked.id), drill, operator);
		
		STNetwork.network.sendToServer(packet);
		mc.displayGuiScreen(null);
	}
}
