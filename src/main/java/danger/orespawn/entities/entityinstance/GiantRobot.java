
package danger.orespawn.entities.entityinstance;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import danger.orespawn.entities.ai.MyEntityAIWanderALot;
import danger.orespawn.entities.renderer.RenderGiantRobotInfo;
import danger.orespawn.utils.GenericTargetSorter;
import danger.orespawn.utils.MyUtils;

public class GiantRobot extends EntityMob {

    private GenericTargetSorter TargetSorter;
    private RenderGiantRobotInfo renderdata;
    private int reload_ticker;
    private float moveSpeed;

    public GiantRobot(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.renderdata = new RenderGiantRobotInfo();
        this.reload_ticker = 0;
        this.moveSpeed = 0.55f;
        this.setSize(3.0f, 9.75f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = OreSpawnMain.Jeffery_stats.health / 2;
        this.fireResistance = 40;
        this.isImmuneToFire = true;
        this.TargetSorter = new GenericTargetSorter(this);
        this.renderdata = new RenderGiantRobotInfo();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new MyEntityAIWanderALot(this, 14, 1.0));
        this.tasks.addTask(2, new EntityAIMoveThroughVillage(this, 0.8999999761581421, false));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(OreSpawnMain.Jeffery_stats.attack);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
        this.initLegData();
    }

    private void initLegData() {
        if (this.renderdata == null) {
            this.renderdata = new RenderGiantRobotInfo();
        }
        this.renderdata.hipydisplayangle = 0.0f;
        this.renderdata.hipxdisplayangle = 0.0f;
        this.renderdata.gpcounter = 2000000;
        this.renderdata.thighdisplayangle[0] = 0.0f;
        this.renderdata.thighdisplayangle[1] = 0.0f;
        this.renderdata.shindisplayangle[0] = 0.0f;
        this.renderdata.shindisplayangle[1] = 0.0f;
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
        return OreSpawnMain.Jeffery_stats.health;
    }

