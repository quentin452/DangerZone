package fr.iamacat.dangerzone_iamacatfr.materials;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
// todo , make can kill ants/termite when moving on salt ore
public class SaltOre extends Block {


    public SaltOre() {
        super(Material.rock);
        this.setHardness(10.0f);
        this.setResistance(4.0f);
        this.setBlockTextureName(Tags.MODID + ":SaltOre");
    }

    public void onEntityCollidedWithBlock(final World par1World, final int par2, final int par3, final int par4,
                                          final Entity par5Entity) {
        if (isAntEntity(par5Entity)) {
            par5Entity.attackEntityFrom(DamageSource.cactus, Float.MAX_VALUE);
        }
    }

    public void onEntityWalking(final World par1World, final int par2, final int par3, final int par4,
                                final Entity par5Entity) {
        if (isAntEntity(par5Entity)) {
            par5Entity.attackEntityFrom(DamageSource.cactus, Float.MAX_VALUE);
        }
    }

    private boolean isAntEntity(Entity entity) {
        return entity instanceof BrownAntInstance || entity instanceof UnstableAntInstance || entity instanceof RainbowAntInstance || entity instanceof RedAntInstance || entity instanceof TermiteInstance;
    }


}
