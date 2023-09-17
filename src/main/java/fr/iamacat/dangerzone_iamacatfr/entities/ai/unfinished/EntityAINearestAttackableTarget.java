

package fr.iamacat.dangerzone_iamacatfr.entities.ai.unfinished;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityGenericCreature;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityStates;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public class EntityAINearestAttackableTarget extends EntityAITarget
{
    EntityLivingBase targetEntity;
    Class targetClass;
    int targetChance;
    private final IEntitySelector entitySelector;
    EnumSet<EntityStates> setOfValidStates;
    private EntityAINearestAttackableTargetSorter theNearestAttackableTargetSorter;

    public EntityAINearestAttackableTarget(final EntityGenericCreature par1EntityLiving, final EnumSet<EntityStates> setOfValidStates, final Class par2Class, final float par3, final int par4, final boolean par5) {
        this(par1EntityLiving, setOfValidStates, par2Class, par3, par4, par5, false);
    }

    public EntityAINearestAttackableTarget(final EntityGenericCreature par1EntityLiving, final EnumSet<EntityStates> setOfValidStates, final Class par2Class, final float par3, final int par4, final boolean par5, final boolean par6) {
        this((EntityLiving)par1EntityLiving, setOfValidStates, par2Class, par3, par4, par5, par6, null);
    }

    public EntityAINearestAttackableTarget(final EntityLiving par1, final EnumSet<EntityStates> setOfValidStates, final Class par2, final float par3, final int par4, final boolean par5, final boolean par6, final IEntitySelector par7IEntitySelector) {
        super(par1, par3, par5, par6);
        this.setOfValidStates = setOfValidStates;
        this.targetClass = par2;
        this.targetDistance = par3;
        this.targetChance = par4;
        this.theNearestAttackableTargetSorter = new EntityAINearestAttackableTargetSorter(this, (Entity)par1);
        this.entitySelector = par7IEntitySelector;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        if (this.setOfValidStates != null && !this.setOfValidStates.contains(((EntityGenericCreature)this.taskOwner).getEntityState())) {
            return false;
        }
        if (this.targetChance > 0 && this.taskOwner.getRNG().nextInt(this.targetChance) != 0) {
            return false;
        }
        if (this.targetClass == EntityPlayer.class) {
            final EntityPlayer var1 = this.taskOwner.worldObj.getClosestVulnerablePlayerToEntity((Entity)this.taskOwner, (double)this.targetDistance);
            if (this.isSuitableTarget((EntityLivingBase)var1, false)) {
                this.targetEntity = (EntityLivingBase)var1;
                return true;
            }
        }
        else {
            final List<Entity> var2 = this.taskOwner.worldObj.selectEntitiesWithinAABB(this.targetClass, this.taskOwner.boundingBox.expand((double)this.targetDistance, 4.0, (double)this.targetDistance), this.entitySelector);
            Collections.sort(var2, this.theNearestAttackableTargetSorter);

            for (final Entity var4 : var2) {
                if (var4 instanceof EntityLiving) {
                    final EntityLiving var5 = (EntityLiving)var4;
                    if (this.isSuitableTarget(var5, false)) {
                        this.targetEntity = var5;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean continueExecuting() {
        return (((EntityGenericCreature)this.taskOwner).getEntityState() == EntityStates.attacking || ((EntityGenericCreature)this.taskOwner).getEntityState() == EntityStates.looking) && super.continueExecuting();
    }

    @Override
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this.targetEntity);
        super.startExecuting();
    }
}
