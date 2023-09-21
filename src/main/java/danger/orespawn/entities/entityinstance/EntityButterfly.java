
package danger.orespawn.entities.entityinstance;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;

import danger.orespawn.utils.GenericTargetSorter;
import danger.orespawn.worldgen.OreSpawnTeleporter;

public class EntityButterfly extends EntityAmbientCreature {

    private static final ResourceLocation texture1;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;
    private static final ResourceLocation texture4;
    private static final ResourceLocation texture5;
    private static final ResourceLocation texture6;
    private static final ResourceLocation texture7;
    private static final ResourceLocation texture8;
    private static final ResourceLocation texture9;
    public int butterfly_type;
    private int attack_delay;
    private GenericTargetSorter TargetSorter;
    private int force_sync;
    private ChunkCoordinates currentFlightTarget;

    public EntityButterfly(final World par1World) {
        super(par1World);
        this.butterfly_type = 0;
        this.attack_delay = 0;
        this.TargetSorter = null;
        this.force_sync = 25;
        this.currentFlightTarget = null;
        this.butterfly_type = OreSpawnMain.OreSpawnRand.nextInt(4);
        this.setSize(0.4f, 0.4f);
        this.getNavigator()
            .setAvoidsWater(true);
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
            .setBaseValue(0.0);
    }

    public ResourceLocation getTexture(final EntityButterfly a) {
        if (a instanceof Mothra) {
            return EntityButterfly.texture5;
        }
        if (a instanceof EntityLunaMoth) {
            if (((EntityLunaMoth) a).moth_type == 1) {
                return EntityButterfly.texture5;
            }
            if (((EntityLunaMoth) a).moth_type == 2) {
                return EntityButterfly.texture7;
            }
            if (((EntityLunaMoth) a).moth_type == 3) {
                return EntityButterfly.texture8;
            }
            return EntityButterfly.texture6;
        } else if (this.butterfly_type == 1) {
            if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4) {
                return EntityButterfly.texture9;
            }
            return EntityButterfly.texture2;
        } else {
            if (this.butterfly_type == 2) {
                return EntityButterfly.texture3;
            }
            if (this.butterfly_type == 3) {
                return EntityButterfly.texture4;
            }
            return EntityButterfly.texture1;
        }
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) this.butterfly_type);
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    protected float getSoundVolume() {
        return 0.0f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return null;
    }

    protected String getDeathSound() {
        return null;
    }

    public boolean canBePushed() {
        return true;
    }

    protected void collideWithEntity(final Entity par1Entity) {}

    protected void collideWithNearbyEntities() {}

    public int mygetMaxHealth() {
        return 2;
    }

    protected boolean isAIEnabled() {
        return true;
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
        if (this.rand.nextInt(100) == 0
            || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 4.0f) {
            for (Block bid = Blocks.stone; bid != Blocks.air && keep_trying != 0; bid = this.worldObj.getBlock(
                this.currentFlightTarget.posX,
                this.currentFlightTarget.posY,
                this.currentFlightTarget.posZ), --keep_trying) {
                this.currentFlightTarget.set(
                    (int) this.posX + this.rand.nextInt(7) - this.rand.nextInt(7),
                    (int) this.posY + this.rand.nextInt(6) - 2,
                    (int) this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
            }
        } else if (this.rand.nextInt(10) == 0 && this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4
            && this.butterfly_type == 1
            && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                EntityLivingBase e = null;
                e = this.findSomethingToAttack();
                if (e != null) {
                    this.currentFlightTarget.set((int) e.posX, (int) (e.posY + 1.0), (int) e.posZ);
                    if (this.getDistanceSqToEntity(e) < 6.0) {
                        this.attackEntityAsMob(e);
                    }
                }
            }
        final double var1 = this.currentFlightTarget.posX + 0.5 - this.posX;
        final double var2 = this.currentFlightTarget.posY + 0.1 - this.posY;
        final double var3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.5 - this.motionX) * 0.10000000149011612;
        this.motionY += (Math.signum(var2) * 0.699999988079071 - this.motionY) * 0.10000000149011612;
        this.motionZ += (Math.signum(var3) * 0.5 - this.motionZ) * 0.10000000149011612;
        final float var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
        this.moveForward = 0.5f;
        this.rotationYaw += var5;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (OreSpawnMain.OreSpawnRand.nextInt(2) != 0) {
            return false;
        }
        if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            return false;
        }
        final boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), 1.0f);
        return var4;
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
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode;
        }
        return par1EntityLiving instanceof EntityHorse;
    }

    private EntityLivingBase findSomethingToAttack() {
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(8.0, 5.0, 8.0));
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

    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.6000000238418579;
        --this.force_sync;
        if (this.force_sync < 0) {
            this.force_sync = 25;
            if (this.worldObj.isRemote) {
                this.butterfly_type = this.dataWatcher.getWatchableObjectInt(20);
            } else {
                this.dataWatcher.updateObject(20, this.butterfly_type);
            }
        }
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        if (par1EntityPlayer == null) {
            return false;
        }
        if (!(par1EntityPlayer instanceof EntityPlayerMP)) {
            return false;
        }
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
            var2 = null;
        }
        if (var2 != null) {
            return false;
        }
        if (par1EntityPlayer.dimension != OreSpawnMain.DimensionID6) {
            MinecraftServer.getServer()
                .getConfigurationManager()
                .transferPlayerToDimension(
                    (EntityPlayerMP) par1EntityPlayer,
                    OreSpawnMain.DimensionID6,
                    (Teleporter) new OreSpawnTeleporter(
                        MinecraftServer.getServer()
                            .worldServerForDimension(OreSpawnMain.DimensionID6),
                        OreSpawnMain.DimensionID6,
                        this.worldObj));
        } else {
            MinecraftServer.getServer()
                .getConfigurationManager()
                .transferPlayerToDimension(
                    (EntityPlayerMP) par1EntityPlayer,
                    0,
                    (Teleporter) new OreSpawnTeleporter(
                        MinecraftServer.getServer()
                            .worldServerForDimension(0),
                        0,
                        this.worldObj));
        }
        return true;
    }

    public boolean getCanSpawnHere() {
        for (int k = -3; k < 3; ++k) {
            for (int j = -3; j < 3; ++j) {
                for (int i = 0; i < 5; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("Butterfly")) {
                            this.butterfly_type = 1;
                            return true;
                        }
                    }
                }
            }
        }
        final Block bid = this.worldObj.getBlock((int) this.posX, (int) this.posY, (int) this.posZ);
        return bid == Blocks.air && this.worldObj.isDaytime()
            && (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4 || this.posY >= 50.0);
    }

    public void initCreature() {}

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("ButterflyType", this.butterfly_type);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.butterfly_type = par1NBTTagCompound.getInteger("ButterflyType");
    }

    static {
        texture1 = new ResourceLocation("orespawn", "butterfly.png");
        texture2 = new ResourceLocation("orespawn", "butterfly2.png");
        texture3 = new ResourceLocation("orespawn", "butterfly3.png");
        texture4 = new ResourceLocation("orespawn", "butterfly4.png");
        texture5 = new ResourceLocation("orespawn", "eyemoth.png");
        texture6 = new ResourceLocation("orespawn", "lunamoth.png");
        texture7 = new ResourceLocation("orespawn", "darkmoth.png");
        texture8 = new ResourceLocation("orespawn", "firemoth.png");
        texture9 = new ResourceLocation("orespawn", "vbutterfly1.png");
    }
}
