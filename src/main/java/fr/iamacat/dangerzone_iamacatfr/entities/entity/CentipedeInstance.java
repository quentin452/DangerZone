
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.render.InfoRenderer;
import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
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
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.*;

public class CentipedeInstance extends EntityMob {

    private GenericTargetSorterInstance TargetSorter;
    private InfoRenderer renderdata;
    private int force_sync;
    private int dmgDelay;
    private float moveSpeed;

    public CentipedeInstance(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.renderdata = new InfoRenderer();
        this.force_sync = 50;
        this.dmgDelay = 0;
        this.moveSpeed = 0.45f;
        this.setSize(2.0f, 1.0f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 150;
        this.fireResistance = 100;
        this.isImmuneToFire = false;
        this.TargetSorter = new GenericTargetSorterInstance((Entity) this);
        this.renderdata = new InfoRenderer();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMoveThroughVillage(this, 0.8999999761581421, false));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0f));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
        if (this.renderdata == null) {
            this.renderdata = new InfoRenderer();
        }
        this.renderdata.rf1 = 0.0f;
        this.renderdata.rf2 = 0.0f;
        this.renderdata.rf3 = 0.0f;
        this.renderdata.rf4 = 0.0f;
        this.renderdata.ri1 = 0;
        this.renderdata.ri2 = 0;
        this.renderdata.ri3 = 0;
        this.renderdata.ri4 = 0;
        this.force_sync = 50;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue((double) this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(18.0);
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        super.onUpdate();
        if (this.isAirBorne) {
            this.getNavigator()
                .setPath((PathEntity) null, 0.0);
        }
    }

    public int mygetMaxHealth() {
        return 120;
    }

    public InfoRenderer getRenderInfo() {
        return this.renderdata;
    }

    public void setRenderInfo(final InfoRenderer r) {
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
        return 20;
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
                .spawnParticle("reddust", this.posX + var1, this.posY + 2.0 + var2, this.posZ + var3, 0.0, 0.75, 0.0);
            this.worldObj
                .spawnParticle("smoke", this.posX + var1, this.posY + 2.0 + var2, this.posZ + var3, 0.0, 0.75, 0.0);
        }
    }

    protected void jump() {
        this.motionY += 0.149999976158142;
        this.posY += 0.5;
        final float f = 0.2f + Math.abs(this.worldObj.rand.nextFloat() * 0.45f);
        this.motionX -= f * Math.sin(Math.toRadians(this.rotationYawHead));
        this.motionZ += f * Math.cos(Math.toRadians(this.rotationYawHead));
        this.isAirBorne = true;
    }

    protected void jumpAtEntity(final EntityLivingBase e) {
        this.motionY += 0.25;
        this.posY += 0.25;
        final float f = 0.3f + Math.abs(this.worldObj.rand.nextFloat() * 0.25f);
        final float d = (float) Math.atan2(e.posX - this.posX, e.posZ - this.posZ);
        this.motionX += f * Math.sin(d);
        this.motionZ += f * Math.cos(d);
        this.isAirBorne = true;
    }

    public int getTrooperBugHealth() {
        return (int) this.getHealth();
    }

    protected String getLivingSound() {
        if (this.rand.nextInt(4) == 0) {
            return "mob.silverfish.say";
        }
        return "mob.silverfish.say";
    }

    protected String getHurtSound() {
        return "mob.silverfish.hit";
    }

    protected String getDeathSound() {
        return "mob.silverfish.kill";
    }

    protected float getSoundVolume() {
        return 2.5f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    /*
     * protected Item getDropItemId() {
     * return Basic.lightningCloud;
     * }
     */

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
        this.dropItemRand(Items.apple, 1);
        // this.dropItemRand(Basic.balloons, 1);
        int i = 2 + this.worldObj.rand.nextInt(5);
        for (int var4 = 0; var4 < 2; ++var4) {
            // this.dropItemRand(Basic.antenna, 1);
        }
        for (int var4 = 0; var4 < 4; ++var4) {
            this.dropItemRand(Items.egg, 4);
            this.dropItemRand(Items.golden_apple, 1);
            this.dropItemRand(Items.string, 5);
        }
        i = 1 + this.worldObj.rand.nextInt(5);
        for (int var4 = 0; var4 < i; ++var4) {
            final int var5 = this.worldObj.rand.nextInt(14);
            switch (var5) {
                case 0: {}
                case 2: {
                    // this.dropItemRand((Item)Basic.dashMeat, 1);
                    break;
                }
            }
        }
    }

    public void initCreature() {}

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final double ks = -0.0;
        double inair = 0.9;
        final int var2 = 6;
        if (super.attackEntityAsMob(par1Entity)) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
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
        if (this.dmgDelay > 0) {
            return false;
        }
        if (!par1DamageSource.getDamageType()
            .equals("cactus")
            && !par1DamageSource.getDamageType()
                .equals("fall")) {
            ret = super.attackEntityFrom(par1DamageSource, par2);
            this.dmgDelay = 20;
            final Entity e = par1DamageSource.getEntity();
            if (e != null && e instanceof EntityLiving) {
                this.setAttackTarget((EntityLivingBase) e);
                this.setTarget(e);
                this.getNavigator()
                    .tryMoveToEntityLiving((Entity) e, 1.2);
                ret = true;
            }
        }
        return ret;
    }

    protected void updateAITasks() {
        EntityLivingBase e = null;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.dmgDelay > 0) {
            --this.dmgDelay;
        }
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(5) == 0) {
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
                if (this.worldObj.rand.nextInt(10) == 1 && !this.isAirBorne) {
                    this.jumpAtEntity(e);
                } else if (this.getDistanceSqToEntity((Entity) e) < (5.5f + e.width / 2.0f) * (5.5f + e.width / 2.0f)) {
                    this.setAttacking(1);
                    if (this.worldObj.rand.nextInt(2) == 0 || this.worldObj.rand.nextInt(3) == 1) {
                        this.attackEntityAsMob((Entity) e);
                        if (!this.worldObj.isRemote) {
                            if (this.worldObj.rand.nextInt(3) == 1) {
                                this.worldObj.playSoundAtEntity((Entity) e, "mob.blaze.hit", 1.4f, 1.0f);
                            } else {
                                this.worldObj.playSoundAtEntity((Entity) e, "mob.blaze.hit", 1.0f, 1.0f);
                            }
                        }
                    }
                } else if (!this.isAirBorne) {
                    this.getNavigator()
                        .tryMoveToEntityLiving((Entity) e, 1.2);
                }
            } else {
                this.setAttacking(0);
            }
        }
        if (this.worldObj.rand.nextInt(150) == 1 && this.getHealth() < this.mygetMaxHealth()) {
            this.heal(1.0f);
        }
    }

    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4,
        final double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName(par1, par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving) var8).playLivingSound();
        }
        return var8;
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
        if (par1EntityLiving instanceof CentipedeInstance) {
            return false;
        }
        if (par1EntityLiving instanceof RainbowCentipedeInstance) {
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
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0, 7.0, 12.0));
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
        for (int k = -2; k < 2; ++k) {
            for (int j = -2; j < 2; ++j) {
                for (int i = 0; i < 5; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("MyCentipede")) {
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
        CentipedeInstance target = null;
        target = (CentipedeInstance) this.worldObj.findNearestEntityWithinAABB(
            CentipedeInstance.class,
            this.boundingBox.expand(16.0, 6.0, 16.0),
            (Entity) this);
        return target == null;
    }

    @SideOnly(Side.CLIENT)
    public static class RenderTheMob7 extends RenderLiving {

        private static final ResourceLocation gbugtexture;

        public RenderTheMob7(final ModelBase par1ModelBase, final float par2) {
            super(par1ModelBase, par2);
        }

        protected ResourceLocation getEntityTexture(final Entity entity) {
            return RenderTheMob7.gbugtexture;
        }

        static {
            gbugtexture = new ResourceLocation(Tags.MODID + ":" + "textures/entity/centipede.png");
        }
    }
}
