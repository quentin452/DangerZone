
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class GenericAgeableInstance extends GenericCreatureInstance {

    public GenericAgeableInstance(final World par1World) {
        super(par1World);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(12, 0);
    }

    public int getGrowingAge() {
        return this.dataWatcher.getWatchableObjectInt(12);
    }

    public void setGrowingAge(final int par1) {
        this.dataWatcher.updateObject(12, (Object) par1);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        int var1 = this.getGrowingAge();
        if (var1 < 0) {
            ++var1;
            this.setGrowingAge(var1);
        } else if (var1 > 0) {
            --var1;
            this.setGrowingAge(var1);
        }
    }

    public boolean isChild() {
        return this.getGrowingAge() < 0;
    }

    public void addGrowth(final int p_110195_1_) {
        int j = this.getGrowingAge();
        j += p_110195_1_ * 20;
        if (j > 0) {
            j = 0;
        }
        this.setGrowingAge(j);
    }

    @Override
    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("Age", this.getGrowingAge());
    }

    @Override
    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setGrowingAge(par1NBTTagCompound.getInteger("Age"));
    }
}
