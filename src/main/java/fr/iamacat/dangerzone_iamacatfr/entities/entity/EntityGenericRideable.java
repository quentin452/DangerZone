

package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public abstract class EntityGenericRideable extends EntityGenericBreedable
{
    public EntityGenericRideable(final World par1World) {
        super(par1World);
    }

    public boolean isRideable() {
        return false;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(21, (Object)0);
    }

    public boolean getSaddled() {
        return (this.dataWatcher.getWatchableObjectInt(21) & 0x1) != 0x0;
    }

    public void setSaddled(final boolean par1) {
        if (par1) {
            this.dataWatcher.updateObject(21, (Object)1);
        }
        else {
            this.dataWatcher.updateObject(21, (Object)0);
        }
    }

    public boolean canBeSteered() {
        final ItemStack var1 = ((EntityPlayer)this.riddenByEntity).getHeldItem();
        return var1 != null && var1.getItem().equals(Items.stick);
    }

    public boolean shouldIgnorePlayerRot() {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer) {
            final ItemStack var1 = ((EntityPlayer)this.riddenByEntity).getHeldItem();
            return var1 != null && var1.getItem() != Items.stick;
        }
        return false;
    }

    public boolean shouldRiderFaceForward(final EntityPlayer player) {
        return true;
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        if (super.interact(par1EntityPlayer)) {
            return true;
        }
        if (this.isRideable()) {
            if (this.getSaddled() && !this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == par1EntityPlayer)) {
                par1EntityPlayer.mountEntity(this);
                return true;
            }
            if (!this.getSaddled() && par1EntityPlayer.inventory.getCurrentItem() != null && par1EntityPlayer.inventory.getCurrentItem().getItem() == Items.saddle) {
                this.setSaddled(true);
                return true;
            }
        }
        return false;
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setBoolean("Saddle", this.getSaddled());
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setSaddled(par1NBTTagCompound.getBoolean("Saddle"));
    }
}
