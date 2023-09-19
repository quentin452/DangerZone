
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.util.EntityStates;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class GenericBreedableInstance extends GenericAgeableInstance {

    protected int loveTimer;
    protected int loveCooldown;

    public boolean isInLove() {
        return this.loveTimer > 0;
    }

    public void resetInLove() {
        this.loveTimer = 0;
    }

    public GenericBreedableInstance(final World par1World) {
        super(par1World);
        this.loveTimer = 0;
        this.loveCooldown = 600;
    }

    protected void entityInit() {
        super.entityInit();
    }

    protected void updateAITasks() {
        super.updateAITasks();
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.getGrowingAge() != 0) {
            this.loveTimer = 0;
        }
        if (this.getEntityState() == EntityStates.inLove) {
            --this.loveTimer;
            if (this.loveTimer % 10 == 0) {
                final String var1 = "heart";
                final double var2 = this.rand.nextGaussian() * 0.02;
                final double var3 = this.rand.nextGaussian() * 0.02;
                final double var4 = this.rand.nextGaussian() * 0.02;
                this.worldObj.spawnParticle(
                    var1,
                    this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width,
                    this.posY + 0.5 + this.rand.nextFloat() * this.height,
                    this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width,
                    var2,
                    var3,
                    var4);
            }
        }
    }

    public boolean isValidBreedingItem(final ItemStack itemStack) {
        return false;
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        final ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && this.isValidBreedingItem(var2) && this.getGrowingAge() == 0) {
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack = var2;
                --itemStack.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory
                        .setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack) null);
                }
            }
            this.loveTimer = this.loveCooldown;
            for (int var3 = 0; var3 < 7; ++var3) {
                final double var4 = this.rand.nextGaussian() * 0.02;
                final double var5 = this.rand.nextGaussian() * 0.02;
                final double var6 = this.rand.nextGaussian() * 0.02;
                this.worldObj.spawnParticle(
                    "heart",
                    this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width,
                    this.posY + 0.5 + this.rand.nextFloat() * this.height,
                    this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width,
                    var4,
                    var5,
                    var6);
            }
            return true;
        }
        return super.interact(par1EntityPlayer);
    }

    public boolean canMateWith(final GenericBreedableInstance targetEntity) {
        return targetEntity != this && targetEntity.getClass() == this.getClass()
            && (this.isInLove() && targetEntity.isInLove());
    }

    public GenericBreedableInstance getBabyAnimalEntity(final Entity par1EntityAnimal) {
        Object object = null;
        try {
            final Class<?> thisClass = par1EntityAnimal.getClass();
            final Constructor<?> ctor = thisClass.getConstructor(World.class);
            try {
                object = ctor.newInstance(this.worldObj);
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException | SecurityException e5) {
            e5.printStackTrace();
        }
        return (GenericBreedableInstance) object;
    }
}
