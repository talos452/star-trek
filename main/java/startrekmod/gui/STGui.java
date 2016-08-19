package startrekmod.gui;

import net.minecraft.client.gui.GuiScreen;

public class STGui extends GuiScreen
{
	int posX, posY;
	String textureName;

	public STGui(String textureName)
	{
		this.textureName = "startrekmod:textures/gui/" + textureName + ".png";
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}

	@Override
	public void drawScreen(int mousePosX, int mousePosY, float f3)
	{
		drawDefaultBackground();
		super.drawScreen(mousePosX, mousePosY, f3);
	}

	@Override
	public void initGui()
	{
		posX = width / 2 - 128;
		posY = height / 2 - 128;
	}
}
