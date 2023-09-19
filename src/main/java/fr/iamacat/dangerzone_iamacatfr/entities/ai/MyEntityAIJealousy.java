
package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.BoyfriendInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.GirlfriendInstance;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityTameable;

public class MyEntityAIJealousy extends MyEntityAINearestAttackableTarget {

    private EntityTameable theTameable;

    public MyEntityAIJealousy(final EntityTameable par1EntityTameable, final Class par2Class, final float par3,
        final int par4, final boolean par5) {
        super(par1EntityTameable, par2Class, par3, par4, par5);
        this.theTameable = par1EntityTameable;
    }

    @Override
    public boolean shouldExecute() {
        final EntityTameable te = (EntityTameable) this.taskOwner;
        GirlfriendInstance gf = null;
        BoyfriendInstance bf = null;
        EntityLivingBase ep;
        if (te == null) {
            return false;
        }
        if (!te.isTamed()) {
            return false;
        }
        if (te.isSitting()) {
            return false;
        }
        if (!super.shouldExecute()) {
            return false;
        }
        final Entity victim = this.targetEntity;
        if (victim == null) {
            return false;
        }
        if (te instanceof GirlfriendInstance) {
            if (victim instanceof GirlfriendInstance) {
                gf = (GirlfriendInstance) victim;
                if (gf.isTamed()) {
                    return false;
                }
            }
        } else if (victim instanceof BoyfriendInstance) {
            bf = (BoyfriendInstance) victim;
            if (bf.isTamed()) {
                return false;
            }
        }
        ep = te.getOwner();
        return ep != null;
    }
}
