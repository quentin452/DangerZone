package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

// todo it seem thats doesn't work
public class TheZooKeeper extends Item {

    public TheZooKeeper() {
        this.setMaxStackSize(1);
        this.setTextureName(Tags.MODID + ":zookeeper"); // Nom de la texture de l'item
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        // Vérifiez si le joueur cible une entité
        Entity target = getMouseOverEntity(player, world);
        if (target != null) {
            // Empêchez l'entité de despawner en lui ajoutant un tag NBT personnalisé
            NBTTagCompound entityNBT = target.getEntityData();
            entityNBT.setBoolean("NoDespawn", true);
        }

        return itemStack;
    }

    private Entity getMouseOverEntity(EntityPlayer player, World world) {
        // Effectuez un rayon depuis la position des yeux du joueur dans la direction de son regard.
        float partialTicks = 1.0F; // Vous pouvez ajuster cela en fonction de votre besoin.
        double reachDistance = 200.0D; // Portée du rayon. Vous pouvez ajuster cela.

        // Obtenez la position des yeux du joueur
        double posX = player.prevPosX + (player.posX - player.prevPosX) * partialTicks;
        double posY = player.prevPosY + (player.posY - player.prevPosY) * partialTicks + player.getEyeHeight();
        double posZ = player.prevPosZ + (player.posZ - player.prevPosZ) * partialTicks;

        // Obtenez la direction du regard du joueur
        float pitch = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * partialTicks;
        float yaw = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * partialTicks;
        double dirX = -Math.sin(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));
        double dirY = -Math.sin(Math.toRadians(pitch));
        double dirZ = Math.cos(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));

        // Calculez la cible du rayon
        double targetX = posX + dirX * reachDistance;
        double targetY = posY + dirY * reachDistance;
        double targetZ = posZ + dirZ * reachDistance;

        // Effectuez le rayon et obtenez le résultat
        MovingObjectPosition target = world.rayTraceBlocks(
            Vec3.createVectorHelper(posX, posY, posZ),
            Vec3.createVectorHelper(targetX, targetY, targetZ));

        if (target != null && target.entityHit != null) {
            return target.entityHit;
        }

        return null;
    }
}
