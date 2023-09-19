
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class MagicInstance extends EntityThrowable {

    private int magictype;
    private int myage;
    private float my_rotation;

    public MagicInstance(final World par1World) {
        super(par1World);
        this.magictype = 0;
        this.myage = 0;
        this.my_rotation = 0.0f;
    }

    public MagicInstance(final World par1World, final int par2) {
        super(par1World);
        this.magictype = 0;
        this.myage = 0;
        this.my_rotation = 0.0f;
    }

    public MagicInstance(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.magictype = 0;
        this.myage = 0;
        this.my_rotation = 0.0f;
    }

    public MagicInstance(final World par1World, final EntityLivingBase par2EntityLiving, final int par3) {
        super(par1World, par2EntityLiving);
        this.magictype = 0;
        this.myage = 0;
        this.my_rotation = 0.0f;
        this.magictype = par3;
    }

    public MagicInstance(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.magictype = 0;
        this.myage = 0;
        this.my_rotation = 0.0f;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
    }

    public int getRockType() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setRockType(final int par1) {
        if (this.worldObj == null) {
            return;
        }
        if (this.worldObj.isRemote) {
            return;
        }
        this.magictype = par1;
        this.dataWatcher.updateObject(20, (Object) par1);
    }

    protected void onImpact(final MovingObjectPosition par1MovingObjectPosition) {
        if (this.isDead) {
            return;
        }
        if (this.worldObj.isRemote) {
            return;
        }
        if (par1MovingObjectPosition.entityHit != null && this.getThrower() != null) {
            final Entity e = par1MovingObjectPosition.entityHit;
            if (this.magictype == 1 && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 2.0f);
                final double ks = 0.1;
                double inair = 0.025;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            if (this.magictype == 2 && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 5.0f);
                final double ks = 0.2;
                double inair = 0.025;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            if (this.magictype == 3 && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 5.0f);
                final double ks = 0.2;
                double inair = 0.025;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                e.setFire(20);
            }
            if (this.magictype == 4 && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 5.0f);
                final double ks = 0.2;
                double inair = 0.025;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                if (e instanceof EntityLivingBase) {
                    ((EntityLivingBase) e).addPotionEffect(new PotionEffect(Potion.poison.id, 100, 0));
                }
            }
            if (this.magictype == 5 && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 10.0f);
                final double ks = 0.1;
                double inair = 0.025;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                if (e instanceof EntityLivingBase) {
                    ((EntityLivingBase) e).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 0));
                }
            }
            if (this.magictype == 6 && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 20.0f);
                final double ks = 0.2;
                double inair = 0.025;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                if (e instanceof EntityLivingBase) {
                    ((EntityLivingBase) e).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0));
                }
            }
            if (this.magictype == 7 && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 40.0f);
                final double ks = 0.2;
                double inair = 0.025;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            if (this.magictype == 8 && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 40.0f);
                final double ks = 0.5;
                double inair = 0.055;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                this.worldObj.newExplosion(
                    (Entity) null,
                    e.posX,
                    e.posY + 0.25,
                    e.posZ,
                    2.1f,
                    true,
                    this.worldObj.getGameRules()
                        .getGameRuleBooleanValue("mobGriefing"));
            }
            if (this.magictype == 9 && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 150.0f);
                final double ks = 0.2;
                double inair = 0.025;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                e.setFire(50);
                if (e instanceof EntityLivingBase) {
                    ((EntityLivingBase) e).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0));
                }
            }
            if (this.magictype == 10 && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 150.0f);
                final double ks = 0.2;
                double inair = 0.025;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                if (e instanceof EntityLivingBase) {
                    ((EntityLivingBase) e).addPotionEffect(new PotionEffect(Potion.poison.id, 200, 0));
                }
                if (e instanceof EntityLivingBase) {
                    ((EntityLivingBase) e).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0));
                }
            }
            if (this.magictype == 11 && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 150.0f);
                final double ks = 0.2;
                double inair = 0.025;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                if (e instanceof EntityLivingBase) {
                    ((EntityLivingBase) e).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 0));
                }
                if (e instanceof EntityLivingBase) {
                    ((EntityLivingBase) e).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0));
                }
            }
            if (this.magictype == 12 && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 2750.0f);
                final double ks = 0.2;
                double inair = 0.025;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                if (e instanceof EntityLivingBase) {
                    ((EntityLivingBase) e).addPotionEffect(new PotionEffect(Potion.confusion.id, 100, 0));
                }
                this.worldObj.newExplosion(
                    (Entity) null,
                    e.posX,
                    e.posY + 0.25,
                    e.posZ,
                    25.1f,
                    true,
                    this.worldObj.getGameRules()
                        .getGameRuleBooleanValue("mobGriefing"));
            }
        } else if (this.magictype != 0) {
            int played = 0;
            final int x = par1MovingObjectPosition.blockX;
            final int y = par1MovingObjectPosition.blockY;
            final int z = par1MovingObjectPosition.blockZ;
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    for (int k = -1; k <= 1; ++k) {
                        final Block bid = this.worldObj.getBlock(x + i, y + j, z + k);
                        if (bid == Blocks.glass || bid == Blocks.glass_pane) {
                            if (!this.worldObj.isRemote) {
                                this.worldObj.setBlock(x + i, y + j, z + k, Blocks.air, 0, k);
                            }
                            if (played == 0) {
                                this.worldObj.playSoundEffect((double) x, (double) y, (double) z, "", 1.0f, 1.0f);
                                ++played;
                            }
                        }
                    }
                }
            }
            if (!this.worldObj.isRemote) {
                if (this.magictype == 1) {}
                if (this.magictype == 2) {}
                if (this.magictype == 3) {}
                if (this.magictype == 4) {}
                if (this.magictype == 5) {}
                if (this.magictype == 6) {}
                if (this.magictype == 7) {}
                if (this.magictype == 8) {}
                if (this.magictype == 9) {}
                if (this.magictype == 10) {}
                if (this.magictype == 11) {}
                if (this.magictype == 12) {}
            }
        }
        this.setDead();
    }

    public void onUpdate() {
        final int x = (int) this.posX;
        final int y = (int) this.posY;
        final int z = (int) this.posZ;
        super.onUpdate();
        this.my_rotation += 30.0f;
        this.my_rotation %= 360.0f;
        final float my_rotation = this.my_rotation;
        this.prevRotationPitch = my_rotation;
        this.rotationPitch = my_rotation;
        ++this.myage;
        if (this.myage > 1000) {
            this.setDead();
        }
        if (this.worldObj.isRemote) {
            this.magictype = this.getRockType();
        } else {
            this.setRockType(this.magictype);
        }
        final Block bid = this.worldObj.getBlock(x, y, z);
        if (bid == Blocks.water && this.motionY < -0.1500000059604645
            && this.motionY > -0.550000011920929
            && (float) (this.motionX * this.motionX + this.motionZ * this.motionZ) > 0.5f) {
            this.motionY = -(this.motionY * 3.0 / 4.0);
            this.motionX = this.motionX * 3.0 / 4.0;
            this.motionZ = this.motionZ * 3.0 / 4.0;
        }
    }
}
