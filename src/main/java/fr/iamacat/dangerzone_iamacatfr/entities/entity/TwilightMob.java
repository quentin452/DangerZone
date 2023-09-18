
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
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class TwilightMob extends EntityMob {

    private GenericTargetSorter TargetSorter;
    private float moveSpeed;
    private EntityLivingBase rt;

    public TwilightMob(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.45f;
        this.rt = null;
        this.setSize(2.0f, 2.0f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 350;
        this.fireResistance = 100;
        this.renderDistanceWeight = 12.0;
        this.TargetSorter = new GenericTargetSorter((Entity) this);
        this.tasks.addTask(0, new EntityAISwimming( this));
        this.tasks.addTask(1, new EntityAIMoveThroughVillage( this, 1.0, false));
        this.tasks.addTask(2, new EntityAIWander( this, 1.0));
        this.tasks
            .addTask(3, new EntityAIWatchClosest( this,  EntityLiving.class, 8.0f));
        this.tasks.addTask(4, new EntityAILookIdle( this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget( this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue((double) this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(88.0);
        this.addPotionEffect(new PotionEffect(11, 1000000000, 3));
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
            .setBaseValue((double) this.moveSpeed);
        super.onUpdate();
    }

    public int mygetMaxHealth() {
        return 50;
    }

    public int getTotalArmorValue() {
        return 24;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    protected String getLivingSound() {
        if (this.rand.nextInt(3) == 0) {
            return "mob.irongolem.death";
        }
        return "";
    }

    protected String getHurtSound() {
        return "mob.irongolem.hit";
    }

    protected String getDeathSound() {
        return "mob.irongolem.hit";
    }

    protected float getSoundVolume() {
        return 1.5f;
    }

    protected float getSoundPitch() {
        return 0.8f;
    }

    protected Item getDropItemId() {
        return Items.iron_ingot;
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
        for (int var4 = 0; var4 < 8; ++var4) {
            this.dropBlockRand(Blocks.lever, 1);
        }
        for (int var4 = 0; var4 < 10; ++var4) {
            this.dropBlockRand(Blocks.iron_block, 1);
        }
        for (int var4 = 0; var4 < 16; ++var4) {
            this.dropItemRand(Items.iron_ingot, 1);
        }
        for (int var4 = 0; var4 < 4; ++var4) {
            this.dropItemRand(Items.redstone, 1);
        }
        for (int var4 = 0; var4 < 6; ++var4) {
            this.dropItemRand(Items.repeater, 1);
        }
        for (int var4 = 0; var4 < 2; ++var4) {
            this.dropBlockRand(Blocks.redstone_block, 1);
        }
        /*
         * for (int var4 = 0; var4 < 2; ++var4) {
         * this.dropBlockRand(Basic.robotBlock, 1);
         * }
         */
        if (this.worldObj.rand.nextInt(3) == 1) {
            this.dropBlockRand((Block) Blocks.beacon, 1);
        }
    }

    public void initCreature() {}

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (super.attackEntityAsMob(par1Entity)) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
                final double ks = 5.15;
                double inair = 1.15;
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

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (!par1DamageSource.getDamageType()
            .equals("cactus")) {
            ret = super.attackEntityFrom(par1DamageSource, par2);
            final Entity e = par1DamageSource.getEntity();
            if (e != null && e instanceof EntityLivingBase) {
                this.rt = (EntityLivingBase) e;
            }
        }
        return ret;
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(3) == 1) {
            EntityLivingBase e = null;
            e = this.rt;
            /*
             * if (Basic.Snap != 0) {
             * e = null;
             * }
             */
            if (e != null) {
                if (e.isDead || this.worldObj.rand.nextInt(250) == 1) {
                    e = null;
                    this.rt = null;
                }
                if (e != null && !this.getEntitySenses()
                    .canSee((Entity) e)) {
                    e = null;
                }
            }
            if (e == null) {
                e = this.findSomethingToAttack();
            }
            if (e != null) {
                this.faceEntity((Entity) e, 10.0f, 10.0f);
                if (this.getDistanceSqToEntity((Entity) e) < (5.0f + e.width / 2.0f) * (5.0f + e.width / 2.0f)) {
                    this.setAttacking(1);
                    if (this.worldObj.rand.nextInt(12) == 1 || this.worldObj.rand.nextInt(8) == 1) {
                        this.attackEntityAsMob((Entity) e);
                        this.attackEntityAsMob((Entity) e);
                        this.attackEntityAsMob((Entity) e);
                        this.attackEntityAsMob((Entity) e);
                        this.attackEntityAsMob((Entity) e);
                        this.attackEntityAsMob((Entity) e);
                        this.attackEntityAsMob((Entity) e);
                        this.attackEntityAsMob((Entity) e);
                        this.attackEntityAsMob((Entity) e);
                        this.attackEntityAsMob((Entity) e);
                    }
                } else {
                    this.getNavigator()
                        .tryMoveToEntityLiving((Entity) e, 1.65);
                }
            } else {
                this.setAttacking(0);
            }
        }
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
        if (!this.getEntitySenses()
            .canSee((Entity) par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof TwilightMob) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode;
        }
        return par1EntityLiving instanceof EntityMob || MobUtils.isAttackableNonMob(par1EntityLiving);
    }

    private EntityLivingBase findSomethingToAttack() {
        /*
         * if (Basic.Snap != 0) {
         * return null;
         * }
         */
        final List var5 = this.worldObj
            .getEntitiesWithinAABB( EntityLivingBase.class, this.boundingBox.expand(18.0, 9.0, 18.0));
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

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public final void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, (Object) (byte) par1);
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
                        if (s != null && s.equals("TwilightMob")) {
                            return true;
                        }
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
        if (this.worldObj.isDaytime()) {
            return false;
        }
        TwilightMob target = null;
        target = (TwilightMob) this.worldObj.findNearestEntityWithinAABB(
             TwilightMob.class,
            this.boundingBox.expand(16.0, 8.0, 16.0),
            (Entity) this);
        return target == null;
    }

    private void robotcanon(final EntityLivingBase e) {
        final double yoff = 1.0;
        final double xzoff = 3.0;
        RobotBeam bf = null;
        final double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        final double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        final float r1 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        final float r2 = 3.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        final float r3 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        bf = new RobotBeam(
            this.worldObj,
            (EntityLivingBase) this,
            e.posX - cx + r1,
            e.posY + e.height / 2.0f - (this.posY + yoff) + r2,
            e.posZ - cz + r3);
        bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
        bf.setPosition(cx, this.posY + yoff, cz);
        bf.setRobot();
        this.worldObj.playSoundAtEntity(
            (Entity) this,
            "random.bow",
            1.0f,
            1.0f / (this.getRNG()
                .nextFloat() * 0.4f + 0.8f));
        this.worldObj.spawnEntityInWorld((Entity) bf);
    }

    @SideOnly(Side.CLIENT)
    public static class RenderTheMob extends RenderLiving {

        private static final ResourceLocation robottexture;

        public RenderTheMob(final ModelBase par1ModelBase, final float par2) {
            super(par1ModelBase, par2);
        }

        protected ResourceLocation getEntityTexture(final Entity entity) {
            return RenderTheMob.robottexture;
        }

        static {
            robottexture = new ResourceLocation(Tags.MODID + ":" + "textures/entity/ponyrobot.png");
        }
    }
}
