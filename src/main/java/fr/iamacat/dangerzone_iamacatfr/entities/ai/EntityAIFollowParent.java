
package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.GenericBreedableInstance;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;

import java.util.List;

public class EntityAIFollowParent extends EntityAIBase {

    GenericBreedableInstance childAnimal;
    GenericBreedableInstance parentAnimal;
    float field_75347_c;
    private int field_75345_d;

    public EntityAIFollowParent(final GenericBreedableInstance par1EntityAnimal, final float par2) {
        this.childAnimal = par1EntityAnimal;
        this.field_75347_c = par2;
    }

    public boolean shouldExecute() {
        if (this.childAnimal.getGrowingAge() >= 0) {
            return false;
        }
        final List<GenericBreedableInstance> var1 = this.childAnimal.worldObj
            .getEntitiesWithinAABB(this.childAnimal.getClass(), this.childAnimal.boundingBox.expand(8.0, 4.0, 8.0));
        GenericBreedableInstance var2 = null;
        double var3 = Double.MAX_VALUE;
        for (final GenericBreedableInstance var5 : var1) {
            if (var5.getGrowingAge() >= 0) {
                final double var6 = this.childAnimal.getDistanceSqToEntity(var5);
                if (var6 > var3) {
                    continue;
                }
                var3 = var6;
                var2 = var5;
            }
        }
        if (var2 == null) {
            return false;
        }
        if (var3 < 9.0) {
            return false;
        }
        this.parentAnimal = var2;
        return true;
    }

    public boolean continueExecuting() {
        if (!this.parentAnimal.isEntityAlive()) {
            return false;
        }
        final double distanceToParent = this.childAnimal.getDistanceSqToEntity(this.parentAnimal);
        return distanceToParent >= 9.0 && distanceToParent <= 256.0;
    }

    public void startExecuting() {
        this.field_75345_d = 0;
    }

    public void resetTask() {
        this.parentAnimal = null;
    }

    public void updateTask() {
        final int field_75345_d = this.field_75345_d - 1;
        this.field_75345_d = field_75345_d;
        if (field_75345_d <= 0) {
            this.field_75345_d = 10;
            this.childAnimal.getNavigator()
                .tryMoveToEntityLiving((Entity) this.parentAnimal, this.field_75347_c);
        }
    }
}
