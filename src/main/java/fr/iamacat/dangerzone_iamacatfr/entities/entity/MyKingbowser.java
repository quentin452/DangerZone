
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderInfo;
import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class MyKingbowser extends EntityMob {

    private GenericTargetSorter TargetSorter;
    private RenderInfo renderdata;
    private int reload_ticker;
    private int was_attacked_ticker;
    private float moveSpeed;

    public MyKingbowser(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.renderdata = new RenderInfo();
        this.reload_ticker = 0;
        this.was_attacked_ticker = 0;
        this.moveSpeed = 0.34f;
        this.setSize(2.5f, 4.5f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 120;
        this.fireResistance = 120;
        this.isImmuneToFire = true;
        this.renderDistanceWeight = 12.0;
        this.TargetSorter = new GenericTargetSorter((Entity) this);
        this.renderdata = new RenderInfo();
        this.tasks.addTask(0, (EntityAIBase) new EntityAISwimming((EntityLiving) this));
        this.tasks.addTask(1, (EntityAIBase) new EntityAIWander((EntityCreature) this, 1.0));
        this.tasks.addTask(
            2,
            (EntityAIBase) new EntityAIMoveThroughVillage((EntityCreature) this, 0.8999999761581421, false));
        this.tasks
            .addTask(3, (EntityAIBase) new EntityAIWatchClosest((EntityLiving) this, (Class) EntityPlayer.class, 8.0f));
        this.tasks.addTask(4, (EntityAIBase) new EntityAILookIdle((EntityLiving) this));
        this.targetTasks.addTask(1, (EntityAIBase) new EntityAIHurtByTarget((EntityCreature) this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue((double) this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(275.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance)
            .setBaseValue(20.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
        this.dataWatcher.addObject(21, (Object) 0);
        if (this.renderdata == null) {
            this.renderdata = new RenderInfo();
        }
        this.renderdata.rf1 = 0.0f;
        this.renderdata.rf2 = 0.0f;
        this.renderdata.rf3 = 0.0f;
        this.renderdata.rf4 = 0.0f;
        this.renderdata.ri1 = 0;
        this.renderdata.ri2 = 0;
        this.renderdata.ri3 = 0;
        this.renderdata.ri4 = 0;
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        super.onUpdate();
    }

    public int mygetMaxHealth() {
        return 1500;
    }

    public int getBowzaHealth() {
        return 1500;
    }

    public RenderInfo getRenderInfo() {
        return this.renderdata;
    }

    public void setRenderInfo(final RenderInfo r) {
        this.renderdata.rf1 = r.rf1;
        this.renderdata.rf2 = r.rf2;
        this.renderdata.rf3 = r.rf3;
        this.renderdata.rf4 = r.rf4;
        this.renderdata.ri1 = r.ri1;
        this.renderdata.ri2 = r.ri2;
        this.renderdata.ri3 = r.ri3;
        this.renderdata.ri4 = r.ri4;
    }

    public int getTotalArmorValue() {
        return 22;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    protected void jump() {
        this.motionY += 0.25;
        super.jump();
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.worldObj.isRemote) {}
    }

    public int getAttackStrength(final Entity par1Entity) {
        int var2 = 0;
        if (this.worldObj.difficultySetting == EnumDifficulty.EASY) {
            var2 = 450;
            if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
                var2 = 480;
            } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                var2 = 520;
            }
        }
        return var2;
    }

    protected String getLivingSound() {
        if (this.rand.nextInt(4) == 0) {
            return Tags.MODID + ":beastroar";
        }
        return Tags.MODID + ":beastroar";
    }

    protected String getHurtSound() {
        return "mob.wither.hurt";
    }

    protected String getDeathSound() {
        return "mob.wither.hurt";
    }

    protected float getSoundVolume() {
        return 2.0f;
    }

    protected float getSoundPitch() {
        return 0.5f;
    }

    /*
     * protected Block getDropItemId() {
     * return Basic.glowBone;
     * }
     */

    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(
            this.worldObj,
            this.posX + rand.nextInt(3) - rand.nextInt(3),
            this.posY + 1.0,
            this.posZ + rand.nextInt(3) - rand.nextInt(3),
            is);
        final float f3 = (float) Math.atan2(rand.nextInt() - this.posZ, rand.nextInt() - this.posX);
        var3.addVelocity(Math.cos(f3) * 0.25, 0.44999998807907104, Math.sin(f3) * 0.25);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld((Entity) var3);
        }
        return is;
    }

    private ItemStack dropBlockRand(final Block index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(
            this.worldObj,
            this.posX + rand.nextInt(3) - rand.nextInt(3),
            this.posY + 1.0,
            this.posZ + rand.nextInt(3) - rand.nextInt(3),
            is);
        final float f3 = (float) Math.atan2(rand.nextInt() - this.posZ, rand.nextInt() - this.posX);
        var3.addVelocity(Math.cos(f3) * 0.25, 0.44999998807907104, Math.sin(f3) * 0.25);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld((Entity) var3);
        }
        return is;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        ItemStack is = null;
        for (int var5 = 5 + this.worldObj.rand.nextInt(10), var6 = 0; var6 < var5; ++var6) {
            // this.dropItemRand(Basic.bowserBone, 16);
        }
        // this.dropItemRand(Basic.bowserEye, 2);
        for (int i = 10 + this.worldObj.rand.nextInt(15), var7 = 0; var7 < i; ++var7) {
            final int var8 = this.worldObj.rand.nextInt(15);
            switch (var8) {
                case 0: {
                    is = this.dropItemRand(Items.fire_charge, 6);
                    break;
                }
                case 1: {
                    is = this.dropItemRand(Items.lava_bucket, 1);
                    break;
                }
                /*
                 * case 2: {
                 * is = this.dropItemRand(Basic.boneHelmet, 1);
                 * break;
                 * }
                 * case 3: {
                 * is = this.dropItemRand(Basic.boneChest, 1);
                 * break;
                 * }
                 * case 4: {
                 * is = this.dropItemRand(Basic.boneLegs, 1);
                 * break;
                 * }
                 * case 5: {
                 * is = this.dropItemRand(Basic.boneBoots, 1);
                 * break;
                 * }
                 */
                case 6: {
                    is = this.dropBlockRand(Blocks.nether_brick, 64);
                    break;
                }
                /*
                 * case 7: {
                 * is = this.dropBlockRand(Basic.boneWall, 64);
                 * break;
                 * }
                 * case 8: {
                 * is = this.dropBlockRand(Basic.phoenixBlock, 1);
                 * break;
                 * }
                 * case 9: {
                 * is = this.dropBlockRand(Basic.boneBlock, 16);
                 * }
                 * case 10: {
                 * is = this.dropItemRand(Basic.phoenixBow, 1);
                 * break;
                 * }
                 */
            }
        }
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            final double ks = 2.0;
            double inair = 0.12;
            final float f3 = (float) Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
            if (par1Entity.isDead || par1Entity instanceof EntityPlayer) {
                inair *= 2.0;
            }
            par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
        }
        return super.attackEntityAsMob(par1Entity);
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        for (int k = -1; k < 2; ++k) {
            for (int j = -1; j < 2; ++j) {
                for (int i = 1; i < 5; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid == Blocks.lava && bid != Blocks.flowing_lava && bid != Blocks.fire) {
                        this.heal(2.0f);
                    }
                }
            }
        }
        if (this.reload_ticker > 0) {
            --this.reload_ticker;
        }
        if (this.was_attacked_ticker > 0) {
            --this.was_attacked_ticker;
        }
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.reload_ticker == 0
            && this.worldObj.rand.nextInt(8) == 1) {
            EntityLivingBase e = null;
            if (this.worldObj.rand.nextInt(50) == 1) {
                this.setAttackTarget((EntityLivingBase) null);
            }
            e = this.getAttackTarget();
            if (e != null && !e.isEntityAlive()) {
                this.setAttackTarget((EntityLivingBase) null);
                e = null;
            }
            if (e == null) {
                e = this.findSomethingToAttack();
            }
            if (e != null) {
                this.faceEntity((Entity) e, 10.0f, 10.0f);
                if (this.getDistanceSqToEntity((Entity) e) < 256.0) {
                    if (this.getDistanceSqToEntity((Entity) e) < 256.0 && this.worldObj.rand.nextInt(4) == 0) {
                        this.firecanon(e);
                    }
                    if (this.getDistanceSqToEntity((Entity) e) < (5.5f + e.width / 2.0f) * (5.5f + e.width / 2.0f)) {
                        this.bowserWrath(this.posX, this.posY, this.posZ, 4.5, 125.0, 1);
                        this.attackEntityAsMob((Entity) e);
                        this.worldObj.playSoundAtEntity((Entity) e, Tags.MODID + ":slap", 3.5f, 1.0f);
                    } else {
                        final double rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                        final double rhdir = Math.toRadians((this.rotationYawHead + 90.0f) % 360.0f);
                        final double pi = 3.1415926545;
                        double rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                        if (rdd > pi) {
                            rdd -= pi * 2.0;
                        }
                        rdd = Math.abs(rdd);
                        if (rdd < 0.5) {
                            final double yoff = 2.0;
                            final double xzoff = 1.75;
                            final FireCannon var2 = new FireCannon(
                                this.worldObj,
                                e.posX - this.posX,
                                e.posY - (this.posY + yoff),
                                e.posZ - this.posZ);
                            var2.setLocationAndAngles(
                                this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw + 45.0f)),
                                this.posY + yoff,
                                this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw + 45.0f)),
                                this.rotationYaw,
                                this.rotationPitch);
                            final double var3 = e.posX - var2.posX;
                            final double var4 = e.posY - var2.posY;
                            final double var5 = e.posZ - var2.posZ;
                            final float var6 = MathHelper.sqrt_double(var3 * var3 + var5 * var5) * 0.2f;
                            var2.setThrowableHeading(var3, var4 + var6, var5, 2.0f, 4.0f);
                            if (this.getDistanceSqToEntity((Entity) e) > 285.0) {
                                this.reload_ticker = 30;
                                this.worldObj.playSoundAtEntity((Entity) this, Tags.MODID + ":slap", 3.5f, 1.0f);
                            } else {
                                this.reload_ticker = 10;
                                this.worldObj.playSoundAtEntity((Entity) this, Tags.MODID + ":slap", 2.5f, 1.0f);
                            }
                            this.worldObj.spawnEntityInWorld((Entity) var2);
                        }
                        this.setAttacking(1);
                    }
                    this.getNavigator()
                        .tryMoveToEntityLiving((Entity) e, 0.75);
                    if (this.worldObj.rand.nextInt(4) == 0) {
                        double dx = e.posX;
                        double dz = e.posZ;
                        dx += (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 2.0;
                        dz += (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 2.0;
                        for (int l = 2; l > -2; --l) {
                            if (this.worldObj.getBlock((int) dx, (int) e.posY + l + 1, (int) dz) == Blocks.air
                                && this.worldObj.getBlock((int) dx, (int) e.posY + l, (int) dz) != Blocks.air) {
                                this.worldObj
                                    .setBlock((int) dx, (int) e.posY + l + 1, (int) dz, (Block) Blocks.flowing_lava);
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (this.reload_ticker <= 0 && this.was_attacked_ticker <= 0) {
            this.setAttacking(0);
        }
    }

    private void MeteorStrike(final EntityLivingBase e) {
        final double yoff = 3.0;
        final double xzoff = 3.5;
        if (this.reload_ticker > 0) {
            this.setAttacking(2);
            if (this.rand.nextInt(30) == 1) {
                final FireCannon var2 = new FireCannon(
                    this.worldObj,
                    e.posX - this.posX,
                    e.posY + 0.75 - (this.posY + yoff),
                    e.posZ - this.posZ);
                var2.setLocationAndAngles(
                    this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)),
                    this.posY + yoff,
                    this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYawHead)),
                    this.rotationYaw,
                    this.rotationPitch);
                this.worldObj.playSoundAtEntity(
                    (Entity) this,
                    "random.bow",
                    0.75f,
                    1.0f / (this.getRNG()
                        .nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld((Entity) var2);
            }
            final FireCannon var2 = new FireCannon(
                this.worldObj,
                e.posX - this.posX,
                e.posY + 0.75 - (this.posY + yoff),
                e.posZ - this.posZ);
            var2.setLocationAndAngles(
                this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)),
                this.posY + yoff,
                this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)),
                this.rotationYawHead,
                this.rotationPitch);
            final double var3 = e.posX - var2.posX;
            final double var4 = e.posY + 0.25 - var2.posY;
            final double var5 = e.posZ - var2.posZ;
            final float var6 = MathHelper.sqrt_double(var3 * var3 + var5 * var5) * 0.2f;
            var2.setThrowableHeading(var3, var4 + var6, var5, 1.4f, 5.0f);
            this.worldObj.playSoundAtEntity(
                (Entity) this,
                "random.explode",
                0.75f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld((Entity) var2);
            --this.reload_ticker;
        } else {
            this.setAttacking(0);
        }
        if (this.reload_ticker <= 0 && this.rand.nextInt(4) == 1) {
            this.reload_ticker = 16;
        }
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (par1DamageSource.getDamageType()
            .equals("cactus")) {
            return false;
        }
        if (this.getShielding() != 0 || this.was_attacked_ticker != 0) {
            return false;
        }
        this.was_attacked_ticker = 5;
        this.setAttacking(1);
        ret = super.attackEntityFrom(par1DamageSource, par2);
        final Entity e = par1DamageSource.getEntity();
        if (e != null && e instanceof EntityLiving) {
            this.setAttackTarget((EntityLivingBase) e);
            this.setTarget(e);
            this.getNavigator()
                .tryMoveToEntityLiving((Entity) e, 1.2);
            ret = true;
        }
        return ret;
    }

    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            return false;
        }
        if (par1EntityLiving == null) {
            return false;
        }
        if (par1EntityLiving == this) {
            return false;
        }
        if (!par1EntityLiving.isEntityAlive()) {
            return false;
        }
        if (MobUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (!this.getEntitySenses()
            .canSee((Entity) par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityZombie) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySkeleton) {
            return false;
        }
        if (par1EntityLiving instanceof EntityEnderman) {
            return false;
        }
        if (par1EntityLiving instanceof EntityCreeper) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySlime) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySpider) {
            return false;
        }
        if (par1EntityLiving instanceof EntityWitch) {
            return false;
        }
        if (par1EntityLiving instanceof EntityBlaze) {
            return false;
        }
        if (par1EntityLiving instanceof EntityCaveSpider) {
            return false;
        }
        if (par1EntityLiving instanceof EntityGhast) {
            return false;
        }
        if (par1EntityLiving instanceof EntityGolem) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySnowman) {
            return false;
        }
        if (par1EntityLiving instanceof EntityIronGolem) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMagmaCube) {
            return false;
        }
        if (par1EntityLiving instanceof MyKingbowser) {
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
        /*
         * if (Basic.Snap != 0) {
         * return null;
         * }
         */
        final List var5 = this.worldObj
            .getEntitiesWithinAABB((Class) EntityLivingBase.class, this.boundingBox.expand(16.0, 16.0, 16.0));
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        for (final Object var7 : var5) {
            final EntityLivingBase var8 = (EntityLivingBase) var7;
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
        this.dataWatcher.updateObject(20, (Object) (byte) par1);
    }

    public final int getShielding() {
        return this.dataWatcher.getWatchableObjectInt(21);
    }

    public final void setShielding(final int par1) {
        this.dataWatcher.updateObject(21, (Object) (byte) par1);
    }

    private void firecanon(final EntityLivingBase e) {
        final double yoff = 2.5;
        final double xzoff = 3.0;
        BetterFireball bf = null;
        final double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        final double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        final float r1 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        final float r2 = 3.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        final float r3 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        bf = new BetterFireball(
            this.worldObj,
            (EntityLivingBase) this,
            e.posX - cx + r1,
            e.posY + e.height / 2.0f - (this.posY + yoff) + r2,
            e.posZ - cz + r3);
        bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
        bf.setPosition(cx, this.posY + yoff, cz);
        bf.setBowser();
        this.worldObj.playSoundAtEntity((Entity) this, Tags.MODID + ":slap", 3.0f, 1.0f);
        this.worldObj.spawnEntityInWorld((Entity) bf);
    }

    private EntityLivingBase bowserWrath(final double X, final double Y, final double Z, final double dist,
        final double damage, final int knock) {
        final AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(X - dist, Y - 2.0, Z - dist, X + dist, Y + 2.0, Z + dist);
        final List var5 = this.worldObj.getEntitiesWithinAABB((Class) EntityLivingBase.class, bb);
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && var8 != null
                && var8 != this
                && !(var8 instanceof MyKingbowser)
                && var8.isEntityAlive()) {
                DamageSource var9 = null;
                var9 = DamageSource.setExplosionSource((Explosion) null);
                var9.setExplosion();
                var8.attackEntityFrom(var9, (float) damage / 1.0f);
                var8.attackEntityFrom(DamageSource.fall, (float) damage / 1.0f);
                final double ks = 3.25;
                final double inair = 1.75;
                final float f3 = (float) Math.atan2(var8.posZ - this.posZ, var8.posX - this.posX);
                var8.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return null;
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
                        if (s != null && s.equals("MyKingbowser")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        if (this.worldObj.isDaytime()) {
            return false;
        }
        MyKingbowser target = null;
        target = (MyKingbowser) this.worldObj.findNearestEntityWithinAABB(
            (Class) MyKingbowser.class,
            this.boundingBox.expand(128.0, 64.0, 128.0),
            (Entity) this);
        return target == null;
    }

    @SideOnly(Side.CLIENT)
    public static class RenderTheMob6 extends RenderLiving {

        private static final ResourceLocation bowsertexture;

        public RenderTheMob6(final ModelBase par1ModelBase, final float par2) {
            super(par1ModelBase, par2);
        }

        protected ResourceLocation getEntityTexture(final Entity entity) {
            return RenderTheMob6.bowsertexture;
        }

        static {
            bowsertexture = new ResourceLocation(Tags.MODID + ":" + "textures/entity/kingbowser.png");
        }
    }
}
