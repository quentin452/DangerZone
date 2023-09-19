
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWanderALot;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CryolophosaurusInstance extends EntityMob {

    private GenericTargetSorter TargetSorter;
    private float moveSpeed;

    public CryolophosaurusInstance(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.25f;
        this.setSize(0.75f, 0.75f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 10;
        this.fireResistance = 10;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.350000023841858));
        this.tasks.addTask(2, new EntityAIMoveThroughVillage(this, 1.0, false));
        this.tasks.addTask(3, new MyEntityAIWanderALot(this, 10, 1.0));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.TargetSorter = new GenericTargetSorter(this);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(3);
    }

    protected void entityInit() {
        super.entityInit();
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    public int mygetMaxHealth() {
        return 10;
    }

    public int getTotalArmorValue() {
        return 1;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
    }

    protected String getLivingSound() {
        if (this.rand.nextInt(6) == 0) {
            return Tags.MODID + ":cryo_living";
        }
        return null;
    }

    protected String getHurtSound() {
        return Tags.MODID + ":cryo_hurt";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":cryo_death";
    }

    protected float getSoundVolume() {
        return 0.75f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItem() {
        final int i = this.worldObj.rand.nextInt(10);
        if (i == 0) {
            return Items.chicken;
        }
        if (i == 1) {
            return ItemInitDangerZone.UraniumNugget;
        }
        if (i == 2) {
            return ItemInitDangerZone.TitaniumNugget;
        }
        return null;
    }

    public void initCreature() {}

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.setRevengeTarget(null);
        }
        if (this.worldObj.rand.nextInt(5) == 1) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                this.getNavigator()
                    .tryMoveToEntityLiving(e, 1.25);
                if (this.getDistanceSqToEntity(e) < 5.0 && (this.rand.nextInt(12) == 0 || this.rand.nextInt(14) == 1)) {
                    this.attackEntityAsMob(e);
                }
            }
        }
    }

    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        if (par1EntityLiving == null) {
            return false;
        }
        if (par1EntityLiving == this) {
            return false;
        }
        if (!par1EntityLiving.isEntityAlive()) {
            return false;
        }
        if (!this.getEntitySenses()
            .canSee(par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof AlosaurusInstance) {
            return false;
        }
        if (par1EntityLiving instanceof TRex) {
            return false;
        }
        if (par1EntityLiving instanceof CryolophosaurusInstance) {
            return false;
        }
        if (par1EntityLiving instanceof GhostInstance) {
            return false;
        }
        if (par1EntityLiving instanceof CaveFisherInstance) {
            return false;
        }
        if (par1EntityLiving instanceof GammaMetroid) {
            return false;
        }
        if (par1EntityLiving instanceof ButterflyInstance) {
            return false;
        }
        if (par1EntityLiving instanceof Firefly) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMosquito) {
            return false;
        }
        if (par1EntityLiving instanceof RockBase) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            if (p.capabilities.isCreativeMode) {
                return false;
            }
        }
        return true;
    }

    private EntityLivingBase findSomethingToAttack() {
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(9.0, 2.0, 9.0));
        Collections.sort((List<Object>) var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7;
        EntityLivingBase var8;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.isSuitableTarget(var8, false)) {
                return var8;
            }
        }
        return null;
    }

    public boolean getCanSpawnHere() {
        return this.isValidLightLevel() && (!this.worldObj.isDaytime() || this.posY <= 50.0);
    }
}