
package danger.orespawn.entities.entityinstance;

import java.util.List;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;

import danger.orespawn.entities.ai.MyEntityAIWanderALot;
import danger.orespawn.worldgen.OreSpawnTeleporter;

public class EntityAnt extends EntityAnimal {

    public double moveSpeed;
    private static final ResourceLocation texture1;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;
    private static final ResourceLocation texture4;
    private static final ResourceLocation texture5;

    public EntityAnt(final World par1World) {
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

    public ResourceLocation getTexture(final EntityAnt a) {
        if (a instanceof EntityRedAnt) {
            return EntityAnt.texture2;
        }
        if (a instanceof EntityRainbowAnt) {
            return EntityAnt.texture3;
        }
        if (a instanceof EntityUnstableAnt) {
            return EntityAnt.texture4;
        }
        if (a instanceof Termite) {
            return EntityAnt.texture5;
        }
        return EntityAnt.texture1;
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
        if (par1EntityPlayer.dimension != OreSpawnMain.DimensionID) {
            MinecraftServer.getServer()
                .getConfigurationManager()
                .transferPlayerToDimension(
                    (EntityPlayerMP) par1EntityPlayer,
                    OreSpawnMain.DimensionID,
                    (Teleporter) new OreSpawnTeleporter(
                        MinecraftServer.getServer()
                            .worldServerForDimension(OreSpawnMain.DimensionID),
                        OreSpawnMain.DimensionID,
                        this.worldObj));
        } else {
            MinecraftServer.getServer()
                .getConfigurationManager()
                .transferPlayerToDimension(
                    (EntityPlayerMP) par1EntityPlayer,
                    0,
                    (Teleporter) new OreSpawnTeleporter(
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
            .getEntitiesWithinAABB(EntityAnt.class, this.boundingBox.expand(20.0, 10.0, 20.0));
        return var5.size();
    }

    public void updateAITick() {
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.setRevengeTarget(null);
        }
        super.updateAITick();
    }

    static {
        texture1 = new ResourceLocation("orespawn", "ant.png");
        texture2 = new ResourceLocation("orespawn", "red_ant.png");
        texture3 = new ResourceLocation("orespawn", "rainbow_ant.png");
        texture4 = new ResourceLocation("orespawn", "unstableant.png");
        texture5 = new ResourceLocation("orespawn", "termite.png");
    }
}
