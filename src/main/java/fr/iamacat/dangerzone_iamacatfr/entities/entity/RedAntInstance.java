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
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import fr.iamacat.dangerzone_iamacatfr.init.DimensionInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions.teleporter.SafeTeleporter;

public class RedAntInstance extends EntityMob {

    public boolean interact(final EntityPlayer player) {
        if (!(player instanceof EntityPlayerMP)) {
            return false;
        }

        ItemStack heldItem = player.inventory.getCurrentItem();

        if (heldItem != null && heldItem.stackSize > 0) {
            // Player is holding an item, do not teleport
            return false;
        }

        int targetDimensionId = player.dimension;
        int destinationDimensionId;

        if (targetDimensionId != DimensionInitDangerZone.MiningDimensionId) {
            destinationDimensionId = DimensionInitDangerZone.MiningDimensionId;
        } else {
            destinationDimensionId = 0;
        }

        MinecraftServer server = MinecraftServer.getServer();
        WorldServer targetWorld = server.worldServerForDimension(targetDimensionId);
        WorldServer destinationWorld = server.worldServerForDimension(destinationDimensionId);

        if (targetWorld != null && destinationWorld != null) {
            SafeTeleporter teleporter = new SafeTeleporter(destinationWorld, destinationDimensionId, player.worldObj);
            server.getConfigurationManager()
                .transferPlayerToDimension((EntityPlayerMP) player, destinationDimensionId, teleporter);
        }

        return true;
    }

    public RedAntInstance(World p_i1743_1_) {
        super(p_i1743_1_);
        this.setSize(1.4F, 0.9F);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, 0);
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate() {
        super.onUpdate();
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(0.50D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.1500000011920929D);
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound() {
        return null;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound() {
        return null;
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound() {
        return null;
    }

    protected void func_145780_a(int x, int y, int z, Block blockIn) {

        // this.playSound("mob.spider.step", 0.15F, 1.0F);
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

    protected Item getDropItem() {
        return null;
    }
}
