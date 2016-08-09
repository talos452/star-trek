package startrekmod.items;

import net.minecraft.potion.Potion;

public class ItemGagh extends STItemFood
{
	public ItemGagh()
	{
		//6 food points, saturation .6
		super("gagh", 6, .6F);
		//counts in seconds rather than ticks for some reason
		//1F refers to probability of effect application
		setPotionEffect(Potion.confusion.id, 10, 0, 1F);
	}
}
