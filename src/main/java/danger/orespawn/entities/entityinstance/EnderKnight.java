
package danger.orespawn.entities.entityinstance;

import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EnderKnight extends EntityMob {

    private static final UUID attackingSpeedBoostModifierUUID;
    private static final AttributeModifier attackingSpeedBoostModifier;
    private int teleportDelay;
    private int stareTimer;
    private Entity lastEntityToAttack;

    public EnderKnight(final World par1World) {
        super(par1World);
        this.setSize(0.6f, 2.9f);
        this.stepHeight = 1.0f;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(OreSpawnMain.EnderKnight_stats.health);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.32);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(OreSpawnMain.EnderKnight_stats.attack);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(18, 0);
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
    }

    protected Entity findPlayerToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0);
        if (entityplayer != null) {
            if (this.shouldAttackPlayer(entityplayer)) {
                if (this.stareTimer == 0) {
                    this.worldObj.playSoundAtEntity(entityplayer, "mob.endermen.stare", 1.0f, 1.0f);
                }
                if (this.stareTimer++ == 5) {
                    this.stareTimer = 0;
                }
                this.setScreaming(true);
                return entityplayer;
            }
            this.stareTimer = 0;
            this.setScreaming(false);
        }
        return null;
    }

    private boolean shouldAttackPlayer(final EntityPlayer par1EntityPlayer) {
        final ItemStack itemstack = par1EntityPlayer.inventory.armorInventory[3];
        if (itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.pumpkin)) {
            return false;
        }
        final Vec3 vec3 = par1EntityPlayer.getLook(1.0f)
            .normalize();
        Vec3 vec4 = Vec3.createVectorHelper(
            this.posX - par1EntityPlayer.posX,
            this.boundingBox.minY + this.height / 2.0f - (par1EntityPlayer.posY + par1EntityPlayer.getEyeHeight()),
            this.posZ - par1EntityPlayer.posZ);
        final double d0 = vec4.lengthVector();
        vec4 = vec4.normalize();
        final double d2 = vec3.dotProduct(vec4);
        return d2 > 1.0 - 0.025 / d0 && par1EntityPlayer.canEntityBeSeen(this);
    }

    public void onLivingUpdate() {
        if (this.isWet()) {
            this.attackEntityFrom(DamageSource.drown, 1.0f);
        }
        if (this.lastEntityToAttack != this.entityToAttack) {
            final IAttributeInstance attributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
            attributeinstance.removeModifier(EnderKnight.attackingSpeedBoostModifier);
            if (this.entityToAttack != null) {
                attributeinstance.applyModifier(EnderKnight.attackingSpeedBoostModifier);
            }
        }
        this.lastEntityToAttack = this.entityToAttack;
        for (int i = 0; i < 2; ++i) {
            this.worldObj.spawnParticle(
                "portal",
                this.posX + (this.rand.nextDouble() - 0.5) * this.width,
                this.posY + this.rand.nextDouble() * this.height - 0.25,
                this.posZ + (this.rand.nextDouble() - 0.5) * this.width,
                (this.rand.nextDouble() - 0.5) * 2.0,
                -this.rand.nextDouble(),
                (this.rand.nextDouble() - 0.5) * 2.0);
        }
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote) {
            final float f = this.getBrightness(1.0f);
            if (f > 0.5f && this.worldObj.canBlockSeeTheSky(
                MathHelper.floor_double(this.posX),
                MathHelper.floor_double(this.posY),
                MathHelper.floor_double(this.posZ)) && this.rand.nextFloat() * 30.0f < (f - 0.4f) * 2.0f) {
                this.entityToAttack = null;
                this.setScreaming(false);
                this.teleportRandomly();
            }
        }
        if (this.isWet() || this.isBurning()) {
            this.setScreaming(false);
            this.teleportRandomly();
        }
        this.isJumping = false;
        if (this.entityToAttack != null) {
            this.faceEntity(this.entityToAttack, 100.0f, 100.0f);
        }
        if (!this.worldObj.isRemote && this.isEntityAlive()) {
            if (this.entityToAttack != null) {
                if (this.entityToAttack instanceof EntityPlayer
                    && this.shouldAttackPlayer((EntityPlayer) this.entityToAttack)) {
                    if (this.entityToAttack.getDistanceSqToEntity(this) < 16.0) {
                        this.teleportRandomly();
                    }
                    this.teleportDelay = 0;
                } else if (this.entityToAttack.getDistanceSqToEntity(this) > 256.0 && this.teleportDelay++ >= 30
                    && this.teleportToEntity(this.entityToAttack)) {
                        this.teleportDelay = 0;
                    }
            } else {
                this.setScreaming(false);
                this.teleportDelay = 0;
            }
        }
        super.onLivingUpdate();
    }

    protected boolean teleportRandomly() {
        final double d0 = this.posX + (this.rand.nextDouble() - 0.5) * 64.0;
        final double d2 = this.posY + (this.rand.nextInt(64) - 32);
        final double d3 = this.posZ + (this.rand.nextDouble() - 0.5) * 64.0;
        return this.teleportTo(d0, d2, d3);
    }

    protected boolean teleportToEntity(final Entity par1Entity) {
        Vec3 vec3 = Vec3.createVectorHelper(
            this.posX - par1Entity.posX,
            this.boundingBox.minY + this.height / 2.0f - par1Entity.posY + par1Entity.getEyeHeight(),
            this.posZ - par1Entity.posZ);
        vec3 = vec3.normalize();
        final double d0 = 16.0;
        final double d2 = this.posX + (this.rand.nextDouble() - 0.5) * 8.0 - vec3.xCoord * d0;
        final double d3 = this.posY + (this.rand.nextInt(16) - 8) - vec3.yCoord * d0;
        final double d4 = this.posZ + (this.rand.nextDouble() - 0.5) * 8.0 - vec3.zCoord * d0;
        return this.teleportTo(d2, d3, d4);
    }

    protected boolean teleportTo(final double par1, final double par3, final double par5) {
        final double d3 = this.posX;
        final double d4 = this.posY;
        final double d5 = this.posZ;
        this.posX = par1;
        this.posY = par3;
        this.posZ = par5;
        boolean flag = false;
        final int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posY);
        final int k = MathHelper.floor_double(this.posZ);
        if (this.worldObj.blockExists(i, j, k)) {
            boolean flag2 = false;
            while (!flag2 && j > 0) {
                final Block l = this.worldObj.getBlock(i, j - 1, k);
                if (l != Blocks.air && l.getMaterial()
                    .blocksMovement()) {
                    flag2 = true;
                } else {
                    --this.posY;
                    --j;
                }
            }
            if (flag2) {
                this.setPosition(this.posX, this.posY, this.posZ);
                if (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox)
                    .isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox)) {
                    flag = true;
                }
            }
        }
        if (!flag) {
            this.setPosition(d3, d4, d5);
            return false;
        }
        final short short1 = 128;
        for (int lx = 0; lx < short1; ++lx) {
            final double d6 = lx / (short1 - 1.0);
            final float f = (this.rand.nextFloat() - 0.5f) * 0.2f;
            final float f2 = (this.rand.nextFloat() - 0.5f) * 0.2f;
            final float f3 = (this.rand.nextFloat() - 0.5f) * 0.2f;
            final double d7 = d3 + (this.posX - d3) * d6 + (this.rand.nextDouble() - 0.5) * this.width * 2.0;
            final double d8 = d4 + (this.posY - d4) * d6 + this.rand.nextDouble() * this.height;
            final double d9 = d5 + (this.posZ - d5) * d6 + (this.rand.nextDouble() - 0.5) * this.width * 2.0;
            this.worldObj.spawnParticle("portal", d7, d8, d9, f, f2, f3);
        }
        this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0f, 1.0f);
        this.playSound("mob.endermen.portal", 1.0f, 1.0f);
        return true;
    }

    protected String getLivingSound() {
        return this.isScreaming() ? "mob.endermen.scream" : "mob.endermen.idle";
    }

    protected String getHurtSound() {
        return "mob.endermen.hit";
    }

    protected String getDeathSound() {
        return "mob.endermen.death";
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.EnderKnight_stats.defense;
    }

    protected Item getDropItem() {
        if (this.worldObj.rand.nextInt(2) == 1) {
            return Items.ender_eye;
        }
        return Items.ender_pearl;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final Item j = this.getDropItem();
        if (j != null) {
            for (int k = this.rand.nextInt(2 + par2), l = 0; l < k; ++l) {
                this.dropItem(j, 1);
            }
        }
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        this.setScreaming(true);
        if (par1DamageSource instanceof EntityDamageSourceIndirect) {
            for (int i = 0; i < 16; ++i) {
                if (this.teleportRandomly()) {
                    return true;
                }
            }
            return super.attackEntityFrom(par1DamageSource, par2);
        }
        return super.attackEntityFrom(par1DamageSource, par2);
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
                        if (s != null && s.equals("Ender Knight")) {
                            return true;
                        }
                    }
                }
            }
        }
        return this.isValidLightLevel() && !this.worldObj.isDaytime() && this.posY >= 30.0;
    }

    public boolean isScreaming() {
        return this.dataWatcher.getWatchableObjectInt(18) > 0;
    }

    public void setScreaming(final boolean par1) {
        this.dataWatcher.updateObject(18, (par1 ? 1 : 0));
    }

    static {
        attackingSpeedBoostModifierUUID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
        attackingSpeedBoostModifier = new AttributeModifier(
            EnderKnight.attackingSpeedBoostModifierUUID,
            "Attacking speed boost",
            6.199999809265137,
            0).setSaved(false);
    }
}
