package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.blocks.*;
import fr.iamacat.dangerzone_iamacatfr.blocks.CreeperRepellent;
import fr.iamacat.dangerzone_iamacatfr.items.CrystalFurnace;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;

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
        ContainerCrystalFurnaceBlock = new CrystalFurnace(
            212,
            false,
            2.0f,
            10.0f).setBlockName("crystalfurnace");

        ContainerCrystalFurnaceOnBlock = new CrystalFurnace(213, true, 2.0f, 10.0f)
            .setBlockName("crystalfurnace");
        CrystalWorkbench = new CrystalWorkbench()
            .setBlockName("crystalworkbench");

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
    }

}
