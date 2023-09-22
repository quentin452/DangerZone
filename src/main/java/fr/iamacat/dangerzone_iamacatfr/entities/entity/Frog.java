
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWander;
import fr.iamacat.dangerzone_iamacatfr.init.DimensionInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Frog extends EntityAnimal {

    private GenericTargetSorter TargetSorter;
    public double moveSpeed;
    private int singing;
    private int jumpcount;

    public Frog(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.10000000149011612;
        this.singing = 0;
        this.jumpcount = 0;
        this.setSize(0.75f, 0.75f);
        this.experienceValue = 5;
        this.TargetSorter = new GenericTargetSorter(this);
        this.getNavigator()
            .setAvoidsWater(false);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.4));
        this.tasks.addTask(2, new MyEntityAIWander(this, 1.0f));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        this.getAttributeMap()
            .registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(0.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    public int getSinging() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setSinging(final int par1) {
        this.dataWatcher.updateObject(20, par1);
    }

    private void jumpAround() {
        this.motionY += 0.75f + Math.abs(this.worldObj.rand.nextFloat() * 0.55f);
        this.posY += 0.3499999940395355;
        final float f = 0.7f + Math.abs(this.worldObj.rand.nextFloat() * 0.75f);
        final float d = (float) Math.toRadians(this.rotationYaw);
        this.motionX -= f * Math.sin(d);
        this.motionZ += f * Math.cos(d);
        this.isAirBorne = true;
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
        if (!this.worldObj.isRemote) {
            if (this.singing != 0) {
                --this.singing;
                if (this.singing <= 0) {
                    this.setSinging(0);
                }
            }
            if (this.jumpcount > 0) {
                --this.jumpcount;
            }
            if (this.jumpcount == 0 && this.worldObj.rand.nextInt(70) == 1) {
                this.jumpAround();
                this.jumpcount = 50;
            }
        }
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        if (par1EntityPlayer != null && par1EntityPlayer.isSneaking()
            && par1EntityPlayer.inventory.getCurrentItem() == null) {
            final World world = par1EntityPlayer.worldObj;
            this.setDead();
            par1EntityPlayer.worldObj
                .playSoundAtEntity(par1EntityPlayer, "random.explode", 1.0f, world.rand.nextFloat() * 0.2f + 0.9f);
            if (!world.isRemote) {
                if (world.rand.nextInt(2) == 0) {
                    Boyfriend ent = null;
                    ent = (Boyfriend) spawnCreature(world, "Boyfriend", this.posX, this.posY + 0.01, this.posZ);
                    if (ent != null) {
                        ent.setPrince(1 + world.rand.nextInt(2));
                    }
                } else {
                    Girlfriend ent2 = null;
                    ent2 = (Girlfriend) spawnCreature(world, "Girlfriend", this.posX, this.posY + 0.01, this.posZ);
                    if (ent2 != null) {
                        ent2.setPrincess(1 + world.rand.nextInt(2));
                    }
                }
            } else {
                for (int var3 = 0; var3 < 16; ++var3) {
                    world.spawnParticle(
                        "smoke",
                        ((float) this.posX + world.rand.nextFloat() - world.rand.nextFloat()),
                        ((float) this.posY + world.rand.nextFloat()),
                        ((float) this.posZ + world.rand.nextFloat() - world.rand.nextFloat()),
                        0.0,
                        0.0,
                        0.0);
                    world.spawnParticle(
                        "explode",
                        ((float) this.posX + world.rand.nextFloat() - world.rand.nextFloat()),
                        ((float) this.posY + world.rand.nextFloat()),
                        ((float) this.posZ + world.rand.nextFloat() - world.rand.nextFloat()),
                        0.0,
                        0.0,
                        0.0);
                    world.spawnParticle(
                        "reddust",
                        ((float) this.posX + world.rand.nextFloat() - world.rand.nextFloat()),
                        ((float) this.posY + world.rand.nextFloat()),
                        ((float) this.posZ + world.rand.nextFloat() - world.rand.nextFloat()),
                        0.0,
                        0.0,
                        0.0);
                }
            }
        }
        return false;
    }

    public boolean isAIEnabled() {
        return true;
    }

    public int mygetMaxHealth() {
        return 8;
    }

    protected String getLivingSound() {
        if (!this.worldObj.isRemote) {
            if (this.worldObj.rand.nextInt(2) == 0) {
                return null;
            }
            this.setSinging(this.singing = 35);
        }
        return Tags.MODID + ":frog";
    }

    protected String getHurtSound() {
        return Tags.MODID + ":scorpion_hit";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":big_splat";
    }

    protected float getSoundVolume() {
        return 0.7f;
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    protected void playStepSound(final int par1, final int par2, final int par3, final int par4) {}

    private void dropItemRand(final Item index, final int par1) {
        final EntityItem var3 = new EntityItem(
            this.worldObj,
            this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2),
            this.posY + 1.0,
            this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2),
            new ItemStack(index, par1, 0));
        this.worldObj.spawnEntityInWorld(var3);
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        for (int i = 0; i < 4; ++i) {
            this.dropItemRand(Items.slime_ball, 1);
        }
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), 3.0f);
        if (par1Entity.isDead) {
            this.heal(1.0f);
        }
        return var4;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        ret = super.attackEntityFrom(par1DamageSource, par2);
        if (!this.worldObj.isRemote && this.jumpcount <= 0) {
            this.jumpAround();
            this.jumpcount = 25;
        }
        return ret;
    }

    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.worldObj.rayTraceBlocks(
            Vec3.createVectorHelper(this.posX, this.posY + 0.25, this.posZ),
            Vec3.createVectorHelper(pX, pY, pZ),
            false) == null;
    }

    protected boolean canTriggerWalking() {
        return true;
    }

    public EntityAgeable createChild(final EntityAgeable var1) {
        return null;
    }

    private int findBuddies() {
        final List var5 = this.worldObj.getEntitiesWithinAABB(Frog.class, this.boundingBox.expand(20.0, 8.0, 20.0));
        return var5.size();
    }

    public boolean getCanSpawnHere() {
        return this.posY >= 50.0 && this.worldObj.isDaytime()
            && (this.worldObj.provider.dimensionId != DimensionInitDangerZone.DimensionID5 || this.worldObj.rand.nextInt(20) == 1)
            && this.findBuddies() <= 5;
    }

    protected void updateAITasks() {
        final int xdir = 1;
        final int zdir = 1;
        final int keep_trying = 50;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.rand.nextInt(12) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            EntityLivingBase e = null;
            e = this.findSomethingToAttack();
            if (e != null) {
                this.getNavigator()
                    .tryMoveToEntityLiving(e, 1.25);
                if (this.getDistanceSqToEntity(e) < 6.0) {
                    this.attackEntityAsMob(e);
                }
            }
        }
    }

    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && par1EntityLiving != null
            && par1EntityLiving != this
            && par1EntityLiving.isEntityAlive()
            && this.getEntitySenses()
                .canSee(par1EntityLiving)
            && (par1EntityLiving instanceof EntityAnt || par1EntityLiving instanceof EntityButterfly
                || par1EntityLiving instanceof Cricket
                || par1EntityLiving instanceof EntityMosquito
                || par1EntityLiving instanceof Firefly
                || par1EntityLiving instanceof WormSmall);
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(8.0, 3.0, 8.0));
        Collections.sort((List<Object>) var5, this.TargetSorter);
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
}
