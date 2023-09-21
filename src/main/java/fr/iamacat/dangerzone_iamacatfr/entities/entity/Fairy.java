
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Fairy extends EntityAmbientCreature {

    private static final ResourceLocation texture0;
    private static final ResourceLocation texture1;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;
    private static final ResourceLocation texture4;
    private static final ResourceLocation texture5;
    private static final ResourceLocation texture6;
    private static final ResourceLocation texture7;
    private static final ResourceLocation texture8;
    int my_blink;
    int blinker;
    int myspace;
    public int fairy_type;
    private int force_sync;
    private ChunkCoordinates currentFlightTarget;
    private String myowner;
    private GenericTargetSorter TargetSorter;

    public Fairy(final World par1World) {
        super(par1World);
        this.my_blink = 0;
        this.blinker = 0;
        this.myspace = 0;
        this.fairy_type = 0;
        this.force_sync = 10;
        this.currentFlightTarget = null;
        this.myowner = null;
        this.TargetSorter = null;
        this.my_blink = 20 + this.rand.nextInt(20);
        this.setSize(0.4f, 0.8f);
        if (par1World != null) {
            this.fairy_type = par1World.rand.nextInt(9);
        }
        this.getNavigator()
            .setAvoidsWater(true);
        this.renderDistanceWeight = 3.0;
        this.tasks.addTask(0, new EntityAIWatchClosest(this, EntityLiving.class, 8.0f));
        this.tasks.addTask(1, new EntityAILookIdle(this));
        this.TargetSorter = new GenericTargetSorter(this);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.10000000149011612);
        this.getAttributeMap()
            .registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(3.0);
    }

    public ResourceLocation getTexture(final Fairy a) {
        if (this.fairy_type == 8) {
            return Fairy.texture8;
        }
        if (this.fairy_type == 7) {
            return Fairy.texture7;
        }
        if (this.fairy_type == 6) {
            return Fairy.texture6;
        }
        if (this.fairy_type == 5) {
            return Fairy.texture5;
        }
        if (this.fairy_type == 4) {
            return Fairy.texture4;
        }
        if (this.fairy_type == 3) {
            return Fairy.texture3;
        }
        if (this.fairy_type == 2) {
            return Fairy.texture2;
        }
        if (this.fairy_type == 1) {
            return Fairy.texture1;
        }
        return Fairy.texture0;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) this.fairy_type);
    }

    public void setOwner(final EntityLivingBase e) {
        EntityPlayer p = null;
        if (e != null && e instanceof EntityPlayer) {
            p = (EntityPlayer) e;
            final String s = p.getDisplayName();
            if (s != null) {
                this.myowner = s;
            }
        }
    }

    public float getBlink() {
        if (this.blinker < this.my_blink / 2) {
            return 240.0f;
        }
        return 0.0f;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            return false;
        }
        final boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), 2.0f);
        return var4;
    }

    public int getTotalArmorValue() {
        return 4;
    }

    protected float getSoundVolume() {
        return 0.25f;
    }

    protected float getSoundPitch() {
        return 1.7f;
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return Tags.MODID + ":rat_hit";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":big_splat";
    }

    public boolean canBePushed() {
        return true;
    }

    protected void collideWithEntity(final Entity par1Entity) {}

    protected void collideWithNearbyEntities() {}

    public int mygetMaxHealth() {
        return 40;
    }

    protected Item getDropItem() {
        return Item.getItemFromBlock(OreSpawnMain.CrystalTorch);
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.600000023841;
        ++this.blinker;
        if (this.blinker > this.my_blink) {
            this.blinker = 0;
        }
        --this.force_sync;
        if (this.force_sync < 0) {
            this.force_sync = 10;
            if (this.worldObj.isRemote) {
                this.fairy_type = this.dataWatcher.getWatchableObjectInt(20);
            } else {
                this.dataWatcher.updateObject(20, (Object) this.fairy_type);
            }
        }
        long t = this.worldObj.getWorldTime();
        t %= 24000L;
        if (t < 12000L) {
            return;
        }
        if (this.worldObj.isRemote && this.worldObj.rand.nextInt(5) == 0 && this.getBlink() > 1.0f) {
            this.worldObj.spawnParticle(
                "fireworksSpark",
                this.posX,
                this.posY - 0.15000000596046448,
                this.posZ,
                ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 8.0f),
                (-this.worldObj.rand.nextFloat() / 8.0f),
                ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 8.0f));
        }
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        if (this.myowner == null) {
            this.myowner = "null";
        }
        par1NBTTagCompound.setString("MyOwner", this.myowner);
        par1NBTTagCompound.setInteger("FairyType", this.fairy_type);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.myowner = par1NBTTagCompound.getString("MyOwner");
        if (this.myowner != null && this.myowner.equals("null")) {
            this.myowner = null;
        }
        this.fairy_type = par1NBTTagCompound.getInteger("fairyType");
    }

    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && par1EntityLiving != null
            && par1EntityLiving != this
            && par1EntityLiving.isEntityAlive()
            && this.getEntitySenses()
                .canSee(par1EntityLiving)
            && par1EntityLiving instanceof EntityMob;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(8.0, 8.0, 8.0));
        Collections.sort((List<Object>) var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7;
        EntityLivingBase var8;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.isSuitableTarget(var8, false)) {
                return var8;
            }
        }
        return null;
    }

    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.worldObj.rayTraceBlocks(
            Vec3.createVectorHelper(this.posX, this.posY + 0.25, this.posZ),
            Vec3.createVectorHelper(pX, pY, pZ),
            false) == null;
    }

    protected void updateAITasks() {
        int keep_trying = 25;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        if (this.worldObj.rand.nextInt(200) == 0
            || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 2.5f) {
            for (Block bid = Blocks.stone; bid != Blocks.air && keep_trying != 0; --keep_trying) {
                int zdir = this.worldObj.rand.nextInt(8);
                int xdir = this.worldObj.rand.nextInt(8);
                if (this.worldObj.rand.nextInt(2) == 0) {
                    zdir = -zdir;
                }
                if (this.worldObj.rand.nextInt(2) == 0) {
                    xdir = -xdir;
                }
                this.currentFlightTarget.set(
                    (int) this.posX + xdir,
                    (int) this.posY + this.worldObj.rand.nextInt(5) - 2,
                    (int) this.posZ + zdir);
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
        } else if (this.worldObj.rand.nextInt(12) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            EntityLivingBase e = null;
            e = this.findSomethingToAttack();
            if (e != null) {
                this.currentFlightTarget.set((int) e.posX, (int) (e.posY + 1.0), (int) e.posZ);
                if (this.getDistanceSqToEntity(e) < 6.0) {
                    this.attackEntityAsMob(e);
                }
            }
        } else if (this.myowner != null) {
            final EntityPlayer p = this.worldObj.getPlayerEntityByName(this.myowner);
            if (p != null) {
                if (this.getDistanceSqToEntity(p) > 64.0) {
                    this.currentFlightTarget.set(
                        (int) p.posX + this.worldObj.rand.nextInt(3) - this.worldObj.rand.nextInt(3),
                        (int) (p.posY + 1.0),
                        (int) p.posZ + this.worldObj.rand.nextInt(3) - this.worldObj.rand.nextInt(3));
                }
                if (this.getDistanceSqToEntity(p) > 256.0) {
                    this.setPosition(
                        p.posX + this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat(),
                        p.posY,
                        p.posZ + this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                }
            }
        }
        if (this.worldObj.rand.nextInt(250) == 1) {
            this.heal(1.0f);
        }
        final double var1 = this.currentFlightTarget.posX + 0.5 - this.posX;
        final double var2 = this.currentFlightTarget.posY + 0.1 - this.posY;
        final double var3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.2 - this.motionX) * 0.1;
        this.motionY += (Math.signum(var2) * 0.699999988079071 - this.motionY) * 0.1;
        this.motionZ += (Math.signum(var3) * 0.2 - this.motionZ) * 0.1;
        final float var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
        this.moveForward = 0.2f;
        this.rotationYaw += var5 / 4.0f;
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    public boolean getCanSpawnHere() {
        int sc = 0;
        for (int k = -1; k <= 1; ++k) {
            for (int j = -1; j <= 1; ++j) {
                final Block bid = this.worldObj.getBlock((int) this.posX + j, (int) this.posY, (int) this.posZ + k);
                if (bid == Blocks.air) {
                    ++sc;
                }
            }
        }
        return sc >= 6 && this.posY >= 50.0;
    }

    public void initCreature() {}

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired() && this.myowner == null;
    }

    static {
        texture0 = new ResourceLocation(Tags.MODID+":fairytexture.png");
        texture1 = new ResourceLocation(Tags.MODID+":fairytexture2.png");
        texture2 = new ResourceLocation(Tags.MODID+":fairytexture3.png");
        texture3 = new ResourceLocation(Tags.MODID+":fairytexture4.png");
        texture4 = new ResourceLocation(Tags.MODID+":fairytexture5.png");
        texture5 = new ResourceLocation(Tags.MODID+":fairytexture6.png");
        texture6 = new ResourceLocation(Tags.MODID+":fairytexture7.png");
        texture7 = new ResourceLocation(Tags.MODID+":fairytexture8.png");
        texture8 = new ResourceLocation(Tags.MODID+":fairytexture9.png");
    }
}
