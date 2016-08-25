package startrekmod.items;

import startrekmod.STItem;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.*;

import com.google.common.collect.Multimap;

public class STItemSword extends STItem
{
	double damage;

	public STItemSword(String textureName, double damage, int uses)
	{
		super (textureName);
		this.damage = damage;
		setMaxDamage (uses);
	}

	@Override
	public Multimap getItemAttributeModifiers()
	{
		Multimap multimap = super.getItemAttributeModifiers ();
		multimap.put (SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName (), new AttributeModifier (field_111210_e, "Weapon modifier", damage, 0));
		return multimap;
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase attacked, EntityLivingBase attacker)
	{
		stack.damageItem (1, attacked);
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}
}
