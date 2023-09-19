
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.util.Random;

import fr.iamacat.dangerzone_iamacatfr.util.EntityStates;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.api.CustomEntityList;
import fr.iamacat.dangerzone_iamacatfr.api.CustomMobData;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.EntityAIMoveTowardsRestriction;

public abstract class GenericCreatureInstance extends AerialInstance {

    private PathEntity pathToEntity;
    public boolean useVarTexture;
    protected Entity entityToAttack;
    private float maximumHomeDistance;
    private ChunkCoordinates homePosition;
    private boolean field_110180_bt;
    private int leashPathCooldown;
    private EntityAIBase field_110178_bs;
    protected int fleeingTick;
    protected int animTime;
    protected int angerLevel;
    protected EntityStates entityState;

    public boolean hasPath() {
        return this.pathToEntity != null;
    }

    public Entity getEntityToAttack() {
        return this.entityToAttack;
    }

    public void setTarget(final Entity par1Entity) {
        this.entityToAttack = par1Entity;
    }

    public int getFleeTick() {
        return this.fleeingTick;
    }

    public void setFleeTick(final int fleeingTick) {
        this.fleeingTick = fleeingTick;
    }

    public int getAnimTime() {
        return this.animTime;
    }

    public void setAnimTime(final int animTime) {
        this.animTime = animTime;
    }

    public int getAngerLevel() {
        return this.angerLevel;
    }

    public void setAngerLevel(final int angerLevel) {
        this.angerLevel = angerLevel;
    }

    public EntityStates getEntityState() {
        return this.entityState;
    }

    public GenericCreatureInstance(final World par1World) {
        super(par1World);
        this.useVarTexture = false;
        this.maximumHomeDistance = -1.0f;
        this.homePosition = new ChunkCoordinates(0, 0, 0);
        this.leashPathCooldown = 0;
        this.field_110178_bs = new EntityAIMoveTowardsRestriction(this, 1.0f);
        this.fleeingTick = 0;
        this.animTime = 0;
        this.angerLevel = 0;
        this.entityState = EntityStates.idle;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    protected void updateAITasks() {
        super.updateAITasks();
        this.attackTime = Math.max(this.attackTime - 1, 0);
        this.fleeingTick = Math.max(this.fleeingTick - 1, 0);
        this.angerLevel = Math.max(this.angerLevel - 1, 0);
    }

    public void onUpdate() {
        super.onUpdate();
        this.leashPathCooldown = Math.max(this.leashPathCooldown - 1, 0);
    }

    protected void updateLeashedState() {
        super.updateLeashedState();
        if (this.getLeashed() && this.getLeashedToEntity() != null
            && this.getLeashedToEntity().worldObj == this.worldObj) {
            final Entity entity = this.getLeashedToEntity();
            this.setHomeArea((int) entity.posX, (int) entity.posY, (int) entity.posZ, 5);
            final float f = this.getDistanceToEntity(entity);
            if (this instanceof GenericTameableInstance && ((GenericTameableInstance) this).isSitting()) {
                if (f > 10.0f) {
                    this.clearLeashed(true, true);
                }
                return;
            }
            if (!this.field_110180_bt) {
                this.tasks.addTask(2, this.field_110178_bs);
                this.getNavigator()
                    .setAvoidsWater(false);
                this.field_110180_bt = true;
            }
            this.func_142017_o(f);
            if (this.leashPathCooldown == 0 && f > 4.0f) {
                final boolean foundPath = this.getNavigator()
                    .tryMoveToEntityLiving(entity, 1.0);
                if (!foundPath) {
                    this.leashPathCooldown = 20;
                }
            }
            if (f > 6.0f) {
                final double d0 = (entity.posX - this.posX) / f;
                final double d2 = (entity.posY - this.posY) / f;
                final double d3 = (entity.posZ - this.posZ) / f;
                this.motionX += d0 * Math.abs(d0) * 0.4;
                this.motionY += d2 * Math.abs(d2) * 0.4;
                this.motionZ += d3 * Math.abs(d3) * 0.4;
            }
            if (f > 10.0f) {
                this.clearLeashed(true, true);
            }
        } else if (!this.getLeashed() && this.field_110180_bt) {
            this.field_110180_bt = false;
            this.tasks.removeTask(this.field_110178_bs);
            this.getNavigator()
                .setAvoidsWater(true);
            this.detachHome();
        }
    }

    protected void func_142017_o(final float par1) {}

    public int getMaxSpawnedInChunk() {
        final CustomEntityList entityEntry = CustomEntityList.getByName(EntityList.getEntityString((Entity) this));
        if (entityEntry != null) {
            return ((CustomMobData) entityEntry.modData.get()).maxSpawnInChunk;
        }
        return super.getMaxSpawnedInChunk();
    }

    public float getBlockPathWeight(final int par1, final int par2, final int par3) {
        return 0.0f;
    }

    protected void attackEntity(final Entity par1Entity, final float par2) {}

    public boolean isWithinHomeDistanceCurrentPosition() {
        return this.isWithinHomeDistance(
            MathHelper.floor_double(this.posX),
            MathHelper.floor_double(this.posY),
            MathHelper.floor_double(this.posZ));
    }

    public boolean isWithinHomeDistance(final int par1, final int par2, final int par3) {
        return this.maximumHomeDistance == -1.0f || this.homePosition.getDistanceSquared(par1, par2, par3)
            < this.maximumHomeDistance * this.maximumHomeDistance;
    }

    public void setHomeArea(final int par1, final int par2, final int par3, final int par4) {
        this.homePosition.set(par1, par2, par3);
        this.maximumHomeDistance = (float) par4;
    }

    public ChunkCoordinates getHomePosition() {
        return this.homePosition;
    }

    public float getMaximumHomeDistance() {
        return this.maximumHomeDistance;
    }

    public void detachHome() {
        this.maximumHomeDistance = -1.0f;
    }

    public boolean hasHome() {
        return this.maximumHomeDistance != -1.0f;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (Object) 0);
    }

    public void writeEntityToNBT(final NBTTagCompound par1nbtTagCompound) {
        super.writeEntityToNBT(par1nbtTagCompound);
        par1nbtTagCompound.setInteger("VarTexture", this.getTextureBase());
    }

    public void readEntityFromNBT(final NBTTagCompound par1nbtTagCompound) {
        super.readEntityFromNBT(par1nbtTagCompound);
        this.setTextureBase(par1nbtTagCompound.getInteger("VarTexture"));
    }

    public int getTextureBase() {
        return this.dataWatcher.getWatchableObjectInt(16);
    }

    public void setTextureBase(final int textureBase) {
        this.dataWatcher.updateObject(16, (Object) textureBase);
    }

    public IEntityLivingData onSpawnWithEgg(IEntityLivingData iEntityLivingData) {
        iEntityLivingData = super.onSpawnWithEgg(iEntityLivingData);
        this.setTextureBase(this.getRandTexture(this.worldObj.rand));
        return iEntityLivingData;
    }

    public int getRandTexture(final Random p_175510_0_) {
        final int i = p_175510_0_.nextInt(3);
        return i;
    }
}
