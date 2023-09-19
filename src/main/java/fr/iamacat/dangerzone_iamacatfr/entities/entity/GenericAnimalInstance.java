
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.util.Collection;
import java.util.List;

import fr.iamacat.dangerzone_iamacatfr.util.EntityStates;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.network.NetworkRegistry;
import fr.iamacat.dangerzone_iamacatfr.DangerLogger;
import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.api.CustomEntityList;
import fr.iamacat.dangerzone_iamacatfr.api.CustomMobData;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.packets.PZPacketAnimTime;

public class GenericAnimalInstance extends GenericTameableInstance {

    public int maxAnimTime;
    public boolean forceDespawn;
    private float flightChance;

    public GenericAnimalInstance(final World par1World) {
        super(par1World);
        this.maxAnimTime = 20;
        this.forceDespawn = false;
        this.experienceValue = 3;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        final CustomEntityList entityEntry = CustomEntityList.getByName(EntityList.getEntityString((Entity) this));
        if (entityEntry != null && ((CustomMobData) entityEntry.modData.get()).entityProperties != null) {
            this.getAttributeMap()
                .registerAttribute(SharedMonsterAttributes.attackDamage);
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
                .setBaseValue((double) ((CustomMobData) entityEntry.modData.get()).entityProperties.maxHealth);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
                .setBaseValue((double) ((CustomMobData) entityEntry.modData.get()).entityProperties.moveSpeed);
            this.getEntityAttribute(SharedMonsterAttributes.followRange)
                .setBaseValue((double) ((CustomMobData) entityEntry.modData.get()).entityProperties.followRange);
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance)
                .setBaseValue(
                    (double) ((CustomMobData) entityEntry.modData.get()).entityProperties.knockbackResistance);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
                .setBaseValue((double) ((CustomMobData) entityEntry.modData.get()).entityProperties.attackDamage);
            this.flightChance = ((CustomMobData) entityEntry.modData.get()).entityProperties.flightChance;
        }
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
    }

    protected void updateDWEntityState(final EntityStates entityState) {
        this.dataWatcher.updateObject(20, entityState.index);
    }

    public int getDWEntityState() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    @Override
    protected void updateAITasks() {
        this.updateAIState();
        super.updateAITasks();
        if (this.shouldAttack) {
            this.setAngerLevel(3);
        }
        this.updateDWEntityState(this.entityState);
    }

    public void updateAIState() {
        // if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL && Properties.despawnInPeaceful &&
        // !this.isTamed()) {
        // this.setDead();
        // }
        if (this.fleeingTick > 0) {
            this.entityState = EntityStates.fleeing;
        } else if (this.loveTimer > 0) {
            this.entityState = EntityStates.inLove;
        } else if (this.angerLevel > 0 && (this.getAttackTarget() != null || this.getAITarget() != null)) {
            this.entityState = EntityStates.attacking;
        } else if (this.angerLevel > 0) {
            this.entityState = EntityStates.looking;
        } else if (this.isSitting()) {
            this.entityState = EntityStates.sitting;
        } else if (this.shouldFollow) {
            this.entityState = EntityStates.following;
        } else {
            this.entityState = EntityStates.idle;
        }
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.animTime = Math.max(this.animTime - 1, 0);
        this.entityState = EntityStates.getEntityByIndex(this.getDWEntityState());
    }

    @Override
    protected boolean canDespawn() {
        final CustomEntityList entityEntry = CustomEntityList.getByName(EntityList.getEntityString((Entity) this));
        if (entityEntry != null && !this.isTamed()) {
            return this.forceDespawn || ((CustomMobData) entityEntry.modData.get()).shouldDespawn;
        }
        return super.canDespawn();
    }

    public boolean isCreatureType(final EnumCreatureType type, final boolean forSpawnCount) {
        final CustomEntityList entityEntry = CustomEntityList.getByName(EntityList.getEntityString(this));
        if (forSpawnCount && entityEntry != null) {
            return ((CustomMobData) entityEntry.modData.get()).spawnType != null
                && entityEntry.modData.get().spawnType.equals(type);
        }
        if (entityEntry != null) {
            return (((CustomMobData) entityEntry.modData.get()).creatureType != null)
                ? ((CustomMobData) entityEntry.modData.get()).creatureType.equals((Object) type)
                : super.isCreatureType(type, forSpawnCount);
        }
        return super.isCreatureType(type, forSpawnCount);
    }

    public boolean attackEntityAsMob(final Entity targetEntity) {
        if (targetEntity.boundingBox.maxY > this.boundingBox.minY
            && targetEntity.boundingBox.minY < this.boundingBox.maxY) {
            this.animTime = this.maxAnimTime;
            if (!this.worldObj.isRemote) {
                final PZPacketAnimTime message = new PZPacketAnimTime()
                    .setPacketData(this.getEntityId(), this.animTime);
                DangerZone.packetHandler.sendToAllAround(
                    message,
                    new NetworkRegistry.TargetPoint(this.dimension, this.posX, this.posY, this.posZ, 30.0));
            }
            float damage = (float) this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
                .getAttributeValue();
            int knockbackScale = 0;
            if (targetEntity instanceof EntityLivingBase) {
                damage += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase) targetEntity);
                knockbackScale += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase) targetEntity);
            }
            final boolean attackedSucceded = targetEntity.attackEntityFrom(DamageSource.causeMobDamage(this), damage);
            if (attackedSucceded) {
                if (knockbackScale > 0) {
                    targetEntity.addVelocity(
                        -MathHelper.sin(this.rotationYaw * 3.1415927f / 180.0f) * knockbackScale * 0.5f,
                        0.1,
                        (double) (MathHelper.cos(this.rotationYaw * 3.1415927f / 180.0f) * knockbackScale * 0.5f));
                    this.motionX *= 0.6;
                    this.motionZ *= 0.6;
                }
                final int fireScale = EnchantmentHelper.getFireAspectModifier(this);
                if (fireScale > 0) {
                    targetEntity.setFire(fireScale * 4);
                }
                if (targetEntity instanceof EntityLivingBase) {
                    EnchantmentHelper.func_151384_a((EntityLivingBase) targetEntity, (Entity) this);
                }
                EnchantmentHelper.func_151385_b((EntityLivingBase) this, targetEntity);
            }
            return attackedSucceded && super.attackEntityAsMob(targetEntity);
        }
        return false;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        if (super.attackEntityFrom(par1DamageSource, par2) && par1DamageSource.getEntity() != null
            && par1DamageSource.getEntity() instanceof EntityPlayer) {
            final EntityPlayer attackingPlayer = (EntityPlayer) par1DamageSource.getEntity();
            if (this.shouldNotifySimilar(attackingPlayer)) {

                final List<Entity> var4 = this.worldObj
                    .getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(20.0, 20.0, 20.0));
                for (final Entity nearbyEntity : var4) {
                    if (nearbyEntity.getClass()
                        .equals(this.getClass())) {
                        final GenericAnimalInstance nearbyAlly = (GenericAnimalInstance) nearbyEntity;
                        nearbyAlly.entityAttackedReaction(attackingPlayer);
                    }
                }
            }
            this.entityAttackedReaction(attackingPlayer);
            return true;
        }
        return false;
    }

    protected void entityAttackedReaction(final EntityPlayer attackingPlayer) {
        if (!this.isTamed()) {
            if (this.shouldPanic()) {
                this.setFleeTick(80);
            } else {
                this.setAngerLevel(400);
            }
        }
    }

    public boolean shouldNotifySimilar(final EntityPlayer attackingPlayer) {
        return false;
    }

    protected boolean shouldPanic() {
        return this.worldObj.rand.nextFloat() * 100.0f < this.flightChance;
    }

    protected int getExperiencePoints(final EntityPlayer par1EntityPlayer) {
        if (this.isTamed()) {
            return 0;
        }
        if (this instanceof IMob || this.getEntityState() == EntityStates.attacking
            || this.getEntityState() == EntityStates.looking) {
            return 5;
        }
        return this.rand.nextInt(2) + 1;
    }

    public boolean getCanSpawnHere() {
        final int xCoord = MathHelper.floor_double(this.posX);
        final int yCoord = MathHelper.floor_double(this.boundingBox.minY);
        final int zCoord = MathHelper.floor_double(this.posZ);
        boolean wasSuccesful = false;
        final CustomEntityList customEntity = CustomEntityList.getByEntity(this);
        if (customEntity == null) {
            DangerLogger.LOGGER.log(
                Level.WARN,
                "Entity %s is Trying to Spawn but does not exist in the CustomEntityList. It will not spawn, please report this to Modder.",
                this.getClass()
                    .toString());
            return false;
        }
        if (customEntity.modData.get().secondarySpawnRate - this.rand.nextInt(100) >= 0 && super.getCanSpawnHere()
            && this.isValidLightLevel(this.worldObj, xCoord, yCoord, zCoord)
            && this.isValidLocation(this.worldObj, xCoord, yCoord, zCoord)) {
            wasSuccesful = true;
        }
        if (customEntity.modData.get().reportSpawningInLog) {
            if (wasSuccesful) {
                DangerLogger.info(
                    "Successfully spawned %s at X:%s Y:%s Z:%s in %s",
                    new Object[] { this.getCommandSenderName(), xCoord, yCoord, zCoord,
                        this.worldObj.getBiomeGenForCoords(xCoord, zCoord) });
            } else {
                DangerLogger.info(
                    "Failed to spawn %s at X:%s Y:%s Z:%s in %s, Spawning Location Inhospitable",
                    new Object[] { this.getCommandSenderName(), xCoord, yCoord, zCoord,
                        this.worldObj.getBiomeGenForCoords(xCoord, zCoord) });
            }
        }
        return wasSuccesful;
    }

    protected boolean isValidLightLevel(final World world, final int xCoord, final int yCoord, final int zCoord) {
        return this.worldObj.getSavedLightValue(EnumSkyBlock.Block, xCoord, yCoord, zCoord) < 1;
    }

    protected boolean isValidLocation(final World world, final int xCoord, final int yCoord, final int zCoord) {
        return true;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final CustomEntityList customEntity = CustomEntityList.getByEntity((Entity) this);
        if (customEntity != null) {
            final Collection<ItemStack> loot = (Collection<ItemStack>) ((CustomMobData) customEntity.modData.get())
                .getLoot(this.rand, par2);
            for (final ItemStack itemStack : loot) {
                if (itemStack != null) {
                    this.entityDropItem(itemStack, 1.0f);
                }
            }
        }
    }

    @Override
    public void writeEntityToNBT(final NBTTagCompound par1nbtTagCompound) {
        super.writeEntityToNBT(par1nbtTagCompound);
        par1nbtTagCompound.setBoolean("ForceDespawn", this.forceDespawn);
    }

    @Override
    public void readEntityFromNBT(final NBTTagCompound par1nbtTagCompound) {
        super.readEntityFromNBT(par1nbtTagCompound);
        this.forceDespawn = par1nbtTagCompound.getBoolean("ForceDespawn");
    }
}
