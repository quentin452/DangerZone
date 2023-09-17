
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
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
        this.tasks.addTask(0, (EntityAIBase) new EntityAISwimming((EntityLiving) this));
        this.tasks.addTask(1, (EntityAIBase) new EntityAIBreakDoor((EntityLiving) this));
        this.tasks.addTask(
            2,
            (EntityAIBase) new EntityAIAttackOnCollide((EntityCreature) this, (Class) EntityPlayer.class, 1.0, false));
        this.tasks.addTask(
            3,
            (EntityAIBase) new EntityAIAttackOnCollide((EntityCreature) this, (Class) EntityVillager.class, 1.0, true));
        this.tasks.addTask(4, (EntityAIBase) new EntityAIMoveTowardsRestriction((EntityCreature) this, 1.0));
        this.tasks.addTask(5, (EntityAIBase) new EntityAIMoveThroughVillage((EntityCreature) this, 1.0, false));
        this.tasks.addTask(6, (EntityAIBase) new EntityAIWander((EntityCreature) this, 1.0));
        this.tasks
            .addTask(7, (EntityAIBase) new EntityAIWatchClosest((EntityLiving) this, (Class) EntityPlayer.class, 8.0f));
        this.tasks.addTask(8, (EntityAIBase) new EntityAILookIdle((EntityLiving) this));
        // this.tasks.addTask(9, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this,
        // (Class)EntityFungleCrab.class, 6.0f, 1.0, 1.2));
        this.targetTasks.addTask(1, (EntityAIBase) new EntityAIHurtByTarget((EntityCreature) this, true));
        this.targetTasks.addTask(
            2,
            (EntityAIBase) new EntityAINearestAttackableTarget(
                (EntityCreature) this,
                (Class) EntityPlayer.class,
                0,
                true));
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
