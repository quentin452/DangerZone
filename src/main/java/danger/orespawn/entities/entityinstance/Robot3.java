
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
import danger.orespawn.entities.renderer.RenderInfo;
import danger.orespawn.utils.GenericTargetSorter;
import danger.orespawn.utils.MyUtils;

public class Robot3 extends EntityMob {

    private GenericTargetSorter TargetSorter;
    private RenderInfo renderdata;
    private int reload_ticker;
    private float moveSpeed;

    public Robot3(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.renderdata = new RenderInfo();
        this.reload_ticker = 0;
        this.moveSpeed = 0.35f;
        this.setSize(2.5f, 5.0f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 60;
        this.fireResistance = 40;
        this.isImmuneToFire = true;
        this.TargetSorter = new GenericTargetSorter(this);
        this.renderdata = new RenderInfo();
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
            .setBaseValue(OreSpawnMain.Robot3_stats.attack);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
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
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
    }

    public int mygetMaxHealth() {
        return OreSpawnMain.Robot3_stats.health;
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
        return OreSpawnMain.Robot3_stats.defense;
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
        for (int var5 = 5 + this.worldObj.rand.nextInt(6), var6 = 0; var6 < var5; ++var6) {
            this.dropItemRand(OreSpawnMain.MyLaserBall, 4);
        }
        for (int i = 5 + this.worldObj.rand.nextInt(10), var6 = 0; var6 < i; ++var6) {
            final int var7 = this.worldObj.rand.nextInt(15);
            switch (var7) {
                case 0: {
                    is = this.dropItemRand(Items.redstone, 1);
                    break;
                }
                case 1: {
                    is = this.dropItemRand(Items.repeater, 1);
                    break;
                }
                case 2: {
                    is = this.dropItemRand(Items.comparator, 1);
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
                    is = this.dropItemRand(Item.getItemFromBlock(Blocks.redstone_block), 1);
                    break;
                }
                case 9: {
                    is = this.dropItemRand(Item.getItemFromBlock(Blocks.light_weighted_pressure_plate), 1);
                    break;
                }
            }
        }
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        return super.attackEntityAsMob(par1Entity);
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.reload_ticker > 0) {
            --this.reload_ticker;
            if (this.reload_ticker < 25) {
                this.setAttacking(0);
            }
        }
        if (this.reload_ticker == 0) {
            EntityLivingBase e = null;
            if (this.worldObj.rand.nextInt(50) == 1) {
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
            this.reload_ticker = 35;
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
                        final double yoff = 3.0;
                        final double xzoff = 1.75;
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
                        var2.setThrowableHeading(var3, var4 + var6, var5, 1.4f, 5.0f);
                        this.worldObj.playSoundAtEntity(this, "fireworks.launch", 3.0f, 1.0f);
                        this.worldObj.spawnEntityInWorld(var2);
                        this.setAttacking(1);
                    }
                    this.getNavigator()
                        .tryMoveToEntityLiving(e, 0.5);
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
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0, 3.0, 16.0));
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
