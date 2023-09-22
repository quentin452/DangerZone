
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.entities.render.InfoRenderer;
import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBeacon;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class RainbowCentipedeInstance extends EntityMob {

    private GenericTargetSorterInstance TargetSorter;
    private InfoRenderer renderdata;
    private int dmgDelay;
    private float moveSpeed;
    private float defense;

    public RainbowCentipedeInstance(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.renderdata = new InfoRenderer();
        this.dmgDelay = 0;
        this.moveSpeed = 0.35f;
        this.defense = 22.5f;
        this.setSize(8.5f, 4.0f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 2500;
        this.fireResistance = 100;
        this.isImmuneToFire = true;
        this.renderDistanceWeight = 12.0;
        this.TargetSorter = new GenericTargetSorterInstance((Entity) this);
        this.renderdata = new InfoRenderer();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMoveThroughVillage(this, 0.8999999761581421, false));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(21, 0);
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
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue((double) this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(65.0);
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
        return 950;
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
        return 22;
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
            final float var1 = (this.rand.nextFloat() - 0.5f) * 16.0f;
            final float var2 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            final float var3 = (this.rand.nextFloat() - 0.5f) * 16.0f;
            this.worldObj
                .spawnParticle("note", this.posX + var1, this.posY + 2.0 + var2, this.posZ + var3, 0.0, 0.75, 0.0);
        }
    }

    protected void jump() {
        super.jump();
        this.motionY += 0.25;
        this.posY += 0.5;
    }

    public int getRainbowCentipedeHealth() {
        return (int) this.getHealth();
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return "mob.irongolem.hit";
    }

    protected String getDeathSound() {
        return "mob.irongolem.hit";
    }

    protected float getSoundVolume() {
        return 2.5f;
    }

    protected float getSoundPitch() {
        return 0.2f;
    }

    protected BlockBeacon getDropItemId() {
        return Blocks.beacon;
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
        /*
         * this.dropItemRand((Item)Basic.rainbow, 10);
         * this.dropItemRand(Basic.butterFlies, 8);
         * for (int i = 4 + this.worldObj.rand.nextInt(28), var4 = 0; var4 < i; ++var4) {
         * this.dropBlockRand(Basic.robotBlock, 1);
         * }
         * int i = 4 + this.worldObj.rand.nextInt(16);
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand((Item)Basic.rainbow, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand((Item)Basic.rainbow, 1);
         * }
         * for (int var4 = 0; var4 < 6; ++var4) {
         * this.dropItemRand(Basic.antenna, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand((Item)Basic.rainbow, 1);
         * }
         * if (this.worldObj.rand.nextInt(5) == 1) {
         * this.dropItemRand(Basic.eggCentipede, 6);
         * }
         */
        /*
         * i = 1 + this.worldObj.rand.nextInt(5);
         * for (int var4 = 0; var4 < i; ++var4) {
         * final int var5 = this.worldObj.rand.nextInt(20);
         * }
         */
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final double ks = 3.75;
        double inair = 0.2;
        int var2 = 6;
        if (super.attackEntityAsMob(par1Entity)) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
                if (this.worldObj.difficultySetting == EnumDifficulty.EASY) {
                    var2 = 8;
                    if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
                        var2 = 10;
                    } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                        var2 = 12;
                    }
                }
                if (this.worldObj.rand.nextInt(3) == 1) {
                    ((EntityLivingBase) par1Entity)
                        .addPotionEffect(new PotionEffect(Potion.digSlowdown.id, var2 * 80, 3));
                }
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
            .equals("cactus")) {
            ret = super.attackEntityFrom(par1DamageSource, par2);
            this.dmgDelay = 25;
            final Entity e = par1DamageSource.getEntity();
            if (e != null && e instanceof EntityLiving) {
                this.setAttackTarget((EntityLivingBase) e);
                this.setTarget(e);
                this.getNavigator()
                    .tryMoveToEntityLiving((Entity) e, 1.5);
            }
        }
        return ret;
    }

    protected void updateAITasks() {
        EntityLivingBase e;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.dmgDelay > 0) {
            --this.dmgDelay;
        }
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(4) == 0) {
            e = this.getAttackTarget();
            if (e != null && !e.isEntityAlive()) {
                this.setAttackTarget(null);
                e = null;
            }
            if (e == null) {
                e = this.findSomethingToAttack();
            }
            if (e != null) {
                this.faceEntity(e, 10.0f, 10.0f);
                this.setAttacking(1);
                if (this.getDistanceSqToEntity(e) < (11.0f + e.width / 2.0f) * (11.0f + e.width / 2.0f)) {
                    if (this.worldObj.rand.nextInt(1) == 0 || this.worldObj.rand.nextInt(1) == 1) {
                        this.attackEntityAsMob(e);
                        if (!this.worldObj.isRemote) {
                            if (this.worldObj.rand.nextInt(3) == 1) {
                                this.worldObj.playSoundAtEntity(e, "random.explode", 4.0f, 1.0f);
                            } else {
                                this.worldObj.playSoundAtEntity(e, "random.explode", 3.5f, 1.0f);
                            }
                        }
                    }
                } else {
                    this.getNavigator()
                        .tryMoveToEntityLiving((Entity) e, 1.5);
                }
                if (this.worldObj.rand.nextInt(40) == 1) {
                    final EntityCreature newent = (EntityCreature) spawnCreature(
                        this.worldObj,
                        "MyCentipede",
                        (this.posX + e.posX) / 2.0 + this.worldObj.rand.nextInt(5) - this.worldObj.rand.nextInt(5),
                        (this.posY + e.posY) / 2.0 + 1.01,
                        (this.posZ + e.posZ) / 2.0 + this.worldObj.rand.nextInt(5) - this.worldObj.rand.nextInt(5));
                }
            } else {
                this.setAttacking(0);
            }
        }
        if (this.worldObj.rand.nextInt(20) == 1 && this.getHealth() < this.mygetMaxHealth()) {
            this.heal(1.0f);
        }
    }

    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4,
        final double par6) {
        Entity var8;
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
        if (!this.getEntitySenses()
            .canSee((Entity) par1EntityLiving)) {
            return false;
        }
        if (MobUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof CentipedeInstance) {
            return false;
        }
        if (par1EntityLiving instanceof EntityCreeper) {
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
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(32.0, 6.0, 32.0));
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
                        if (s != null && s.equals("MyRainbowCentipede")) {
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
        RainbowCentipedeInstance target;
        target = (RainbowCentipedeInstance) this.worldObj.findNearestEntityWithinAABB(
            RainbowCentipedeInstance.class,
            this.boundingBox.expand(16.0, 6.0, 16.0),
            (Entity) this);
        return target == null;
    }

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(21);
    }

    public final void setAttacking(final int par1) {
        this.dataWatcher.updateObject(21, par1);
    }
}
