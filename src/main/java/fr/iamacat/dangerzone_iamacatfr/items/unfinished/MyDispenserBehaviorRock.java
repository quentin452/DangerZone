
package fr.iamacat.dangerzone_iamacatfr.items.unfinished;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityThrownRock;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public final class MyDispenserBehaviorRock extends BehaviorProjectileDispense {

    public ItemStack dispenseStack(final IBlockSource par1IBlockSource, final ItemStack par2ItemStack) {
        final World world = par1IBlockSource.getWorld();
        final IPosition iposition = BlockDispenser.func_149939_a(par1IBlockSource);
        final EnumFacing enumfacing = BlockDispenser.func_149937_b(par1IBlockSource.getBlockMetadata());
        final IProjectile iprojectile = this.getProjectileEntity(world, iposition);
        iprojectile.setThrowableHeading(
            enumfacing.getFrontOffsetX(),
            (enumfacing.getFrontOffsetY() + 0.1f),
            enumfacing.getFrontOffsetZ(),
            this.func_82500_b(),
            this.func_82498_a());
        final EntityThrownRock r = (EntityThrownRock) iprojectile;
        if (par2ItemStack.getItem() == ItemInitDangerZone.MySmallRock) {
            r.setRockType(1);
        }
        if (par2ItemStack.getItem() == ItemInitDangerZone.MyRock) {
            r.setRockType(2);
        }
        if (par2ItemStack.getItem() == ItemInitDangerZone.MyRedRock) {
            r.setRockType(3);
        }
        if (par2ItemStack.getItem() == ItemInitDangerZone.MyGreenRock) {
            r.setRockType(4);
        }
        if (par2ItemStack.getItem() == ItemInitDangerZone.MyBlueRock) {
            r.setRockType(5);
        }
        if (par2ItemStack.getItem() == ItemInitDangerZone.MyPurpleRock) {
            r.setRockType(6);
        }
        if (par2ItemStack.getItem() == ItemInitDangerZone.MySpikeyRock) {
            r.setRockType(7);
        }
        if (par2ItemStack.getItem() == ItemInitDangerZone.MyTNTRock) {
            r.setRockType(8);
        }
        if (par2ItemStack.getItem() == ItemInitDangerZone.MyCrystalRedRock) {
            r.setRockType(9);
        }
        if (par2ItemStack.getItem() == ItemInitDangerZone.MyCrystalGreenRock) {
            r.setRockType(10);
        }
        if (par2ItemStack.getItem() == ItemInitDangerZone.MyCrystalBlueRock) {
            r.setRockType(11);
        }
        if (par2ItemStack.getItem() == ItemInitDangerZone.MyCrystalTNTRock) {
            r.setRockType(12);
        }
        world.spawnEntityInWorld((Entity) iprojectile);
        par2ItemStack.splitStack(1);
        return par2ItemStack;
    }

    protected IProjectile getProjectileEntity(final World par1World, final IPosition par2IPosition) {
        final EntityThrownRock entityarrow = new EntityThrownRock(
            par1World,
            par2IPosition.getX(),
            par2IPosition.getY(),
            par2IPosition.getZ());
        return (IProjectile) entityarrow;
    }
}
