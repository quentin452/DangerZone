
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderInfo;
import fr.iamacat.dangerzone_iamacatfr.items.CrystalCow;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.MyUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
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

public class Rotator extends EntityMob {

    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorter TargetSorter;
    private RenderInfo renderdata;
    private int busy_fighting;
    private int was_spawnered;

    public Rotator(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.TargetSorter = null;
        this.renderdata = new RenderInfo();
        this.busy_fighting = 0;
        this.was_spawnered = 0;
        this.setSize(1.0f, 2.0f);
        this.experienceValue = 35;
        this.isImmuneToFire = true;
        this.fireResistance = 25;
        this.TargetSorter = new GenericTargetSorter(this);
        this.renderdata = new RenderInfo();
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(OreSpawnMain.Rotator_stats.attack);
    }

    protected void entityInit() {
        super.entityInit();
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
        return "vortexlive";
    }

    protected String getHurtSound() {
        return Tags.MODID + ":glasshit";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":glassdead";
    }

    public boolean canBePushed() {
        return true;
    }

    protected void collideWithEntity(final Entity par1Entity) {}

    public int mygetMaxHealth() {
        return OreSpawnMain.Rotator_stats.health;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        EntityLivingBase e = null;
        super.onUpdate();
        this.motionY *= 0.6;
        if (this.worldObj.isRemote && this.worldObj.rand.nextInt(10) == 1) {
            this.worldObj.spawnParticle(
                "fireworksSpark",
                this.posX,
                this.posY + 1.399999976158142,
                this.posZ,
                ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 4.0f),
                ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 4.0f),
                ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 4.0f));
        }
        this.busy_fighting = 0;
        e = this.findSomethingToAttack();
        if (e != null) {
            final double a = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
            this.worldObj.spawnParticle(
                "fireworksSpark",
                this.posX,
                this.posY + 1.399999976158142,
                this.posZ,
                Math.cos(a),
                (e.posY - this.posY) / 10.0,
                Math.sin(a));
            this.busy_fighting = 1;
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
        if (t < 12000L && this.worldObj.rand.nextInt(400) == 1) {
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
        if (this.rand.nextInt(300) == 0
            || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 2.1f) {
            for (Block bid = Blocks.stone; bid != Blocks.air && keep_trying != 0; --keep_trying) {
                zdir = this.rand.nextInt(10) + 8;
                xdir = this.rand.nextInt(10) + 8;
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
        } else if (this.rand.nextInt(9) == 2) {
            e = this.findSomethingToAttack();
            if (e != null) {
                double a = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                a += 1.5707963267948966;
                this.currentFlightTarget
                    .set((int) (e.posX + 2.5 * Math.cos(a)), (int) e.posY, (int) (e.posZ + 2.5 * Math.sin(a)));
                if (this.getDistanceSqToEntity(e) < 9.0) {
                    this.attackEntityAsMob(e);
                }
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
        if (e != null && e instanceof EntityArrow) {
            return false;
        }
        ret = super.attackEntityFrom(par1DamageSource, par2);
        if (e != null && this.currentFlightTarget != null) {
            this.currentFlightTarget.set((int) e.posX, (int) e.posY, (int) e.posZ);
        }
        return ret;
    }

    public boolean getCanSpawnHere() {
        for (int k = -2; k <= 2; ++k) {
            for (int j = -2; j <= 2; ++j) {
                for (int i = 1; i < 4; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("Rotator")) {
                            this.was_spawnered = 1;
                            return true;
                        }
                    }
                }
            }
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        for (int k = -1; k <= 1; ++k) {
            for (int j = -1; j <= 1; ++j) {
                for (int i = 1; i < 3; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid != Blocks.air) {
                        return false;
                    }
                }
            }
        }
        long t = this.worldObj.getWorldTime();
        t %= 24000L;
        return t >= 12000L;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.Rotator_stats.defense;
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
        return !(par1EntityLiving instanceof Termite) && !(par1EntityLiving instanceof Vortex)
            && !(par1EntityLiving instanceof Rotator)
            && !(par1EntityLiving instanceof DungeonBeast)
            && !(par1EntityLiving instanceof Peacock)
            && !(par1EntityLiving instanceof CrystalCow)
            && !(par1EntityLiving instanceof Irukandji)
            && !(par1EntityLiving instanceof Skate)
            && !(par1EntityLiving instanceof Whale)
            && !(par1EntityLiving instanceof Flounder)
            && !(par1EntityLiving instanceof Urchin)
            && !(par1EntityLiving instanceof TerribleTerror)
            && !(par1EntityLiving instanceof LurkingTerror)
            && !(par1EntityLiving instanceof CloudShark)
            && !(par1EntityLiving instanceof Mothra)
            && !(par1EntityLiving instanceof Bee)
            && !(par1EntityLiving instanceof Mantis);
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0, 10.0, 12.0));
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

    protected Item getDropItem() {
        final int i = this.worldObj.rand.nextInt(4);
        if (i == 0) {
            return OreSpawnMain.MyCrystalPinkIngot;
        }
        if (i == 1) {
            return OreSpawnMain.MyTigersEyeIngot;
        }
        if (i == 2) {
            return Item.getItemFromBlock(OreSpawnMain.CrystalCoal);
        }
        if (i == 3) {
            return Items.iron_ingot;
        }
        return null;
    }
}
