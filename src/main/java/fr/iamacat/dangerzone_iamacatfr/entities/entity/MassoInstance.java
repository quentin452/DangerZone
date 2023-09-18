
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class MassoInstance extends EntityTameable {

    public MassoInstance(final World par1World) {
        super(par1World);
        this.setSize(1.0f, 1.0f);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAILeapAtTarget(this, 0.4f));
        this.tasks.addTask(4, new EntityAIWander(this, 0.4));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, BaryonyxInstance.class, 8.0f, 0.8, 0.8));
        // this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntitySpino.class,
        // 8.0f, 0.8, 0.8));
        // this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this,
        // (Class)EntityDromaeosaurus.class, 8.0f, 0.6, 0.6));
        // this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this,
        // (Class)EntityMegalodon.class, 8.0f, 0.8, 0.8));
        // this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityTylo.class,
        // 8.0f, 0.8, 0.8));
        // this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this,
        // (Class)EntityQuetzalcoatlus.class, 8.0f, 0.8, 0.8));
        // this.tasks.addTask(1, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityCryo.class,
        // 8.0f, 0.8, 0.8));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.4);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(10.0);
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setBoolean("Angry", this.isAngry());
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setAngry(par1NBTTagCompound.getBoolean("Angry"));
    }

    protected boolean isAIEnabled() {
        return true;
    }

    protected String getLivingSound() {
        this.playSound(Tags.MODID + ":mob.masso.Masso", this.getSoundVolume(), this.getSoundPitch());
        return null;
    }

    protected String getHurtSound() {
        this.playSound(Tags.MODID + ":mob.masso.MassoHurt", this.getSoundVolume(), this.getSoundPitch());
        return null;
    }

    protected String getDeathSound() {
        this.playSound(Tags.MODID + ":mob.other.MedHerbDeath", this.getSoundVolume(), this.getSoundPitch());
        return null;
    }

    protected void attackEntity(final Entity par1Entity, final float par2) {
        if (this.attackTime <= 0 && par2 < 2.0f
            && par1Entity.boundingBox.maxY > this.boundingBox.minY
            && par1Entity.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;
            this.attackEntityAsMob(par1Entity);
        }
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final int i = 10;
        return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) i);
    }

    public EntityAgeable createChild(final EntityAgeable entityageable) {
        return null;
    }

    public void setAttackTarget(final EntityLivingBase par1EntityLivingBase) {
        super.setAttackTarget(par1EntityLivingBase);
        if (par1EntityLivingBase == null) {
            this.setAngry(false);
        }
    }

    public boolean isAngry() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 0x2) != 0x0;
    }

    public void setAngry(final boolean par1) {
        final int b0 = this.dataWatcher.getWatchableObjectByte(16);
        if (par1) {
            this.dataWatcher.updateObject(16, (byte) (b0 | 0x2));
        } else {
            this.dataWatcher.updateObject(16, (byte) (b0 & 0xFFFFFFFD));
        }
    }
}
