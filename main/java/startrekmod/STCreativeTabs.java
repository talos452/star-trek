package startrekmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class STCreativeTabs extends CreativeTabs
{
	Item icon;
	
	public static CreativeTabs tabSTBlocks;
	public static CreativeTabs tabSTItems;
	public static CreativeTabs tabSTEggs;
	public static CreativeTabs tabSTHuman;
	public static CreativeTabs tabSTKlingon;
	
	public STCreativeTabs(String lable, Item icon)
	{
		super(lable);
		this.icon = icon;
	}

	@Override
	public Item getTabIconItem()
	{
		return icon;
	}
	
	public static void preinit()
	{
		tabSTBlocks = new STCreativeTabs("tabSTBlocks", Item.getItemFromBlock(STBlock.dilithiumBlock));
		tabSTItems = new STCreativeTabs("tabSTItems", STItem.dilithiumCrystal);
		tabSTEggs = new STCreativeTabs("tabSTEggs", Items.egg);
		tabSTHuman = new STCreativeTabs("tabSTHuman", STItem.phaserII);
		tabSTKlingon = new STCreativeTabs("tabSTKlingon", STItem.batleth);
	}
}
