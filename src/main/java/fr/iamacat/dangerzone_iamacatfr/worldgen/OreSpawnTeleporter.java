
package fr.iamacat.dangerzone_iamacatfr.worldgen;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
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

import java.util.List;
import java.util.Random;

public class OreSpawnTeleporter extends Teleporter {

    private WorldServer world;
    private World oldWorld;
    private Random random;
    private int newdim;

    public OreSpawnTeleporter(final WorldServer par1WorldServer, final int dim, final World par2World) {
        super(par1WorldServer);
        this.world = par1WorldServer;
        this.oldWorld = par2World;
        this.random = new Random(par1WorldServer.getSeed());
        this.newdim = dim;
    }

    public void placeInPortal(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8) {
        this.justPutMe(par1Entity);
    }

    public boolean placeInExistingPortal(final Entity par1Entity, final double par2, final double par4,
        final double par6, final float par8) {
        this.justPutMe(par1Entity);
        return true;
    }

    public boolean makePortal(final Entity par1Entity) {
        return true;
    }

    private boolean isGroundBlock(final Block bid) {
        return bid != Blocks.air && (bid == Blocks.dirt || bid == Blocks.grass
            || bid == Blocks.stone
            || bid == Blocks.end_stone
            || bid == Blocks.netherrack
            || bid == Blocks.cobblestone
            || bid == Blocks.sand
            || bid == Blocks.sandstone
            || bid == Blocks.farmland);
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
                Block bid = this.world.getBlock(posX, posY + 1, posZ);
                if (bid == Blocks.air || bid == null) {
                    inarow = 0;
                    bid = this.world.getBlock(posX, posY, posZ);
                    if (bid == Blocks.air || bid == null) {
                        airfound = 1;
                        bid = this.world.getBlock(posX, posY - 1, posZ);
                        if (bid != Blocks.air && bid != null) {
                            if (this.world.getBlock(posX, posY - 1, posZ)
                                .getMaterial()
                                .isSolid()) {
                                found = 1;
                                break;
                            }
                            if (bid == Blocks.tallgrass && this.world.getBlock(posX, posY - 2, posZ)
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
                    if (this.isGroundBlock(bid)) {
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
                    posX = posX + OreSpawnMain.OreSpawnRand.nextInt(2 + i / 5)
                        - OreSpawnMain.OreSpawnRand.nextInt(2 + i / 5);
                }
                if (i > 500) {
                    posX = posX + this.random.nextInt(2 + i / 5) - this.random.nextInt(2 + i / 5);
                }
                posZ = (int) par1Entity.posZ + this.world.rand.nextInt(3 + i / 5) - this.world.rand.nextInt(3 + i / 5);
                if (i > 100) {
                    posZ = posZ + OreSpawnMain.OreSpawnRand.nextInt(2 + i / 5)
                        - OreSpawnMain.OreSpawnRand.nextInt(2 + i / 5);
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
                    if ((p1 == null || p2 == null || !p1.equals(p2)) && !et.func_152114_e(ep)) {
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
        e.setWorld((World) this.world);
        final Entity var6 = EntityList.createEntityByName(EntityList.getEntityString(e), (World) this.world);
        if (var6 != null) {
            var6.copyDataFrom(e, true);
            var6.setLocationAndAngles(newX, newY, newZ, (float) ro, 0.0f);
            final Entity entity = var6;
            final Entity entity2 = var6;
            final Entity entity3 = var6;
            final double motionX2 = 0.0;
            entity3.motionZ = motionX2;
            entity2.motionY = motionX2;
            entity.motionX = motionX2;
            var6.setWorld((World) this.world);
            this.world.spawnEntityInWorld(var6);
        }
        e.isDead = true;
    }

    public void removeStalePortalLocations(final long par1) {}
}
