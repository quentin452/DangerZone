
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class DemonSpiderEntity extends EntityMob {

    private GenericTargetSorter TargetSorter;
    private float moveSpeed;
    private EntityLivingBase rt;

    public DemonSpiderEntity(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.38f;
        this.rt = null;
        this.setSize(2.0f, 2.2f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 150;
        this.fireResistance = 100;
        this.renderDistanceWeight = 12.0;
        this.TargetSorter = new GenericTargetSorter((Entity) this);
        this.tasks.addTask(0, new EntityAISwimming( this));
        this.tasks.addTask(1, new EntityAIMoveThroughVillage( this, 1.0, false));
        this.tasks.addTask(2, new EntityAIWander( this, 1.0));
        this.tasks
            .addTask(3, new EntityAIWatchClosest( this, (Class<EntityPlayer>) EntityPlayer.class, 8.0f));
        this.tasks.addTask(4, new EntityAILookIdle( this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget( this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue((double) this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(480.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
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
        return 250;
    }

    public int getTotalArmorValue() {
        return 20;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    protected String getLivingSound() {
        if (this.rand.nextInt(4) == 0) {
            return "";
        }
        return "";
    }

    protected String getHurtSound() {
        return "mob.blaze.hit";
    }

    protected String getDeathSound() {
        return "mob.blaze.death";
    }

    protected float getSoundVolume() {
        return 2.5f;
    }

    protected float getSoundPitch() {
        return 4.0f;
    }

    protected Item getDropItemId() {
        return Items.brewing_stand;
    }

    private ItemStack dropItemRand(final Item index) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, 1, 0);
        Random random = new Random();

        var3 = new EntityItem(
            this.worldObj,
            this.posX + (random.nextInt(7) - 3),
            this.posY + 1.0,
            this.posZ + (random.nextInt(7) - 3),
            is);

        final float f3 = (float) Math.atan2(random.nextInt() - this.posZ, random.nextInt() - this.posX);
        var3.addVelocity(Math.cos(f3) * 0.15000000596046448, 0.25, Math.sin(f3) * 0.25);

        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }

        return is;
    }

    private ItemStack dropBlockRand(final Block index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        Random random = new Random();

        var3 = new EntityItem(
            this.worldObj,
            this.posX + (random.nextInt(7) - 3),
            this.posY + 1.0,
            this.posZ + (random.nextInt(7) - 3),
            is);

        final float f3 = (float) Math.atan2(random.nextInt() - this.posZ, random.nextInt() - this.posX);
        var3.addVelocity(Math.cos(f3) * 0.15000000596046448, 0.25, Math.sin(f3) * 0.25);

        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }

        return is;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        // this.dropItemRand(Items.apple, 1);
        this.dropItemRand(Items.spider_eye);
        for (int var4 = 0; var4 < 7; ++var4) {
            this.dropItemRand(Items.string);
        }
        for (int var4 = 0; var4 < 7; ++var4) {
            this.dropItemRand(Items.spider_eye);
        }
        // this.dropItemRand(Basic.balloons, 1);
        // this.dropItemRand(Items.apple, 1);
        /*
         * if (this.worldObj.rand.nextInt(5) == 1) {
         * this.dropItemRand(Basic.ajSword, 1);
         * }
         * if (this.worldObj.rand.nextInt(5) == 1) {
         * this.dropItemRand(Basic.eggDemonSpider, 1);
         * }
         */
    }

    public void initCreature() {}

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (super.attackEntityAsMob(par1Entity)) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
                final double ks = 1.2;
                double inair = 0.1;
                final int var2 = 6;
                final float f3 = (float) Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
                if (par1Entity.isDead || par1Entity instanceof EntityPlayer) {
                    inair *= 2.0;
                    ((EntityLivingBase) par1Entity)
                        .addPotionEffect(new PotionEffect(Potion.digSlowdown.id, var2 * 180, 9));
                    ((EntityLivingBase) par1Entity)
                        .addPotionEffect(new PotionEffect(Potion.confusion.id, var2 * 180, 9));
                    ((EntityLivingBase) par1Entity)
                        .addPotionEffect(new PotionEffect(Potion.blindness.id, var2 * 180, 9));
                    ((EntityLivingBase) par1Entity).addPotionEffect(new PotionEffect(Potion.wither.id, var2 * 180, 9));
                    ((EntityLivingBase) par1Entity)
                        .addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, var2 * 180, 9));
                }
                par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            return true;
        }
        return false;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (!par1DamageSource.getDamageType()
            .equals("cactus")) {
            ret = super.attackEntityFrom(par1DamageSource, par2);
            final Entity e = par1DamageSource.getEntity();
            if (e != null && e instanceof EntityLivingBase) {
                this.rt = (EntityLivingBase) e;
            }
        }
        return ret;
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(5) == 1) {
            EntityLivingBase e = null;
            e = this.rt;
            /*
             * if (Basic.Snap != 0) {
             * e = null;
             * }
             */
            if (e != null) {
                if (e.isDead || this.worldObj.rand.nextInt(200) == 1) {
                    e = null;
                    this.rt = null;
                }
                if (e != null && !this.getEntitySenses()
                    .canSee((Entity) e)) {
                    e = null;
                }
            }
            if (e == null) {
                e = this.findSomethingToAttack();
            }
            if (e != null) {
                this.faceEntity((Entity) e, 10.0f, 10.0f);
                if (this.getDistanceSqToEntity((Entity) e) < (5.0f + e.width / 2.0f) * (5.0f + e.width / 2.0f)) {
                    this.setAttacking(1);
                    if (this.worldObj.rand.nextInt(2) == 0 || this.worldObj.rand.nextInt(3) == 1) {
                        this.attackEntityAsMob((Entity) e);
                    }
                } else {
                    this.getNavigator()
                        .tryMoveToEntityLiving((Entity) e, 1.25);
                }
            } else {
                this.setAttacking(0);
            }
        }
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
            .canSee(par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof DemonSpiderEntity) {
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
        /*
         * if (Basic.Snap != 0) {
         * return null;
         * }
         */
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(20.0, 6.0, 20.0));
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

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public final void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, (Object) (byte) par1);
    }

    public boolean getCanSpawnHere() {
        for (int k = -4; k < 4; ++k) {
            for (int j = -4; j < 4; ++j) {
                for (int i = 4; i < 5; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("DemonSpider")) {
                            return true;
                        }
                    }
                }
            }
        }
        DemonSpiderEntity target = null;
        target = (DemonSpiderEntity) this.worldObj.findNearestEntityWithinAABB(
            (Class<DemonSpiderEntity>) DemonSpiderEntity.class,
            this.boundingBox.expand(24.0, 12.0, 24.0),
            (Entity) this);
        return target == null;
    }

    @SideOnly(Side.CLIENT)
    public static class RenderTheMob2 extends RenderLiving {

        private static final ResourceLocation dspidertexture;

        public RenderTheMob2(final ModelBase par1ModelBase, final float par2) {
            super(par1ModelBase, par2);
        }

        protected ResourceLocation getEntityTexture(final Entity entity) {
            return RenderTheMob2.dspidertexture;
        }

        static {
            dspidertexture = new ResourceLocation(Tags.MODID + ":" + "textures/entity/demonspider.png");
        }
    }
}
