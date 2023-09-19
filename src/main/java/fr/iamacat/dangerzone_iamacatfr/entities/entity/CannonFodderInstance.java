
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CannonFodderInstance extends EntityTameable {

    String name_one;
    String name_two;
    private int is_activated;
    private int hat_color;
    private int syncer;
    private int px;
    private int pz;
    private int py;
    private GenericTargetSorter LocalTargetSorter;

    public CannonFodderInstance(final World par1World) {
        super(par1World);
        this.name_one = null;
        this.name_two = null;
        this.is_activated = 0;
        this.hat_color = 0;
        this.syncer = 0;
        this.px = 0;
        this.pz = 0;
        this.py = 0;
        this.LocalTargetSorter = null;
        this.LocalTargetSorter = new GenericTargetSorter(this);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
        this.dataWatcher.addObject(21, (Object) 0);
    }

    public void onUpdate() {
        super.onUpdate();
        ++this.syncer;
        if (this.syncer > 5) {
            if (this.worldObj.isRemote) {
                this.is_activated = this.dataWatcher.getWatchableObjectInt(20);
                this.hat_color = this.dataWatcher.getWatchableObjectInt(21);
            } else {
                this.dataWatcher.updateObject(20, (Object) this.is_activated);
                this.dataWatcher.updateObject(21, (Object) this.hat_color);
            }
            this.syncer = 0;
        }
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
            var2 = null;
        }
        if (super.interact(par1EntityPlayer)) {
            return true;
        }
        if (this.name_one != null && this.isTamed()) {
            if (this.name_one.equals(
                par1EntityPlayer.getUniqueID()
                    .toString())) {
                if (this.name_two == null) {
                    this.name_two = this.name_one;
                    this.func_152115_b(
                        this.name_one = par1EntityPlayer.getUniqueID()
                            .toString());
                    this.is_activated = 2;
                }
            } else if (this.name_two != null) {
                if (!this.name_two.equals(
                    par1EntityPlayer.getUniqueID()
                        .toString())) {
                    return true;
                }
                this.name_two = this.name_one;
                this.func_152115_b(
                    this.name_one = par1EntityPlayer.getUniqueID()
                        .toString());
                this.is_activated = 2;
            } else {
                this.name_two = this.name_one;
                this.func_152115_b(
                    this.name_one = par1EntityPlayer.getUniqueID()
                        .toString());
                this.is_activated = 2;
            }
        }
        if (var2 != null && var2.getItem() == Items.carrot && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0) {
            this.hat_color = 1;
            if (this.name_one == null) {
                this.name_one = par1EntityPlayer.getUniqueID()
                    .toString();
            }
            if (this.is_activated == 0) {
                this.is_activated = 1;
            }
            this.setTamed(true);
            this.func_152115_b(this.name_one);
            this.playTameEffect(true);
            this.heal(this.getMaxHealth() - this.getHealth());
            this.func_110163_bv();
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack = var2;
                --itemStack.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                }
            }
            return true;
        }
        if (var2 != null && var2.getItem() == Items.potato && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0) {
            this.hat_color = 3;
            if (this.name_one == null) {
                this.name_one = par1EntityPlayer.getUniqueID()
                    .toString();
            }
            if (this.is_activated == 0) {
                this.is_activated = 1;
            }
            this.setTamed(true);
            this.func_152115_b(this.name_one);
            this.playTameEffect(true);
            this.heal(this.getMaxHealth() - this.getHealth());
            this.func_110163_bv();
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack2 = var2;
                --itemStack2.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                }
            }
            return true;
        }
        if (var2 != null && var2.getItem() == ItemInitDangerZone.Quinoa
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0) {
            this.hat_color = 2;
            if (this.name_one == null) {
                this.name_one = par1EntityPlayer.getUniqueID()
                    .toString();
            }
            if (this.is_activated == 0) {
                this.is_activated = 1;
            }
            this.setTamed(true);
            this.func_152115_b(this.name_one);
            this.playTameEffect(true);
            this.heal(this.getMaxHealth() - this.getHealth());
            this.func_110163_bv();
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack3 = var2;
                --itemStack3.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                }
            }
            return true;
        }
        if (var2 != null && this.is_activated == 2
            && var2.getItem() == ItemInitDangerZone.CookedCornDog
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0) {
            String myname = "Ostrich";
            if (this instanceof Lizard) {
                myname = "Lizard";
            }
            if (this instanceof ChipMunkInstance) {
                myname = "Chipmunk";
            }
            if (this instanceof VelocityRaptor) {
                myname = "Velocity Raptor";
            }
            if (!this.worldObj.isRemote) {
                final Entity newent = spawnCreature(
                    this.worldObj,
                    myname,
                    this.posX + this.worldObj.rand.nextFloat(),
                    this.posY + 0.01,
                    this.posZ + this.worldObj.rand.nextFloat());
                if (newent != null) {
                    final CannonFodderInstance cf = (CannonFodderInstance) newent;
                    cf.func_152115_b(this.func_152113_b());
                    cf.setTamed(true);
                    cf.setStuff(this.hat_color, this.is_activated, this.name_one, this.name_two);
                }
            }
            this.playTameEffect(true);
            this.worldObj.playSoundAtEntity(par1EntityPlayer, "random.explode", 0.75f, 2.0f);
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack4 = var2;
                --itemStack4.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                }
            }
            return true;
        }
        if (this.is_activated == 2 && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0) {
            if (this.isSitting()) {
                this.setSitting(false);
                this.playTameEffect(true);
            } else {
                this.setSitting(true);
                this.playTameEffect(false);
                this.px = (int) this.posX;
                this.py = (int) this.posY;
                this.pz = (int) this.posZ;
            }
            return true;
        }
        return false;
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

    public void setStuff(final int hc, final int ia, final String s1, final String s2) {
        this.hat_color = hc;
        this.is_activated = ia;
        this.name_one = s1;
        this.name_two = s2;
        this.func_110163_bv();
    }

    public int getHatColor() {
        return this.hat_color;
    }

    public int get_is_activated() {
        return this.is_activated;
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        if (this.name_one == null) {
            par1NBTTagCompound.setString("NameOne", "");
        } else {
            par1NBTTagCompound.setString("NameOne", this.name_one);
        }
        if (this.name_two == null) {
            par1NBTTagCompound.setString("NameTwo", "");
        } else {
            par1NBTTagCompound.setString("NameTwo", this.name_two);
        }
        par1NBTTagCompound.setInteger("IsActivated", this.is_activated);
        par1NBTTagCompound.setInteger("HatColor", this.hat_color);
        par1NBTTagCompound.setInteger("PatrolX", this.px);
        par1NBTTagCompound.setInteger("PatrolY", this.py);
        par1NBTTagCompound.setInteger("PatrolZ", this.pz);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.name_one = par1NBTTagCompound.getString("NameOne");
        if (this.name_one != null && this.name_one.equals("")) {
            this.name_one = null;
        }
        this.name_two = par1NBTTagCompound.getString("NameTwo");
        if (this.name_two != null && this.name_two.equals("")) {
            this.name_two = null;
        }
        this.is_activated = par1NBTTagCompound.getInteger("IsActivated");
        this.hat_color = par1NBTTagCompound.getInteger("HatColor");
        this.px = par1NBTTagCompound.getInteger("PatrolX");
        this.py = par1NBTTagCompound.getInteger("PatrolY");
        this.pz = par1NBTTagCompound.getInteger("PatrolZ");
        if (this.name_one != null) {
            this.setTamed(true);
            this.func_152115_b(this.name_one);
        }
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
        if (this.isSitting()) {
            final double dx = this.px - par1EntityLiving.posX;
            final double dy = this.py - par1EntityLiving.posY;
            final double dz = this.pz - par1EntityLiving.posZ;
            if (dx * dx + dy * dy + dz * dz > 144.0) {
                return false;
            }
        }
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        if (par1EntityLiving instanceof CannonFodderInstance) {
            final CannonFodderInstance cf = (CannonFodderInstance) par1EntityLiving;
            final int i = cf.getHatColor();
            return i != 0 && i != this.hat_color;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode && (this.name_one == null || !this.name_one.equals(
                p.getUniqueID()
                    .toString()))
                && (this.name_two == null || !this.name_two.equals(
                    p.getUniqueID()
                        .toString()));
        }
        return false;
    }

    private EntityLivingBase findSomethingToAttack() {
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(10.0, 4.0, 10.0));
        Collections.sort((List<Object>) var5, this.LocalTargetSorter);
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

    public int getTotalArmorValue() {
        if (this.is_activated == 2) {
            return 3;
        }
        return 0;
    }

    public void attackEntityAsFodder(final Entity par1Entity, final float f) {
        par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), f);
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.setRevengeTarget(null);
        }
        if (this.is_activated != 2) {
            return;
        }
        int pfreq = 5;
        int sfreq = 7;
        float dm = 4.0f;
        if (this instanceof ChipMunkInstance) {
            dm = 3.0f;
            sfreq = 6;
        }
        if (this instanceof Lizard) {
            dm = 6.0f;
            sfreq = 8;
        }
        if (this instanceof VelocityRaptor) {
            sfreq = 6;
            pfreq = 4;
        }
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(pfreq) == 1) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                this.getNavigator()
                    .tryMoveToEntityLiving(e, 1.25);
                if (this.getDistanceSqToEntity(e) < 9.0
                    && (this.rand.nextInt(sfreq + 1) == 0 || this.rand.nextInt(sfreq) == 1)) {
                    this.attackEntityAsFodder(e, dm);
                }
            } else if (this.isSitting()) {
                this.getNavigator()
                    .tryMoveToXYZ(this.px, this.py, this.pz, 0.6499999761581421);
            }
        }
        if (this.worldObj.rand.nextInt(250) == 1) {
            this.heal(1.0f);
        }
    }

    public EntityAgeable createChild(final EntityAgeable entityageable) {
        return null;
    }
}
