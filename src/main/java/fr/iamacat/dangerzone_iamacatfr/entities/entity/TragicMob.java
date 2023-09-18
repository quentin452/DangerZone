package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.util.Calendar;
import java.util.List;

import net.minecraft.entity.*;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.bosses.TragicBoss;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.minibosses.TragicMiniBoss;
import fr.iamacat.dangerzone_iamacatfr.entities.projectile.EntityProjectile;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public abstract class TragicMob extends EntityMob {

    protected TragicMiniBoss superiorForm;

    private int supportID = -1; // the potion id for the support buff applied to others
    private int supportAmp = 1; // the potion amplifier for the support buff

    public TragicMob(World par1World) {
        super(par1World);
    }

    protected boolean canCorrupt() {
        return true;
    }

    // protected boolean canChange()
    // {
    // return this.superiorForm != null && DangerZoneConfig.allowMobTransformation;
    // }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(13, Byte.valueOf((byte) 0));
        this.dataWatcher.addObject(14, Byte.valueOf((byte) 0));
        this.dataWatcher.addObject(15, Integer.valueOf(0));
    }

    public int getCorruptionTicks() {
        return this.dataWatcher.getWatchableObjectInt(15);
    }

    protected void setCorruptionTicks(int i) {
        this.dataWatcher.updateObject(15, i);
    }

    protected void incrementCorruptionTicks() {
        int pow = this.getCorruptionTicks();
        this.setCorruptionTicks(++pow);
    }

    public boolean isChanging() {
        return this.dataWatcher.getWatchableObjectInt(14) == 1;
    }

    public boolean isSupport() {
        return this.dataWatcher.getWatchableObjectInt(13) == 1;
    }

    public void setSupport(boolean flag) {
        this.dataWatcher.updateObject(13, flag ? (byte) 1 : 0);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.worldObj.isRemote) {
            if (this.isChanging()) {
                this.spawnExplosionParticle();
            }

            if (this.isSupport() && this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                double d = 0.35D;
                double d2 = 0.35D;

                for (byte i = 0; i < 3; i++) {
                    this.worldObj.spawnParticle(
                        "smoke",
                        this.posX + (this.rand.nextDouble() - rand.nextDouble()) * this.width * 1.25D,
                        this.posY + this.rand.nextDouble() * this.height,
                        this.posZ + (this.rand.nextDouble() - rand.nextDouble()) * this.width * 1.25D,
                        (this.rand.nextDouble() - 0.6D) * 0.1D,
                        this.rand.nextDouble() * 0.1D,
                        (this.rand.nextDouble() - 0.6D) * 0.1D);

                    this.worldObj.spawnParticle(
                        "redstone",
                        this.posX + (this.rand.nextDouble() - rand.nextDouble()) * this.width * 1.25D,
                        this.posY + this.rand.nextDouble() * this.height,
                        this.posZ + (this.rand.nextDouble() - rand.nextDouble()) * this.width * 1.25D,
                        0.6D,
                        0.2D,
                        0.6D);

                    this.worldObj.spawnParticle(
                        "redstone",
                        this.posX + (this.rand.nextDouble() - rand.nextDouble()) * this.width * 1.25D,
                        this.posY + this.rand.nextDouble() * this.height,
                        this.posZ + (this.rand.nextDouble() - rand.nextDouble()) * this.width * 1.25D,
                        rand.nextDouble() * d + d2,
                        rand.nextDouble() * d + d2,
                        rand.nextDouble() * d + d2);

                    this.worldObj.spawnParticle(
                        "redstone",
                        this.posX + (this.rand.nextDouble() - rand.nextDouble()) * this.width * 1.25D,
                        this.posY + this.rand.nextDouble() * this.height,
                        this.posZ + (this.rand.nextDouble() - rand.nextDouble()) * this.width * 1.25D,
                        rand.nextDouble() * d + d2,
                        rand.nextDouble() * d + d2,
                        rand.nextDouble() * d + d2);

                    this.worldObj.spawnParticle(
                        "redstone",
                        this.posX + (this.rand.nextDouble() - rand.nextDouble()) * this.width * 1.25D,
                        this.posY + this.rand.nextDouble() * this.height,
                        this.posZ + (this.rand.nextDouble() - rand.nextDouble()) * this.width * 1.25D,
                        rand.nextDouble() * d + d2,
                        rand.nextDouble() * d + d2,
                        rand.nextDouble() * d + d2);
                }
            }
            return;
        }

        if (this.isChanging() && this.ticksExisted > 1) {
            this.change();
            return;
        }

        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.HARD
            && this.isSupport()
            && this.ticksExisted % 30 == 0) {
            if (this.supportID < 0) {
                this.supportID = this.getRandomPotionID();
                this.supportAmp = rand.nextInt(2);
            }

            if (Potion.potionTypes[this.supportID] != null) {
                PotionEffect effect = new PotionEffect(this.supportID, 300, this.supportAmp);
                this.addPotionEffect(effect);

                List<Entity> list = this.worldObj
                    .getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0, 32.0, 32.0));

                for (Entity e : list) {
                    if (e instanceof EntityMob && this.canEntityBeSeen(e) && ((EntityMob) e).getAttackTarget() != this)
                        ((EntityMob) e).addPotionEffect(effect);
                }
            }
        }

        if (this.getAttackTarget() != null && this.getAttackTarget().isDead) this.setAttackTarget(null);
        if (this.getAttackTarget() != null
            && (this.getAttackTarget() instanceof TragicMob || this.getAttackTarget() instanceof TragicBoss))
            this.setAttackTarget(null);

        if (this.getAttackTarget() == null && this.canCorrupt()) {
            EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);

            Entity result = null;

            if (entityplayer != null && this.canEntityBeSeen(entityplayer)) {
                result = entityplayer;
            } else {
                List<Entity> list = this.worldObj
                    .getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(16.0, 16.0, 16.0));

                for (int i = 0; i < list.size(); i++) {
                    Entity entity = list.get(i);

                    if (this.canEntityBeSeen(entity) && entity != this) {
                        if (!(entity instanceof EntityWither) && !(entity instanceof EntityDragon)
                            && !(entity instanceof TragicBoss)
                            && entity.getClass() != this.getClass()) {
                            if (entity instanceof TragicMob) {
                                if (this.superiorForm != null && entity != this.superiorForm
                                    && entity.getClass() != this.getLesserForm()) {
                                    result = entity;
                                    break;
                                } else if (entity.getClass() != this.getLesserForm() && this.superiorForm == null) {
                                    result = entity;
                                    break;
                                }
                            } else if (entity instanceof EntityAnimal) {
                                result = entity;
                                break;
                            }
                        }
                    }
                }

                this.setAttackTarget((EntityLivingBase) result);
            }
        }

        /*
         * if (this.canChange() && this.getCorruptionTicks() >= 400 && this.rand.nextInt(200) <=
         * TragicConfig.mobTransformationChance && this.ticksExisted % 20 == 0 && rand.nextInt(4) == 0)
         * {
         * this.dataWatcher.updateObject(14, (byte) 1);
         * }
         * }
         * else if (this.canChange() && this.ticksExisted >= 6000 && this.ticksExisted % 20 == 0 &&
         * this.rand.nextInt(100) <= TragicConfig.mobTransformationChance)
         * {
         * this.dataWatcher.updateObject(14, (byte) 1);
         * }
         */
    }

    protected void change() {
        if (this.isChangeAllowed() && this.getSuperiorForm() != null) {
            TragicMob boss = (TragicMob) this.getSuperiorForm();
            boss.copyDataFrom(this, true);
            boss.copyLocationAndAnglesFrom(this);
            this.worldObj.removeEntity(this);
            this.worldObj.spawnEntityInWorld(boss);
            boss.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 200, 2));
            boss.addPotionEffect(new PotionEffect(Potion.resistance.id, 200, 2));
            boss.dataWatcher.updateObject(14, (byte) 0);
            boss.playSound(Tags.MODID + ":random.change", 1.0F, 1.0F);
        }
    }

    protected TragicMiniBoss getSuperiorForm() {
        return this.superiorForm;
    }

    /**
     * This needs to be overriden by each class to specify whether their superior form is allowed via the config, else
     * it isn't even used
     *
     * @return
     */
    protected abstract boolean isChangeAllowed();

    public boolean isCorrupted() {
        return this.getCorruptionTicks() > 0;
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
        if (this.worldObj.isRemote) return false;

        boolean result = super.attackEntityAsMob(par1Entity);

        if (result && this.canCorrupt() && rand.nextInt(4) == 0) {
            if (par1Entity instanceof TragicMob && ((TragicMob) par1Entity).canCorrupt()) {
                // Remplace l'effet de potion par une autre logique si nécessaire
                // ((TragicMob) par1Entity).appliquerEffetCorruption();
            } else if (par1Entity instanceof EntityMob && !(par1Entity instanceof TragicMob)) {
                // Remplace l'effet de potion par une autre logique si nécessaire
                // ((EntityMob) par1Entity).appliquerEffetCorruption();
            } else if (par1Entity instanceof EntityAnimal) {
                // Remplace l'effet de potion par une autre logique si nécessaire
                // ((EntityAnimal) par1Entity).appliquerEffetCorruption();
            } else if (par1Entity instanceof EntityPlayer && !((EntityPlayer) par1Entity).capabilities.isCreativeMode) {
                // Remplace l'effet de potion par une autre logique si nécessaire
                // ((EntityPlayer) par1Entity).appliquerEffetCorruption();
            }
        }

        return result;
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        if (tag.hasKey("corruptionTicks")) this.setCorruptionTicks(tag.getInteger("corruptionTicks"));
        if (tag.hasKey("changeState")) this.dataWatcher.updateObject(14, tag.getByte("changeState"));
        if (tag.hasKey("support")) this.setSupport(tag.getByte("support") == 1);
        if (tag.hasKey("supportID")) this.supportID = tag.getInteger("supportID");
        if (tag.hasKey("supportAmp")) this.supportAmp = tag.getInteger("supportAmp");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setInteger("corruptionTicks", this.getCorruptionTicks());
        tag.setByte("changeState", this.dataWatcher.getWatchableObjectByte(14));
        tag.setByte("support", this.isSupport() ? (byte) 1 : (byte) 0);
        tag.setInteger("supportID", this.supportID);
        tag.setInteger("supportAmp", this.supportAmp);
    }

    public boolean getMobGriefing() {
        return this.worldObj.getGameRules()
            .getGameRuleBooleanValue("mobGriefing");
    }

    public boolean getAllowLoot() {
        return this.worldObj.getGameRules()
            .getGameRuleBooleanValue("doMobLoot");
    }

    @Override
    protected void onDeathUpdate() {
        ++this.deathTime;

        if (this.deathTime == 20) {
            int i;

            if (!this.worldObj.isRemote && (this.recentlyHit > 0 || this.isPlayer())
                && this.func_146066_aG()
                && this.getAllowLoot()) {
                i = this.getExperiencePoints(this.attackingPlayer);

                while (i > 0) {
                    int j = EntityXPOrb.getXPSplit(i);
                    i -= j;
                    this.worldObj
                        .spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
                }
            }

            this.setDead();
            this.spawnExplosionParticle();
        }
    }

    @Override
    protected void dropFewItems(boolean flag, int l) {
        super.dropFewItems(flag, l);
        // todo
        /*
         * if (!this.worldObj.isRemote)
         * {
         * int x = this.getDropAmount() + l;
         * int drops = 0;
         * int commonDropRate = 50;
         * int rareDropRate = 10;
         * for (int i = 0; i < x; i++)
         * {
         * if (rand.nextInt(100) <= commonDropRate + (x * 4))
         * {
         * ItemStack drop = this.isMobVariant() ? EntityDropHelper.getDropFromVariant(this.getClass(), true) :
         * EntityDropHelper.getDropFromEntity(this.getClass(), true);
         * if (drop != null) this.capturedDrops.add(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ,
         * drop));
         * drops++;
         * }
         * if (flag && rand.nextInt(100) <= rareDropRate + x)
         * {
         * ItemStack drop = this.isMobVariant() ? EntityDropHelper.getDropFromVariant(this.getClass(), false) :
         * EntityDropHelper.getDropFromEntity(this.getClass(), false);
         * if (drop != null) this.capturedDrops.add(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ,
         * drop));
         * drops++;
         * }
         * if (drops > x * 2.5) break;
         * }
         * if (!allowMobStatueDrops) return;
         * int id = 0;
         * // Vous pouvez définir id en fonction de votre type d'entité ici
         * if (id != 0 && rand.nextInt(100) <= mobStatueDropChance && flag)
         * {
         * this.capturedDrops.add(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new
         * ItemStack(TragicItems.MobStatue, 1, id)));
         * }
         * }
         */
    }

    @Override
    public void onDeath(DamageSource par1DamageSource) {
        super.onDeath(par1DamageSource);

        if (par1DamageSource.getEntity() != null && par1DamageSource.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) par1DamageSource.getEntity();

        }
    }

    public boolean isMobVariant() {
        return false;
    }

    @Override
    public void onKillEntity(EntityLivingBase entity) {
        super.onKillEntity(entity);
        if (this.worldObj.isRemote) return;
        int i = (int) (entity.getMaxHealth() * 20);
        if (entity instanceof EntityPlayer) i *= 20;
        this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, i, 2));
        this.addPotionEffect(new PotionEffect(Potion.resistance.id, i, 2));
    }

    public Class<? extends TragicMob> getLesserForm() {
        return this.getClass();
    }

    @Override
    public boolean canAttackClass(Class par1Class) {
        return super.canAttackClass(par1Class) && par1Class != TragicBoss.class && this instanceof TragicMiniBoss
            ? par1Class != this.getLesserForm()
            : true;
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.HARD)
            this.setSupport(rand.nextInt(100) == 0);

        // Vos constantes locales pour les chances et les effets de potion
        final int groupBuffChance = 200;
        final int potionDuration = 20;
        final int maxPotionLevel = 2;

        if (data == null && rand.nextInt(groupBuffChance) == 0) {
            int id = this.getRandomPotionID();
            PotionEffect effect = new PotionEffect(id, potionDuration, rand.nextInt(maxPotionLevel));
            this.addPotionEffect(effect);
            return new GroupBuff(effect);
        } else if (data instanceof GroupBuff) {
            this.addPotionEffect(((GroupBuff) data).getReducedEffect());
        }

        return super.onSpawnWithEgg(data);
    }

    private int getRandomPotionID() {
        int id = Potion.damageBoost.id;
        switch (rand.nextInt(12)) {
            case 0:
            default:
                break;
            case 1:
                id = Potion.moveSpeed.id;
                break;
            case 2:
                id = Potion.invisibility.id;
                break;
            case 3:
                id = this.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD ? Potion.poison.id
                    : Potion.regeneration.id;
                break;
            case 4:
                id = Potion.fireResistance.id;
                break;
            case 5:
                id = Potion.resistance.id;
                break;
            case 6:
                id = Potion.jump.id;
                break;
        }

        return id;
    }

    /**
     * The maximum attempts for mob drops, the looting amount during a kill is added to this amount
     *
     * @return
     */
    public int getDropAmount() {
        return 1;
    }

    /**
     * Utility method for firing a projectile at input target, neither can be null, dispersal is how far off target the
     * projectile
     * will be, setting this to 0 will negate it, on hard projectiles are automatically set to fire with target's motion
     * taken into account
     *
     * @param entity
     * @param target
     * @param //        variance
     * @param dispersal
     * @return
     */
    protected Entity fireProjectileAtEntity(Entity entity, Entity target, float dispersal) {
        entity.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
        entity.setPosition(this.posX, this.posY + (this.height * 2 / 3), this.posZ);
        if (entity instanceof EntityProjectile) ((EntityProjectile) entity).shootingEntity = this;
        else if (entity instanceof EntityFireball) ((EntityFireball) entity).shootingEntity = this;

        double d0 = target.posX - this.posX;
        double d1 = target.posY - this.posY + (target.height * 0.5D) - (this.height * 2 / 3);
        double d2 = target.posZ - this.posZ;

        float mf = entity instanceof EntityProjectile ? ((EntityProjectile) entity).getMotionFactor()
            : entity instanceof EntityWitherSkull && ((EntityWitherSkull) entity).isInvulnerable() ? 0.73F : 0.95F;
        float dist = this.getDistanceToEntity(this.getAttackTarget());

        if (this.worldObj.difficultySetting.getDifficultyId() > 2) {
            d0 += target.motionX * dist / mf;
            d1 += (target.motionY + 0.09) * dist / mf; // with a small adjustment for a player on the ground, which has
                                                       // a motion value of about -0.1
            d2 += target.motionZ * dist / mf;
        }

        float f = MathHelper.sqrt_float(dist) * dispersal;
        d0 += f * this.rand.nextGaussian();
        d2 += f * this.rand.nextGaussian();

        double d3 = MathHelper.sqrt_double(d0 * d0 + d1 * d1 + d2 * d2);

        if (entity instanceof EntityProjectile) {
            ((EntityProjectile) entity).accelerationX = d0 / d3 * 0.1D;
            ((EntityProjectile) entity).accelerationY = d1 / d3 * 0.1D;
            ((EntityProjectile) entity).accelerationZ = d2 / d3 * 0.1D;
        } else if (entity instanceof EntityFireball) {
            ((EntityFireball) entity).accelerationX = d0 / d3 * 0.1D;
            ((EntityFireball) entity).accelerationY = d1 / d3 * 0.1D;
            ((EntityFireball) entity).accelerationZ = d2 / d3 * 0.1D;
        }

        this.worldObj.spawnEntityInWorld(entity);

        return entity;
    }

    @Override
    public boolean attackEntityFrom(DamageSource src, float dmg) {
        if (src.getEntity() instanceof EntityLivingBase) // ascension testing
        {
            if (((EntityLivingBase) src.getEntity()).getHeldItem() != null) {
                /*
                 * ItemStack stack = ((EntityLivingBase) src.getEntity()).getHeldItem();
                 * if (stack.getItem() instanceof TragicWeapon)
                 * {
                 * dmg += ((TragicWeapon) stack.getItem()).ascensionLevel;
                 * }
                 */
            }
        }
        return super.attackEntityFrom(src, dmg);
    }

    public static class GroupBuff implements IEntityLivingData {

        public final PotionEffect effect;

        public GroupBuff(PotionEffect effect) {
            this.effect = effect;
        }

        public PotionEffect getReducedEffect() {
            return new PotionEffect(effect.getPotionID(), effect.getDuration() * 3 / 4, effect.getAmplifier() / 2 * 3);
        }
    }

    @Override
    public String getCommandSenderName() {
        String s = this.isMobVariant() ? this.getVariantName() : null;
        if (s == null) return super.getCommandSenderName();
        return StatCollector.translateToLocal("entity." + s + ".name");
    }

    protected String getVariantName() {
        return EntityList.getEntityString(this);
    }

    public boolean isHalloween() {
        Calendar calendar = this.worldObj.getCurrentDate();

        if ((calendar.get(2) + 1 == 10 && calendar.get(5) > 29) || (calendar.get(2) + 1 == 11 || calendar.get(5) < 3)) {
            return true;
        }

        return false;
    }
}
