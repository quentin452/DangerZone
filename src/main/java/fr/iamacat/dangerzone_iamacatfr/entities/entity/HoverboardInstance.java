
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C0CPacketInput;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.List;

public class HoverboardInstance extends EntityLiving {

    private int boatPosRotationIncrements;
    private double boatX;
    private double boatY;
    private double boatZ;
    private double boatYaw;
    private double boatPitch;
    private double velocityX;
    private double velocityY;
    private double velocityZ;
    private int damage_counter;
    private int exploding;
    private int color;
    private int playing;
    private static final ResourceLocation texture1;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;
    private static final ResourceLocation texture4;
    private static final ResourceLocation texture5;
    private static final ResourceLocation texture6;
    private static final ResourceLocation texture7;
    private static final ResourceLocation texture8;
    private static final ResourceLocation texture9;
    private static final ResourceLocation texture10;

    public HoverboardInstance(final World par1World) {
        super(par1World);
        this.damage_counter = 100;
        this.exploding = 0;
        this.color = 1;
        this.playing = 0;
        this.setSize(1.25f, 1.0f);
        this.riddenByEntity = null;
    }

    public HoverboardInstance(final World par1World, final double par2, final double par4, final double par6) {
        this(par1World);
        this.setPosition(par2, par4 + this.yOffset, par6);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = par2;
        this.prevPosY = par4;
        this.prevPosZ = par6;
    }

