
package fr.iamacat.dangerzone_iamacatfr.entities.entity.babydragon;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public abstract class DecoyOverworldDragonTameable extends EntityTameable {

    public DecoyOverworldDragonTameable(final World w) {
        super(w);
        this.addBasicAI();
        this.setTamed(false);
    }

    public double getHP() {
        return this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .getAttributeValue();
    }

    public double getMoveSpeed() {
        return this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .getAttributeValue();
    }

    public double getAttackDamage() {
        return this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .getAttributeValue();
    }

    public double getFollowRange() {
        return this.getEntityAttribute(SharedMonsterAttributes.followRange)
            .getAttributeValue();
    }

    public double getKnockbackResistance() {
        return this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance)
            .getAttributeValue();
    }

    public abstract String mobName();

    protected String getLivingSound() {
        return super.getLivingSound();
    }

    protected String getHurtSound() {
        return super.getHurtSound();
    }

    protected String getDeathSound() {
        return super.getDeathSound();
    }

    protected void addBasicAI() {
        this.getNavigator()
            .setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming( this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAILeapAtTarget( this, 0.4f));
        this.tasks.addTask(
            4,
            new EntityAIAttackOnCollide( this, this.getMoveSpeed() * 5.0, true));
        this.tasks.addTask(
            5,
            new EntityAIFollowOwner((EntityTameable) this, this.getMoveSpeed() * 5.0, 4.0f, 16.0f));
        this.tasks.addTask(6, new EntityAIMate((EntityAnimal) this, 1.0));
        this.tasks.addTask(7, new EntityAIWander( this, 1.0));
        this.tasks
            .addTask(9, new EntityAIWatchClosest( this,  EntityPlayer.class, 8.0f));
        this.tasks.addTask(9, new EntityAILookIdle( this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget((EntityTameable) this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget((EntityTameable) this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget( this, true));
        this.targetTasks.addTask(
            6,
            new EntityAINearestAttackableTarget(
                 this,
                 EntityLiving.class,
                0,
                false,
                true,
                IMob.mobSelector));
    }

    protected void addAttackingAI() {
        this.tasks.addTask(
            5,
            new EntityAIAttackOnCollide(
                 this,
                 EntityPlayer.class,
                this.getMoveSpeed(),
                false));
        this.targetTasks.addTask(
            6,
            new EntityAINearestAttackableTarget(
                 this,
                 EntityPlayer.class,
                0,
                true));
    }

    public EntityLivingBase getAttackTarget() {
        return (this.isTamed() || this.isAngry()) ? super.getAttackTarget() : null;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public boolean getCanSpawnHere() {
        final int i = MathHelper.floor_double(this.posX);
        final int j = MathHelper.floor_double(this.boundingBox.minY);
        final int k = MathHelper.floor_double(this.posZ);
        return this.worldObj.getBlock(i, j - 40, k) == Blocks.grass && this.worldObj.getFullBlockLightValue(i, j, k) < 4
            && super.getCanSpawnHere();
    }

    protected boolean isValidLightLevel() {
        return true;
    }

    public boolean isAngry() {
        return false;
    }
}
