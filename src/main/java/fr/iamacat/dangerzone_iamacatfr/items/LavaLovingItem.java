
package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class LavaLovingItem extends EntityItem {

    public LavaLovingItem(final World par1World, final double par2, final double par4, final double par6,
        final ItemStack par8ItemStack) {
        super(par1World, par2, par4, par6, par8ItemStack);
        this.fireResistance = 300;
        this.isImmuneToFire = true;
        this.hurtResistantTime = 300;
    }

    public void noFire() {
        this.fireResistance = 300;
        this.isImmuneToFire = true;
        this.hurtResistantTime = 300;
    }

    public void yesFire() {
        this.fireResistance = 0;
        this.isImmuneToFire = false;
        this.hurtResistantTime = 0;
    }

    protected void dealFireDamage(final float par1) {
        if (!this.isImmuneToFire) {
            this.attackEntityFrom(DamageSource.inFire, par1);
        }
    }
}
