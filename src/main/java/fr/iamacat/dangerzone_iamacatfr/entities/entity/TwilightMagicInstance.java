
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.entities.ai.EntitySensesOptimized;
import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.*;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TwilightMagicInstance extends EntityMob {

    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorterInstance TargetSorter;
    private int stuck_count;
    private int lastX;
    private int lastZ;
    private Entity rt;
    private int MagicType;
    private int shotBySword;
    public int shotbyplayer;
    private final EntitySensesOptimized senses;

    public TwilightMagicInstance(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.TargetSorter = null;
        this.stuck_count = 0;
        this.lastX = 0;
        this.lastZ = 0;
        this.rt = null;
        this.MagicType = 0;
        this.shotBySword = 0;
        this.shotbyplayer = 0;
        this.setSize(0.8f, 0.8f);
        this.getNavigator()
            .setAvoidsWater(false);
        this.experienceValue = 100;
        this.isImmuneToFire = false;
        this.fireResistance = 5;
        this.TargetSorter = new GenericTargetSorterInstance(this);
        this.noClip = true;
        this.senses = new EntitySensesOptimized(this);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.3199999928474426);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance)
            .setBaseValue(5.0);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(750.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, 0);
    }

    public void setWasShot() {
        this.shotBySword = 1;
    }

    protected boolean canDespawn() {
        return true;
    }

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public final void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, (Object) (byte) par1);
    }

    protected float getSoundVolume() {
        return 0.35f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected void collideWithEntity(final Entity par1Entity) {}

    public int mygetMaxHealth() {
        return Integer.MAX_VALUE;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        super.onUpdate();

        World world = this.worldObj;
        Random rand = world.rand;

        if (rand.nextInt(3) == 0) { // Réduit la fréquence des particules
            double offsetX = (rand.nextFloat() - rand.nextFloat()) / 2.0;
            double offsetY = (rand.nextFloat() - rand.nextFloat()) / 2.0;
            double offsetZ = (rand.nextFloat() - rand.nextFloat()) / 2.0;

            double posX = this.posX;
            double posY = this.posY + 1.25;
            double posZ = this.posZ;

            world.spawnParticle("fireworksSpark", posX, posY, posZ, offsetX, offsetY, offsetZ);
            world.spawnParticle("witchMagic", posX, posY, posZ, offsetX, offsetY, offsetZ);

            this.motionY *= 0.6;

            if (this.isInWater() && rand.nextInt(20) == 1) {
                this.attackEntityAsMob(this);
            }
        }
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity instanceof EntityLivingBase) {
            EntityLivingBase target = (EntityLivingBase) par1Entity;

            // Définir les valeurs des dégâts en fonction du type d'entité
            float damage = 0.0f;
            float explosionDamage = 5.0f;
            float healthReductionFactor = 1.35f;

            if (target instanceof DarknessInstance) {
                damage = 2.14748365E9f;
            } else if (target instanceof EntityPlayer) {
                damage = -40.0f;
            } else if (this.shotbyplayer == 1) {
                damage = target.getHealth() / healthReductionFactor;
            } else if (target instanceof HydraInstance || target instanceof UrsaMAJORInstance) {
                damage = -50.0f;
            }

            // Appliquer les dégâts à la cible
            target.attackEntityFrom(DamageSource.setExplosionSource(null).setExplosion(), damage);
            target.attackEntityFrom(DamageSource.fall, damage);

            // Appliquer l'effet météorologique
            worldObj.addWeatherEffect(new EntityLightningBolt(worldObj, target.posX, target.posY - 16.0, target.posZ));

            // Vérifier la santé de la cible
            if (target.getHealth() < 5.0f) {
                target.setHealth(target.getHealth() / healthReductionFactor - 0.0f);
                createExplodeSource(target.posX, target.posY, target.posZ, 2.0, explosionDamage, 1);
            } else {
                target.setHealth(target.getHealth() / healthReductionFactor);
            }
        }
        return false;
    }

    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.worldObj.rayTraceBlocks(
            Vec3.createVectorHelper(this.posX, this.posY + 0.75, this.posZ),
            Vec3.createVectorHelper(pX, pY, pZ),
            false) == null;
    }

    private EntityLivingBase createExplodeSource(final double X, final double Y, final double Z, final double dist,
        final double damage, final int knock) {
        final AxisAlignedBB bb = AxisAlignedBB
            .getBoundingBox(X - dist, Y - 10.0, Z - dist, X + dist, Y + 10.0, Z + dist);
        final List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, bb);
        Collections.sort((List<Object>) var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7;
        EntityLivingBase var8 ;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (var8 != null && var8 != this && var8.isEntityAlive() && !(var8 instanceof TwilightMagicInstance)) {
                DamageSource var9 ;
                var9 = DamageSource.setExplosionSource(null);
                var9.setExplosion();
                var8.attackEntityFrom(var9, (float) damage );
                var8.attackEntityFrom(DamageSource.fall, (float) damage );
                this.worldObj.playSoundAtEntity(
                    var8,
                    "random.explode",
                    2.65f,
                    1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
                final double ks = 0.0;
                final double inair = 0.0;
                final float f3 = (float) Math.atan2(var8.posZ - this.posZ, var8.posX - this.posX);
                var8.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return null;
    }

    private ChunkCoordinates getRandomFlightTarget() {
        int x = (int) this.posX + rand.nextInt(16) - 8;
        int y = (int) this.posY + rand.nextInt(20) - 10;
        int z = (int) this.posZ + rand.nextInt(16) - 8;
        return new ChunkCoordinates(x, y, z);
    }
    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();

        if (this.currentFlightTarget == null || this.stuck_count > 50) {
            this.currentFlightTarget = getRandomFlightTarget();
            this.stuck_count = 0;
        }

        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            EntityLivingBase target = this.findSomethingToAttack();
            if (target != null) {
                this.currentFlightTarget = new ChunkCoordinates((int) target.posX, (int) (target.posY + target.height / 2.0), (int) target.posZ);
                double distanceSquared = this.getDistanceSqToEntity(target);
                if (distanceSquared < (12.0f + target.width / 2.0f) * (12.0f + target.width / 2.0f)) {
                    this.attackEntityAsMob(target);
                    this.setDead();
                    return;
                }
            }
        }

        double targetX = this.currentFlightTarget.posX + 0.8 - this.posX;
        double targetY = this.currentFlightTarget.posY + 0.8 - this.posY;
        double targetZ = this.currentFlightTarget.posZ + 0.8 - this.posZ;

        double moveX = Math.signum(targetX) * 1.8;
        double moveY = Math.signum(targetY) * 1.8;
        double moveZ = Math.signum(targetZ) * 1.8;

        // Précalculez l'angle en radians
        double angleRad = Math.atan2(moveZ, moveX);

        this.motionX += (moveX - this.motionX) * 0.6;
        this.motionY += (moveY - this.motionY) * 0.4;
        this.motionZ += (moveZ - this.motionZ) * 0.6;

        // Utilisez une constante plutôt que de multiplier par 90.0/3.141592653589793
        float yaw = (float) (angleRad * 51.295);

        float yawDiff = MathHelper.wrapAngleTo180_float(yaw - this.rotationYaw);

        // Utilisez une constante plutôt que de diviser par 8.0f
        this.moveForward = 2.0f;

        this.rotationYaw += yawDiff * 0.125; // 1.0 / 8.0
    }

    public boolean canBePushed() {
        return false;
    }

    protected boolean canTriggerWalking() {
        return true;
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    public boolean doesEntityNotTriggerPressurePlate() {
        return false;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        return false;
    }

    public int getTotalArmorValue() {
        return 25;
    }

    public void initCreature() {}

    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving) {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && par1EntityLiving != null
            && par1EntityLiving != this
            && par1EntityLiving.isEntityAlive()
            && this.getOptimizedEntitySenses().canSee(par1EntityLiving)
            && !par1EntityLiving.isInWater()
            && !(par1EntityLiving instanceof TwilightMagicInstance)
            && !(par1EntityLiving instanceof WindigoInstance)
            && !(par1EntityLiving instanceof ArcticScorpionInstance)
            && !(par1EntityLiving instanceof TwilicornInstance)
            && !(par1EntityLiving instanceof DashInstance)
            && !(par1EntityLiving instanceof DashCloudInstance)
            && !(par1EntityLiving instanceof AJInstance)
            && !(par1EntityLiving instanceof PhoenixInstance)
            && (par1EntityLiving instanceof DarknessInstance || (!(par1EntityLiving instanceof EntityPlayer)
            && (!MobUtils.isAttackableNonMob(par1EntityLiving) || true)));
    }
    public EntitySensesOptimized getOptimizedEntitySenses() {
        return this.senses;
    }
    private EntityLivingBase findSomethingToAttack() {
        AxisAlignedBB searchBox = this.boundingBox.expand(32.0, 16.0, 32.0);

        List entities = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, searchBox);


        entities.sort(this.TargetSorter);

        for (Object entity : entities) {
            if (this.isSuitableTarget((EntityLivingBase) entity)) {
                return (EntityLivingBase) entity;
            }
        }

        return null;
    }

}
