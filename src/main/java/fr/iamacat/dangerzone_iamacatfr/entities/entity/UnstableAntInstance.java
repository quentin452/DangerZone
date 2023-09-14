package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.init.DimensionInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions.teleporter.SafeTeleporter;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class UnstableAntInstance extends EntityAnimal {

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

        if (targetDimensionId != DimensionInitDangerZone.DangerDimensionId) {
            destinationDimensionId = DimensionInitDangerZone.DangerDimensionId;
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

    public UnstableAntInstance(World p_i1743_1_) {
        super(p_i1743_1_);
        this.setSize(0.7F, 0.45F);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable p_90011_1_) {
        return null;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, 0);
    }

    public void onUpdate() {
        super.onUpdate();
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(1.00D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.400000011920929D);
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

    protected Item getDropItem() {
        return null;
    }
}
