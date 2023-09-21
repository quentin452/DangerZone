
package danger.orespawn.entities.entityinstance;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class RedCow extends EntityCow {

    public RedCow(final World world) {
        super(world);
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        for (int var3 = this.rand.nextInt(3) + this.rand.nextInt(1 + par2), var4 = 0; var4 < var3; ++var4) {
            this.dropItem(Items.apple, 1);
        }
        super.dropFewItems(par1, par2);
    }

    public EntityCow createChild(final EntityAgeable entityageable) {
        return this.spawnBabyAnimal(entityageable);
    }

    public RedCow spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new RedCow(this.worldObj);
    }

    protected void updateAITick() {
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.setRevengeTarget(null);
        }
        super.updateAITick();
    }

    protected boolean canDespawn() {
        return false;
    }
}
