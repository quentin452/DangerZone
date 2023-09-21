
package danger.orespawn.entities.entityinstance;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import danger.orespawn.entities.ai.MyEntityAIWander;
import danger.orespawn.utils.GenericTargetSorter;

public class Skate extends EntityMob {

    private GenericTargetSorter TargetSorter;
    private EntityLivingBase buddy;
    private float moveSpeed;
    private int closest;
    private int tx;
    private int ty;
    private int tz;

    public Skate(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.buddy = null;
        this.moveSpeed = 0.25f;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.setSize(0.75f, 0.25f);
        this.getNavigator()
            .setAvoidsWater(false);
        this.experienceValue = 10;
        this.fireResistance = 3;
        this.isImmuneToFire = false;
        this.TargetSorter = new GenericTargetSorter(this);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new MyEntityAIWander(this, 1.0f));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(OreSpawnMain.Skate_stats.attack);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
    }

    public int mygetMaxHealth() {
        return OreSpawnMain.Skate_stats.health;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.Skate_stats.defense;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    public int getAttackStrength(final Entity par1Entity) {
        final int var2 = 4;
        return var2;
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return null;
    }

    protected String getDeathSound() {
        return "orespawn:ratdead";
    }

    protected float getSoundVolume() {
        return 0.33f;
    }

    protected float getSoundPitch() {
        return 1.75f;
    }

    protected Item getDropItem() {
        return Items.string;
    }

    public void initCreature() {}

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (this.isDead) {
            return false;
        }
        final Entity e = par1DamageSource.getEntity();
        if (e != null && e instanceof Skate) {
            return false;
        }
        if (e != null && e instanceof EntityLiving) {
            if (e instanceof Skate) {
                return false;
            }
            this.setAttackTarget((EntityLivingBase) e);
            this.setTarget(e);
            this.getNavigator()
                .tryMoveToEntityLiving(e, 1.2);
            ret = true;
        }
        ret = super.attackEntityFrom(par1DamageSource, par2);
        return ret;
    }

    private boolean scan_it(final int x, final int y, final int z, final int dx, final int dy, final int dz) {
        int found = 0;
        int closest = Integer.MAX_VALUE;
        int tx = 0, ty = 0, tz = 0;

        for (int i = -dy; i <= dy; ++i) {
            for (int j = -dz; j <= dz; ++j) {
                for (int k = -dx; k <= dx; ++k) {
                    int blockX = x + k;
                    int blockY = y + i;
                    int blockZ = z + j;

                    Block bid = this.worldObj.getBlock(blockX, blockY, blockZ);

                    if (bid == Blocks.water || bid == Blocks.flowing_water) {
                        int d = k * k + j * j + i * i;

                        if (d < closest) {
                            closest = d;
                            tx = blockX;
                            ty = blockY;
                            tz = blockZ;
                        }
                        found++;
                    }
                }
            }
        }

        return found != 0;
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (!this.isInWater() && this.worldObj.rand.nextInt(10) == 0) {
            this.closest = 99999;
            final int tx = 0;
            this.tz = tx;
            this.ty = tx;
            this.tx = tx;
            for (int i = 1; i < 12; ++i) {
                int j = i;
                if (j > 5) {
                    j = 5;
                }
                if (this.scan_it((int) this.posX, (int) this.posY - 1, (int) this.posZ, i, j, i)) {
                    break;
                }
                if (i >= 5) {
                    ++i;
                }
            }
            if (this.closest < 99999) {
                this.getNavigator()
                    .tryMoveToXYZ(this.tx, (this.ty - 1), this.tz, 1.33);
            } else {
                if (this.worldObj.rand.nextInt(25) == 1) {
                    this.heal(-1.0f);
                }
                if (this.getHealth() <= 0.0f) {
                    this.setDead();
                    return;
                }
            }
        }
        if (this.worldObj.rand.nextInt(8) == 1) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                if (this.getDistanceSqToEntity(e) < 4.0) {
                    this.setAttacking(1);
                    if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1) {
                        this.attackEntityAsMob(e);
                    }
                } else {
                    this.getNavigator()
                        .tryMoveToEntityLiving(e, 1.2);
                }
            } else {
                this.setAttacking(0);
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
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode;
        }
        return false;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(10.0, 4.0, 10.0));
        Collections.sort((List<Object>) var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        final EntityLivingBase e = this.getAttackTarget();
        if (e != null && e.isEntityAlive()) {
            return e;
        }
        this.setAttackTarget(null);
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.isSuitableTarget(var8, false)) {
                return var8;
            }
        }
        return null;
    }

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public final void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, par1);
    }

    private int findBuddies() {
        final List var5 = this.worldObj.getEntitiesWithinAABB(Skate.class, this.boundingBox.expand(16.0, 8.0, 16.0));
        return var5.size();
    }

    public boolean getCanSpawnHere() {
        return this.posY >= 50.0 && this.worldObj.isDaytime()
            && this.worldObj.rand.nextInt(30) == 1
            && this.findBuddies() <= 6;
    }
}