    public ResourceLocation getTexture() {
        switch (this.getColor()) {
            case 1: {
                return HoverboardInstance.texture1;
            }
            case 2: {
                return HoverboardInstance.texture2;
            }
            case 3: {
                return HoverboardInstance.texture3;
            }
            case 4: {
                return HoverboardInstance.texture4;
            }
            case 5: {
                return HoverboardInstance.texture5;
            }
            case 6: {
                return HoverboardInstance.texture6;
            }
            case 7: {
                return HoverboardInstance.texture7;
            }
            case 8: {
                return HoverboardInstance.texture8;
            }
            case 9: {
                return HoverboardInstance.texture9;
            }
            case 10: {
                return HoverboardInstance.texture10;
            }
            default: {
                return HoverboardInstance.texture1;
            }
        }
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(60.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(1.3300000429153442);
        this.getAttributeMap()
            .registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(0.0);
    }

    protected boolean canDespawn() {
        return false;
    }

    public boolean shouldRiderSit() {
        return false;
    }

    public int getTrackingRange() {
        return 128;
    }

    public int getUpdateFrequency() {
        return 10;
    }

    public boolean sendsVelocityUpdates() {
        return true;
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    protected boolean canTriggerWalking() {
        return false;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(22, 0);
        this.dataWatcher.addObject(23, 1);
        this.dataWatcher.addObject(24,0.0f);
        this.dataWatcher.addObject(20,0);
        this.dataWatcher.addObject(21, 0);
        this.func_110163_bv();
    }

    public boolean canBePushed() {
        return true;
    }

    public double getMountedYOffset() {
        return 0.5;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        final boolean p = par1DamageSource.getEntity() instanceof EntityPlayer;
        if (this.riddenByEntity != null && !p) {
            return false;
        }
        if (par1DamageSource.getDamageType()
            .equals("inWall")) {
            return false;
        }
        if (!this.worldObj.isRemote && !this.isDead) {
            this.setForwardDirection(-this.getForwardDirection());
            this.setTimeSinceHit(10);
            this.setDamageTaken(this.getDamageTaken() + par2 * 10.0f);
            this.setBeenAttacked();
            final boolean flag = par1DamageSource.getEntity() instanceof EntityPlayer
                && ((EntityPlayer) par1DamageSource.getEntity()).capabilities.isCreativeMode;
            if (flag || this.getDamageTaken() > 40.0f) {
                if (this.riddenByEntity != null) {
                    this.riddenByEntity.mountEntity(this);
                }
                if (!flag) {
                    this.dropItem(ItemInitDangerZone.Hoverboard, 1);
                }
                this.setDead();
            }
            return true;
        }
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void performHurtAnimation() {
        this.setForwardDirection(-this.getForwardDirection());
        this.setTimeSinceHit(10);
        this.setDamageTaken(this.getDamageTaken() * 11.0f);
    }

    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    @SideOnly(Side.CLIENT)
    public void setPositionAndRotation2(final double par1, final double par3, final double par5, final float par7,
        final float par8, final int par9) {
        if (this.riddenByEntity != null) {
            this.boatPosRotationIncrements = par9 + 8;
        } else {
            this.boatPosRotationIncrements = 6;
        }
        this.boatX = par1;
        this.boatY = par3;
        this.boatZ = par5;
        this.boatYaw = par7;
        this.boatPitch = par8;
        this.motionX = this.velocityX;
        this.motionY = this.velocityY;
        this.motionZ = this.velocityZ;
    }

    @SideOnly(Side.CLIENT)
    public void setVelocity(final double par1, final double par3, final double par5) {
        this.motionX = par1;
        this.velocityX = par1;
        this.motionY = par3;
        this.velocityY = par3;
        this.motionZ = par5;
        this.velocityZ = par5;
    }

    public void onLivingpdate() {
        if (this.riddenByEntity == null) {
            super.onLivingUpdate();
        }
        this.setFire(0);
    }

    public void onUpdate() {
        List list;
        final double velocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        double d6 = this.rand.nextFloat() * 2.0f - 1.0f;
        double d7 = (this.rand.nextInt(2) * 2 - 1) * 0.7;
        double obstruction_factor = 0.0;
        double relative_g = 0.0;
        double max_speed = 0.85;
        double gh = 0.75;
        int dist = 2;
        if (this.isDead) {
            return;
        }
        this.isAirBorne = true;
        if (this.getTimeSinceHit() > 0) {
            this.setTimeSinceHit(this.getTimeSinceHit() - 1);
        }
        if (this.getDamageTaken() > 0.0f) {
            this.setDamageTaken(this.getDamageTaken() - 1.0f);
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (velocity > 0.15 && this.riddenByEntity != null) {
            final double d8 = Math.cos(Math.toRadians(this.rotationYaw + 270.0f));
            final double d9 = Math.sin(Math.toRadians(this.rotationYaw + 270.0f));
            Block bid = Blocks.air;
            int i;
            for (i = 1; i < 10; ++i) {
                bid = this.worldObj.getBlock((int) this.posX, (int) this.posY - i, (int) this.posZ);
                if (bid != Blocks.air) {
                    break;
                }
            }
            for (int j = 0; j < 1.0 + velocity * 10.0; ++j) {
                d6 = this.rand.nextFloat() * 2.0f - 1.0f;
                d7 = (this.rand.nextInt(2) * 2 - 1) * 0.7;
                if (this.rand.nextBoolean()) {
                    final double d10 = this.posX - d8 * d6 * 0.8 + d9 * d7;
                    final double d11 = this.posZ - d9 * d6 * 0.8 - d8 * d7;
                    if (this.rand.nextBoolean()) {
                        this.worldObj.spawnParticle(
                            "smoke",
                            d10,
                            this.posY - 0.25,
                            d11,
                            this.motionX,
                            this.motionY,
                            this.motionZ);
                    } else {
                        this.worldObj.spawnParticle(
                            "reddust",
                            d10,
                            this.posY - 0.25,
                            d11,
                            this.motionX,
                            this.motionY,
                            this.motionZ);
                    }
                } else {
                    final double d10 = this.posX + d8 + d9 * d6 * 0.7;
                    final double d11 = this.posZ + d9 - d8 * d6 * 0.7;
                    if (this.rand.nextBoolean()) {
                        this.worldObj.spawnParticle(
                            "smoke",
                            d10,
                            this.posY - 0.225,
                            d11,
                            this.motionX,
                            this.motionY,
                            this.motionZ);
                    } else {
                        this.worldObj.spawnParticle(
                            "reddust",
                            d10,
                            this.posY - 0.225,
                            d11,
                            this.motionX,
                            this.motionY,
                            this.motionZ);
                    }
                }
                if (bid == Blocks.water || bid == Blocks.flowing_water) {
                    for (int k = 0; k < 5; ++k) {
                        this.worldObj.spawnParticle(
                            "splash",
                            this.posX + this.rand.nextFloat(),
                            this.posY - i + 1.25,
                            this.posZ + this.rand.nextFloat(),
                            this.motionX / 2.0,
                            this.motionY + velocity,
                            this.motionZ / 2.0);
                    }
                }
            }
        }
        if (this.playing > 0) {
            --this.playing;
        }
        if (this.riddenByEntity != null && this.playing == 0 && this.worldObj.rand.nextInt(80) == 1) {
            this.worldObj.playSoundAtEntity(this.riddenByEntity, Tags.MODID + ":hover", 0.45f, 1.0f);
            this.playing = 55;
        }
        if (!this.worldObj.isRemote) {
            if (this.exploding > 0) {
                --this.exploding;
            }
            if (this.exploding == 0 && velocity > 0.65 && this.worldObj.rand.nextInt(20000) == 1) {
                this.exploding = 45;
                this.playing = 50;
            }
            this.setExploding(this.exploding);
        } else {
            this.exploding = this.getExploding();
        }
        if (this.getExploding() > 0 && this.riddenByEntity != null) {
            if (this.worldObj.rand.nextInt(10) == 1) {
                this.worldObj.playSoundAtEntity(
                    this.riddenByEntity,
                    "random.explode",
                    0.55f,
                    0.75f + this.worldObj.rand.nextFloat());
            }
            for (int i = 0; i < 15; ++i) {
                this.worldObj.spawnParticle(
                    "explode",
                    (int) (this.posX + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 4.0f),
                    (int) (this.posY + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 4.0f),
                    (int) (this.posZ + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 4.0f),
                    this.motionX,
                    0.0,
                    this.motionZ);
                this.worldObj.spawnParticle(
                    "largeexplode",
                    (int) (this.posX + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 2.0f),
                    (int) (this.posY + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 2.0f),
                    (int) (this.posZ + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 2.0f),
                    this.motionX,
                    0.0,
                    this.motionZ);
                this.worldObj.spawnParticle(
                    "smoke",
                    (int) (this.posX + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 5.0f),
                    (int) (this.posY + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 5.0f),
                    (int) (this.posZ + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 5.0f),
                    this.motionX,
                    0.0,
                    this.motionZ);
                this.worldObj.spawnParticle(
                    "largesmoke",
                    (int) (this.posX + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 3.0f),
                    (int) (this.posY + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 3.0f),
                    (int) (this.posZ + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 3.0f),
                    this.motionX,
                    0.0,
                    this.motionZ);
            }
        }
        if (this.worldObj.isRemote) {
            if (this.riddenByEntity == null) {
                final Block bid = this.worldObj
                    .getBlock((int) this.posX, (int) ((float) this.posY - (float) gh), (int) this.posZ);
                if (bid != Blocks.air) {
                    this.motionY += 0.06;
                    this.posY += 0.07;
                    this.boatY += 0.07;
                } else {
                    this.motionY -= 0.003;
                }
            } else if (this.riddenByEntity instanceof EntityClientPlayerMP) {
                final EntityClientPlayerMP pp = (EntityClientPlayerMP) this.riddenByEntity;
                pp.sendQueue.addToSendQueue(
                    (Packet) new C03PacketPlayer.C05PacketPlayerLook(pp.rotationYaw, pp.rotationPitch, pp.onGround));
                pp.sendQueue.addToSendQueue(
                    (Packet) new C0CPacketInput(
                        pp.moveStrafing,
                        pp.moveForward,
                        pp.movementInput.jump,
                        pp.movementInput.sneak));
            }
            if (this.boatPosRotationIncrements > 0) {
                final double d8 = this.posX + (this.boatX - this.posX) / this.boatPosRotationIncrements;
                final double d9 = this.posY + (this.boatY - this.posY) / this.boatPosRotationIncrements;
                final double d12 = this.posZ + (this.boatZ - this.posZ) / this.boatPosRotationIncrements;
                this.setPosition(d8, d9, d12);
                this.rotationPitch += (float) ((this.boatPitch - this.rotationPitch) / this.boatPosRotationIncrements);
                double d13 = MathHelper.wrapAngleTo180_double(this.boatYaw - this.rotationYaw);
                if (this.riddenByEntity != null) {
                    d13 = MathHelper.wrapAngleTo180_double(this.riddenByEntity.rotationYaw - this.rotationYaw);
                }
                this.setRotation(
                    this.rotationYaw += (float) (d13 / this.boatPosRotationIncrements),
                    this.rotationPitch);
                --this.boatPosRotationIncrements;
            } else {
                final double d8 = this.posX + this.motionX;
                final double d9 = this.posY + this.motionY;
                final double d12 = this.posZ + this.motionZ;
                this.setPosition(d8, d9, d12);
                this.motionX *= 0.99;
                this.motionY *= 0.95;
                this.motionZ *= 0.99;
            }
        } else {
            if (this.riddenByEntity != null) {
                gh = 1.25;
            }
            Block bid = this.worldObj
                .getBlock((int) this.posX, (int) ((float) this.posY - (float) gh), (int) this.posZ);
            if (bid != Blocks.air) {
                this.motionY += 0.06;
                this.posY += 0.1;
                if (bid == Blocks.tallgrass && this.riddenByEntity != null
                    && this.worldObj.rand.nextInt(200) == 1
                    && this.worldObj.getGameRules()
                        .getGameRuleBooleanValue("mobGriefing")) {
                    this.worldObj.setBlock((int) this.posX, (int) (this.posY - gh), (int) this.posZ, Blocks.air);
                }
                if (bid == Blocks.grass && this.riddenByEntity != null
                    && this.worldObj.rand.nextInt(200) == 1
                    && this.worldObj.getGameRules()
                        .getGameRuleBooleanValue("mobGriefing")) {
                    this.worldObj.setBlock((int) this.posX, (int) (this.posY - gh), (int) this.posZ, Blocks.dirt);
                }
            } else {
                this.motionY -= 0.01;
            }
            if (this.riddenByEntity != null) {
                final EntityPlayer pp2 = (EntityPlayer) this.riddenByEntity;
                obstruction_factor = 0.0;
                dist = 3;
                dist += (int) (velocity * 8.0);
                for (int k = 1; k < dist; ++k) {
                    for (int i = 1; i < dist * 2; ++i) {
                        final double dx = i * Math.cos(Math.toRadians(this.rotationYaw + 90.0f));
                        final double dz = i * Math.sin(Math.toRadians(this.rotationYaw + 90.0f));
                        bid = this.worldObj
                            .getBlock((int) (this.posX + dx), (int) this.posY - k, (int) (this.posZ + dz));
                        if (bid != Blocks.air) {
                            obstruction_factor += 0.05;
                        }
                    }
                }
                this.motionY += obstruction_factor * 0.11;
                this.posY += obstruction_factor * 0.11;
                double d8;
                for (d8 = this.riddenByEntity.rotationYaw, d8 %= 360.0; d8 < 0.0; d8 += 360.0) {}
                double d9;
                for (d9 = this.rotationYaw, d9 %= 360.0; d9 < 0.0; d9 += 360.0) {}
                for (relative_g = (d8 - d9) % 180.0; relative_g < 0.0; relative_g += 180.0) {}
                if (relative_g > 90.0) {
                    relative_g -= 180.0;
                }
                if (velocity > 0.01) {
                    d8 = 1.85 - velocity;
                    d8 = Math.abs(d8);
                    if (d8 < 0.01) {
                        d8 = 0.01;
                    }
                    if (d8 > 0.9) {
                        d8 = 0.9;
                    }
                    this.rotationYaw = this.riddenByEntity.rotationYaw + (float) (relative_g * d8);
                } else {
                    this.rotationYaw = this.riddenByEntity.rotationYaw;
                }
                relative_g = Math.abs(relative_g) * velocity;
                if (relative_g > 50.0) {
                    relative_g = 0.0;
                }
                this.rotationPitch = 10.0f * (float) velocity;
                this.setRotation(this.rotationYaw, this.rotationPitch);
                double newvelocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
                if (this.exploding != 0) {
                    newvelocity -= 0.05;
                    if (newvelocity < 0.0) {
                        newvelocity = 0.0;
                    }
                }
                final double rr = Math.atan2(this.riddenByEntity.motionZ, this.riddenByEntity.motionX);
                final double rhm = Math.atan2(this.motionZ, this.motionX);
                final double rhdir = Math.toRadians((this.riddenByEntity.rotationYaw + 90.0f) % 360.0f);
                final double rt = 0.0;
                final double pi = 3.1415926545;
                double deltav = 0.0;
                final float im = pp2.moveForward;
                if (DangerZone.flyup_keystate != 0) {
                    ++max_speed;
                }
                double rdv = Math.abs(rhm - rhdir) % (pi * 2.0);
                if (rdv > pi) {
                    rdv -= pi * 2.0;
                }
                rdv = Math.abs(rdv);
                if (Math.abs(newvelocity) < 0.01) {
                    rdv = 0.0;
                }
                if (rdv > 1.5) {
                    newvelocity = -newvelocity;
                }
                if (Math.abs(im) > 0.001f) {
                    if (im > 0.0f) {
                        deltav = 0.025;
                        if (max_speed > 1.0) {
                            deltav += 0.15;
                        }
                    } else {
                        max_speed = 0.35;
                        deltav = -0.02;
                    }
                    newvelocity += deltav;
                    if (newvelocity >= 0.0) {
                        if (newvelocity > max_speed) {
                            newvelocity = max_speed;
                        }
                        this.motionX = Math.cos(Math.toRadians(this.rotationYaw + 90.0f)) * newvelocity;
                        this.motionZ = Math.sin(Math.toRadians(this.rotationYaw + 90.0f)) * newvelocity;
                    } else {
                        if (newvelocity < -max_speed) {
                            newvelocity = -max_speed;
                        }
                        newvelocity = -newvelocity;
                        this.motionX = Math.cos(Math.toRadians(this.rotationYaw + 270.0f)) * newvelocity;
                        this.motionZ = Math.sin(Math.toRadians(this.rotationYaw + 270.0f)) * newvelocity;
                    }
                } else if (newvelocity >= 0.0) {
                    this.motionX = Math.cos(Math.toRadians(this.rotationYaw + 90.0f)) * newvelocity;
                    this.motionZ = Math.sin(Math.toRadians(this.rotationYaw + 90.0f)) * newvelocity;
                } else {
                    this.motionX = Math.cos(Math.toRadians(this.rotationYaw + 270.0f)) * (newvelocity * -1.0);
                    this.motionZ = Math.sin(Math.toRadians(this.rotationYaw + 270.0f)) * (newvelocity * -1.0);
                }
            } else if (this.riddenByEntity == null) {
                this.motionX = 0.0;
                this.motionZ = 0.0;
            }
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            if (this.isCollidedHorizontally && velocity > 0.75) {
                this.setDead();
                for (int p = this.worldObj.rand.nextInt(10), k = 0; k < 6 + p; ++k) {
                    this.dropItem(Items.stick, 1);
                }
                for (int k = 0; k < 2; ++k) {
                    this.dropItem(Items.diamond, 1);
                }
            } else {
                this.motionX *= 0.98;
                this.motionY *= 0.94;
                this.motionZ *= 0.98;
            }
            list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(0.25, 0.0, 0.25));
            if (list != null && !list.isEmpty()) {
                for (int l = 0; l < list.size(); ++l) {
                    final Entity entity = (Entity) list.get(l);
                    if (entity != this.riddenByEntity && entity.canBePushed()
                        && !(entity instanceof GirlfriendInstance)
                        && !(entity instanceof BoyfriendInstance)) {
                        entity.applyEntityCollision(this);
                    }
                }
            }
            if (this.riddenByEntity != null && this.riddenByEntity.isDead) {
                this.riddenByEntity = null;
            }
        }
    }

    public void updateRiderPosition() {
        if (this.riddenByEntity != null) {
            this.riddenByEntity.setPosition(
                this.posX,
                this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(),
                this.posZ);
        }
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        par1NBTTagCompound.setInteger("HoverColor", this.getColor());
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        this.color = par1NBTTagCompound.getInteger("HoverColor");
        if (this.color < 1) {
            this.color = 1;
        }
        if (this.color > 10) {
            this.color = 10;
        }
        this.setColor(this.color);
    }

    public float getShadowSize() {
        return 0.25f;
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
            var2 = null;
        }
        if (var2 != null && var2.getItem() == ItemInitDangerZone.MyUltimateSword
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0) {
            if (!this.worldObj.isRemote) {
                ++this.color;
                if (this.color > 10) {
                    this.color = 1;
                }
                this.setColor(this.color);
            }
            return true;
        }
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer
            && this.riddenByEntity != par1EntityPlayer) {
            return true;
        }
        if (!this.worldObj.isRemote) {
            par1EntityPlayer.mountEntity(this);
        }
        return true;
    }

    public void setDamageTaken(final float f) {
        this.dataWatcher.updateObject(24, (Object) f);
    }

    public float getDamageTaken() {
        return this.dataWatcher.getWatchableObjectFloat(24);
    }

    public void setTimeSinceHit(final int par1) {
        this.dataWatcher.updateObject(22, (Object) par1);
    }

    public int getTimeSinceHit() {
        return this.dataWatcher.getWatchableObjectInt(22);
    }

    public void setForwardDirection(final int par1) {
        this.dataWatcher.updateObject(23, (Object) par1);
    }

    public int getForwardDirection() {
        return this.dataWatcher.getWatchableObjectInt(23);
    }

    public void setExploding(final int par1) {
        this.dataWatcher.updateObject(20, (Object) par1);
    }

    public int getExploding() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setColor(final int par1) {
        this.dataWatcher.updateObject(21, (Object) par1);
    }

    public int getColor() {
        return this.dataWatcher.getWatchableObjectInt(21);
    }

    static {
        texture1 = new ResourceLocation(Tags.MODID + ":Elevator1.png");
        texture2 = new ResourceLocation(Tags.MODID + ":Elevator2.png");
        texture3 = new ResourceLocation(Tags.MODID + ":Elevator3.png");
        texture4 = new ResourceLocation(Tags.MODID + ":Elevator4.png");
        texture5 = new ResourceLocation(Tags.MODID + ":Elevator5.png");
        texture6 = new ResourceLocation(Tags.MODID + ":Elevator6.png");
        texture7 = new ResourceLocation(Tags.MODID + ":Elevator7.png");
        texture8 = new ResourceLocation(Tags.MODID + ":Elevator8.png");
        texture9 = new ResourceLocation(Tags.MODID + ":Elevator9.png");
        texture10 = new ResourceLocation(Tags.MODID + ":Elevator10.png");
    }
}
