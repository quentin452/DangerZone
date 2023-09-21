
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.items.CrystalCow;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.MyUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Vortex extends EntityMob {

    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorter TargetSorter;
    private int winded;
    private int busy_fighting;
    private int was_spawnered;

    public Vortex(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.TargetSorter = null;
        this.winded = 0;
        this.busy_fighting = 0;
        this.was_spawnered = 0;
        this.setSize(2.0f, 4.0f);
        this.experienceValue = 200;
        this.isImmuneToFire = true;
        this.fireResistance = 250;
        this.TargetSorter = new GenericTargetSorter(this);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.3499999940395355);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(OreSpawnMain.Vortex_stats.attack);
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired() && this.busy_fighting == 0 && this.was_spawnered == 0;
    }

    protected float getSoundVolume() {
        return 0.75f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected String getLivingSound() {
        return Tags.MODID + ":vortexlive";
    }

    protected String getHurtSound() {
        return null;
    }

    protected String getDeathSound() {
        return Tags.MODID + ":vortexlive";
    }

    public boolean canBePushed() {
        return true;
    }

    protected void collideWithEntity(final Entity par1Entity) {}

    public int mygetMaxHealth() {
        return OreSpawnMain.Vortex_stats.health;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        EntityLivingBase e = null;
        super.onUpdate();
        this.motionY *= 0.6;
        this.busy_fighting = 0;
        e = this.findSomethingToAttack();
        if (e != null) {
            this.busy_fighting = 1;
            if (this.worldObj.isRemote) {
                for (int i = 0; i < 20; ++i) {
                    double d = this.worldObj.rand.nextDouble() * 3.5;
                    d *= d;
                    double dir = this.worldObj.rand.nextDouble() * 2.0 * 3.141592653589793;
                    dir -= 3.141592653589793;
                    final double dx = Math.cos(dir) * d / 2.0;
                    final double dz = Math.sin(dir) * d / 2.0;
                    dir += 1.5707963267948966;
                    this.worldObj.spawnParticle(
                        "smoke",
                        this.posX + dx,
                        this.posY + 0.75 + d,
                        this.posZ + dz,
                        Math.cos(dir) * this.worldObj.rand.nextFloat() / 4.0,
                        (this.worldObj.rand.nextFloat() / 2.0f),
                        Math.sin(dir) * this.worldObj.rand.nextFloat() / 4.0);
                }
            }
        }
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.heal(1.0f);
        }
        if (this.isNoDespawnRequired()) {
            return;
        }
        if (this.busy_fighting != 0) {
            return;
        }
        if (this.was_spawnered != 0) {
            return;
        }
        long t = this.worldObj.getWorldTime();
        t %= 24000L;
        if (t < 12000L && this.worldObj.rand.nextInt(500) == 1) {
            this.setDead();
        }
    }

    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.worldObj.rayTraceBlocks(
            Vec3.createVectorHelper(this.posX, this.posY + 0.75, this.posZ),
            Vec3.createVectorHelper(pX, pY, pZ),
            false) == null;
    }

    protected void updateAITasks() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 50;
        EntityLivingBase e = null;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        if (this.winded > 0) {
            --this.winded;
        }
        if (this.rand.nextInt(300) == 0
            || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 2.1f) {
            for (Block bid = Blocks.stone; bid != Blocks.air && keep_trying != 0; --keep_trying) {
                zdir = this.rand.nextInt(14) + 10;
                xdir = this.rand.nextInt(14) + 10;
                if (this.rand.nextInt(2) == 0) {
                    zdir = -zdir;
                }
                if (this.rand.nextInt(2) == 0) {
                    xdir = -xdir;
                }
                this.currentFlightTarget
                    .set((int) this.posX + xdir, (int) this.posY + this.rand.nextInt(6) - 3, (int) this.posZ + zdir);
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
        }
        e = this.findSomethingToAttack();
        if (e != null) {
            this.currentFlightTarget.set((int) e.posX, (int) e.posY, (int) e.posZ);
            final double d = this.getDistanceSqToEntity(e);
            if (d < 81.0 && this.winded == 0) {
                final double a = Math.atan2(this.posZ - e.posZ, this.posX - e.posX);
                double pm = 1.0;
                if (e instanceof EntityPlayer) {
                    pm = 2.0;
                }
                e.addVelocity(
                    Math.cos(a) * (10.0 - Math.sqrt(d)) * 0.10000000149011612,
                    (10.0 - Math.sqrt(d)) * 0.05000000074505806 * pm,
                    Math.sin(a) * (10.0 - Math.sqrt(d)) * 0.10000000149011612);
            }
            if (this.getDistanceSqToEntity(e) < (4.0f + e.width / 2.0f) * (4.0f + e.width / 2.0f)
                && this.rand.nextInt(8) == 2) {
                this.attackEntityAsMob(e);
            }
        }
        final double var1 = this.currentFlightTarget.posX + 0.5 - this.posX;
        final double var2 = this.currentFlightTarget.posY + 0.1 - this.posY;
        final double var3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.4 - this.motionX) * 0.2;
        this.motionY += (Math.signum(var2) * 0.699999988079071 - this.motionY) * 0.20000000149011612;
        this.motionZ += (Math.signum(var3) * 0.4 - this.motionZ) * 0.2;
        final float var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
        this.moveForward = 0.75f;
        this.rotationYaw += var5 / 4.0f;
    }

    protected boolean canTriggerWalking() {
        return true;
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        final Entity e = par1DamageSource.getEntity();
        ret = super.attackEntityFrom(par1DamageSource, par2);
        if (e != null && this.currentFlightTarget != null) {
            this.currentFlightTarget.set((int) e.posX, (int) e.posY, (int) e.posZ);
        }
        this.winded = 20;
        return ret;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.Vortex_stats.defense;
    }

    public boolean getCanSpawnHere() {
        for (int k = -3; k < 3; ++k) {
            for (int j = -3; j < 3; ++j) {
                for (int i = 0; i < 5; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("Vortex")) {
                            this.was_spawnered = 1;
                            return true;
                        }
                    }
                }
            }
        }
        for (int k = -2; k <= 2; ++k) {
            for (int j = -2; j <= 2; ++j) {
                for (int i = 1; i < 4; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid != Blocks.air) {
                        return false;
                    }
                }
            }
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        if (this.posY < 50.0) {
            return false;
        }
        long t = this.worldObj.getWorldTime();
        t %= 24000L;
        if (t < 12000L) {
            return false;
        }
        if (this.worldObj.rand.nextInt(2) != 1) {
            return false;
        }
        Vortex target = null;
        target = (Vortex) this.worldObj
            .findNearestEntityWithinAABB(Vortex.class, this.boundingBox.expand(20.0, 16.0, 20.0), this);
        return target == null;
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
        final MyUtils oreSpawnUtils = OreSpawnMain.OreSpawnUtils;
        if (MyUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (!this.getEntitySenses()
            .canSee(par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            if (p.capabilities.isCreativeMode) {
                return false;
            }
        }
        return !(par1EntityLiving instanceof Vortex) && !(par1EntityLiving instanceof Rotator)
            && !(par1EntityLiving instanceof Mothra)
            && !(par1EntityLiving instanceof Brutalfly)
            && !(par1EntityLiving instanceof Peacock)
            && !(par1EntityLiving instanceof CrystalCow)
            && !(par1EntityLiving instanceof Irukandji)
            && !(par1EntityLiving instanceof Skate)
            && !(par1EntityLiving instanceof Whale)
            && !(par1EntityLiving instanceof Flounder)
            && !(par1EntityLiving instanceof Urchin);
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0, 10.0, 16.0));
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.isSuitableTarget(var8, false)) {
                return var8;
            }
        }
        return null;
    }

    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(
            this.worldObj,
            this.posX + OreSpawnMain.OreSpawnRand.nextInt(6) - OreSpawnMain.OreSpawnRand.nextInt(6),
            this.posY + 1.0 + this.worldObj.rand.nextInt(10),
            this.posZ + OreSpawnMain.OreSpawnRand.nextInt(6) - OreSpawnMain.OreSpawnRand.nextInt(6),
            is);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }
        return is;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItemRand(OreSpawnMain.VortexEye, 1);
        this.dropItemRand(Items.item_frame, 1);
        for (int i = 5 + this.worldObj.rand.nextInt(7), var4 = 0; var4 < i; ++var4) {
            final int var5 = this.worldObj.rand.nextInt(10);
            if (var5 == 0) {
                this.dropItemRand(Items.stick, 1);
            }
            if (var5 == 1) {
                this.dropItemRand(OreSpawnMain.MyTigersEyeIngot, 1);
            }
            if (var5 == 2) {
                this.dropItemRand(OreSpawnMain.MyCrystalPinkIngot, 1);
            }
            if (var5 == 3) {
                this.dropItemRand(Items.iron_ingot, 1);
            }
            if (var5 == 4) {
                this.dropItemRand(OreSpawnMain.UraniumNugget, 1);
            }
            if (var5 == 6) {
                this.dropItemRand(OreSpawnMain.TitaniumNugget, 1);
            }
            if (var5 == 7) {
                this.dropItemRand(OreSpawnMain.MyIrukandji, 1);
            }
            if (var5 == 8) {
                this.dropItemRand(Item.getItemFromBlock(OreSpawnMain.CrystalCoal), 1);
            }
        }
    }

    protected Item getDropItem() {
        return OreSpawnMain.FairyEgg;
    }
}
