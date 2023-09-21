
package danger.orespawn.entities.entityinstance;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class Island extends EntityAnimal {

    private float dir;
    private float speed;
    private int radius;
    private int depth;
    private int timer;
    private int just_spawned;
    private int ticker;
    private int once;
    private double myX;
    private double myY;
    private double myZ;
    private int dirchange;

    public Island(final World par1World) {
        super(par1World);
        this.dir = 0.0f;
        this.speed = 0.1f;
        this.radius = 5;
        this.depth = 3;
        this.timer = 73;
        this.just_spawned = 1;
        this.ticker = 0;
        this.once = 1;
        this.setSize(0.5f, 0.5f);
        this.ticker = par1World.rand.nextInt(50);
        this.dirchange = this.worldObj.rand.nextInt(2500);
    }

    public void onUpdate() {
        super.onUpdate();
        final double motionX = 0.0;
        this.motionZ = motionX;
        this.motionY = motionX;
        this.motionX = motionX;
        if (this.worldObj.isRemote) {
            return;
        }
        if (this.once != 0) {
            this.myX = this.posX;
            this.myY = this.posY;
            this.myZ = this.posZ;
            this.once = 0;
        }
        if (this.just_spawned != 0) {
            this.dir = this.worldObj.rand.nextFloat() * 3.1415927f;
            if (this.worldObj.rand.nextInt(2) == 1) {
                this.dir *= -1.0f;
            }
            if (this.worldObj.rand.nextInt(40) != 1) {
                this.radius = 3 + this.worldObj.rand.nextInt(4);
                this.depth = 2 + this.worldObj.rand.nextInt(3);
                this.speed = this.worldObj.rand.nextFloat() / 50.0f * OreSpawnMain.IslandSpeedFactor;
            } else {
                this.radius = 6 + this.worldObj.rand.nextInt(5);
                this.depth = 3 + this.worldObj.rand.nextInt(4);
                this.speed = this.worldObj.rand.nextFloat() / 200.0f * OreSpawnMain.IslandSpeedFactor;
            }
            this.create_island();
            this.ticker = this.worldObj.rand.nextInt(50);
            this.dirchange = this.worldObj.rand.nextInt(10000);
        }
        ++this.ticker;
        if (this.ticker >= this.timer) {
            this.update_island();
            this.ticker = 0;
        }
        --this.dirchange;
        if (this.dirchange <= 0) {
            this.dirchange = this.worldObj.rand.nextInt(5000);
            this.dir = this.worldObj.rand.nextFloat() * 3.1415927f;
            if (this.worldObj.rand.nextInt(2) == 1) {
                this.dir *= -1.0f;
            }
        }
        this.just_spawned = 0;
    }

    public void onLivingUpdate() {
        if (this.worldObj.isRemote) {
            super.onLivingUpdate();
        }
    }

    protected void updateAITick() {}

    protected void updateAITasks() {}

    protected void fall(final float par1) {}

    protected boolean canDespawn() {
        return false;
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.just_spawned = par1NBTTagCompound.getInteger("JustSpawned");
        this.depth = par1NBTTagCompound.getInteger("Idepth");
        this.radius = par1NBTTagCompound.getInteger("Iradius");
        this.speed = par1NBTTagCompound.getFloat("Ispeed");
        this.dir = par1NBTTagCompound.getFloat("Idir");
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("JustSpawned", this.just_spawned);
        par1NBTTagCompound.setInteger("Idepth", this.depth);
        par1NBTTagCompound.setInteger("Iradius", this.radius);
        par1NBTTagCompound.setFloat("Ispeed", this.speed);
        par1NBTTagCompound.setFloat("Idir", this.dir);
    }

    public EntityAgeable createChild(final EntityAgeable entityageable) {
        return null;
    }

    private void create_island() {
        final double deltadir = 0.10471975333333333;
        final double deltamag = 0.3499999940395355;
        int ixlast = 0;
        int izlast = 0;
        int xoff = 0;
        int zoff = 0;
        for (int i = 0; i < this.depth; ++i) {
            izlast = (ixlast = 0);
            for (double curdir = -3.1415926; curdir < 3.1415926; curdir += deltadir) {
                double tradius = this.radius;
                tradius /= i + 1;
                for (double h = 0.75; h < tradius; h += deltamag) {
                    final int ix = (int) (this.posX + Math.cos(curdir + this.dir) * h);
                    final int iz = (int) (this.posZ + Math.sin(curdir + this.dir) * h);
                    if (ix != ixlast || iz != izlast) {
                        ixlast = ix;
                        izlast = iz;
                        if (i == 0) {
                            final Block bid;
                            if ((bid = this.worldObj.getBlock(ix, (int) this.posY - i + 1, iz)) == Blocks.air) {
                                if (this.worldObj.rand.nextInt(5000) == 1) {
                                    this.worldObj.setBlock(ix, (int) this.posY - i + 1, iz, Blocks.lava);
                                } else {
                                    this.FastSetBlock(ix, (int) this.posY - i + 1, iz, (Block) Blocks.mycelium);
                                    if (this.worldObj.rand.nextInt(20) == 1
                                        && this.worldObj.getBlock(ix, (int) this.posY - i + 2, iz) == Blocks.air) {
                                        if (this.worldObj.rand.nextInt(2) == 1) {
                                            this.worldObj.setBlock(
                                                ix,
                                                (int) this.posY - i + 2,
                                                iz,
                                                (Block) Blocks.brown_mushroom);
                                        } else {
                                            this.worldObj
                                                .setBlock(ix, (int) this.posY - i + 2, iz, (Block) Blocks.red_mushroom);
                                        }
                                    }
                                }
                            } else if (bid == Blocks.bedrock) {
                                this.setDead();
                                return;
                            }
                        } else if (this.worldObj.rand.nextInt(10) == 1) {
                            this.FastSetBlock(ix, (int) this.posY - i + 1, iz, Blocks.diamond_ore);
                        } else {
                            this.FastSetBlock(ix, (int) this.posY - i + 1, iz, Blocks.end_stone);
                        }
                    }
                }
            }
        }
        if (this.posX < 0.0) {
            xoff = -1;
        }
        if (this.posZ < 0.0) {
            zoff = -1;
        }
        this.worldObj.setBlock((int) this.posX + xoff, (int) this.posY, (int) this.posZ + zoff, Blocks.air);
        this.FastSetBlock((int) this.posX + xoff, (int) this.posY, (int) this.posZ + zoff, Blocks.air);
    }

    private void update_island() {
        final double deltadir = 0.10471975333333333;
        final double deltamag = 0.3499999940395355;
        final double pi2 = 1.57079632675;
        int ixlast = 0;
        int izlast = 0;
        int xoff = 0;
        int zoff = 0;
        this.myX += this.speed * Math.cos(this.dir);
        this.myZ += this.speed * Math.sin(this.dir);
        final int mx = (int) this.myX;
        final int mz = (int) this.myZ;
        final int px = (int) this.posX;
        final int pz = (int) this.posZ;
        if (mx != px || mz != pz) {
            for (int i = 0; i < this.depth; ++i) {
                izlast = (ixlast = 0);
                for (double curdir = -3.3; curdir < 3.3; curdir += deltadir / 2.0) {
                    double tradius;
                    double h;
                    for (tradius = this.radius, tradius /= i + 1, h = 0.75; h < tradius; h += deltamag) {}
                    h -= deltamag;
                    if (h < 0.75) {
                        h = 0.75;
                    }
                    while (h < tradius + deltamag) {
                        final int ix = (int) (this.posX + Math.cos(curdir + this.dir) * h);
                        final int iz = (int) (this.posZ + Math.sin(curdir + this.dir) * h);
                        if (ix != ixlast || iz != izlast) {
                            ixlast = ix;
                            izlast = iz;
                            if (i == 0) {
                                final Block bid = this.worldObj.getBlock(ix, (int) this.posY + 1 + 1, iz);
                                if (bid == Blocks.red_mushroom || bid == Blocks.brown_mushroom) {
                                    this.FastSetBlock(ix, (int) this.posY + 1 + 1, iz, Blocks.air);
                                }
                            }
                            this.FastSetBlock(ix, (int) this.posY - i + 1, iz, Blocks.air);
                        }
                        h += deltamag / 2.0;
                    }
                }
            }
            if (this.posX < 0.0) {
                xoff = -1;
            }
            if (this.posZ < 0.0) {
                zoff = -1;
            }
            this.worldObj.setBlock((int) this.posX + xoff, (int) this.posY, (int) this.posZ + zoff, Blocks.end_stone);
            this.posX = (int) this.myX;
            if (this.myX < 0.0) {
                this.posX -= 0.5;
            } else {
                this.posX += 0.5;
            }
            this.posZ = (int) this.myZ;
            if (this.myZ < 0.0) {
                this.posZ -= 0.5;
            } else {
                this.posZ += 0.5;
            }
            for (int i = 0; i < this.depth; ++i) {
                izlast = (ixlast = 0);
                for (double curdir = -3.1415926; curdir < 3.1415926; curdir += deltadir) {
                    double tradius;
                    double h;
                    for (tradius = this.radius, tradius /= i + 1, h = 0.75; h < tradius; h += deltamag) {}
                    h -= deltamag * 3.0;
                    if (h < 0.75) {
                        h = 0.75;
                    }
                    while (h < tradius) {
                        final int ix = (int) (this.posX + Math.cos(curdir + this.dir) * h);
                        final int iz = (int) (this.posZ + Math.sin(curdir + this.dir) * h);
                        if (ix != ixlast || iz != izlast) {
                            ixlast = ix;
                            izlast = iz;
                            if (i == 0) {
                                final Block bid;
                                if ((bid = this.worldObj.getBlock(ix, (int) this.posY - i + 1, iz)) == Blocks.air) {
                                    if (this.worldObj.rand.nextInt(5000) == 1) {
                                        this.worldObj.setBlock(ix, (int) this.posY - i + 1, iz, Blocks.lava);
                                    } else {
                                        this.FastSetBlock(ix, (int) this.posY - i + 1, iz, (Block) Blocks.mycelium);
                                        if (this.worldObj.rand.nextInt(20) == 1
                                            && this.worldObj.getBlock(ix, (int) this.posY - i + 2, iz) == Blocks.air) {
                                            if (this.worldObj.rand.nextInt(2) == 1) {
                                                this.worldObj.setBlock(
                                                    ix,
                                                    (int) this.posY - i + 2,
                                                    iz,
                                                    (Block) Blocks.brown_mushroom);
                                            } else {
                                                this.worldObj.setBlock(
                                                    ix,
                                                    (int) this.posY - i + 2,
                                                    iz,
                                                    (Block) Blocks.red_mushroom);
                                            }
                                        }
                                    }
                                } else if (bid == Blocks.bedrock) {
                                    this.setDead();
                                    return;
                                }
                            } else {
                                final Block bid = this.worldObj.getBlock(ix, (int) this.posY - i + 1, iz);
                                if (bid == Blocks.stone) {
                                    if (!this.worldObj.isRemote) {
                                        this.worldObj.createExplosion(this, ix, this.posY - i + 1.0, iz, 5.0f, true);
                                    }
                                } else if (this.worldObj.rand.nextInt(10) == 1) {
                                    this.FastSetBlock(ix, (int) this.posY - i + 1, iz, Blocks.diamond_ore);
                                } else {
                                    this.FastSetBlock(ix, (int) this.posY - i + 1, iz, Blocks.end_stone);
                                }
                            }
                        }
                        h += deltamag;
                    }
                }
            }
            xoff = 0;
            if (this.posX < 0.0) {
                xoff = -1;
            }
            zoff = 0;
            if (this.posZ < 0.0) {
                zoff = -1;
            }
            this.worldObj.setBlock((int) this.posX + xoff, (int) this.posY, (int) this.posZ + zoff, Blocks.air);
            this.FastSetBlock((int) this.posX + xoff, (int) this.posY, (int) this.posZ + zoff, Blocks.air);
        }
        if (this.worldObj.rand.nextInt(2 + 2000 / this.timer) == 1) {
            final AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(
                this.posX - 10.0,
                this.posY - 5.0,
                this.posZ - 10.0,
                this.posX + 10.0,
                this.posY + 5.0,
                this.posZ + 10.0);
            final List var5 = this.worldObj.getEntitiesWithinAABB(Triffid.class, bb);
            final Iterator var6 = var5.iterator();
            if (!var6.hasNext()) {
                final EntityCreature newent = (EntityCreature) spawnCreature(
                    this.worldObj,
                    "Triffid",
                    this.posX,
                    this.posY + 2.01,
                    this.posZ);
            }
        }
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

    protected Item getDropItem() {
        return Item.getItemFromBlock(OreSpawnMain.MyIslandBlock);
    }

    public void FastSetBlock(final int ix, final int iy, final int iz, final Block id) {
        OreSpawnMain.setBlockFast(this.worldObj, ix, iy, iz, id, 0, 3);
    }
}
