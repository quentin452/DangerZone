
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class BaryonyxInstance extends EntityMob {

    public BaryonyxInstance(final World par1World) {
        super(par1World);
        this.setSize(this.width * 2.5f, this.height * 2.5f);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.4, false));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, MassoInstance.class, 0.4, false));
        this.tasks.addTask(2, new EntityAIWander(this, 0.4));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, MassoInstance.class, 0, true));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.8);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(10.0);
    }

    protected String getLivingSound() {
        this.playSound(Tags.MODID + ":baryliving1", this.getSoundVolume(), this.getSoundPitch());
        return null;
    }

    protected String getHurtSound() {
        this.playSound(Tags.MODID + ":baryhurt", this.getSoundVolume(), this.getSoundPitch());
        return null;
    }

    protected String getDeathSound() {
        this.playSound(Tags.MODID + ":largecarndeath", this.getSoundVolume(), this.getSoundPitch());
        return null;
    }

    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    protected boolean canDespawn() {
        return false;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItem(Items.fish, 3);
    }
}
