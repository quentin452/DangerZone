package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class CrystalCowInstance extends EntityCow {

    public CrystalCowInstance(World world) {
        super(world);
    }

    @Override
    protected void dropFewItems(final boolean par1, final int par2) {
        int itemCount = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
        for (int var4 = 0; var4 < itemCount; ++var4) {
            this.dropItem(ItemInitDangerZone.CrystalAppleItem, 1);
        }
        this.dropItem(Items.apple, 1);
        super.dropFewItems(par1, par2);
    }
}
