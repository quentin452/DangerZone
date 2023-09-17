

package fr.iamacat.dangerzone_iamacatfr.api;

import com.google.common.base.Optional;
import net.minecraft.block.Block;

public enum BlockList
{
    instance;

    public static Optional<? extends Block> palmHoloTree;
    public static Optional<? extends Block> aloeVera;
    public static Optional<? extends Block> wateredDirt;
    public static Optional<? extends Block> tumbleweed;
    public static Optional<? extends Block> jasper;
    public static Optional<? extends Block> palmTreeLog;
    public static Optional<? extends Block> palmTreePlank;
    public static Optional<? extends Block> palmTreeSlab;
    public static Optional<? extends Block> palmTreeDoubleSlab;
    public static Optional<? extends Block> palmTreeStairs;
    public static Optional<? extends Block> palmTreeLeaves;
    public static Optional<? extends Block> palmTreeSapling;
    public static Optional<? extends Block> coconut;
    public static Optional<? extends Block> nightBloom;
    public static Optional<? extends Block> creeperBlossom;
    public static Optional<? extends Block> spawnerGrass;
    public static Optional<? extends Block> quickSand;
    public static Optional<? extends Block> spike_ivory;
    public static Optional<? extends Block> spike_wood;
    public static Optional<? extends Block> spike_stone;
    public static Optional<? extends Block> spike_iron;
    public static Optional<? extends Block> campfire;
    public static Optional<? extends Block> mobHeads;
    public static Optional<? extends Block> tombstone;
    public static Optional<? extends Block> universalFlowerPot;
    public static Optional<? extends Block> customBrewingStand;
    public static Optional<? extends Block> limitedMobSpawner;
    public static Optional<? extends Block> brewingStandSingle;
    public static Optional<? extends Block> brewingStandTriple;

    static {
        BlockList.palmHoloTree = Optional.absent();
        BlockList.aloeVera = Optional.absent();
        BlockList.wateredDirt = Optional.absent();
        BlockList.tumbleweed =Optional.absent();
        BlockList.jasper = Optional.absent();
        BlockList.palmTreeLog = Optional.absent();
        BlockList.palmTreePlank = Optional.absent();
        BlockList.palmTreeSlab =  Optional.absent();
        BlockList.palmTreeDoubleSlab =  Optional.absent();
        BlockList.palmTreeStairs =  Optional.absent();
        BlockList.palmTreeLeaves = Optional.absent();
        BlockList.palmTreeSapling = Optional.absent();
        BlockList.coconut = Optional.absent();
        BlockList.nightBloom =  Optional.absent();
        BlockList.creeperBlossom =  Optional.absent();
        BlockList.spawnerGrass = Optional.absent();
        BlockList.quickSand =  Optional.absent();
        BlockList.spike_ivory = Optional.absent();
        BlockList.spike_wood = Optional.absent();
        BlockList.spike_stone = Optional.absent();
        BlockList.spike_iron = Optional.absent();
        BlockList.campfire =  Optional.absent();
        BlockList.mobHeads = Optional.absent();
        BlockList.tombstone = Optional.absent();
        BlockList.universalFlowerPot =  Optional.absent();
        BlockList.customBrewingStand = Optional.absent();
        BlockList.limitedMobSpawner =  Optional.absent();
        BlockList.brewingStandSingle =  Optional.absent();
        BlockList.brewingStandTriple =  Optional.absent();
    }
}
