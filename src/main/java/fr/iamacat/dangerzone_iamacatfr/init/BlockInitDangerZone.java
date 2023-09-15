package fr.iamacat.dangerzone_iamacatfr.init;

import fr.iamacat.dangerzone_iamacatfr.materials.*;
import net.minecraft.block.Block;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.blocks.*;
import fr.iamacat.dangerzone_iamacatfr.items.CrystalFurnace;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class BlockInitDangerZone {

    public static Block blocktorch;
    public static Block BrownAntNest;
    public static Block RainbowAntNest;
    public static Block RedAntNest;
    public static Block UnstablenAntNest;
    public static Block TermiteNest;
    public static Block CreeperRepellent;
    public static Block CrystalWorkbench;
    public static Block ContainerCrystalFurnaceBlock;

    public static Block ContainerCrystalFurnaceOnBlock;

    public static Block AmethystBlock;
    public static Block TigersEyeBlock;
    public static Block RubyBlock;
    public static Block TitaniumBlock;
    public static Block UraniumBlock;
    public static Block PinkTourmalineBlock;

    public static Block AmethystBlockOre;
    public static Block TigersEyeBlockOre;
    public static Block RubyBlockOre;
    public static Block TitaniumBlockOre;
    public static Block UraniumBlockOre;
    public static void init() {

        blocktorch = new ExtremeTorch();

        blocktorch.setBlockName("ExtremeTorch");
        blocktorch.setBlockTextureName(Tags.MODID + ":extreme_torch");

        BrownAntNest = new BrownAntNest();

        BrownAntNest.setBlockName("BrownAntNest");

        RainbowAntNest = new RainbowAntNest();

        RainbowAntNest.setBlockName("RainbowAntNest");
        RedAntNest = new RedAntNest();

        RedAntNest.setBlockName("RedAntNest");
        UnstablenAntNest = new UnstableAntNest();

        UnstablenAntNest.setBlockName("UnstableAntNest");

        TermiteNest = new TermiteAntNest();

        TermiteNest.setBlockName("TermiteAntNest");

        CreeperRepellent = new CreeperRepellent();

        CreeperRepellent.setBlockName("CreeperRepelent");
        ContainerCrystalFurnaceBlock = new CrystalFurnace(212, false, 2.0f, 10.0f).setBlockName("crystalfurnace");

        ContainerCrystalFurnaceOnBlock = new CrystalFurnace(213, true, 2.0f, 10.0f).setBlockName("crystalfurnace");
        CrystalWorkbench = new CrystalWorkbench().setBlockName("crystalworkbench");

        TigersEyeBlock = new TigersEyeBlock();

        TigersEyeBlock.setBlockName("TigersEyeBlock");

        AmethystBlock = new AmethystBlock();

        AmethystBlock.setBlockName("AmethystBlock");

        RubyBlock = new RubyBlock();

        RubyBlock.setBlockName("RubyBlock");

        TitaniumBlock = new TitaniumBlock();

        TitaniumBlock.setBlockName("TitaniumBlock");

        UraniumBlock = new UraniumBlock();

        UraniumBlock.setBlockName("UraniumBlock");

        PinkTourmalineBlock = new PinkTourmalineBlock();

        PinkTourmalineBlock.setBlockName("PinkTourmalineBlock");

        TigersEyeBlockOre = new TigersEyeOre();

        TigersEyeBlockOre.setBlockName("TigersEyeBlockOre");

        AmethystBlockOre = new AmethystOre();

        AmethystBlockOre.setBlockName("AmethystBlockOre");

        RubyBlockOre = new RubyOre();

        RubyBlockOre.setBlockName("RubyBlockOre");

        TitaniumBlockOre = new TitaniumOre();

        TitaniumBlockOre.setBlockName("TitaniumBlockOre");

        UraniumBlockOre = new UraniumOre();

        UraniumBlockOre.setBlockName("UraniumBlockOre");

    }

    public static void register() {

        GameRegistry.registerBlock(blocktorch, "ExtremeTorch");
        blocktorch.setLightLevel(15);
        GameRegistry.registerBlock(BrownAntNest, "BrownAntNest");
        GameRegistry.registerBlock(RainbowAntNest, "RainbowAntNest");
        GameRegistry.registerBlock(RedAntNest, "RedAntNest");
        GameRegistry.registerBlock(UnstablenAntNest, "UnstableAntNest");
        GameRegistry.registerBlock(TermiteNest, "TermiteNest");
        GameRegistry.registerBlock(CreeperRepellent, "CreeperRepelent");
        GameRegistry.registerBlock(ContainerCrystalFurnaceBlock, "CrystalFurnaceBlock");
        GameRegistry.registerBlock(ContainerCrystalFurnaceOnBlock, "CrystalFurnaceOnBlock");
        GameRegistry.registerBlock(CrystalWorkbench, "CrystalWorkbenchBlock");
        GameRegistry.registerBlock(TigersEyeBlock, "TigersEyeBlock");
        GameRegistry.registerBlock(AmethystBlock, "AmethystBlock");
        GameRegistry.registerBlock(RubyBlock, "RubyBlock");
        GameRegistry.registerBlock(TitaniumBlock, "TitaniumBlock");
        GameRegistry.registerBlock(UraniumBlock, "UraniumBlock");
        GameRegistry.registerBlock(PinkTourmalineBlock, "PinkTourmalineBlock");

        GameRegistry.registerBlock(TigersEyeBlockOre,"TigersEyeBlockOre");
        GameRegistry.registerBlock(AmethystBlockOre, "AmethystBlockOre");
        GameRegistry.registerBlock(RubyBlockOre, "RubyBlockOre");
        GameRegistry.registerBlock(TitaniumBlockOre, "TitaniumBlockOre");
        GameRegistry.registerBlock(UraniumBlockOre, "UraniumBlockOre");

    }

}