    public RenderGiantRobotInfo getRenderGiantRobotInfo() {
        return this.renderdata;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.Jeffery_stats.defense;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    protected void jump() {
        this.motionY += 0.25;
        super.jump();
    }

    protected String getLivingSound() {
        if (this.rand.nextInt(4) == 0) {
            return "orespawn:robot_living";
        }
        return null;
    }

    protected String getHurtSound() {
        return "orespawn:robot_hurt";
    }

    protected String getDeathSound() {
        return "orespawn:robot_death";
    }

    protected float getSoundVolume() {
        return 1.0f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItem() {
        return Items.iron_ingot;
    }

    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(
            this.worldObj,
            this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2),
            this.posY + 1.0,
            this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2),
            is);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }
        return is;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        ItemStack is = null;
        for (int var5 = 15 + this.worldObj.rand.nextInt(15), var6 = 0; var6 < var5; ++var6) {
            this.dropItemRand(OreSpawnMain.MyLaserBall, 4);
        }
        for (int i = 10 + this.worldObj.rand.nextInt(10), var6 = 0; var6 < i; ++var6) {
            final int var7 = this.worldObj.rand.nextInt(12);
            switch (var7) {
                case 0: {
                    is = this.dropItemRand(OreSpawnMain.SpiderRobotKit, 1);
                    break;
                }
                case 1: {
                    is = this.dropItemRand(OreSpawnMain.AntRobotKit, 1);
                    break;
                }
                case 2: {
                    is = this.dropItemRand(OreSpawnMain.MyRayGun, 1);
                    break;
                }
                case 3: {
                    is = this.dropItemRand(Item.getItemFromBlock(Blocks.redstone_block), 1);
                    break;
                }
                case 4: {
                    is = this.dropItemRand(Item.getItemFromBlock(Blocks.dispenser), 1);
                    break;
                }
                case 5: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block) Blocks.sticky_piston), 1);
                    break;
                }
                case 6: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block) Blocks.piston), 1);
                    break;
                }
                case 7: {
                    is = this.dropItemRand(Item.getItemFromBlock(Blocks.lever), 1);
                    break;
                }
                case 8: {
                    is = this.dropItemRand(Item.getItemFromBlock(Blocks.iron_block), 1);
                    break;
                }
                case 9: {
                    is = this.dropItemRand(Item.getItemFromBlock(Blocks.detector_rail), 1);
                    break;
                }
            }
        }
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final double ks = 2.2;
        double inair = 0.25;
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

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.reload_ticker > 0) {
            --this.reload_ticker;
        }
        if (this.worldObj.rand.nextInt(5) == 0) {
            EntityLivingBase e = null;
            if (this.worldObj.rand.nextInt(100) == 1) {
                this.setAttackTarget(null);
            }
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
                if (this.getDistanceSqToEntity(e) < 256.0) {
                    final double rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                    final double rhdir = Math.toRadians((this.rotationYawHead + 90.0f) % 360.0f);
                    final double pi = 3.1415926545;
                    double rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                    if (rdd > pi) {
                        rdd -= pi * 2.0;
                    }
                    rdd = Math.abs(rdd);
                    if (rdd < 0.5) {
                        if (this.reload_ticker == 0) {
                            final double yoff = 10.0;
                            final double xzoff = 3.75;
                            final LaserBall var2 = new LaserBall(
                                this.worldObj,
                                e.posX - this.posX,
                                e.posY - (this.posY + yoff),
                                e.posZ - this.posZ);
                            var2.setLocationAndAngles(
                                this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)),
                                this.posY + yoff,
                                this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYawHead)),
                                this.rotationYawHead,
                                this.rotationPitch);
                            final double var3 = e.posX - var2.posX;
                            final double var4 = e.posY - var2.posY;
                            final double var5 = e.posZ - var2.posZ;
                            final float var6 = MathHelper.sqrt_double(var3 * var3 + var5 * var5) * 0.2f;
                            var2.setThrowableHeading(var3, var4 + var6, var5, 2.0f, 4.0f);
                            if (this.getDistanceSqToEntity(e) > 100.0) {
                                var2.setSpecial();
                                this.reload_ticker = 25;
                                this.worldObj.playSoundAtEntity(this, "fireworks.launch", 3.5f, 0.5f);
                            } else {
                                this.reload_ticker = 10;
                                this.worldObj.playSoundAtEntity(this, "fireworks.launch", 2.5f, 1.0f);
                            }
                            this.worldObj.spawnEntityInWorld(var2);
                        }
                        if (this.getDistanceSqToEntity(e) < (8.0f + e.width / 2.0f) * (8.0f + e.width / 2.0f)) {
                            this.setAttacking(1);
                            this.attackEntityAsMob(e);
                        } else {
                            this.setAttacking(0);
                        }
                    }
                    this.getNavigator()
                        .tryMoveToEntityLiving(e, 0.5);
                } else {
                    this.setAttacking(0);
                }
            } else {
                this.setAttacking(0);
            }
        }
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (!par1DamageSource.getDamageType()
            .equals("cactus")) {
            ret = super.attackEntityFrom(par1DamageSource, par2);
        }
        final Entity e = par1DamageSource.getEntity();
        if (e != null && e instanceof EntityLiving) {
            this.setAttackTarget((EntityLivingBase) e);
            this.setTarget(e);
        }
        return ret;
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
        if (par1EntityLiving instanceof EntityMob) {
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
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0, 12.0, 16.0));
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
        this.dataWatcher.updateObject(20, par1);
    }

    public boolean getCanSpawnHere() {
        if (this.posY < 50.0) {
            return false;
        }
        if (this.worldObj.isDaytime()) {
            return false;
        }
        for (int k = -1; k < 1; ++k) {
            for (int j = -1; j <= 1; ++j) {
                for (int i = 1; i < 6; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid != Blocks.air && bid != Blocks.tallgrass) {
                        return false;
                    }
                }
            }
        }
        return this.isValidLightLevel();
    }
}
