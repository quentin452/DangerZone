package fr.iamacat.dangerzone_iamacatfr.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

import java.util.Random;

public class TeleportBlock extends Block {

    public TeleportBlock() {
        super(Material.rock);
    }

    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;

            int found = 0;
            Random rand = new Random();
            int randX = 0, randY = 0, randZ = 0;

            for (int tries = 0; tries < 1000 && found == 0; ++tries) {
                randX = x + rand.nextInt(33) - 16;
                randZ = z + rand.nextInt(33) - 16;
                randY = y;

                if (rand.nextBoolean()) {
                    randX = x - rand.nextInt(33) - 16;
                }
                if (rand.nextBoolean()) {
                    randZ = z - rand.nextInt(33) - 16;
                }

                for (randY = y - 4; randY <= y + 4; ++randY) {
                    if (world.getBlock(randX, randY - 1, randZ)
                        .getMaterial()
                        .isSolid() && world.isAirBlock(randX, randY, randZ)
                        && world.isAirBlock(randX, randY + 1, randZ)) {
                        found = 1;
                        break;
                    }
                }
            }

            if (found != 0) {
                double newX = randX + 0.5;
                double newY = randY;
                double newZ = randZ + 0.5;

                if (entity instanceof EntityPlayerMP) {
                    EntityPlayerMP mp = (EntityPlayerMP) entity;
                    mp.playerNetServerHandler.setPlayerLocation(newX, newY, newZ, player.rotationYaw, 0.0f);
                } else {
                    player.setLocationAndAngles(newX, newY, newZ, player.rotationYaw, 0.0f);
                }

                for (int i = 0; i < 6; ++i) {
                    world.spawnParticle("smoke", newX, newY + 2.25, newZ, 0.0, 0.0, 0.0);
                    world.spawnParticle("explode", newX, newY + 2.25, newZ, 0.0, 0.0, 0.0);
                    world.spawnParticle("reddust", newX, newY + 2.25, newZ, 0.0, 0.0, 0.0);
                }

                world.playSoundAtEntity(player, "random.explode", 1.0f, 1.5f);
            }
        }
    }
}
