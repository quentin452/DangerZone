
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWanderALot;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

import java.util.List;

public class Cricket extends EntityAnimal {

    public double moveSpeed;
    private int singing;
    private int jumpcount;

    public Cricket(final World par1World) {
        super(par1World);
        this.moveSpeed = 0.15000000596046448;
        this.singing = 0;
        this.jumpcount = 0;
        this.setSize(0.1f, 0.1f);
        this.experienceValue = 1;
        this.getNavigator()
            .setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAIPanic(this, 1.4));
        this.tasks.addTask(1, new MyEntityAIWanderALot(this, 8, 1.0));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        this.getAttributeMap()
            .registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(0.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    public int getSinging() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setSinging(int par1) {
        this.dataWatcher.updateObject(20, par1);
    }

    private void jumpAround() {
        this.motionY += 0.55f + Math.abs(this.worldObj.rand.nextFloat() * 0.35f);
        this.posY += 0.25;
        final float f = 0.3f + Math.abs(this.worldObj.rand.nextFloat() * 0.25f);
        final float d = (float) (this.worldObj.rand.nextFloat() * 3.141592653589793 * 2.0);
        this.motionX += f * Math.sin(d);
        this.motionZ += f * Math.cos(d);
        this.isAirBorne = true;
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
        if (!this.worldObj.isRemote) {
            if (this.singing != 0) {
                --this.singing;
                if (this.singing <= 0) {
                    this.setSinging(0);
                }
            }
            if (this.jumpcount > 0) {
                --this.jumpcount;
            }
            if (this.jumpcount == 0 && this.worldObj.rand.nextInt(50) == 1) {
                this.jumpAround();
                this.jumpcount = 50;
            }
        }
    }

    public boolean isAIEnabled() {
        return true;
    }

    public int mygetMaxHealth() {
        return 3;
    }

    protected String getLivingSound() {
        if (!this.worldObj.isRemote) {
            if (this.worldObj.rand.nextInt(2) == 0) {
                return null;
            }
            this.setSinging(this.singing = 40);
        }
        return "orespawn:cricket";
    }

    protected String getHurtSound() {
        return null;
    }

    protected String getDeathSound() {
        return null;
    }

    protected float getSoundVolume() {
        return 0.7f;
    }

    protected void playStepSound(final int par1, final int par2, final int par3, final int par4) {}

    protected void dropFewItems(final boolean par1, final int par2) {}

    protected boolean canTriggerWalking() {
        return true;
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    public EntityAgeable createChild(final EntityAgeable var1) {
        return null;
    }

    public boolean getCanSpawnHere() {
        return this.posY >= 30.0 && this.findBuddies() <= 5;
    }

    private int findBuddies() {
        final List var5 = this.worldObj.getEntitiesWithinAABB(Cricket.class, this.boundingBox.expand(20.0, 10.0, 20.0));
        return var5.size();
    }
}
