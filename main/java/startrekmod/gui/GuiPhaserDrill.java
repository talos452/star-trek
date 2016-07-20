package com.vulcanforge.startrekmod.gui;

import org.lwjgl.opengl.GL11;

import vulcanforge.startrekmod.STMod;

import com.vulcanforge.startrekmod.entity.EntityPhaserDrill;
import com.vulcanforge.startrekmod.network.packet.*;

import net.minecraft.client.gui.*;
import net.minecraft.util.ResourceLocation;

public class GuiPhaserDrill extends STGui
{
	EntityPhaserDrill drill;
	GuiButton north, east, south, west, fire;
	
	public GuiPhaserDrill(EntityPhaserDrill drill)
	{
		super("guiPhaserDrill");
		this.drill = drill;
	}
	
	@Override
	public void initGui()
	{
		super.initGui();
		
		fire = new GuiButton(0, posX + 80, posY + 118, 96, 20, "Firing Sequence");
		north = new GuiButton(1, posX + 80, posY + 88, 96, 20, "Aim North");
		east = new GuiButton(2, posX, posY + 118, 72, 20, "Aim East");
		south = new GuiButton(3, posX + 80, posY + 148, 96, 20, "Aim South");
		west = new GuiButton(4, posX + 184, posY + 118, 72, 20, "Aim West");
		
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
		PacketPhaserDrill packet;
		
		if(clicked.id == 0)
			packet = new PacketPhaserDrill(true, 0, drill);
		else
			packet = new PacketPhaserDrill(false, clicked.id, drill);
		
		STMod.instance.network.sendToServer(packet);
	}
}
