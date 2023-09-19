
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BasilikInstance extends EntityMob {

    public BasilikInstance(final World world) {
        super(world);
        this.setSize(1.0f, 3.0f);
        this.getNavigator()
            .setBreakDoors(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIBreakDoor(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0, false));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0, true));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0));
        this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, 1.0, false));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        // this.tasks.addTask(9, (EntityAIBase)new EntityAIAvoidEntity(this,
        // EntityFungleCrab.class, 6.0f, 1.0, 1.2));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange)
            .setBaseValue(60.0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(200.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.35);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(8.0);
    }

    protected String getLivingSound() {
        return "random.fizz";
    }

    protected String getHurtSound() {
        return "mob.villager.death";
    }

    protected String getDeathSound() {
        return "creeper.primed";
    }

    protected float getSoundVolume() {
        return 0.4f;
    }
}
