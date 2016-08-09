package startrekmod.gui;

import net.minecraft.client.gui.GuiScreen;

public class STGui extends GuiScreen
{
	String textureName = "startrekmod:textures/gui/";
	int posX, posY;
	
	public STGui(String textureName)
	{
		this.textureName = "startrekmod:textures/gui/" + textureName + ".png";
	}
	
	@Override
	public void initGui()
	{
		//a 256x256 box drawn at posX, posY will center on the screen
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
