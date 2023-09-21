package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWanderALot;
import fr.iamacat.dangerzone_iamacatfr.init.DimensionInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import fr.iamacat.dangerzone_iamacatfr.worldgen.dimensions.teleporter.SafeTeleporter;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.List;

public class UnstableAntInstance extends EntityAnimal {

    public double moveSpeed;
    private static final ResourceLocation texture4;

    public UnstableAntInstance(final World par1World) {
        super(par1World);
        this.moveSpeed = 0.15000000596046448;
        this.setSize(0.1f, 0.1f);
        this.experienceValue = 0;
        this.getNavigator()
            .setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAIPanic(this, 1.4));
        this.tasks.addTask(1, new MyEntityAIWanderALot(this, 9, 1.0));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        this.getAttributeMap()
            .registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(0.0);
    }

    public ResourceLocation getTexture(final UnstableAntInstance a) {
        return UnstableAntInstance.texture4;
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
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
        if (par1EntityPlayer.dimension != DimensionInitDangerZone.DangerDimensionId) {
            MinecraftServer.getServer()
                .getConfigurationManager()
                .transferPlayerToDimension(
                    (EntityPlayerMP) par1EntityPlayer,
                    DimensionInitDangerZone.DangerDimensionId,
                    new SafeTeleporter(
                        MinecraftServer.getServer()
                            .worldServerForDimension( DimensionInitDangerZone.DangerDimensionId),
                        DimensionInitDangerZone.DangerDimensionId,
                        this.worldObj));
        } else {
            MinecraftServer.getServer()
                .getConfigurationManager()
                .transferPlayerToDimension(
                    (EntityPlayerMP) par1EntityPlayer,
                    0,
                 new SafeTeleporter(
                        MinecraftServer.getServer()
                            .worldServerForDimension(0),
                        0,
                        this.worldObj));
        }
        return true;
    }

    public boolean isAIEnabled() {
        return true;
    }

    public int mygetMaxHealth() {
        return 1;
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
        return 0.0f;
    }

    protected void playStepSound(final int par1, final int par2, final int par3, final int par4) {}

    protected void dropFewItems(final boolean par1, final int par2) {}

    protected boolean canTriggerWalking() {
        return true;
    }

    public EntityAgeable createChild(final EntityAgeable var1) {
        return null;
    }

    public boolean getCanSpawnHere() {
        return this.posY >= 50.0 && this.findBuddies() <= 4;
    }

    private int findBuddies() {
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(UnstableAntInstance.class, this.boundingBox.expand(20.0, 10.0, 20.0));
        return var5.size();
    }

    public void updateAITick() {
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.setRevengeTarget(null);
        }
        super.updateAITick();
    }

    static {
        texture4 = new ResourceLocation(Tags.MODID  +":textures/entity/unstableant.png");
    }
}
