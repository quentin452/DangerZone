package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

import java.util.HashSet;
import java.util.Set;

public class EntitySensesOptimized {

    // this class was maked to don't use ArrayList because its not optimized with TwilightMagicInstance logic
    private final EntityLiving entityObj;
    private final Set<Entity> seenEntities = new HashSet<>();
    private final Set<Entity> unseenEntities = new HashSet<>();

    public EntitySensesOptimized(EntityLiving entity) {
        this.entityObj = entity;
    }

    public boolean canSee(Entity target) {
        if (this.seenEntities.contains(target)) {
            return true;
        } else if (this.unseenEntities.contains(target)) {
            return false;
        } else {
            this.entityObj.worldObj.theProfiler.startSection("canSee");
            boolean flag = this.entityObj.canEntityBeSeen(target);
            this.entityObj.worldObj.theProfiler.endSection();

            if (flag) {
                this.seenEntities.add(target);
            } else {
                this.unseenEntities.add(target);
            }

            return flag;
        }
    }
}
