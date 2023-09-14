package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions.teleporter;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class SafeTeleporter extends Teleporter {
    // todo fix sometimes can be teleported underground / in blocks

    private final WorldServer world;
    private final World oldWorld;
    private final Random random;
    private final int newdim;

    public SafeTeleporter(final WorldServer par1WorldServer, final int dim, final World par2World) {
        super(par1WorldServer);
        this.world = par1WorldServer;
        this.oldWorld = par2World;
        this.random = new Random(par1WorldServer.getSeed());
        this.newdim = dim;
    }

    public void placeInPortal(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8) {
        // Handle portal placement here if needed
    }

    public boolean placeInExistingPortal(final Entity par1Entity, final double par2, final double par4,
        final double par6, final float par8) {
        // Handle placing in an existing portal here if needed
        return true;
    }

    public boolean makePortal(final Entity par1Entity) {
        // Create a portal here if needed
        return true;
    }

    private boolean isGroundBlock(final Block block) {
        // Define your ground block conditions here
        return block != Blocks.air && (block == Blocks.dirt || block == Blocks.grass
            || block == Blocks.stone
            || block == Blocks.end_stone
            || block == Blocks.netherrack
            || block == Blocks.cobblestone
            || block == Blocks.sand
            || block == Blocks.sandstone
            || block == Blocks.farmland);
    }

    public boolean justPutMe(final Entity par1Entity) {
        int posX = (int) par1Entity.posX;
        int posZ = (int) par1Entity.posZ;
        int posY = 120;
        int found = 0;
        int inarow = 0;
        int airfound = 0;

        for (int i = 0; i < 1000 && found == 0; ++i) {
            for (posY = 180; posY > 1; --posY) {
                Block blockAbove = this.world.getBlock(posX, posY + 1, posZ);

                if (blockAbove == Blocks.air || blockAbove == null) {
                    inarow = 0;
                    Block block = this.world.getBlock(posX, posY, posZ);

                    if (block == Blocks.air || block == null) {
                        airfound = 1;
                        Block blockBelow = this.world.getBlock(posX, posY - 1, posZ);

                        if (blockBelow != Blocks.air && blockBelow != null) {
                            if (blockBelow.getMaterial()
                                .isSolid()) {
                                found = 1;
                                break;
                            }

                            if (blockBelow == Blocks.tallgrass && this.world.getBlock(posX, posY - 2, posZ)
                                .getMaterial()
                                .isSolid()) {
                                found = 1;
                                --posY;
                                break;
                            }
                            break;
                        }
                    }
                } else {
                    if (this.isGroundBlock(blockAbove)) {
                        ++inarow;
                    }

                    if (airfound != 0 && inarow >= 3) {
                        break;
                    }
                }
            }

            if (found == 0) {
                posX = (int) par1Entity.posX + this.world.rand.nextInt(3 + i / 5) - this.world.rand.nextInt(3 + i / 5);

                if (i > 100) {
                    posX = posX + random.nextInt(2 + i / 5) - random.nextInt(2 + i / 5);
                }

                if (i > 500) {
                    posX = posX + this.random.nextInt(2 + i / 5) - this.random.nextInt(2 + i / 5);
                }

                posZ = (int) par1Entity.posZ + this.world.rand.nextInt(3 + i / 5) - this.world.rand.nextInt(3 + i / 5);

                if (i > 100) {
                    posZ = posZ + random.nextInt(2 + i / 5) - random.nextInt(2 + i / 5);
                }

                if (i > 500) {
                    posZ = posZ + this.random.nextInt(2 + i / 5) - this.random.nextInt(2 + i / 5);
                }

                airfound = 0;
                inarow = 0;
            }
        }

        if (found == 0) {
            posX = (int) par1Entity.posX;
            posZ = (int) par1Entity.posZ;

            for (posY = 180; posY > 1; --posY) {
                if (Blocks.air == this.world.getBlock(posX, posY + 1, posZ)
                    && Blocks.air == this.world.getBlock(posX, posY, posZ)
                    && Blocks.air != this.world.getBlock(posX, posY - 1, posZ)) {
                    break;
                }
            }
        }

        final double oldX = par1Entity.posX;
        final double oldY = par1Entity.posY;
        final double oldZ = par1Entity.posZ;
        double newX = posX;
        double newZ = posZ;
        final double newY = posY;

        if (newX < 0.0) {
            newX -= 0.5;
        } else {
            newX += 0.5;
        }

        if (newZ < 0.0) {
            newZ -= 0.5;
        } else {
            newZ += 0.5;
        }

        par1Entity.setLocationAndAngles(newX, newY, newZ, par1Entity.rotationYaw, 0.0f);
        final double motionX = 0.0;
        par1Entity.motionZ = motionX;
        par1Entity.motionY = motionX;
        par1Entity.motionX = motionX;

        final MinecraftServer minecraftserver = MinecraftServer.getServer();
        final WorldServer worldserver = minecraftserver.worldServerForDimension(this.oldWorld.provider.dimensionId);
        final WorldServer worldserver2 = minecraftserver.worldServerForDimension(this.newdim);

        if (par1Entity instanceof EntityPlayer) {
            final EntityPlayer ep = (EntityPlayer) par1Entity;
            final AxisAlignedBB bb = AxisAlignedBB
                .getBoundingBox(oldX - 24.0, oldY - 12.0, oldZ - 24.0, oldX + 24.0, oldY + 12.0, oldZ + 24.0);
            final List var5 = this.oldWorld.getEntitiesWithinAABB(EntityTameable.class, bb);

            for (final Object var7 : var5) {
                final EntityTameable et = (EntityTameable) var7;

                if (!et.isSitting()) {
                    final String p1 = ep.getUniqueID()
                        .toString();
                    final String p2 = et.func_152113_b();

                    if ((p1 == null || !p1.equals(p2)) && !et.func_152114_e(ep)) {
                        continue;
                    }

                    this.sendToThisDimension((Entity) var7, newX, newY, newZ, (int) ep.rotationYaw);
                }
            }
        }

        worldserver.resetUpdateEntityTick();
        worldserver2.resetUpdateEntityTick();
        return true;
    }

    public void sendToThisDimension(final Entity e, final double newX, final double newY, final double newZ,
        final int ro) {
        if (this.oldWorld.isRemote) {
            return;
        }

        e.worldObj.removeEntity(e);
        e.isDead = false;
        e.setLocationAndAngles(newX, newY, newZ, (float) ro, 0.0f);
        final double motionX = 0.0;
        e.motionZ = motionX;
        e.motionY = motionX;
        e.motionX = motionX;
        e.setWorld(this.world);

        final Entity newEntity = EntityList.createEntityByName(EntityList.getEntityString(e), this.world);

        if (newEntity != null) {
            newEntity.copyDataFrom(e, true);
            newEntity.setLocationAndAngles(newX, newY, newZ, (float) ro, 0.0f);
            final double motionX2 = 0.0;
            newEntity.motionZ = motionX2;
            newEntity.motionY = motionX2;
            newEntity.motionX = motionX2;
            newEntity.setWorld(this.world);
            this.world.spawnEntityInWorld(newEntity);
        }

        e.isDead = true;
    }

    public void removeStalePortalLocations(final long par1) {
        // Remove stale portal locations if needed
    }
}
