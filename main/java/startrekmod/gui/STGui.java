package startrekmod.gui;

import startrekmod.STMod;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class STGui extends GuiScreen
{
	String textureName = "startrekmod:textures/gui/";
	int posX, posY;
	
	public STGui(String textureName)
	{
		this.textureName += (textureName + ".png");
	}
	
	@Override
	public void initGui()
	{
		posX = width / 2 - 128;
		posY = height / 2 - 128;
	}
	
	@Override
	public void drawScreen(int mousePosX, int mousePosY, float f3)
	{
		drawDefaultBackground();
		super.drawScreen(mousePosX, mousePosY, f3);
	}
	
	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}
