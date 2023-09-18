
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.util.*;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class MyBear extends EntityMob {

    private GenericTargetSorter TargetSorter;
    private float moveSpeed;
    private EntityLivingBase rt;

    public MyBear(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.34f;
        this.rt = null;
        this.setSize(3.0f, 4.0f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 350;
        this.fireResistance = 100;
        this.renderDistanceWeight = 1.0;
        this.TargetSorter = new GenericTargetSorter((Entity) this);
        this.tasks.addTask(0, (EntityAIBase) new EntityAISwimming((EntityLiving) this));
        this.tasks.addTask(1, (EntityAIBase) new EntityAIMoveThroughVillage((EntityCreature) this, 1.0, false));
        this.tasks.addTask(2, (EntityAIBase) new EntityAIWander((EntityCreature) this, 1.0));
        this.tasks
            .addTask(3, (EntityAIBase) new EntityAIWatchClosest((EntityLiving) this, (Class) EntityLiving.class, 8.0f));
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
            .setBaseValue(12.0);
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
        return 100;
    }

    public int getTotalArmorValue() {
        return 15;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    public void onDeathUpdate() {
        super.onDeathUpdate();
        for (int i = 0; i < 20; ++i) {
            final float var1 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            final float var2 = (this.rand.nextFloat() - 0.5f) * 4.0f;
            final float var3 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.worldObj
                .spawnParticle("crit", this.posX + var1, this.posY + 2.0 + var2, this.posZ + var3, 0.0, 0.75, 0.0);
            this.worldObj.spawnParticle(
                "largeexplode",
                this.posX + var1,
                this.posY + 2.0 + var2,
                this.posZ + var3,
                0.0,
                0.75,
                0.0);
        }
    }

    protected String getLivingSound() {
        if (this.rand.nextInt(3) == 0) {
            return "mob.enderdragon.growl";
        }
        return "";
    }

    protected String getHurtSound() {
        return Tags.MODID + ":beastroar";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":beastroar";
    }

    protected float getSoundVolume() {
        return 1.2f;
    }

    protected float getSoundPitch() {
        return 0.8f;
    }

    protected Item getDropItemId() {
        return Items.beef;
    }

    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        Random random = new Random();
        var3 = new EntityItem(
            this.worldObj,
            this.posX + random.nextInt(3) - random.nextInt(3),
            this.posY + 1.0,
            this.posZ + random.nextInt(3) - random.nextInt(3),
            is);
        final float f3 = (float) Math.atan2(random.nextInt() - this.posZ, random.nextInt() - this.posX);
        var3.addVelocity(Math.cos(f3) * 0.25, 0.44999998807907104, Math.sin(f3) * 0.25);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld((Entity) var3);
        }
        return is;
    }

    private ItemStack dropBlockRand(final Block index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        Random random = new Random();
        var3 = new EntityItem(
            this.worldObj,
            this.posX + random.nextInt(3) - random.nextInt(3),
            this.posY + 1.0,
            this.posZ + random.nextInt(3) - random.nextInt(3),
            is);
        final float f3 = (float) Math.atan2(random.nextInt() - this.posZ, random.nextInt() - this.posX);
        var3.addVelocity(Math.cos(f3) * 0.25, 0.44999998807907104, Math.sin(f3) * 0.25);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld((Entity) var3);
        }
        return is;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        /*
         * for (int var4 = 0; var4 < 8; ++var4) {
         * this.dropItemRand(Basic.bearFur, 1);
         * }
         * for (int var4 = 0; var4 < 15; ++var4) {
         * this.dropItemRand(Basic.bearFur, 1);
         * }
         * for (int var4 = 0; var4 < 16; ++var4) {
         * this.dropItemRand(Basic.diamondGems, 1);
         * }
         * for (int var4 = 0; var4 < 4; ++var4) {
         * this.dropBlockRand((Block)Blocks.leaves, 1);
         * }
         * for (int var4 = 0; var4 < 6; ++var4) {
         * this.dropItemRand(Basic.bearTooth, 1);
         * }
         */
        for (int var4 = 0; var4 < 2; ++var4) {
            this.dropItemRand(Items.apple, 1);
        }
        if (this.worldObj.rand.nextInt(3) == 1) {
            this.dropItemRand(Items.beef, 1);
        }
    }

    public void initCreature() {}

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (super.attackEntityAsMob(par1Entity)) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
                final double ks = 0.8;
                double inair = 0.05;
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
                this.setAttacking(1);
                if (this.getDistanceSqToEntity((Entity) e) < (5.5f + e.width / 3.0f) * (5.5f + e.width / 3.0f)) {
                    this.setAttacking(1);
                    if (this.worldObj.rand.nextInt(3) == 1 || this.worldObj.rand.nextInt(2) == 1) {
                        this.attackEntityAsMob((Entity) e);
                    }
                    if (this.getDistanceSqToEntity((Entity) e) < (3.0f + e.width / 3.0f) * (3.0f + e.width / 3.0f)) {
                        this.attackEntityAsMob((Entity) e);
                    }
                }
                if (this.getDistanceSqToEntity((Entity) e) < (300.0f + e.width / 2.0f) * (300.0f + e.width / 2.0f)) {
                    this.findSomethingToAttack();
                    if (e != null) {
                        this.getNavigator()
                            .tryMoveToEntityLiving((Entity) e, 1.25);
                    }
                } else {
                    this.getNavigator()
                        .tryMoveToEntityLiving((Entity) e, 1.25);
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
        if (par1EntityLiving instanceof MyBear) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode;
        }
        return !(par1EntityLiving instanceof EntityZombie) && !(par1EntityLiving instanceof EntitySkeleton)
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
            && (!MobUtils.isAttackableNonMob(par1EntityLiving) || true);
    }

    private EntityLivingBase findSomethingToAttack() {
        /*
         * if (Basic.Snap != 0) {
         * return null;
         * }
         */
        final List var5 = this.worldObj
            .getEntitiesWithinAABB((Class) EntityLivingBase.class, this.boundingBox.expand(18.0, 9.0, 18.0));
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

    @SideOnly(Side.CLIENT)
    public static class RenderTheMob17 extends RenderLiving {

        private static final ResourceLocation beartexture;

        public RenderTheMob17(final ModelBase par1ModelBase, final float par2) {
            super(par1ModelBase, par2);
        }

        protected ResourceLocation getEntityTexture(final Entity entity) {
            return RenderTheMob17.beartexture;
        }

        static {
            beartexture = new ResourceLocation(Tags.MODID + ":" + "textures/entity/bear.png");
        }
    }
}
