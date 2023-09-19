
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.*;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class LeviathanInstance extends EntityMob {

    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorterInstance TargetSorter;
    private int winded;
    private int busy_fighting;
    private int was_spawnered;

    public LeviathanInstance(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.TargetSorter = null;
        this.winded = 0;
        this.busy_fighting = 0;
        this.was_spawnered = 0;
        this.setSize(8.0f, 4.0f);
        this.experienceValue = 600;
        this.isImmuneToFire = true;
        this.fireResistance = 250;
        this.renderDistanceWeight = 12.0;
        this.handleWaterMovement();
        this.canBreatheUnderwater();
        this.TargetSorter = new GenericTargetSorterInstance((Entity) this);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue((double) this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.3499999940395355);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(5.0);
    }

    protected boolean canDespawn() {
        return false;
    }

    protected float getSoundVolume() {
        return 1.75f;
    }

    protected float getSoundPitch() {
        return 4.0f;
    }

    protected String getLivingSound() {
        return "mob.enderdragon.growl";
    }

    protected String getHurtSound() {
        return "mob.enderdragon.hit";
    }

    protected String getDeathSound() {
        return "mob.enderdragon.hit";
    }

    public boolean canBePushed() {
        return true;
    }

    protected void collideWithEntity(final Entity par1Entity) {}

    public int mygetMaxHealth() {
        return 990;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        EntityLivingBase e = null;
        super.onUpdate();
        for (int i = 0; i < 40; ++i) {
            final float var1 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            final float var2 = (this.rand.nextFloat() - 0.5f) * 4.0f;
            final float var3 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.worldObj
                .spawnParticle("splash", this.posX + var1, this.posY + 2.0 + var2, this.posZ + var3, 0.0, 0.75, 0.0);
        }
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
                    dir += 1.570796326794897;
                }
            }
        }
        if (this.worldObj.rand.nextInt(100) == 1) {
            this.heal(10.0f);
        }
    }

    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.worldObj.rayTraceBlocks(
            Vec3.createVectorHelper(this.posX, this.posY + 0.75, this.posZ),
            Vec3.createVectorHelper(pX, pY, pZ),
            false) == null;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (super.attackEntityAsMob(par1Entity)) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
                final double ks = 0.2;
                double inair = -0.2;
                final float f3 = (float) Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
                if (par1Entity.isDead || par1Entity instanceof EntityPlayer) {
                    inair *= 2.0;
                }
                par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            return true;
        }
        return false;
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
            final double d = this.getDistanceSqToEntity((Entity) e);
            if (d < 181.0) {
                final double a = Math.atan2(this.posZ - e.posZ, this.posX - e.posX);
                double pm = 1.0;
                if (e instanceof EntityPlayer) {
                    pm = 2.0;
                }
                e.addVelocity(
                    Math.cos(a) * (20.0 - Math.sqrt(d)) * 0.1000000014901161,
                    (20.0 - Math.sqrt(d)) * 0.0500000007450581 * pm,
                    Math.sin(a) * (20.0 - Math.sqrt(d)) * 0.1000000014901161);
            }
            if (this.getDistanceSqToEntity((Entity) e) < (10.0f + e.width / 2.0f) * (10.0f + e.width / 2.0f)
                && this.rand.nextInt(3) == 1
                && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                this.attackEntityAsMob((Entity) e);
            }
        }
        final double var1 = this.currentFlightTarget.posX + 0.5 - this.posX;
        final double var2 = this.currentFlightTarget.posY + 0.1 - this.posY;
        final double var3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.4 - this.motionX) * 0.2;
        this.motionY += (Math.signum(var2) * 0.699999988079071 - this.motionY) * 0.2000000014901161;
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
        return 20;
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
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            if (p.capabilities.isCreativeMode) {
                return false;
            }
        }
        return !(par1EntityLiving instanceof LeviathanInstance) && !(par1EntityLiving instanceof EntityZombie)
            && !(par1EntityLiving instanceof EntitySkeleton)
            && !(par1EntityLiving instanceof EntityEnderman)
            && !(par1EntityLiving instanceof EntityCreeper)
            && !(par1EntityLiving instanceof EntitySlime)
            && !(par1EntityLiving instanceof EntitySpider)
            && !(par1EntityLiving instanceof EntityWitch)
            && !(par1EntityLiving instanceof EntityBlaze)
            && !(par1EntityLiving instanceof EntityCaveSpider)
            && !(par1EntityLiving instanceof EntityGhast)
            && !(par1EntityLiving instanceof EntityGolem)
            && !(par1EntityLiving instanceof EntitySnowman)
            && !(par1EntityLiving instanceof EntityIronGolem)
            && !(par1EntityLiving instanceof EntityMagmaCube)
            && !(par1EntityLiving instanceof EntityCreature)
            && !(par1EntityLiving instanceof EntityDragon);
    }

    private EntityLivingBase findSomethingToAttack() {
        /*
         * if (Basic.Snap != 0) {
         * return null;
         * }
         */
        final List var5 = this.worldObj
            .getEntitiesWithinAABB( EntityLivingBase.class, this.boundingBox.expand(16.0, 10.0, 16.0));
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
        this.dropBlockRand(Blocks.lapis_block, 1);
        for (int i = 12 + this.worldObj.rand.nextInt(7), var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(Items.stick, 1);
            this.dropItemRand(Items.apple, 1);
            // this.dropItemRand(Basic.balloons, 1);
            this.dropBlockRand(Blocks.lapis_block, 2);
            this.dropItemRand(Items.iron_ingot, 1);
            final int var5 = this.worldObj.rand.nextInt(10);
            if (var5 == 0) {
                this.dropItemRand(Items.stick, 1);
            }
            if (var5 == 1) {
                this.dropItemRand(Items.apple, 1);
            }
            /*
             * if (var5 == 2) {
             * this.dropItemRand(Basic.balloons, 1);
             * }
             */
            if (var5 == 3) {
                this.dropItemRand(Items.iron_ingot, 1);
            }
        }
    }

    public void onDeathUpdate() {
        super.onDeathUpdate();
        for (int i = 0; i < 40; ++i) {
            final float var1 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            final float var2 = (this.rand.nextFloat() - 0.5f) * 4.0f;
            final float var3 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.worldObj
                .spawnParticle("splash", this.posX + var1, this.posY + 2.0 + var2, this.posZ + var3, 0.0, 0.75, 0.0);
            this.worldObj
                .spawnParticle("splash", this.posX + var1, this.posY + 2.0 + var2, this.posZ + var3, 0.0, 0.75, 0.0);
            this.worldObj
                .spawnParticle("bubble", this.posX + var1, this.posY + 2.0 + var2, this.posZ + var3, 0.0, 0.75, 0.0);
        }
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
                        if (s != null && s.equals("MyLeviathan")) {
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
        LeviathanInstance target = null;
        target = (LeviathanInstance) this.worldObj.findNearestEntityWithinAABB(
             LeviathanInstance.class,
            this.boundingBox.expand(64.0, 32.0, 64.0),
            (Entity) this);
        return target == null;
    }

    protected Item getDropItemId() {
        return Items.apple;
    }

    @SideOnly(Side.CLIENT)
    public static class RenderTheMob3 extends RenderLiving {

        private static final ResourceLocation dleviathantexture;

        public RenderTheMob3(final ModelBase par1ModelBase, final float par2) {
            super(par1ModelBase, par2);
        }

        protected ResourceLocation getEntityTexture(final Entity entity) {
            return RenderTheMob3.dleviathantexture;
        }

        static {
            dleviathantexture = new ResourceLocation(Tags.MODID + ":" + "textures/entity/leviathan.png");
        }
    }
}
