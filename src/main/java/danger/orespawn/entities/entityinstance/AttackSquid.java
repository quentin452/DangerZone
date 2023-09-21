
package danger.orespawn.entities.entityinstance;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.falsepattern.lib.compat.BlockPos;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import danger.orespawn.entities.ai.MyEntityAIWanderALot;
import danger.orespawn.utils.GenericTargetSorter;

public class AttackSquid extends EntityMob {

    private GenericTargetSorter TargetSorter;
    private EntityLivingBase buddy;
    private float moveSpeed;
    private int wasshot;
    private int closest;
    private int tx;
    private int ty;
    private int tz;
    private EntityLivingBase currentTarget;
    private double currentDistanceSquared;

    public AttackSquid(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.buddy = null;
        this.moveSpeed = 0.25f;
        this.wasshot = 0;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.setSize(1.0f, 1.25f);
        this.getNavigator()
            .setAvoidsWater(false);
        this.experienceValue = 15;
        this.fireResistance = 3;
        this.isImmuneToFire = false;
        this.TargetSorter = new GenericTargetSorter(this);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new MyEntityAIWanderALot(this, 16, 1.0));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(OreSpawnMain.AttackSquid_stats.attack);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    public void setWasShot() {
        this.wasshot = 250;
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
    }

    public int mygetMaxHealth() {
        return OreSpawnMain.AttackSquid_stats.health;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.AttackSquid_stats.defense;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    public int getAttackStrength(final Entity par1Entity) {
        final int var2 = 2;
        return var2;
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return "orespawn:squid_hurt";
    }

    protected String getDeathSound() {
        return "orespawn:squid_death";
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

    protected float getSoundVolume() {
        return 1.0f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItem() {
        return Items.fish;
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
        int var4 = this.worldObj.rand.nextInt(50);
        switch (var4) {
            case 0: {
                is = this.dropItemRand(Items.gold_nugget, 1);
                break;
            }
            case 1: {
                is = this.dropItemRand(Items.gold_ingot, 1);
                break;
            }
            case 2: {
                is = this.dropItemRand(Items.golden_carrot, 1);
                break;
            }
            case 3: {
                is = this.dropItemRand(Items.golden_sword, 1);
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5));
                }
                if (this.worldObj.rand.nextInt(2) == 1) {
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    break;
                }
                break;
            }
            case 4: {
                is = this.dropItemRand(Items.golden_shovel, 1);
                if (this.worldObj.rand.nextInt(2) == 1) {
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    break;
                }
                break;
            }
            case 5: {
                is = this.dropItemRand(Items.golden_pickaxe, 1);
                if (this.worldObj.rand.nextInt(2) == 1) {
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5));
                    break;
                }
                break;
            }
            case 6: {
                is = this.dropItemRand(Items.golden_axe, 1);
                if (this.worldObj.rand.nextInt(2) == 1) {
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    break;
                }
                break;
            }
            case 7: {
                is = this.dropItemRand(Items.golden_hoe, 1);
                if (this.worldObj.rand.nextInt(2) == 1) {
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    break;
                }
                break;
            }
            case 8: {
                is = this.dropItemRand(Items.golden_helmet, 1);
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                }
                if (this.worldObj.rand.nextInt(2) == 1) {
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(2));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5));
                    break;
                }
                break;
            }
            case 9: {
                is = this.dropItemRand(Items.golden_chestplate, 1);
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                }
                if (this.worldObj.rand.nextInt(2) == 1) {
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    break;
                }
                break;
            }
            case 10: {
                is = this.dropItemRand(Items.golden_leggings, 1);
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                }
                if (this.worldObj.rand.nextInt(2) == 1) {
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    break;
                }
                break;
            }
            case 11: {
                is = this.dropItemRand(Items.golden_boots, 1);
                if (this.worldObj.rand.nextInt(6) == 1) {
                    is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5));
                }
                if (this.worldObj.rand.nextInt(2) == 1) {
                    is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    break;
                }
                break;
            }
            case 12: {
                this.dropItemRand(Items.golden_apple, 1);
                break;
            }
            case 13: {
                this.dropItemRand(Item.getItemFromBlock(Blocks.gold_block), 1);
                break;
            }
            case 14: {
                EntityItem var5 = null;
                is = new ItemStack(Items.golden_apple, 1, 1);
                var5 = new EntityItem(
                    this.worldObj,
                    this.posX + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3),
                    this.posY + 1.0,
                    this.posZ + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3),
                    is);
                if (var5 != null) {
                    this.worldObj.spawnEntityInWorld(var5);
                }
                break;
            }
            case 15:
            case 16:
            case 17: {
                this.dropItemRand(Items.dye, 1);
                break;
            }
        }
        int i;
        for (i = 1 + this.worldObj.rand.nextInt(3), var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(Items.fish, 1);
        }
    }

    public void initCreature() {}

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        return super.attackEntityAsMob(par1Entity);
    }

    protected void fall(final float par1) {
        if (this.wasshot != 0) {
            return;
        }
        super.fall(par1);
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret;
        if (this.isDead) {
            return false;
        }
        final Entity e = par1DamageSource.getEntity();
        if (e != null && e instanceof AttackSquid) {
            return false;
        }
        if (e != null && e instanceof WaterBall) {
            return false;
        }
        if (e != null && e instanceof WaterDragon) {
            return false;
        }
        if (e != null && e instanceof EntityLiving) {
            if (e instanceof AttackSquid) {
                return false;
            }
            if (e instanceof WaterDragon) {
                return false;
            }
            this.setAttackTarget((EntityLivingBase) e);
            this.setTarget(e);
            ret = true;
        }
        ret = super.attackEntityFrom(par1DamageSource, par2);
        if ((this.getHealth() <= 0.0f || this.isDead) && this.worldObj.provider.dimensionId != OreSpawnMain.DimensionID5
            && !this.worldObj.isRemote
            && e != null
            && e instanceof EntityPlayer
            && this.worldObj.rand.nextInt(15) == 1
            && OreSpawnMain.KrakenEnable != 0
            && this.wasshot == 0) {
            for (int j = 1 + this.worldObj.rand.nextInt(3), i = 0; i < j; ++i) {
                final EntityCreature newent = (EntityCreature) spawnCreature(
                    this.worldObj,
                    "The Kraken",
                    this.posX + this.worldObj.rand.nextInt(4) - this.worldObj.rand.nextInt(4),
                    170.0,
                    this.posZ + this.worldObj.rand.nextInt(4) - this.worldObj.rand.nextInt(4));
            }
        }
        return ret;
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }

        super.updateAITasks();

        if (this.wasshot > 0) {
            --this.wasshot;
            if (this.wasshot == 0) {
                this.setDead();
                return;
            }
        }

        // Store the random value to reduce method calls
        int randomValue = this.worldObj.rand.nextInt(10);

        if (this.isInWater()) {
            // Si l'entité est dans l'eau, elle bouge très peu mais peut attaquer les joueurs.
            EntityLivingBase target = this.findSomethingToAttack();
            if (target != null) {
                double distanceSquared = this.getDistanceSqToEntity(target);

                if (distanceSquared < 9.0) {
                    this.setAttacking(1);
                    if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1) {
                        this.attackEntityAsMob(target);
                    }
                } else {
                    // L'entité est déjà dans l'eau, donc elle ne se déplace pas.
                    this.setAttacking(0);
                }
            }
        } else {
            // Si l'entité n'est pas dans l'eau, elle se déplace vers l'eau.
            if (randomValue == 0) {
                if (shouldScanForTarget()) {
                    if (this.worldObj.rand.nextInt(25) == 1) {
                        this.heal(-1.0f);
                    }
                    if (this.getHealth() <= 0.0f) {
                        this.setDead();
                        return;
                    }
                }
            } else if (randomValue == 1) {
                EntityLivingBase target = this.findSomethingToAttack();
                if (target != null) {
                    double distanceSquared = this.getDistanceSqToEntity(target);

                    if (distanceSquared < 9.0) {
                        this.setAttacking(1);
                        if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1) {
                            this.attackEntityAsMob(target);
                        }
                    } else {
                        // Check if there's a change in position or target before trying to move
                        if (target != this.currentTarget || distanceSquared != this.currentDistanceSquared) {
                            this.currentTarget = target;
                            this.currentDistanceSquared = distanceSquared;
                            this.getNavigator().tryMoveToEntityLiving(target, 1.2);
                        }
                        this.watercanon(target);
                    }
                } else {
                    if (this.buddy != null) {
                        this.getNavigator().tryMoveToEntityLiving(this.buddy, 1.0);
                    }
                    this.setAttacking(0);
                }
            }
        }
    }

    private boolean shouldScanForTarget() {
        for (int i = 1; i < 12; i += (i >= 5) ? 2 : 1) {
            int j = Math.min(i, 5);
            int x = (int) this.posX;
            int y = (int) this.posY - 1;
            int z = (int) this.posZ;
            Block block = getBlock(x, y, z);
            if (block != null && !block.getMaterial().isSolid()) {
                return false;
            }
        }
        return true;
    }

    private Block getBlock(int x, int y, int z) {
        return this.worldObj.getBlock(x, y, z);
    }


    private void watercanon(final EntityLivingBase e) {
        final double yoff = 1.0;
        final double xzoff = 1.2;
        if (this.worldObj.rand.nextInt(5) == 1) {
            if (this.rand.nextInt(3) == 1) {
                final InkSack var2 = new InkSack(
                    this.worldObj,
                    e.posX - this.posX,
                    e.posY + 0.75 - (this.posY + yoff),
                    e.posZ - this.posZ);
                var2.setLocationAndAngles(
                    this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)),
                    this.posY + yoff,
                    this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)),
                    this.rotationYawHead,
                    this.rotationPitch);
                final double var3 = e.posX - this.posX;
                final double var4 = e.posY + 0.25 - var2.posY;
                final double var5 = e.posZ - this.posZ;
                final float var6 = MathHelper.sqrt_double(var3 * var3 + var5 * var5) * 0.2f;
                var2.setThrowableHeading(var3, var4 + var6, var5, 1.4f, 5.0f);
                this.worldObj.playSoundAtEntity(
                    this,
                    "random.bow",
                    0.75f,
                    1.0f / (this.getRNG()
                        .nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld(var2);
            } else {
                final WaterBall var7 = new WaterBall(
                    this.worldObj,
                    e.posX - this.posX,
                    e.posY + 0.75 - (this.posY + yoff),
                    e.posZ - this.posZ);
                var7.setLocationAndAngles(
                    this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)),
                    this.posY + yoff,
                    this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)),
                    this.rotationYawHead,
                    this.rotationPitch);
                final double var3 = e.posX - this.posX;
                final double var4 = e.posY + 0.25 - var7.posY;
                final double var5 = e.posZ - this.posZ;
                final float var6 = MathHelper.sqrt_double(var3 * var3 + var5 * var5) * 0.2f;
                var7.setThrowableHeading(var3, var4 + var6, var5, 1.4f, 5.0f);
                this.worldObj.playSoundAtEntity(
                    this,
                    "random.bow",
                    0.75f,
                    1.0f / (this.getRNG()
                        .nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld(var7);
            }
        }
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
        if (!this.getEntitySenses()
            .canSee(par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode;
        }
        if (par1EntityLiving instanceof Girlfriend) {
            return true;
        }
        if (par1EntityLiving instanceof Boyfriend) {
            return true;
        }
        if (par1EntityLiving instanceof EntityZombie) {
            return true;
        }
        if (par1EntityLiving instanceof EntityVillager) {
            return true;
        }
        if (par1EntityLiving instanceof EntitySpider) {
            return true;
        }
        if (par1EntityLiving instanceof EntityCaveSpider) {
            return true;
        }
        if (par1EntityLiving instanceof Ghost) {
            return false;
        }
        if (par1EntityLiving instanceof GhostSkelly) {
            return false;
        }
        if (par1EntityLiving instanceof Lizard) {
            return true;
        }
        if (par1EntityLiving instanceof AttackSquid) {
            if (this.worldObj.rand.nextInt(5) == 1) {
                this.buddy = par1EntityLiving;
            }
            return false;
        }
        return this.wasshot != 0;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(10.0, 4.0, 10.0));
        Collections.sort((List<Object>) var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        final EntityLivingBase e = this.getAttackTarget();
        if (e != null && e.isEntityAlive()) {
            return e;
        }
        this.setAttackTarget(null);
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
        this.dataWatcher.updateObject(20, par1);
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("WasShot", this.wasshot);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.wasshot = par1NBTTagCompound.getInteger("WasShot");
    }

    public boolean getCanSpawnHere() {
        super.getCanSpawnHere();
        return this.posY >= 50.0 && this.worldObj.isDaytime();
    }
}
