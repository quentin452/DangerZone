
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.entities.render.MinotaurInfoRenderer;
import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
// todo add a spawn for this entity
public class IronWillInstance extends EntityMob {

    private GenericTargetSorterInstance TargetSorter;
    private MinotaurInfoRenderer renderdata;
    private int force_sync;
    private int dmgDelay;
    private float moveSpeed;

    public IronWillInstance(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.renderdata = new MinotaurInfoRenderer();
        this.force_sync = 50;
        this.dmgDelay = 0;
        this.moveSpeed = 0.4f;
        this.setSize(5.0f, 6.0f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 150;
        this.fireResistance = 100;
        this.isImmuneToFire = false;
        this.renderDistanceWeight = 12.0;
        this.TargetSorter = new GenericTargetSorterInstance((Entity) this);
        this.renderdata = new MinotaurInfoRenderer();
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
        this.initPunches();
    }

    private void initPunches() {
        if (this.renderdata == null) {
            this.renderdata = new MinotaurInfoRenderer();
        }
        this.renderdata.hipydisplayangle = 0.0f;
        this.renderdata.hipxdisplayangle = 0.0f;
        this.renderdata.gpcounter = 2000000;
        this.renderdata.thighdisplayangle[0] = 0.0f;
        this.renderdata.thighdisplayangle[1] = 0.0f;
        this.renderdata.shindisplayangle[0] = 0.0f;
        this.renderdata.shindisplayangle[1] = 0.0f;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue((double) this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(75.0);
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    public MinotaurInfoRenderer getRenderMinotaurInfo() {
        return this.renderdata;
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
        return 650;
    }

    public int getTotalArmorValue() {
        return 21;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    protected void JustCharge() {
        while (this.rotationYaw < 0.0f) {
            this.rotationYaw += 360.0f;
        }
        while (this.rotationYawHead < 0.0f) {
            this.rotationYawHead += 360.0f;
        }
        while (this.rotationYaw > 360.0f) {
            this.rotationYaw -= 360.0f;
        }
        while (this.rotationYawHead > 360.0f) {
            this.rotationYawHead -= 360.0f;
        }
        this.motionY += 0.05;
        this.posY += 0.05;
        final float f = 3.2f + Math.abs(this.worldObj.rand.nextFloat() * 0.45f);
        this.motionX += f * Math.cos(Math.toRadians(this.rotationYawHead + 90.0f));
        this.motionZ += f * Math.sin(Math.toRadians(this.rotationYawHead + 90.0f));
        this.isAirBorne = true;
        this.getNavigator()
            .setPath((PathEntity) null, 0.0);
    }

    protected void ChargeAtPlayer(final EntityLivingBase e) {
        this.motionY += 0.15;
        this.posY += 0.15;
        double d1 = e.posX - this.posX;
        final double d2 = e.posZ - this.posZ;
        final float d3 = (float) Math.atan2(d2, d1);
        final float f2 = (float) (d3 * 180.0 / 3.141592653589793) - 90.0f;
        this.rotationYaw = f2;
        d1 = Math.sqrt(d1 * d1 + d2 * d2);
        this.motionX += d1 * 0.15 * Math.cos(d3);
        this.motionZ += d1 * 0.15 * Math.sin(d3);
        this.isAirBorne = true;
        this.getNavigator()
            .setPath((PathEntity) null, 0.0);
    }

    public int getTrooperBugHealth() {
        return (int) this.getHealth();
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return Tags.MODID + ":beastroar";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":beastroar";
    }

    protected float getSoundVolume() {
        return 1.8f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItemId() {
        return Items.beef;
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
        // this.dropItemRand(Basic.bearTooth, 1);
        this.dropItemRand(Items.golden_apple, 1);
        int i = 2 + this.worldObj.rand.nextInt(5);
        for (int var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(Items.cooked_beef, 1);
        }
        for (int var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(Items.arrow, 1);
        }
        for (int var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(Items.apple, 1);
        }
        for (int var4 = 0; var4 < 2; ++var4) {
            this.dropItemRand(Items.ender_eye, 1);
        }
        i = 1 + this.worldObj.rand.nextInt(5);
        for (int var4 = 0; var4 < i; ++var4) {
            final int var5 = this.worldObj.rand.nextInt(14);
        }
        i = 1 + this.worldObj.rand.nextInt(5);
        for (int var4 = 0; var4 < i; ++var4) {
            final int var5 = this.worldObj.rand.nextInt(20);
            switch (var5) {
                case 0: {}
                case 2: {
                    // final ItemStack is = this.dropItemRand(Basic.ajSpade, 1);
                    break;
                }
                case 3: {
                    // final ItemStack is = this.dropItemRand(Basic.ajSword, 1);
                    break;
                }
                case 4: {
                    // final ItemStack is = this.dropBlockRand(Basic.hardAppleBlock, 1);
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
        final double ks = 5.0;
        double inair = 0.25;
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
            this.dmgDelay = 22;
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
                if (this.worldObj.rand.nextInt(10) == 1) {
                    this.ChargeAtPlayer(e);
                } else if (this.getDistanceSqToEntity((Entity) e) < (8.8f + e.width / 2.0f) * (8.8f + e.width / 2.0f)) {
                    this.setAttacking( 1);
                    this.attackEntityAsMob((Entity) e);
                    if (!this.worldObj.isRemote) {
                        if (this.worldObj.rand.nextInt(3) == 1) {
                            this.worldObj.playSoundAtEntity((Entity) e, "random.explode", 3.0f, 1.0f);
                        } else {
                            this.worldObj.playSoundAtEntity((Entity) e, "random.explode", 3.0f, 1.0f);
                        }
                    }
                } else if (!this.isAirBorne) {
                    this.getNavigator()
                        .tryMoveToEntityLiving((Entity) e, 1.2);
                }
            } else {
                this.setAttacking( 0);
            }
        }
        if (this.worldObj.rand.nextInt(60) == 1 && this.getHealth() < this.mygetMaxHealth()) {
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
        if (par1EntityLiving instanceof EntityEnderman) {
            return false;
        }
        if (par1EntityLiving instanceof EntityCreeper) {
            return false;
        }
        if (par1EntityLiving instanceof IronWillInstance) {
            return false;
        }
        if (par1EntityLiving instanceof MooseBigInstance) {
            return false;
        }
        if (par1EntityLiving instanceof MooseInstance) {
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
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(36.0, 18.0, 36.0));
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
        this.dataWatcher.updateObject(20, par1);
    }


    public boolean getCanSpawnHere() {
        for (int k = -3; k < 3; ++k) {
            for (int j = -3; j < 3; ++j) {
                for (int i = 0; i < 5; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("MyIronWill")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        for (int k = -2; k < 2; ++k) {
            for (int j = -2; j < 2; ++j) {
                for (int i = 1; i < 5; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid != Blocks.air) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
