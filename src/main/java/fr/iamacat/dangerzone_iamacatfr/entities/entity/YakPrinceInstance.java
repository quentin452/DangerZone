
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.entities.render.InfoRenderer;
import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
public class YakPrinceInstance extends EntityMob {

    private GenericTargetSorterInstance TargetSorter;
    private InfoRenderer renderdata;
    private int dmgDelay;
    private float moveSpeed;

    public YakPrinceInstance(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.renderdata = new InfoRenderer();
        this.dmgDelay = 0;
        this.moveSpeed = 0.4f;
        this.setSize(5.0f, 5.0f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 200;
        this.fireResistance = 0;
        this.isImmuneToFire = false;
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
        this.dataWatcher.addObject(20, 0);
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
            .setBaseValue(105.0);
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
        return 620;
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
        return 21;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    protected void jump() {
        super.jump();
        this.motionY += 0.25;
        this.posY += 0.5;
    }

    public int getThunderHoovesHealth() {
        return (int) this.getHealth();
    }

    protected String getLivingSound() {
        return "";
    }

    protected String getHurtSound() {
        return "mob.cow.hurt";
    }

    protected String getDeathSound() {
        return "mob.cow.hurt";
    }

    protected float getSoundVolume() {
        return 4.0f;
    }

    protected float getSoundPitch() {
        return 0.1f;
    }

    protected Block getDropItemId() {
        return Blocks.gold_block;
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
         * this.dropItemRand((Item)Basic.hardApple, 3);
         * this.dropBlockRand(Basic.hardAppleBlock, 1);
         * for (int i = 12 + this.worldObj.rand.nextInt(5), var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand(Basic.bearFur, 1);
         * }
         */
        int i = 4 + this.worldObj.rand.nextInt(8);
        for (int var4 = 0; var4 < 25; ++var4) {
            this.dropItemRand(Items.beef, 1);
        }
        /*
         * for (int var4 = 0; var4 < 15; ++var4) {
         * this.dropItemRand(Basic.balloons, 1);
         * }
         */
        for (int var4 = 0; var4 < 30; ++var4) {
            this.dropItemRand(Items.gold_ingot, 1);
        }
        for (int var4 = 0; var4 < 45; ++var4) {
            this.dropItemRand(Items.gold_nugget, 1);
        }
        /*
         * for (int var4 = 0; var4 < 2; ++var4) {
         * this.dropItemRand(Basic.yakHorn, 1);
         * }
         */
        for (int var4 = 0; var4 < 15; ++var4) {
            this.dropItemRand(Items.golden_carrot, 1);
        }
        for (int var4 = 0; var4 < 10; ++var4) {
            this.dropItemRand(Items.golden_apple, 1);
        }
        for (int var4 = 0; var4 < 8; ++var4) {
            this.dropItemRand(Items.golden_horse_armor, 1);
        }
        i = 1 + this.worldObj.rand.nextInt(5);
        for (int var4 = 0; var4 < i; ++var4) {
            final int var5 = this.worldObj.rand.nextInt(5);
            switch (var5) {
                /*
                 * case 0: {
                 * final ItemStack is = this.dropItemRand(Basic.ajPick, 1);
                 * break;
                 * }
                 * case 1: {
                 * final ItemStack is = this.dropItemRand(Basic.bearFur, 20);
                 * break;
                 * }
                 * case 2: {
                 * final ItemStack is = this.dropItemRand(Items.beef, 64);
                 * break;
                 * }
                 * case 3: {
                 * final ItemStack is = this.dropItemRand(Items.appleword, 1);
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                 * break;
                 * }
                 * break;
                 * }
                 * case 4: {
                 * final ItemStack is = this.dropItemRand(Basic.ajSpade, 1);
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                 * break;
                 * }
                 * break;
                 * }
                 * case 5: {
                 * final ItemStack is = this.dropItemRand(Basic.boneAxe, 1);
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5));
                 * break;
                 * }
                 * break;
                 * }
                 * case 6: {
                 * final ItemStack is = this.dropItemRand(Basic.bonePick, 1);
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                 * break;
                 * }
                 * break;
                 * }
                 * case 7: {
                 * final ItemStack is = this.dropItemRand(Basic.appleHoe, 1);
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                 * break;
                 * }
                 * break;
                 * }
                 * case 8: {
                 * final ItemStack is = this.dropItemRand(Basic.appleHelmet, 1);
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(2));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5));
                 * break;
                 * }
                 * break;
                 * }
                 * case 9: {
                 * final ItemStack is = this.dropItemRand(Basic.boneChest, 1);
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                 * break;
                 * }
                 * break;
                 * }
                 * case 10: {
                 * final ItemStack is = this.dropItemRand(Basic.boneLegs, 1);
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                 * break;
                 * }
                 * break;
                 * }
                 * case 11: {
                 * final ItemStack is = this.dropItemRand(Basic.ajBoots, 1);
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5));
                 * }
                 * if (this.worldObj.rand.nextInt(2) == 1) {
                 * is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                 * break;
                 * }
                 * break;
                 * }
                 * case 12: {
                 * final ItemStack is = this.dropItemRand(Basic.balloons, 10);
                 * break;
                 * }
                 */
            }
        }
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final double ks = 5.0;
        double inair = 0.3;
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
            this.dmgDelay = 15;
            final Entity e = par1DamageSource.getEntity();
            if (e != null && e instanceof EntityLiving) {
                this.setAttackTarget((EntityLivingBase) e);
                this.setTarget(e);
                this.getNavigator()
                    .tryMoveToEntityLiving((Entity) e, 1.2);
            }
        }
        return ret;
    }

    protected void updateAITasks() {
        EntityLivingBase e = null;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.dmgDelay > 0) {
            --this.dmgDelay;
        }
        if (this.worldObj.rand.nextInt(4) == 0) {
            e = this.getAttackTarget();
            if (e != null && !e.isEntityAlive()) {
                this.setAttackTarget((EntityLivingBase) null);
                e = null;
            }
            if (e == null) {
                e = this.findSomethingToAttack();
            }
            if (this.worldObj.rand.nextInt(100) == 0) {
                this.setAttackTarget((EntityLivingBase) null);
            }
            if (e != null) {
                this.faceEntity((Entity) e, 10.0f, 10.0f);
                this.setAttacking(1);
                this.getNavigator()
                    .tryMoveToEntityLiving((Entity) e, 1.2);
                if (this.getDistanceSqToEntity((Entity) e) < (9.8f + e.width / 2.0f) * (9.8f + e.width / 2.0f)) {
                    this.attackEntityAsMob((Entity) e);
                }
                if (this.getDistanceSqToEntity((Entity) e) < (70.0f + e.width / 2.0f) * (70.0f + e.width / 2.0f)) {
                    e = null;
                    e = this.findSomethingToAttack();
                } else {
                    this.getNavigator()
                        .tryMoveToEntityLiving((Entity) e, 1.2);
                }
            } else {
                this.setAttacking(0);
            }
        }
        if (this.worldObj.rand.nextInt(40) == 1 && this.getHealth() < this.mygetMaxHealth()) {
            this.heal(4.0f);
        }
    }

    public boolean getCanSpawnHere() {
        for (byte k = -3; k < 3; ++k) {
            for (byte j = -3; j < 3; ++j) {
                for (byte i = 0; i < 5; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((byte) this.posX + j, (byte) this.posY + i, (byte) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((byte) this.posX + j, (byte) this.posY + i, (byte) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("YakPrinceInstance")) {
                            return true;
                        }
                    }
                    if (bid != Blocks.air) {
                        return false;
                    }
                }
            }
        }
        return this.isValidLightLevel() && !this.worldObj.isDaytime() && this.posY >= 50.0;
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
        if (par1EntityLiving instanceof YakPrinceInstance) {
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

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public final void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, (Object) (byte) par1);
    }

    private EntityLivingBase findSomethingToAttack() {
        /*
         * if (Basic.Snap != 0) {
         * return null;
         * }
         */
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(24.0, 6.0, 24.0));
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
}
