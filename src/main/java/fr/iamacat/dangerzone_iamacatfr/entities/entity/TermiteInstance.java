package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import fr.iamacat.dangerzone_iamacatfr.init.DimensionInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions.teleporter.SafeTeleporter;

public class TermiteInstance extends EntityMob {

    public boolean interact(EntityPlayer player) {
        ItemStack heldItem = player.inventory.getCurrentItem();
        if (!(player instanceof EntityPlayerMP)) {
            return false;
        }

        int targetDimensionId = player.dimension;
        int destinationDimensionId;

        // Check if the player is in the Crystal Dimension and right-clicked on the entity
        if (targetDimensionId == DimensionInitDangerZone.CrystalDimensionId) {
            // Perform the teleportation to the Overworld only with the held item check
            if (heldItem != null && heldItem.stackSize > 0) {
                // Player is holding an item, do not teleport
                return false;
            }
            destinationDimensionId = 0;
        } else {
            // Check if the player has items in their hand or inventory or armor slots
            ItemStack currentItem = player.inventory.getCurrentItem();

            for (ItemStack itemStack : player.inventory.mainInventory) {
                if (itemStack != null && itemStack.stackSize > 0) {
                    // Display a warning in the chat
                    player.addChatMessage(new ChatComponentText("You must have an empty inventory to teleport."));
                    return false;
                }
            }

            for (ItemStack itemStack : player.inventory.armorInventory) {
                if (itemStack != null && itemStack.stackSize > 0) {
                    // Display a warning in the chat
                    player.addChatMessage(new ChatComponentText("You must have an empty inventory to teleport."));
                    return false;
                }
            }

            // If all checks passed, set the destination to the Crystal Dimension
            destinationDimensionId = DimensionInitDangerZone.CrystalDimensionId;
        }

        // Teleport the player only if the checks passed
        if (targetDimensionId != destinationDimensionId) {
            MinecraftServer server = MinecraftServer.getServer();
            WorldServer targetWorld = server.worldServerForDimension(targetDimensionId);
            WorldServer destinationWorld = server.worldServerForDimension(destinationDimensionId);

            if (targetWorld != null && destinationWorld != null) {
                SafeTeleporter teleporter = new SafeTeleporter(
                    destinationWorld,
                    destinationDimensionId,
                    player.worldObj);
                server.getConfigurationManager()
                    .transferPlayerToDimension((EntityPlayerMP) player, destinationDimensionId, teleporter);
            }

        }

        return true;
    }

    public TermiteInstance(World p_i1743_1_) {
        super(p_i1743_1_);
        this.setSize(0.7F, 0.45F);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, 0);
    }

    public void onUpdate() {
        super.onUpdate();
    }

    @Override
    protected Entity findPlayerToAttack() {

        return this.worldObj.getClosestVulnerablePlayerToEntity(this, 16);

    }

    @Override
    protected void attackEntity(Entity target, float distance) {

        if (target instanceof EntityPlayer) {

            EntityPlayer player = (EntityPlayer) target;

            if (distance < 0.5F) {

                if (player.getHealth() > 0) {

                    player.attackEntityFrom(DamageSource.causeMobDamage(this), 0.5F);

                }

            }

        }

        super.attackEntity(target, distance);

    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(0.50D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.1500000011920929D);
    }

    protected Item getDropItem() {
        return null;
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

    protected void func_145780_a(int x, int y, int z, Block blockIn) {
        // this.playSound("mob.spider.step", 0.15F, 1.0F);
    }
}
