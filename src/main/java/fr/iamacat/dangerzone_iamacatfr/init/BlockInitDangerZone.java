package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.blocks.*;
import fr.iamacat.dangerzone_iamacatfr.items.CrystalFurnace;
import fr.iamacat.dangerzone_iamacatfr.materials.*;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;

public class BlockInitDangerZone {

    public static Block EnderPearlBlock;
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
    public static Block CrystalTorch;
    public static Block TeleportBlock;

    public static Block MobzillaScaleBlock;
    public static Block EyeOfEnderBlock;
    public static Block TrollBlock1;
    public static Block TrollBlock2;
    public static Block SaltOre;

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

        CrystalTorch = new CrystalTorch();

        CrystalTorch.setBlockName("CrystalTorch");

        TeleportBlock = new TeleportBlock();

        TeleportBlock.setBlockName("TeleportBlock");

        EnderPearlBlock = new EnderPearlBlock();
        EnderPearlBlock.setBlockName("EnderPearlBlock");

        MobzillaScaleBlock = new MobzillaScaleBlock();
        MobzillaScaleBlock.setBlockName("MobzillaScaleBlock");

        EyeOfEnderBlock = new EyeOfEnderBlock();
        EyeOfEnderBlock.setBlockName("EyeOfEnderBlock");

        TrollBlock1 = new TrollBlock1();
        TrollBlock1.setBlockName("TrollBlock1");

        TrollBlock2 = new TrollBlock2();
        TrollBlock2.setBlockName("TrollBlock2");

        SaltOre = new SaltOre();
        SaltOre.setBlockName("SaltOre");

    }

    public static void register() {

        GameRegistry.registerBlock(blocktorch, "ExtremeTorch");
        blocktorch.setLightLevel(15);
        GameRegistry.registerBlock(CrystalTorch, "CrystalTorch");
        CrystalTorch.setLightLevel(14);
        CrystalTorch.setBlockTextureName(Tags.MODID + ":crystaltorch");
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

        GameRegistry.registerBlock(TigersEyeBlockOre, "TigersEyeBlockOre");
        GameRegistry.registerBlock(AmethystBlockOre, "AmethystBlockOre");
        GameRegistry.registerBlock(RubyBlockOre, "RubyBlockOre");
        GameRegistry.registerBlock(TitaniumBlockOre, "TitaniumBlockOre");
        GameRegistry.registerBlock(UraniumBlockOre, "UraniumBlockOre");
        GameRegistry.registerBlock(TeleportBlock, "TeleportBlock");
        TeleportBlock.setBlockTextureName(Tags.MODID + ":blockteleport");

        GameRegistry.registerBlock(EnderPearlBlock, "EnderPearlBlock");
        GameRegistry.registerBlock(MobzillaScaleBlock, "MobzillaScaleBlock");
        GameRegistry.registerBlock(EyeOfEnderBlock, "EyeOfEnderBlock");
        GameRegistry.registerBlock(TrollBlock1, "TrollBlock1");
        GameRegistry.registerBlock(TrollBlock2, "TrollBlock2");
        GameRegistry.registerBlock(SaltOre, "SaltOre");

    }

}
