
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderSpiderRobotInfo;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.MyUtils;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

public class AntRobot extends EntityLiving {

    private int boatPosRotationIncrements;
    private double boatX;
    private double boatY;
    private double boatZ;
    private double boatYaw;
    private double boatPitch;
    private int playing;
    private GenericTargetSorter TargetSorter;
    private float moveSpeed;
    private RenderSpiderRobotInfo renderdata;
    private int didonce;
    private int rideTicker;
    private int owned;

    public AntRobot(final World par1World) {
        super(par1World);
        this.playing = 0;
        this.TargetSorter = null;
        this.moveSpeed = 0.3f;
        this.renderdata = new RenderSpiderRobotInfo();
        this.didonce = 0;
        this.rideTicker = 0;
        this.owned = 0;
        this.setSize(2.75f, 1.25f);
        this.riddenByEntity = null;
        this.TargetSorter = new GenericTargetSorter(this);
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 12.0f));
        this.tasks.addTask(2, new EntityAILookIdle(this));
        this.isImmuneToFire = true;
        this.experienceValue = OreSpawnMain.AntRobot_stats.health / 2;
    }

    public AntRobot(final World par1World, final double par2, final double par4, final double par6) {
        this(par1World);
        this.setPosition(par2, par4 + this.yOffset, par6);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = par2;
        this.prevPosY = par4;
        this.prevPosZ = par6;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(OreSpawnMain.AntRobot_stats.health);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        this.getAttributeMap()
            .registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(OreSpawnMain.AntRobot_stats.attack);
    }

    protected boolean canDespawn() {
        return false;
    }

    public void setOwned() {
        this.owned = 1;
    }

    public int getOwned() {
        return this.owned;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.AntRobot_stats.defense;
    }

    protected void updateAITasks() {
        EntityLivingBase e = null;
        if (this.isDead) {
            return;
        }
        if (this.riddenByEntity != null) {
            return;
        }
        super.updateAITasks();
        if (this.owned == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            if (this.worldObj.rand.nextInt(20) == 0) {
                this.feetFindSomethingToHit();
            }
            if (this.worldObj.rand.nextInt(150) == 0) {
                this.setAttackTarget(null);
            }
            e = this.getAttackTarget();
            if (e != null && !e.isEntityAlive()) {
                this.setAttackTarget(null);
                e = null;
            }
            if (e == null) {
                e = this.findSomethingToAttack(2.0f, false);
            }
            if (e != null) {
                this.faceEntity(e, 10.0f, 10.0f);
                if (this.getDistanceSqToEntity(e) > 16.0) {
                    final double d1 = e.posZ - this.posZ;
                    final double d2 = e.posX - this.posX;
                    final double dd = Math.atan2(d1, d2);
                    this.goThisWay(0.2 * Math.cos(dd), 0.2 * Math.sin(dd));
                }
            } else {
                this.setAttacking(0);
            }
            if (e != null && this.worldObj.rand.nextInt(15) == 0) {
                e = this.getAttackTarget();
                if (e == null) {
                    e = this.findSomethingToAttack(2.0f, true);
                }
                if (e != null) {
                    if (this.getDistanceSqToEntity(e) < (6.0f + e.width / 2.0f) * (6.0f + e.width / 2.0f)) {
                        this.setAttacking(1);
                        this.attackEntityAsMob(e);
                    } else {
                        this.setAttacking(0);
                    }
                } else {
                    this.setAttacking(0);
                }
            }
        }
    }

    protected void updateAITick() {
        if (this.riddenByEntity != null) {
            return;
        }
        super.updateAITick();
    }

    private void initLegData() {
        if (this.renderdata == null) {
            this.renderdata = new RenderSpiderRobotInfo();
        }
        for (int i = 0; i < 6; ++i) {
            this.renderdata.ycurrentangle[i] = 0.0f;
            this.renderdata.ywantedangle[i] = 0.0f;
            this.renderdata.ydisplayangle[i] = 0.0f;
            this.renderdata.yvelocity[i] = 0.0f;
            this.renderdata.ymid[i] = 0.0f;
            this.renderdata.yoff[i] = 0.0f;
            this.renderdata.yrange[i] = 0.0f;
            this.renderdata.udcurrentangle[i] = 0.0f;
            this.renderdata.udwantedangle[i] = 0.0f;
            this.renderdata.uddisplayangle[i] = 0.0f;
            this.renderdata.udvelocity[i] = 0.0f;
            this.renderdata.p1xangle[i] = 0.7853981633974483;
            this.renderdata.p2xangle[i] = 0.0;
            this.renderdata.p3xangle[i] = -0.7853981633974483;
            this.renderdata.pxvelocity[i] = 0.0f;
            this.renderdata.foot_xpos[i] = (float) this.posX;
            this.renderdata.foot_ypos[i] = (float) this.posY;
            this.renderdata.foot_zpos[i] = (float) this.posZ;
            this.renderdata.realposx[i] = 0.0f;
            this.renderdata.realposy[i] = 0.0f;
            this.renderdata.realposz[i] = 0.0f;
            this.renderdata.legoff[i] = 0.0f;
            this.renderdata.footup[i] = 1;
            this.renderdata.uppoint[i] = 0.0f;
            this.renderdata.footingticker[i] = 0;
            this.renderdata.gpcounter = 0;
            if (i == 0) {
                this.renderdata.legoff[i] = 0.75f;
                this.renderdata.ymid[i] = 0.0f;
                this.renderdata.yrange[i] = 0.2617994f;
                this.renderdata.pairedwith[i] = 1;
                this.renderdata.yoff[i] = -0.75f;
            }
            if (i == 1) {
                this.renderdata.legoff[i] = 0.75f;
                this.renderdata.ymid[i] = 3.1415927f;
                this.renderdata.yrange[i] = -0.2617994f;
                this.renderdata.pairedwith[i] = 0;
                this.renderdata.yoff[i] = -0.75f;
            }
            if (i == 2) {
                this.renderdata.legoff[i] = 1.0f;
                this.renderdata.ymid[i] = -0.7853982f;
                this.renderdata.yrange[i] = 0.2617994f;
                this.renderdata.pairedwith[i] = 3;
                this.renderdata.yoff[i] = -0.75f;
            }
            if (i == 3) {
                this.renderdata.legoff[i] = 1.0f;
                this.renderdata.ymid[i] = 3.9269907f;
                this.renderdata.yrange[i] = -0.2617994f;
                this.renderdata.pairedwith[i] = 2;
                this.renderdata.yoff[i] = -0.75f;
            }
            if (i == 4) {
                this.renderdata.legoff[i] = 1.15f;
                this.renderdata.ymid[i] = 0.7853982f;
                this.renderdata.yrange[i] = 0.2617994f;
                this.renderdata.pairedwith[i] = 5;
                this.renderdata.yoff[i] = -0.75f;
            }
            if (i == 5) {
                this.renderdata.legoff[i] = 1.15f;
                this.renderdata.ymid[i] = 2.3561945f;
                this.renderdata.yrange[i] = -0.2617994f;
                this.renderdata.pairedwith[i] = 4;
                this.renderdata.yoff[i] = -0.75f;
            }
        }
    }

    private float getNewVelocity(final float v, final float diff, float curval) {
        float tv = v;
        tv *= 18.0f;
        if (tv < 2.0f) {
            tv = 2.0f;
        }
        if (tv > 8.0f) {
            tv = 8.0f;
        }
        if (diff > 0.0f) {
            if (diff < 0.008726646259971648 * tv) {
                curval = 0.0f;
            } else {
                curval += (float) (0.004363323129985824 * tv);
                if (diff < 0.06981317007977318 * tv) {
                    curval = (float) (0.017453292519943295 * tv);
                }
                if (diff < 0.03490658503988659 * tv) {
                    curval = (float) (0.008726646259971648 * tv);
                }
                if (curval > 0.06981317007977318 * tv) {
                    curval = (float) (0.06981317007977318 * tv);
                }
            }
        } else if (diff > -0.008726646259971648 * tv) {
            curval = 0.0f;
        } else {
            curval -= (float) (0.004363323129985824 * tv);
            if (diff > -0.06981317007977318 * tv) {
                curval = -(float) (0.017453292519943295 * tv);
            }
            if (diff > -0.03490658503988659 * tv) {
                curval = -(float) (0.008726646259971648 * tv);
            }
            if (curval < -0.06981317007977318 * tv) {
                curval = -(float) (0.06981317007977318 * tv);
            }
        }
        return curval;
    }

    public void updateLegs() {
        if (!this.worldObj.isRemote) {
            return;
        }
        this.rotationYaw %= 360.0f;
        while (this.rotationYaw < 0.0f) {
            this.rotationYaw += 360.0f;
        }
        final RenderSpiderRobotInfo renderdata = this.renderdata;
        ++renderdata.gpcounter;
        if (this.didonce == 0) {
            this.didonce = 1;
            this.initLegData();
        }
        float d1 = (float) (this.prevPosX - this.posX);
        float d2 = (float) (this.prevPosY - this.posY);
        float d3 = (float) (this.prevPosZ - this.posZ);
        final float realv = (float) Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
        int i;
        int fcount;
        int[] footingticker;
        int n;
        int it;
        float dd;
        float da;
        float c1;
        float c2;
        float c3;
        float cc;
        float diff;
        double[] p1xangle;
        int n2;
        float[] udwantedangle;
        int n3;
        float[] udwantedangle2;
        int n4;
        double rhm;
        double rhdir;
        double rdv;
        float[] udcurrentangle;
        int n5;
        float n6;
        float[] ywantedangle;
        int n7;
        float n8;
        float[] ycurrentangle;
        int n9;
        float[] ycurrentangle2;
        int n10;
        float[] ycurrentangle3;
        int n11;
        for (i = 0, i = 0; i < 6; ++i) {
            fcount = 0;
            footingticker = this.renderdata.footingticker;
            n = i;
            ++footingticker[n];
            this.renderdata.realposx[i] = (float) (this.posX - this.renderdata.legoff[i] * Math.sin(
                Math.toRadians(MathHelper.wrapAngleTo180_double((this.rotationYaw + 90.0f)))
                    + this.renderdata.ymid[i]));
            this.renderdata.realposz[i] = (float) (this.posZ + this.renderdata.legoff[i] * Math.cos(
                Math.toRadians(MathHelper.wrapAngleTo180_double((this.rotationYaw + 90.0f)))
                    + this.renderdata.ymid[i]));
            this.renderdata.realposy[i] = (float) this.posY + this.renderdata.yoff[i];
            it = this.renderdata.footingticker[i] + this.renderdata.footingticker[this.renderdata.pairedwith[i]];
            if (it > 50
                && this.renderdata.footingticker[i] > this.renderdata.footingticker[this.renderdata.pairedwith[i]]) {
                this.renderdata.footingticker[i] = 0;
            }
            d1 = this.renderdata.realposx[i] - this.renderdata.foot_xpos[i];
            d2 = this.renderdata.realposy[i] - this.renderdata.foot_ypos[i];
            d3 = this.renderdata.realposz[i] - this.renderdata.foot_zpos[i];
            dd = (float) Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
            dd *= 16.0f;
            da = (float) (Math.abs(
                this.renderdata.ycurrentangle[i]
                    - (Math.toRadians(MathHelper.wrapAngleTo180_double(this.rotationYaw)) + this.renderdata.ymid[i]))
                % 6.283185307179586);
            if (da > 3.141592653589793) {
                da -= (float) 6.283185307179586;
            }
            if (da < -3.141592653589793) {
                da += (float) 6.283185307179586;
            }
            da = Math.abs(da);
            if (dd > 144.0f || dd < 22.0f
                || da > Math.abs(this.renderdata.yrange[i]) * 8.0f / 6.0f
                || Math.abs(this.renderdata.udcurrentangle[i]) > 1.25
                || this.renderdata.footingticker[i] == 0) {
                this.findNewFooting(i);
                d1 = this.renderdata.realposx[i] - this.renderdata.foot_xpos[i];
                d2 = this.renderdata.realposy[i] - this.renderdata.foot_ypos[i];
                d3 = this.renderdata.realposz[i] - this.renderdata.foot_zpos[i];
                dd = (float) Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
                dd *= 16.0f;
            }
            c1 = (float) (49.0 * Math.cos(this.renderdata.p2xangle[i] - this.renderdata.p1xangle[i]));
            c2 = 49.0f;
            c3 = (float) (49.0 * Math.cos(this.renderdata.p2xangle[i] - this.renderdata.p3xangle[i]));
            cc = c1 + c2 + c3;
            diff = cc - dd;
            this.renderdata.pxvelocity[i] = this
                .getNewVelocity(realv, (float) (diff * 3.141592653589793 / 360.0), this.renderdata.pxvelocity[i]);
            if (this.renderdata.pxvelocity[i] == 0.0f || Math.abs(diff) < 8.0f) {
                ++fcount;
            }
            p1xangle = this.renderdata.p1xangle;
            n2 = i;
            p1xangle[n2] += this.renderdata.pxvelocity[i];
            this.renderdata.p2xangle[i] = 0.0;
            this.renderdata.p3xangle[i] = -this.renderdata.p1xangle[i];
            if (this.renderdata.uppoint[i] != 0.0f) {
                dd = (float) Math.atan2(dd, (this.renderdata.realposy[i] - this.renderdata.uppoint[i]) * 16.0);
            } else {
                dd = (float) Math.atan2(dd, (this.renderdata.realposy[i] - this.renderdata.foot_ypos[i]) * 16.0);
            }
            this.renderdata.udwantedangle[i] = (float) (dd - 1.5707963267948966);
            while (this.renderdata.udwantedangle[i] > 3.141592653589793) {
                udwantedangle = this.renderdata.udwantedangle;
                n3 = i;
                udwantedangle[n3] -= (float) 6.283185307179586;
            }
            while (this.renderdata.udwantedangle[i] < -3.141592653589793) {
                udwantedangle2 = this.renderdata.udwantedangle;
                n4 = i;
                udwantedangle2[n4] += (float) 6.283185307179586;
            }
            rhm = this.renderdata.udwantedangle[i];
            rhdir = this.renderdata.udcurrentangle[i];
            for (rdv = (rhm - rhdir) % 6.283185307179586; rdv > 3.141592653589793; rdv -= 6.283185307179586) {}
            while (rdv < -3.141592653589793) {
                rdv += 6.283185307179586;
            }
            diff = (float) rdv;
            this.renderdata.udvelocity[i] = this.getNewVelocity(realv * 2.0f, diff, this.renderdata.udvelocity[i]);
            if (this.renderdata.udvelocity[i] == 0.0f || Math.abs(diff) < 0.03490658503988659) {
                this.renderdata.uppoint[i] = 0.0f;
                ++fcount;
            }
            for (rhdir += this.renderdata.udvelocity[i]; rhdir > 3.141592653589793; rhdir -= 6.283185307179586) {}
            while (rhdir < -3.141592653589793) {
                rhdir += 6.283185307179586;
            }
            udcurrentangle = this.renderdata.udcurrentangle;
            n5 = i;
            n6 = (float) rhdir;
            udcurrentangle[n5] = n6;
            dd = n6;
            this.renderdata.uddisplayangle[i] = dd;
            d1 = this.renderdata.realposx[i] - this.renderdata.foot_xpos[i];
            d3 = this.renderdata.realposz[i] - this.renderdata.foot_zpos[i];
            dd = (float) Math.atan2(d3, d1);
            ywantedangle = this.renderdata.ywantedangle;
            n7 = i;
            n8 = dd;
            ywantedangle[n7] = n8;
            rhm = n8;
            rhdir = this.renderdata.ycurrentangle[i];
            rdv = (rhm - rhdir) % 6.283185307179586;
            if (rdv > 3.141592653589793) {
                rdv -= 6.283185307179586;
            }
            if (rdv < -3.141592653589793) {
                rdv += 6.283185307179586;
            }
            diff = (float) rdv;
            this.renderdata.yvelocity[i] = this.getNewVelocity(realv, diff, this.renderdata.yvelocity[i]);
            if (this.renderdata.yvelocity[i] == 0.0f || Math.abs(diff) < 0.03490658503988659) {
                ++fcount;
            }
            ycurrentangle = this.renderdata.ycurrentangle;
            n9 = i;
            ycurrentangle[n9] += this.renderdata.yvelocity[i];
            while (this.renderdata.ycurrentangle[i] > 3.141592653589793) {
                ycurrentangle2 = this.renderdata.ycurrentangle;
                n10 = i;
                ycurrentangle2[n10] -= (float) 6.283185307179586;
            }
            while (this.renderdata.ycurrentangle[i] < -3.141592653589793) {
                ycurrentangle3 = this.renderdata.ycurrentangle;
                n11 = i;
                ycurrentangle3[n11] += (float) 6.283185307179586;
            }
            for (dd = (float) (this.renderdata.ycurrentangle[i]
                - Math.toRadians(MathHelper.wrapAngleTo180_double(this.rotationYaw))
                - 1.5707963267948966); dd > 3.141592653589793; dd -= (float) 6.283185307179586) {}
            while (dd < -3.141592653589793) {
                dd += (float) 6.283185307179586;
            }
            this.renderdata.ydisplayangle[i] = dd;
            if (fcount == 3) {
                this.renderdata.footup[i] = 0;
            }
        }
    }

    private void findNewFooting(final int i) {
        float f = 9.0f;
        int found = 0;
        float range = 0.0f;
        final double rhdir = Math.toRadians((this.rotationYaw + 90.0f) % 360.0f);
        final double pi = 3.1415926545;
        this.renderdata.footingticker[i] = 0;
        float d1 = (float) (this.posX - this.prevPosX);
        float d2 = (float) (this.posZ - this.prevPosZ);
        final double rhm = Math.atan2(d2, d1);
        final double velocity = Math.sqrt(d1 * d1 + d2 * d2);
        double rdv = Math.abs(rhm - rhdir) % (pi * 2.0);
        if (rdv > pi) {
            rdv -= pi * 2.0;
        }
        rdv = Math.abs(rdv);
        if (Math.abs(velocity) < 0.01) {
            rdv = 0.0;
        }
        range = this.renderdata.yrange[i];
        range *= 0.8f;
        if (Math.abs((this.prevRotationYaw - this.rotationYaw) % 360.0f) > 0.75f) {
            range = 0.0f;
        }
        if (i >= 4) {
            f = 4.0f;
        }
        if (rdv > 1.5) {
            range = -range;
            f = 4.0f;
            if (i >= 4) {
                f = 9.0f;
            }
        }
        if (i == 0 || i == 1) {
            f = 6.0f;
        }
        final float deffx;
        float fx = deffx = (float) (this.renderdata.realposx[i] - f / 2.0f
            * Math.sin(
                Math.toRadians(MathHelper.wrapAngleTo180_double((this.rotationYaw + 90.0f)))
                    + this.renderdata.ymid[i]));
        final float deffz;
        float fz = deffz = (float) (this.renderdata.realposz[i] + f / 2.0f
            * Math.cos(
                Math.toRadians(MathHelper.wrapAngleTo180_double((this.rotationYaw + 90.0f)))
                    + this.renderdata.ymid[i]));
        final float deffy;
        float fy = deffy = this.renderdata.realposy[i] - 1.0f;
        final float oldf = f;
        int span = 1;
        while (found == 0 && f > 2.5f) {
            fx = (float) (this.renderdata.realposx[i] - f * Math.sin(
                Math.toRadians(MathHelper.wrapAngleTo180_double((this.rotationYaw + 90.0f))) + this.renderdata.ymid[i]
                    - range));
            fz = (float) (this.renderdata.realposz[i] + f * Math.cos(
                Math.toRadians(MathHelper.wrapAngleTo180_double((this.rotationYaw + 90.0f))) + this.renderdata.ymid[i]
                    - range));
            fy = this.renderdata.realposy[i];
            for (int j = 8; found == 0 && j > -9; --j) {
                for (int m = -span; found == 0 && m <= span; ++m) {
                    for (int n = -span; found == 0 && n <= span; ++n) {
                        final Block blk = this.worldObj.getBlock((int) fx + m, (int) fy + j, (int) fz + n);
                        if (blk != Blocks.air && this.worldObj.getBlock((int) fx + m, (int) fy + j, (int) fz + n)
                            .getMaterial()
                            .isSolid()) {
                            d1 = this.renderdata.realposx[i] - (fx + m);
                            final float d3 = this.renderdata.realposy[i] - (fy + j + 1.0f);
                            d2 = this.renderdata.realposz[i] - (fz + n);
                            float dd = (float) Math.sqrt(d1 * d1 + d3 * d3 + d2 * d2);
                            dd *= 16.0f;
                            if (dd <= 144.0f) {
                                fy += j + 1;
                                fx += m;
                                fz += n;
                                found = 1;
                                break;
                            }
                        }
                    }
                }
            }
            --f;
            if (f < 2.5f && range != 0.0f) {
                range = 0.0f;
                span = 3;
                f = oldf;
            }
        }
        if (found == 0) {
            fx = deffx;
            fy = deffy;
            fz = deffz;
        }
        final float sfx = this.renderdata.foot_xpos[i];
        final float sfy = this.renderdata.foot_ypos[i];
        final float sfz = this.renderdata.foot_zpos[i];
        this.renderdata.foot_xpos[i] = fx;
        this.renderdata.foot_ypos[i] = fy;
        this.renderdata.foot_zpos[i] = fz;
        if (this.renderdata.footup[i] == 0) {
            this.renderdata.footup[i] = 1;
            d1 = sfx - fx;
            final float d3 = sfy - fy;
            d2 = sfz - fz;
            float dd = (float) Math.sqrt(d1 * d1 + d3 * d3 + d2 * d2);
            dd *= 16.0f;
            d1 = (sfy + fy) / 2.0f;
            if (dd > 3.0f) {
                d1 += 0.3f;
            }
            if (dd > 24.0f) {
                d1 += 0.6f;
            }
            if (dd > 50.0f) {
                d1 += 0.6f;
            }
            this.renderdata.uppoint[i] = d1;
        }
    }

    public boolean shouldRiderSit() {
        return true;
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

    protected boolean canTriggerWalking() {
        return true;
    }

    protected void entityInit() {
        super.entityInit();
        this.func_110163_bv();
        this.initLegData();
        final int i = 0;
        this.dataWatcher.addObject(20, (Object) i);
    }

    public RenderSpiderRobotInfo getRenderSpiderRobotInfo() {
        return this.renderdata;
    }

    public boolean canBePushed() {
        return false;
    }

    public double getMountedYOffset() {
        return 0.55 + Math.cos(this.rideTicker * 0.19f) * 0.02;
    }

    public void updateRiderPosition() {
        if (this.riddenByEntity != null) {
            float f = -1.25f;
            f += (float) (Math.cos(this.rideTicker * 0.33f) * 0.05);
            this.riddenByEntity.setPosition(
                this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)),
                this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(),
                this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)));
        }
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        if (par1DamageSource.getDamageType()
            .equals("inWall")) {
            return false;
        }
        if (par1DamageSource.getDamageType()
            .equals("cactus")) {
            return false;
        }
        if (par1DamageSource.getDamageType()
            .equals("inFire")) {
            return false;
        }
        if (par1DamageSource.getDamageType()
            .equals("onFire")) {
            return false;
        }
        if (par1DamageSource.getDamageType()
            .equals("magic")) {
            return false;
        }
        if (par1DamageSource.getDamageType()
            .equals("starve")) {
            return false;
        }
        final Entity e = par1DamageSource.getEntity();
        if (e != null && e instanceof EntityLiving) {
            this.setAttackTarget((EntityLivingBase) e);
            this.faceEntity(e, 20.0f, 20.0f);
        }
        return super.attackEntityFrom(par1DamageSource, par2);
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    @SideOnly(Side.CLIENT)
    public void setPositionAndRotation2(final double par1, final double par3, final double par5, final float par7,
        final float par8, final int par9) {
        if (this.riddenByEntity != null) {
            this.boatPosRotationIncrements = par9 + 8;
        } else {
            this.boatPosRotationIncrements = par9 + 6;
        }
        this.boatX = par1;
        this.boatY = par3;
        this.boatZ = par5;
        this.boatYaw = par7;
        this.boatPitch = par8;
    }

    @SideOnly(Side.CLIENT)
    public void setVelocity(final double par1, final double par3, final double par5) {
        if (this.riddenByEntity == null) {
            super.setVelocity(par1, par3, par5);
        }
    }

    public void onUpdate() {
        super.onUpdate();
        this.setFire(0);
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && !this.worldObj.isRemote
            && this.riddenByEntity != null
            && this.worldObj.rand.nextInt(50) == 0) {
            this.feetFindSomethingToHit();
        }
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && !this.worldObj.isRemote
            && this.riddenByEntity != null
            && this.worldObj.rand.nextInt(9) == 0) {
            EntityLivingBase e = null;
            e = this.findSomethingToAttack(1.0f, true);
            if (e != null) {
                if (this.getDistanceSqToEntity(e) < (6.0f + e.width / 2.0f) * (6.0f + e.width / 2.0f)) {
                    this.setAttacking(1);
                    this.attackEntityAsMob(e);
                }
            } else {
                this.setAttacking(0);
            }
        }
        final float f = 4.0f;
        float dx = (float) (f * Math.cos(Math.toRadians(this.rotationYaw - 80.0f)));
        float dz = (float) (f * Math.sin(Math.toRadians(this.rotationYaw - 80.0f)));
        final float dx2 = (float) (f * Math.cos(Math.toRadians(this.rotationYaw - 90.0f)));
        final float dz2 = (float) (f * Math.sin(Math.toRadians(this.rotationYaw - 90.0f)));
        if (this.worldObj.rand.nextInt(18) == 0) {
            this.worldObj.spawnParticle(
                "flame",
                this.posX + dx,
                this.posY + 0.5,
                this.posZ + dz,
                (dx2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0f),
                ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 10.0f),
                (dz2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0f));
        }
        if (this.worldObj.rand.nextInt(7) == 0) {
            this.worldObj.spawnParticle(
                "smoke",
                this.posX + dx,
                this.posY + 0.5,
                this.posZ + dz,
                (dx2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0f),
                ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 10.0f),
                (dz2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0f));
        }
        if (this.worldObj.rand.nextInt(16) == 0) {
            this.worldObj.spawnParticle(
                "fireworksSpark",
                this.posX + dx,
                this.posY + 0.5,
                this.posZ + dz,
                (dx2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0f),
                ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 5.0f),
                (dz2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0f));
        }
        dx = (float) (f * Math.cos(Math.toRadians(this.rotationYaw - 100.0f)));
        dz = (float) (f * Math.sin(Math.toRadians(this.rotationYaw - 100.0f)));
        if (this.worldObj.rand.nextInt(18) == 0) {
            this.worldObj.spawnParticle(
                "flame",
                this.posX + dx,
                this.posY + 0.5,
                this.posZ + dz,
                (dx2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0f),
                ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 10.0f),
                (dz2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0f));
        }
        if (this.worldObj.rand.nextInt(7) == 0) {
            this.worldObj.spawnParticle(
                "smoke",
                this.posX + dx,
                this.posY + 0.5,
                this.posZ + dz,
                (dx2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0f),
                ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 10.0f),
                (dz2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0f));
        }
        if (this.worldObj.rand.nextInt(16) == 0) {
            this.worldObj.spawnParticle(
                "fireworksSpark",
                this.posX + dx,
                this.posY + 0.5,
                this.posZ + dz,
                (dx2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0f),
                ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 5.0f),
                (dz2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0f));
        }
    }

    public void onLivingUpdate() {
        final List list = null;
        final double velocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        final double d6 = this.rand.nextFloat() * 2.0f - 1.0f;
        final double d7 = (this.rand.nextInt(2) * 2 - 1) * 0.7;
        double obstruction_factor = 0.0;
        double relative_g = 0.0;
        double max_speed = 0.3;
        double gh = 1.75;
        int dist = 2;
        if (this.isDead) {
            return;
        }
        if (this.riddenByEntity == null) {
            super.onLivingUpdate();
        }
        if (this.motionY > 0.8500000238418579) {
            this.motionY = 0.8500000238418579;
        }
        if (this.motionY < -0.8500000238418579) {
            this.motionY = -0.8500000238418579;
        }
        if (this.motionX < -1.25) {
            this.motionX = -1.25;
        }
        if (this.motionX > 1.25) {
            this.motionX = 1.25;
        }
        if (this.motionZ < -1.25) {
            this.motionZ = -1.25;
        }
        if (this.motionZ > 1.25) {
            this.motionZ = 1.25;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.rideTicker += this.worldObj.rand.nextInt(3);
        if (this.playing > 0) {
            --this.playing;
        }
        if (this.riddenByEntity != null && this.playing == 0 && this.worldObj.rand.nextInt(80) == 1) {
            this.worldObj.playSoundAtEntity(this, "orespawn:robotspider", 0.35f, 1.0f);
            this.playing = 125;
        }
        if (this.worldObj.isRemote) {
            if (this.riddenByEntity == null) {
                Block bid = this.worldObj
                    .getBlock((int) this.posX, (int) ((float) this.posY - (float) gh + 1.0f), (int) this.posZ);
                if (bid == Blocks.air) {
                    bid = this.worldObj
                        .getBlock((int) this.posX, (int) ((float) this.posY - (float) gh), (int) this.posZ);
                }
                if (bid != Blocks.air && bid != Blocks.water
                    && bid != Blocks.flowing_water
                    && bid != Blocks.lava
                    && bid != Blocks.flowing_lava) {
                    this.motionY += 0.12;
                    this.posY += 0.12;
                    this.boatY += 0.12;
                } else {
                    this.motionY -= 0.002;
                }
            }
            if (this.boatPosRotationIncrements > 0) {
                final double d8 = this.posX + (this.boatX - this.posX) / this.boatPosRotationIncrements;
                final double d9 = this.posY + (this.boatY - this.posY) / this.boatPosRotationIncrements;
                final double d10 = this.posZ + (this.boatZ - this.posZ) / this.boatPosRotationIncrements;
                this.setPosition(d8, d9, d10);
                this.rotationPitch += (float) ((this.boatPitch - this.rotationPitch) / this.boatPosRotationIncrements);
                double d11 = MathHelper.wrapAngleTo180_double(this.boatYaw - this.rotationYaw);
                if (this.riddenByEntity != null) {
                    d11 = MathHelper.wrapAngleTo180_double(this.riddenByEntity.rotationYaw - this.rotationYaw);
                }
                this.setRotation(
                    this.rotationYaw += (float) (d11 / this.boatPosRotationIncrements),
                    this.rotationPitch);
                --this.boatPosRotationIncrements;
            } else {
                final double d8 = this.posX + this.motionX;
                final double d9 = this.posY + this.motionY;
                final double d10 = this.posZ + this.motionZ;
                this.setPosition(d8, d9, d10);
                this.motionX *= 0.99;
                this.motionY *= 0.95;
                this.motionZ *= 0.99;
            }
            this.updateLegs();
        } else {
            if (this.riddenByEntity != null) {
                gh = 2.25;
                final Block bid = this.worldObj
                    .getBlock((int) this.posX, (int) ((float) this.posY - (float) gh), (int) this.posZ);
                if (bid != Blocks.air && bid != Blocks.water
                    && bid != Blocks.flowing_water
                    && bid != Blocks.lava
                    && bid != Blocks.flowing_lava) {
                    this.motionY += 0.06;
                    this.posY += 0.03;
                } else {
                    this.motionY -= 0.02;
                }
            } else {
                Block bid = this.worldObj
                    .getBlock((int) this.posX, (int) ((float) this.posY - (float) gh + 1.0f), (int) this.posZ);
                if (bid == Blocks.air) {
                    bid = this.worldObj
                        .getBlock((int) this.posX, (int) ((float) this.posY - (float) gh), (int) this.posZ);
                }
                if (bid != Blocks.air && bid != Blocks.water
                    && bid != Blocks.flowing_water
                    && bid != Blocks.lava
                    && bid != Blocks.flowing_lava) {
                    this.motionY += 0.15;
                    this.posY += 0.15;
                    this.boatY += 0.15;
                } else {
                    this.motionY -= 0.002;
                }
            }
            if (this.riddenByEntity != null) {
                final EntityPlayer pp = (EntityPlayer) this.riddenByEntity;
                obstruction_factor = 0.0;
                dist = 3;
                dist += (int) (velocity * 6.0);
                for (int k = 1; k < dist; ++k) {
                    for (int i = 1; i < dist * 2; ++i) {
                        for (int j = -90; j <= 90; j += 30) {
                            final double dx = i * Math.cos(Math.toRadians(this.rotationYaw + 90.0f + j));
                            final double dz = i * Math.sin(Math.toRadians(this.rotationYaw + 90.0f + j));
                            final Block bid = this.worldObj
                                .getBlock((int) (this.posX + dx), (int) this.posY - k, (int) (this.posZ + dz));
                            if (bid != Blocks.air && bid != Blocks.water
                                && bid != Blocks.flowing_water
                                && bid != Blocks.lava
                                && bid != Blocks.flowing_lava) {
                                obstruction_factor += 0.02;
                            }
                        }
                    }
                }
                this.motionY += obstruction_factor * 0.05;
                this.posY += obstruction_factor * 0.05;
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
                this.rotationPitch = 0.0f;
                this.setRotation(this.rotationYaw, this.rotationPitch);
                double newvelocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
                final double rr = Math.atan2(this.riddenByEntity.motionZ, this.riddenByEntity.motionX);
                final double rhm = Math.atan2(this.motionZ, this.motionX);
                final double rhdir = Math.toRadians((this.riddenByEntity.rotationYaw + 90.0f) % 360.0f);
                final double rt = 0.0;
                final double pi = 3.1415926545;
                double deltav = 0.0;
                final float im = pp.moveForward;
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
                        deltav = 0.05;
                    } else {
                        max_speed = 0.25;
                        deltav = -0.05;
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
                this.moveEntity(this.motionX, this.motionY, this.motionZ);
                this.motionX *= 0.98;
                this.motionY *= 0.98;
                this.motionZ *= 0.98;
            }
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.8;
            this.motionY *= 0.98;
            this.motionZ *= 0.8;
            if (this.riddenByEntity != null && this.riddenByEntity.isDead) {
                this.riddenByEntity = null;
            }
        }
    }

    public void goThisWay(final double mx, final double mz) {
        this.motionX = mx;
        this.motionZ = mz;
    }

    public boolean isAIEnabled() {
        return this.riddenByEntity == null;
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("AntRobotOwned", this.owned);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.owned = par1NBTTagCompound.getInteger("AntRobotOwned");
    }

    public float getShadowSize() {
        return 0.95f;
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
            var2 = null;
        }
        if (this.owned == 0) {
            return true;
        }
        if (var2 != null && var2.getItem() == Items.iron_ingot && par1EntityPlayer.getDistanceSqToEntity(this) < 25.0) {
            if (!this.worldObj.isRemote) {
                float f = this.getMaxHealth() - this.getHealth();
                if (f > 100.0f) {
                    f = 100.0f;
                }
                if (f > 0.0f) {
                    this.heal(f);
                }
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack = var2;
                --itemStack.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                }
            }
            return true;
        }
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer
            && this.riddenByEntity != par1EntityPlayer) {
            return true;
        }
        if (!this.worldObj.isRemote && this.riddenByEntity == null
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0) {
            par1EntityPlayer.mountEntity(this);
            this.worldObj.playSoundAtEntity(this, "orespawn:robotspidermount", 0.45f, 1.0f);
        }
        return true;
    }

    private void feetFindSomethingToHit() {
        if (OreSpawnMain.PlayNicely != 0) {
            return;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(10.0, 8.0, 10.0));
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.feetisSuitableTarget(var8, false)) {
                this.feetattackEntityAsMob(var8);
            }
        }
    }

    private boolean feetisSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        if (par1EntityLiving == null) {
            return false;
        }
        if (par1EntityLiving == this) {
            return false;
        }
        if (!par1EntityLiving.isEntityAlive()) {
            return false;
        }
        if (par1EntityLiving instanceof AntRobot) {
            return false;
        }
        if (par1EntityLiving == this.riddenByEntity) {
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
        final float d1 = (float) (par1EntityLiving.posX - this.posX);
        final float d2 = (float) (par1EntityLiving.posY - this.posY);
        final float d3 = (float) (par1EntityLiving.posZ - this.posZ);
        final float dd = (float) Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
        if (dd > 9.0f) {
            return false;
        }
        if (dd < 6.0f) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode;
        }
        return true;
    }

    public boolean feetattackEntityAsMob(final Entity par1Entity) {
        boolean ret = false;
        if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            final double ks = 0.6;
            double inair = 0.1;
            final float f3 = (float) Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
            ret = par1Entity
                .attackEntityFrom(DamageSource.causeMobDamage(this), OreSpawnMain.AntRobot_stats.attack / 10.0f);
            if (par1Entity.isDead || par1Entity instanceof EntityPlayer) {
                inair *= 2.0;
            }
            if (ret) {
                par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return ret;
    }

    private EntityLivingBase findSomethingToAttack(final float distmul, final boolean dircheck) {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.worldObj.getEntitiesWithinAABB(
            EntityLivingBase.class,
            this.boundingBox.expand(12.0 * distmul, 12.0, 12.0 * distmul));
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.isSuitableTarget(var8, dircheck)) {
                return var8;
            }
        }
        return null;
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
        if (par1EntityLiving instanceof AntRobot) {
            return false;
        }
        if (par1EntityLiving == this.riddenByEntity) {
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
        if (par2) {
            final double rr = Math.atan2(par1EntityLiving.posZ - this.posZ, par1EntityLiving.posX - this.posX);
            final double rhdir = Math.toRadians((this.rotationYaw + 90.0f) % 360.0f);
            final double pi = 3.1415926545;
            double rdd = Math.abs(rr - rhdir) % (pi * 2.0);
            if (rdd > pi) {
                rdd -= pi * 2.0;
            }
            rdd = Math.abs(rdd);
            if (this.getDistanceSqToEntity(par1EntityLiving) < 36.0) {
                return true;
            }
            if (rdd > 0.75) {
                return false;
            }
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode;
        }
        return true;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        boolean ret = false;
        if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            final double ks = 0.7;
            double inair = 0.1;
            final float f3 = (float) Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
            ret = par1Entity
                .attackEntityFrom(DamageSource.causeMobDamage(this), (float) OreSpawnMain.AntRobot_stats.attack);
            if (par1Entity.isDead || par1Entity instanceof EntityPlayer) {
                inair *= 2.0;
            }
            if (ret) {
                par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return ret;
    }

    public int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, (Object) par1);
    }

    protected Item getDropItem() {
        return null;
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
        for (int i = 7 + this.worldObj.rand.nextInt(7), var4 = 0; var4 < i; ++var4) {
            final int var5 = this.worldObj.rand.nextInt(12);
            switch (var5) {
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
                case 10: {
                    is = this.dropItemRand(Items.iron_ingot, 1);
                    break;
                }
            }
        }
    }
}
