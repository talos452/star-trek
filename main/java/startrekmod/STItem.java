package startrekmod;

import startrekmod.entity.energyblast.*;
import startrekmod.items.*;

import net.minecraft.item.Item;

import cpw.mods.fml.common.registry.GameRegistry;

public class STItem extends Item
{
    public static Item batleth;
    public static Item communicator;
    public static Item dilithiumCrystal;
    public static Item disrupterKlingon;
    public static Item dktahg;
    public static Item duraniumIngot;
    public static Item gagh;
    public static Item goldLatinum;
    public static Item latinumIngot;
    public static Item painStick;
    public static Item phaserDrill;
    public static Item phaserII;
    public static Item phaserIII;
    public static Item powerCell;
    public static Item spawnKlingon;

    public STItem (String textureName)
    {
        super ();
        setTextureName (STMod.MODID + ":" + textureName);
        setUnlocalizedName (textureName);
        GameRegistry.registerItem (this, textureName);
    }

    public static void preinit ()
    {
        phaserII = new ItemEnergyWeapon ("phaser", EntityPhaserBlastStun.class, 400);
        phaserIII = new ItemEnergyWeapon ("phaser_rifle", EntityPhaserBlastKill.class, 100);
        powerCell = new STItem ("power_cell");
        duraniumIngot = new STItem ("duranium_ingot");
        latinumIngot = new STItem ("latinum_ingot");
        dilithiumCrystal = new STItem ("dilithium_crystal");
        goldLatinum = new STItem ("gold_pressed_latinum");
        batleth = new STItemSword ("batleth", 8, -1);
        phaserDrill = new ItemPhaserDrill ("phaser_drill");
        gagh = new ItemGagh ();
        dktahg = new STItemSword ("dktahg", 6, -1);
        spawnKlingon = new ItemSpawnEgg ("Klingon");
        painStick = new ItemPainStick ();
        disrupterKlingon = new ItemEnergyWeapon ("klingon_disruptor", EntityDisruptorBlastKill.class, 100);
        communicator = new ItemCommunicator ();
    }

    public static void init ()
    {
        phaserII.setCreativeTab (STCreativeTabs.tabSTHuman);
        phaserIII.setCreativeTab (STCreativeTabs.tabSTHuman);
        batleth.setCreativeTab (STCreativeTabs.tabSTKlingon);
        powerCell.setCreativeTab (STCreativeTabs.tabSTItems);
        duraniumIngot.setCreativeTab (STCreativeTabs.tabSTItems);
        latinumIngot.setCreativeTab (STCreativeTabs.tabSTItems);
        dilithiumCrystal.setCreativeTab (STCreativeTabs.tabSTItems);
        goldLatinum.setCreativeTab (STCreativeTabs.tabSTItems);
        phaserDrill.setCreativeTab (STCreativeTabs.tabSTHuman);
        gagh.setCreativeTab (STCreativeTabs.tabSTKlingon);
        dktahg.setCreativeTab (STCreativeTabs.tabSTKlingon);
        spawnKlingon.setCreativeTab (STCreativeTabs.tabSTEggs);
        painStick.setCreativeTab (STCreativeTabs.tabSTKlingon);
        disrupterKlingon.setCreativeTab (STCreativeTabs.tabSTKlingon);
        communicator.setCreativeTab (STCreativeTabs.tabSTItems);
    }
}
