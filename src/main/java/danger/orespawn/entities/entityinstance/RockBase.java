
package danger.orespawn.entities.entityinstance;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class RockBase extends EntityLiving {

    public int rock_type;
    private double dx;
    private double dz;

    public RockBase(final World par1World) {
        super(par1World);
        this.rock_type = 0;
        this.setSize(0.25f, 0.15f);
        this.fireResistance = 100000;
        this.isImmuneToFire = true;
        final double n = 0.0;
        this.dz = n;
        this.dx = n;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        final Entity e = par1DamageSource.getEntity();
        if (par1DamageSource.getDamageType()
            .equals("inWall")) {
            return false;
        }
        if (e != null && e instanceof EntityLivingBase) {
            this.playSound("random.pop", 0.75f, 2.25f);
        }
        return super.attackEntityFrom(par1DamageSource, par2);
    }

    public int getRockType() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setRockType(final int par1) {
        if (this.worldObj == null) {
            return;
        }
        if (this.worldObj.isRemote) {
            return;
        }
        this.dataWatcher.updateObject(20, (Object) par1);
    }

    public void placeRock(final int par1) {
        this.setRockType(this.rock_type = par1);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue((1 + this.rock_type / 4));
        this.setHealth((float) (1 + this.rock_type / 4));
    }

    public int getTotalArmorValue() {
        return 0;
    }

    protected void fall(final float par1) {}

    public void onUpdate() {
        if (this.dx == 0.0 && this.dz == 0.0) {
            this.dx = this.posX;
            this.dz = this.posZ;
        }
        super.onUpdate();
        this.rotationPitch = 0.0f;
        final float n = 0.0f;
        this.rotationYawHead = n;
        this.rotationYaw = n;
        if (this.worldObj.isRemote) {
            this.rock_type = this.getRockType();
        }
        if (!this.worldObj.isRemote && this.rock_type == 0) {
            if (this.worldObj.provider.dimensionId != OreSpawnMain.DimensionID5) {
                this.rock_type = 1;
                if (this.worldObj.rand.nextInt(10) == 0) {
                    this.rock_type = 2;
                }
                if (this.worldObj.rand.nextInt(20) == 0) {
                    this.rock_type = 3;
                }
                if (this.worldObj.rand.nextInt(30) == 0) {
                    this.rock_type = 4;
                }
                if (this.worldObj.rand.nextInt(40) == 0) {
                    this.rock_type = 5;
                }
                if (this.worldObj.rand.nextInt(50) == 0) {
                    this.rock_type = 6;
                }
                if (this.worldObj.rand.nextInt(100) == 0) {
                    this.rock_type = 7;
                }
                if (this.worldObj.rand.nextInt(200) == 0) {
                    this.rock_type = 8;
                }
                if (this.worldObj.rand.nextInt(500) == 0) {
                    this.rock_type = 9;
                }
                if (this.worldObj.rand.nextInt(500) == 0) {
                    this.rock_type = 10;
                }
                if (this.worldObj.rand.nextInt(500) == 0) {
                    this.rock_type = 11;
                }
                if (this.worldObj.rand.nextInt(1000) == 0) {
                    this.rock_type = 12;
                }
            } else {
                this.rock_type = 9;
                if (this.worldObj.rand.nextInt(3) == 0) {
                    this.rock_type = 10;
                }
                if (this.worldObj.rand.nextInt(5) == 0) {
                    this.rock_type = 11;
                }
                if (this.worldObj.rand.nextInt(10) == 0) {
                    this.rock_type = 12;
                }
            }
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
                .setBaseValue((1 + this.rock_type / 4));
            this.setHealth((float) (1 + this.rock_type / 4));
        }
        if (!this.worldObj.isRemote) {
            this.setRockType(this.rock_type);
        }
        if (this.worldObj.isRemote) {
            if (this.rock_type == 9 && this.worldObj.rand.nextInt(20) == 0) {
                this.worldObj.spawnParticle(
                    "flame",
                    this.posX,
                    this.posY,
                    this.posZ,
                    ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0f),
                    (this.worldObj.rand.nextFloat() / 10.0f),
                    ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0f));
            }
            if (this.rock_type == 10 && this.worldObj.rand.nextInt(20) == 0) {
                this.worldObj.spawnParticle(
                    "happyVillager",
                    this.posX,
                    this.posY + 0.25,
                    this.posZ,
                    ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0f),
                    (this.worldObj.rand.nextFloat() / 2.0f),
                    ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0f));
            }
            if (this.rock_type == 11 && this.worldObj.rand.nextInt(20) == 0) {
                this.worldObj.spawnParticle(
                    "smoke",
                    this.posX,
                    this.posY,
                    this.posZ,
                    ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0f),
                    (this.worldObj.rand.nextFloat() / 10.0f),
                    ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0f));
            }
            if (this.rock_type == 12 && this.worldObj.rand.nextInt(20) == 0) {
                this.worldObj.spawnParticle(
                    "fireworksSpark",
                    this.posX,
                    this.posY + 0.25,
                    this.posZ,
                    ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0f),
                    (this.worldObj.rand.nextFloat() / 5.0f),
                    ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 60.0f));
            }
        }
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

    protected float getSoundVolume() {
        return 0.65f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItem() {
        return null;
    }

    public boolean canDespawn() {
        return false;
    }

    public boolean getCanSpawnHere() {
        return this.posY >= 50.0;
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    public boolean canBePushed() {
        return true;
    }

    public void performHurtAnimation() {
        final int n = 0;
        this.maxHurtTime = n;
        this.hurtTime = n;
        this.attackedAtYaw = 0.0f;
    }

    protected void onDeathUpdate() {
        this.setDead();
    }

    public void onDeath(final DamageSource par1DamageSource) {
        this.setDead();
        if (this.rock_type == 1) {
            this.dropItemRand(OreSpawnMain.MySmallRock, 1);
        }
        if (this.rock_type == 2) {
            this.dropItemRand(OreSpawnMain.MyRock, 1);
        }
        if (this.rock_type == 3) {
            this.dropItemRand(OreSpawnMain.MyRedRock, 1);
        }
        if (this.rock_type == 4) {
            this.dropItemRand(OreSpawnMain.MyGreenRock, 1);
        }
        if (this.rock_type == 5) {
            this.dropItemRand(OreSpawnMain.MyBlueRock, 1);
        }
        if (this.rock_type == 6) {
            this.dropItemRand(OreSpawnMain.MyPurpleRock, 1);
        }
        if (this.rock_type == 7) {
            this.dropItemRand(OreSpawnMain.MySpikeyRock, 1);
        }
        if (this.rock_type == 8) {
            this.dropItemRand(OreSpawnMain.MyTNTRock, 1);
        }
        if (this.rock_type == 9) {
            this.dropItemRand(OreSpawnMain.MyCrystalRedRock, 1);
        }
        if (this.rock_type == 10) {
            this.dropItemRand(OreSpawnMain.MyCrystalGreenRock, 1);
        }
        if (this.rock_type == 11) {
            this.dropItemRand(OreSpawnMain.MyCrystalBlueRock, 1);
        }
        if (this.rock_type == 12) {
            this.dropItemRand(OreSpawnMain.MyCrystalTNTRock, 1);
        }
    }

    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(
            this.worldObj,
            this.posX + (OreSpawnMain.OreSpawnRand.nextFloat() - OreSpawnMain.OreSpawnRand.nextFloat()) / 3.0f,
            this.posY + 0.25,
            this.posZ + (OreSpawnMain.OreSpawnRand.nextFloat() - OreSpawnMain.OreSpawnRand.nextFloat()) / 3.0f,
            is);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }
        return is;
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("ButterflyType", this.rock_type);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.rock_type = par1NBTTagCompound.getInteger("ButterflyType");
    }
}
