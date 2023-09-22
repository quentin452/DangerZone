
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.render.InfoRenderer;
import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
public class ToughGuyInstance extends EntityMob {

    private GenericTargetSorterInstance TargetSorter;
    private float moveSpeed;
    private InfoRenderer renderdata;

    public ToughGuyInstance(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.25f;
        this.renderdata = new InfoRenderer();
        this.setSize(1.9f, 3.6f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 40;
        this.fireResistance = 100;
        this.renderDistanceWeight = 12.0;
        this.TargetSorter = new GenericTargetSorterInstance((Entity) this);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMoveThroughVillage(this, 1.0, false));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue((double) this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(19.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
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

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        super.onUpdate();
    }

    public int mygetMaxHealth() {
        return 60;
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
            return "mob.irongolem.walk";
        }
        return "mob.irongolem.walk";
    }

    protected String getHurtSound() {
        return Tags.MODID + ":toughpain";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":toughdeath";
    }

    protected float getSoundVolume() {
        return 1.5f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItemId() {
        return Items.skull;
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

    public void initCreature() {}

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (super.attackEntityAsMob(par1Entity)) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
                final double ks = 1.6;
                double inair = 0.65;
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

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(5) == 0) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                this.faceEntity((Entity) e, 10.0f, 10.0f);
                if (this.getDistanceSqToEntity((Entity) e) < (5.0f + e.width / 3.0f) * (5.0f + e.width / 3.0f)) {
                    this.setAttacking((byte) 1);
                    if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1) {
                        this.attackEntityAsMob((Entity) e);
                    }
                } else {
                    this.getNavigator()
                        .tryMoveToEntityLiving((Entity) e, 1.75);
                }
            } else {
                this.setAttacking((byte) 0);
            }
        }
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
        if (MobUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof ToughGuyInstance) {
            return false;
        }
        if (par1EntityLiving instanceof EntityZombie) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySkeleton) {
            return false;
        }
        if (par1EntityLiving instanceof EntityEnderman) {
            return false;
        }
        if (par1EntityLiving instanceof EntityCreeper) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySlime) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySpider) {
            return false;
        }
        if (par1EntityLiving instanceof EntityWitch) {
            return false;
        }
        if (par1EntityLiving instanceof EntityBlaze) {
            return false;
        }
        if (par1EntityLiving instanceof EntityCaveSpider) {
            return false;
        }
        if (par1EntityLiving instanceof EntityGhast) {
            return false;
        }
        if (par1EntityLiving instanceof EntityGolem) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySnowman) {
            return false;
        }
        if (par1EntityLiving instanceof EntityIronGolem) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMagmaCube) {
            return false;
        }
        if (!this.getEntitySenses()
            .canSee((Entity) par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode;
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
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0, 5.0, 12.0));
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

    public final byte getAttacking() {
        return this.dataWatcher.getWatchableObjectByte(20);
    }

    public final void setAttacking(final byte par1) {
        this.dataWatcher.updateObject(20, par1);
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
                        if (s != null && s.equals("MyToughGuy")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        if (this.worldObj.isDaytime()) {
            return false;
        }
        ToughGuyInstance target = null;
        target = (ToughGuyInstance) this.worldObj.findNearestEntityWithinAABB(
            ToughGuyInstance.class,
            this.boundingBox.expand(16.0, 6.0, 16.0),
            (Entity) this);
        return target == null;
    }

    @SideOnly(Side.CLIENT)
    public static class RenderTheMob18 extends RenderLiving {

        private static final ResourceLocation mantexture;

        public RenderTheMob18(final ModelBase par1ModelBase, final float par2) {
            super(par1ModelBase, par2);
        }

        protected ResourceLocation getEntityTexture(final Entity entity) {
            return RenderTheMob18.mantexture;
        }

        static {
            mantexture = new ResourceLocation(Tags.MODID + ":" + "textures/entity/toughguy.png");
        }
    }
}
