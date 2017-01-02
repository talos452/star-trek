package startrekmod.items;

import net.minecraft.potion.Potion;

public class ItemGagh extends STItemFood
{
    public ItemGagh ()
    {
        super ("gagh", 6, .6F);
        setPotionEffect (Potion.confusion.id, 10, 0, 1F);
    }
}
