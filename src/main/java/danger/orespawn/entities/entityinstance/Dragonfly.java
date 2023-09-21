
package danger.orespawn.entities.entityinstance;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import danger.orespawn.utils.GenericTargetSorter;

public class Dragonfly extends EntityAnimal {

    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorter TargetSorter;

    public Dragonfly(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.TargetSorter = null;
        this.setSize(1.5f, 0.5f);
        this.getNavigator()
            .setAvoidsWater(false);
        this.experienceValue = 5;
        this.isImmuneToFire = false;
        this.fireResistance = 5;
        this.TargetSorter = new GenericTargetSorter(this);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.33000001311302185);
        this.getAttributeMap()
            .registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(2.0);
    }

    protected void entityInit() {
        super.entityInit();
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    protected float getSoundVolume() {
        return 0.25f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected String getLivingSound() {
        return "orespawn:dragonfly_living";
    }

    protected String getHurtSound() {
        return "orespawn:dragonfly_hurt";
    }

    protected String getDeathSound() {
        return "orespawn:dragonfly_death";
    }

    public boolean canBePushed() {
        return true;
    }

    protected void collideWithEntity(final Entity par1Entity) {}

    public int mygetMaxHealth() {
        return 10;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.6;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), 2.0f);
        return var4;
    }

    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.worldObj.rayTraceBlocks(
            Vec3.createVectorHelper(this.posX, this.posY + 0.25, this.posZ),
            Vec3.createVectorHelper(pX, pY, pZ),
            false) == null;
    }

    protected void updateAITasks() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 50;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        if (this.rand.nextInt(300) == 0
            || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 2.1f) {
            for (Block bid = Blocks.stone; bid != Blocks.air && keep_trying != 0; --keep_trying) {
                zdir = this.rand.nextInt(5) + 5;
                xdir = this.rand.nextInt(5) + 5;
                if (this.rand.nextInt(2) == 0) {
                    zdir = -zdir;
                }
                if (this.rand.nextInt(2) == 0) {
                    xdir = -xdir;
                }
                this.currentFlightTarget
                    .set((int) this.posX + xdir, (int) this.posY + this.rand.nextInt(5) - 2, (int) this.posZ + zdir);
                bid = this.worldObj.getBlock(
                    this.currentFlightTarget.posX,
                    this.currentFlightTarget.posY,
                    this.currentFlightTarget.posZ);
                if (bid == Blocks.air && !this.canSeeTarget(
                    this.currentFlightTarget.posX,
                    this.currentFlightTarget.posY,
                    this.currentFlightTarget.posZ)) {
                    bid = Blocks.stone;
                }
            }
        } else if (this.rand.nextInt(12) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            EntityLivingBase e = null;
            e = this.findSomethingToAttack();
            if (e != null) {
                this.currentFlightTarget.set((int) e.posX, (int) (e.posY + 1.0), (int) e.posZ);
                if (this.getDistanceSqToEntity(e) < 6.0) {
                    this.attackEntityAsMob(e);
                }
            }
        }
        final double var1 = this.currentFlightTarget.posX + 0.5 - this.posX;
        final double var2 = this.currentFlightTarget.posY + 0.1 - this.posY;
        final double var3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.5 - this.motionX) * 0.30000000149011613;
        this.motionY += (Math.signum(var2) * 0.699999988079071 - this.motionY) * 0.20000000149011612;
        this.motionZ += (Math.signum(var3) * 0.5 - this.motionZ) * 0.30000000149011613;
        final float var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
        this.moveForward = 1.0f;
        this.rotationYaw += var5 / 4.0f;
    }

    protected boolean canTriggerWalking() {
        return true;
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    public boolean doesEntityNotTriggerPressurePlate() {
        return false;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        final boolean ret = super.attackEntityFrom(par1DamageSource, par2);
        final Entity e = par1DamageSource.getEntity();
        if (e != null && this.currentFlightTarget != null) {
            this.currentFlightTarget.set((int) e.posX, (int) e.posY, (int) e.posZ);
        }
        return ret;
    }

    public boolean getCanSpawnHere() {
        return this.posY >= 50.0 && this.worldObj.isDaytime();
    }

    public void initCreature() {}

    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && par1EntityLiving != null
            && par1EntityLiving != this
            && par1EntityLiving.isEntityAlive()
            && this.getEntitySenses()
                .canSee(par1EntityLiving)
            && (par1EntityLiving instanceof EntityAnt || par1EntityLiving instanceof EntityButterfly
                || par1EntityLiving instanceof Cockateil
                || par1EntityLiving instanceof EntityMosquito
                || par1EntityLiving instanceof Firefly
                || (par1EntityLiving instanceof EntityHorse && OreSpawnMain.DragonflyHorseFriendly == 0));
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(10.0, 6.0, 10.0));
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

    protected Item getDropItem() {
        final int i = this.worldObj.rand.nextInt(6);
        if (i == 0) {
            return Items.gold_nugget;
        }
        if (i == 1) {
            return OreSpawnMain.UraniumNugget;
        }
        if (i == 2) {
            return OreSpawnMain.TitaniumNugget;
        }
        return null;
    }

    public EntityAgeable createChild(final EntityAgeable var1) {
        return null;
    }
}
