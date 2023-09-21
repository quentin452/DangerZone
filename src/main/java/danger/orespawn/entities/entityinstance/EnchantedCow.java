
package danger.orespawn.entities.entityinstance;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EnchantedCow extends RedCow {

    public EnchantedCow(final World world) {
        super(world);
    }

    private void dropEnchantedGoldenApple() {
        final EntityItem var3 = new EntityItem(
            this.worldObj,
            this.posX,
            this.posY + 1.0,
            this.posZ,
            new ItemStack(Items.golden_apple, 1, 1));
        this.worldObj.spawnEntityInWorld(var3);
    }

    @Override
    protected void dropFewItems(final boolean par1, final int par2) {
        for (int var3 = this.rand.nextInt(4) + this.rand.nextInt(1 + par2), var4 = 0; var4 < var3; ++var4) {
            this.dropItem(Items.apple, 1);
        }
        this.dropItem(Items.golden_apple, 2);
        this.dropEnchantedGoldenApple();
        super.dropFewItems(par1, par2);
    }

    @Override
    public EntityCow createChild(final EntityAgeable entityageable) {
        return this.spawnBabyAnimal(entityageable);
    }

    @Override
    public EnchantedCow spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new EnchantedCow(this.worldObj);
    }
}
