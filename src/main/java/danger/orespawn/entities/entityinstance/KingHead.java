
package danger.orespawn.entities.entityinstance;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class KingHead extends EntityLiving {

    private int boatPosRotationIncrements;
    private double boatX;
    private double boatY;
    private double boatZ;
    private double boatYaw;
    private double boatPitch;
    private double velocityX;
    private double velocityY;
    private double velocityZ;

    public KingHead(final World par1World) {
        super(par1World);
        this.setSize(19.9f, 10.0f);
        this.noClip = true;
        this.fireResistance = 10000;
        this.isImmuneToFire = true;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(OreSpawnMain.TheKing_stats.health);
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

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    protected boolean canTriggerWalking() {
        return false;
    }

    protected void entityInit() {
        super.entityInit();
    }

    public boolean canBePushed() {
        return true;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (par1DamageSource.getDamageType()
            .equals("inWall")) {
            return false;
        }
        Entity e = par1DamageSource.getEntity();
        if (e != null && (e instanceof TheKing || e instanceof KingHead)) {
            return false;
        }
        e = par1DamageSource.getSourceOfDamage();
        if (e != null && (e instanceof TheKing || e instanceof KingHead)) {
            return false;
        }
        final List var5 = this.worldObj.getEntitiesWithinAABB(TheKing.class, this.boundingBox.expand(48.0, 32.0, 48.0));
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        TheKing var8 = null;
        if (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (TheKing) var7;
            ret = var8.attackEntityFrom(par1DamageSource, par2);
        }
        return ret;
    }

    public boolean canBeCollidedWith() {
        return true;
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

    public void onUpdate() {
        if (this.isDead) {
            return;
        }
        this.isAirBorne = true;
        this.setFire(0);
        if (this.worldObj.isRemote) {
            if (this.boatPosRotationIncrements > 0) {
                final double d4 = this.posX + (this.boatX - this.posX) / this.boatPosRotationIncrements;
                final double d5 = this.posY + (this.boatY - this.posY) / this.boatPosRotationIncrements;
                final double d6 = this.posZ + (this.boatZ - this.posZ) / this.boatPosRotationIncrements;
                this.setPosition(d4, d5, d6);
                this.rotationPitch += (float) ((this.boatPitch - this.rotationPitch) / this.boatPosRotationIncrements);
                double d7 = MathHelper.wrapAngleTo180_double(this.boatYaw - this.rotationYaw);
                if (this.riddenByEntity != null) {
                    d7 = MathHelper.wrapAngleTo180_double(this.riddenByEntity.rotationYaw - this.rotationYaw);
                }
                this.setRotation(this.rotationYaw += (float) (d7 / this.boatPosRotationIncrements), this.rotationPitch);
                --this.boatPosRotationIncrements;
            }
        } else {
            final List var5 = this.worldObj
                .getEntitiesWithinAABB(TheKing.class, this.boundingBox.expand(32.0, 32.0, 32.0));
            final Iterator var6 = var5.iterator();
            Entity var7;
            TheKing var8;
            if (var6.hasNext()) {
                var7 = (Entity) var6.next();
                var8 = (TheKing) var7;
                this.posY = var8.posY + 12.0;
                this.posX = var8.posX - 30.0 * Math.sin(Math.toRadians(var8.rotationYawHead));
                this.posZ = var8.posZ + 30.0 * Math.cos(Math.toRadians(var8.rotationYawHead));
                this.rotationYaw = var8.rotationYaw;
                this.rotationYawHead = var8.rotationYawHead;
                this.motionX = var8.motionX;
                this.motionY = var8.motionY;
                this.motionZ = var8.motionZ;
                this.setHealth(var8.getHealth());
            } else {
                this.setDead();
            }
        }
    }
}
