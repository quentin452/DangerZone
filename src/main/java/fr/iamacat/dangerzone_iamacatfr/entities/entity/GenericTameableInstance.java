
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import fr.iamacat.dangerzone_iamacatfr.util.EntityStates;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.NetworkRegistry;
import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.network.packet.PZPacketTameParticle;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public abstract class GenericTameableInstance extends GenericRideableInstance {

    boolean shouldFollow;
    boolean shouldAttack;

    public GenericTameableInstance(final World par1World) {
        super(par1World);
        this.shouldFollow = false;
        this.setTamed(this.shouldAttack = false);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(23, (Object) 0);
        this.dataWatcher.addObject(24, (Object) "");
        this.dataWatcher.addObject(25, (Object) "");
    }

    public String getOwnerName() {
        return this.dataWatcher.getWatchableObjectString(24);
    }

    public void setOwner(final String par1Str) {
        this.dataWatcher.updateObject(24, (Object) par1Str);
    }

    public EntityLivingBase getOwner() {
        return (EntityLivingBase) this.worldObj.getPlayerEntityByName(this.getOwnerName());
    }

    public String getEntityTamed() {
        return this.dataWatcher.getWatchableObjectString(25);
    }

    public void setEntityTamed(final String ETamed) {
        this.dataWatcher.updateObject(25, ETamed);
    }

    public boolean isTamed() {
        return (this.dataWatcher.getWatchableObjectInt(23) & 0x4) != 0x0;
    }

    public void setTamed(final boolean par1) {
        final int var2 = this.dataWatcher.getWatchableObjectInt(23);
        if (par1) {
            this.dataWatcher.updateObject(23, (var2 | 0x4));
        } else {
            this.dataWatcher.updateObject(23, (var2 & 0xFFFFFFFB));
        }
    }

    protected boolean canDespawn() {
        return !this.isTamed() && super.canDespawn();
    }

    public boolean isSitting() {
        return (this.dataWatcher.getWatchableObjectInt(23) & 0x1) != 0x0;
    }

    public void setSitting(final boolean par1) {
        final int var2 = this.dataWatcher.getWatchableObjectInt(23);
        if (par1) {
            this.dataWatcher.updateObject(23, (var2 | 0x1));
        } else {
            this.dataWatcher.updateObject(23, (var2 & 0xFFFFFFFE));
        }
    }

    public void playTameEffect(final boolean par1) {
        String var2 = "heart";
        if (!par1) {
            var2 = "smoke";
        }
        for (int var3 = 0; var3 < 7; ++var3) {
            final double var4 = this.rand.nextGaussian() * 0.02;
            final double var5 = this.rand.nextGaussian() * 0.02;
            final double var6 = this.rand.nextGaussian() * 0.02;
            this.worldObj.spawnParticle(
                var2,
                this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width,
                this.posY + 0.5 + this.rand.nextFloat() * this.height,
                this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width,
                var4,
                var5,
                var6);
        }
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        if (this.getOwnerName() == null) {
            par1NBTTagCompound.setString("Owner", "");
        } else {
            par1NBTTagCompound.setString("Owner", this.getOwnerName());
        }
        if (this.getEntityTamed() == null) {
            par1NBTTagCompound.setString("EntityTamed", "");
        } else {
            par1NBTTagCompound.setString("EntityTamed", this.getEntityTamed());
        }
        par1NBTTagCompound.setBoolean("Sitting", this.isSitting());
        par1NBTTagCompound.setBoolean("Should Follow", this.shouldFollow);
        par1NBTTagCompound.setBoolean("Should Attack", this.shouldAttack);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        if (par1NBTTagCompound.hasKey("Owner")) {
            final String owner = par1NBTTagCompound.getString("Owner");
            if (owner.length() > 0) {
                this.setOwner(owner);
                this.setTamed(true);
            }
        } else {
            this.setOwner("");
            this.setTamed(false);
        }
        if (par1NBTTagCompound.hasKey("EntityTamed")) {
            final String entityTamed = par1NBTTagCompound.getString("EntityTamed");
            if (entityTamed.length() > 0) {
                this.setEntityTamed(entityTamed);
            }
        } else {
            this.setEntityTamed("");
        }
        this.setSitting(par1NBTTagCompound.getBoolean("Sitting"));
        this.shouldFollow = par1NBTTagCompound.getBoolean("Should Follow");
        this.shouldAttack = par1NBTTagCompound.getBoolean("Should Attack");
    }

    public boolean isValidTamingItem(final ItemStack itemStack) {
        return false;
    }

    public int getHealingValueIfValid(final ItemStack itemStack) {
        return 0;
    }

    protected void updateAITasks() {
        super.updateAITasks();
    }

    public void onUpdate() {
        super.onUpdate();
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        final ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (this.isTamed()) {
            if (par1EntityPlayer.getCommandSenderName()
                .equalsIgnoreCase(this.getOwnerName())) {
                if (var2 != null) {
                    if (var2.getItem() == Items.paper || var2.getItem() == Items.name_tag) {
                        par1EntityPlayer.openGui(Tags.MODID, 2, par1EntityPlayer.worldObj, this.getEntityId(), 0, 0);
                        return true;
                    }
                    if (this.getHealingValueIfValid(var2) > 0 && this.getHealth() < this.getMaxHealth()) {
                        if (!par1EntityPlayer.capabilities.isCreativeMode) {
                            final ItemStack itemStack = var2;
                            --itemStack.stackSize;
                        }
                        this.heal((float) this.getHealingValueIfValid(var2));
                        if (var2.stackSize <= 0) {
                            par1EntityPlayer.inventory
                                .setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack) null);
                        }
                        return true;
                    }
                }
                if (!this.isValidBreedingItem(var2)) {
                    if (this.worldObj.isRemote) {
                        return true;
                    }
                    if (this.getEntityState() == EntityStates.sitting) {
                        this.setSitting(false);
                        this.shouldFollow = true;
                    } else if (this.getEntityState() == EntityStates.following) {
                        this.shouldFollow = false;
                        this.shouldAttack = true;
                        this.setAngerLevel(2);
                    } else if (this.getEntityState() == EntityStates.attacking
                        || this.getEntityState() == EntityStates.looking) {
                            this.shouldAttack = false;
                        } else if (this.getEntityState() == EntityStates.idle) {
                            this.setSitting(true);
                            this.isJumping = false;
                        }
                    return true;
                }
            }
        } else if (var2 != null && this.isValidTamingItem(var2)) {
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack2 = var2;
                --itemStack2.stackSize;
            }
            if (var2.stackSize <= 0) {
                par1EntityPlayer.inventory
                    .setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack) null);
            }
            if (!this.worldObj.isRemote) {
                boolean tameEffectSuccess = false;
                if (this.rand.nextInt(3) == 0) {
                    this.setTamed(true);
                    this.setAttackTarget((EntityLivingBase) null);
                    this.setSitting(true);
                    this.setHealth(this.getMaxHealth());
                    this.setOwner(par1EntityPlayer.getCommandSenderName());
                    this.setEntityTamed(this.getDefaultEntityName());
                    tameEffectSuccess = true;
                }
                final ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                final DataOutputStream data = new DataOutputStream(bytes);
                try {
                    data.writeInt(5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    data.writeInt(this.getEntityId());
                    data.writeBoolean(tameEffectSuccess);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                final PZPacketTameParticle message = new PZPacketTameParticle()
                    .setPacketData(this.getEntityId(), tameEffectSuccess);
                DangerZone.packetHandler.sendToAllAround(
                    message,
                    new NetworkRegistry.TargetPoint(this.dimension, this.posX, this.posY, this.posZ, 10.0));
            }
            return true;
        }
        return super.interact(par1EntityPlayer);
    }

    public String getDefaultEntityName() {
        return this.getCommandSenderName();
    }
}
