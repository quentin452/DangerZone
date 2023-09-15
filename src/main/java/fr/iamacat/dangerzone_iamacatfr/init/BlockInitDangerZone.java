package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.blocks.*;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;

public class BlockInitDangerZone {

    public static Block blocktorch;
    public static Block BrownAntNest;
    public static Block RainbowAntNest;
    public static Block RedAntNest;
    public static Block UnstablenAntNest;
    public static Block TermiteNest;

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
    }

    public static void register() {

        GameRegistry.registerBlock(blocktorch, "ExtremeTorch");
        blocktorch.setLightLevel(15);
        GameRegistry.registerBlock(BrownAntNest, "BrownAntNest");
        GameRegistry.registerBlock(RainbowAntNest, "RainbowAntNest");
        GameRegistry.registerBlock(RedAntNest, "RedAntNest");
        GameRegistry.registerBlock(UnstablenAntNest, "UnstableAntNest");
        GameRegistry.registerBlock(TermiteNest, "TermiteNest");
    }

}
