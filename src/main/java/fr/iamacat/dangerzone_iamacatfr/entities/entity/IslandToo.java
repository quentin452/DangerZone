
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;

public class IslandToo extends EntityAnimal {

    private int dir;
    private float speed;
    private int width;
    private int depth;
    private int length;
    private int timer;
    private int just_spawned;
    private int ticker;
    private int once;
    private double myX;
    private double myY;
    private double myZ;
    private int dirchange;
    private int blocktype;

    public IslandToo(final World par1World) {
        super(par1World);
        this.dir = 0;
        this.speed = 0.1f;
        this.width = 5;
        this.depth = 3;
        this.length = 10;
        this.timer = 42;
        this.just_spawned = 1;
        this.ticker = 0;
        this.once = 1;
        this.dirchange = 0;
        this.blocktype = 0;
        this.setSize(0.5f, 0.5f);
        this.ticker = par1World.rand.nextInt(50);
        this.dirchange = this.worldObj.rand.nextInt(5000);
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
            this.dir = this.worldObj.rand.nextInt(4);
            if (this.worldObj.rand.nextInt(40) != 1) {
                this.width = 1 + this.worldObj.rand.nextInt(5 * OreSpawnMain.IslandSizeFactor);
                this.length = this.width;
                this.depth = 1 + this.worldObj.rand.nextInt(4);
                this.speed = this.worldObj.rand.nextFloat() / 40.0f * OreSpawnMain.IslandSpeedFactor;
                if (this.length * this.width * this.depth <= 64) {
                    this.speed *= 2.0f;
                }
                if (this.length * this.width * this.depth <= 32) {
                    this.speed *= 2.0f;
                }
            } else {
                this.width = 5 + this.worldObj.rand.nextInt(8 * OreSpawnMain.IslandSizeFactor);
                this.length = this.width;
                this.depth = 3 + this.worldObj.rand.nextInt(6);
                this.speed = this.worldObj.rand.nextFloat() / 150.0f * OreSpawnMain.IslandSpeedFactor;
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
            this.dir = this.worldObj.rand.nextInt(4);
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
        this.width = par1NBTTagCompound.getInteger("Iwidth");
        this.depth = par1NBTTagCompound.getInteger("Idepth");
        this.length = par1NBTTagCompound.getInteger("Ilength");
        this.speed = par1NBTTagCompound.getFloat("Ispeed");
        this.dir = par1NBTTagCompound.getInteger("Idir");
        this.blocktype = par1NBTTagCompound.getInteger("Iblocktype");
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("JustSpawned", this.just_spawned);
        par1NBTTagCompound.setInteger("Iwidth", this.width);
        par1NBTTagCompound.setInteger("Idepth", this.depth);
        par1NBTTagCompound.setInteger("Ilength", this.length);
        par1NBTTagCompound.setFloat("Ispeed", this.speed);
        par1NBTTagCompound.setInteger("Idir", this.dir);
        par1NBTTagCompound.setInteger("Iblocktype", this.blocktype);
    }

    public EntityAgeable createChild(final EntityAgeable entityageable) {
        return null;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        final boolean ret = false;
        int xoff = 0;
        int zoff = 0;
        final int ix = (int) this.posX;
        final int iz = (int) this.posZ;
        if (ix < 0) {
            xoff = 1;
            this.posX = ix;
            this.posX -= 0.5;
        } else {
            this.posX = ix;
            this.posX += 0.5;
        }
        if (iz < 0) {
            zoff = 1;
            this.posZ = iz;
            this.posZ -= 0.5;
        } else {
            this.posZ = iz;
            this.posZ += 0.5;
        }
        super.attackEntityFrom(par1DamageSource, par2);
        return ret;
    }

    private void create_island() {
        int xoff = 0;
        int zoff = 0;
        if (this.posX < 0.0) {
            xoff = 1;
        }
        if (this.posZ < 0.0) {
            zoff = 1;
        }
        for (int k = 0; k <= this.depth; ++k) {
            int il = this.length / (this.depth - k + 1);
            if (il < 1) {
                il = 1;
            }
            for (int i = -il; i <= il; ++i) {
                for (int j = -il; j <= il; ++j) {
                    final int ix = (int) this.posX + j - xoff;
                    final int iz = (int) this.posZ + i - zoff;
                    if (k == this.depth) {
                        final Block bid;
                        if ((bid = this.worldObj.getBlock(ix, (int) this.posY + k, iz)) == Blocks.air) {
                            if (this.worldObj.rand.nextInt(5000) == 1) {
                                this.worldObj.setBlock(ix, (int) this.posY + k, iz, Blocks.water);
                            } else {
                                this.FastSetBlock(ix, (int) this.posY + k, iz, (Block) Blocks.grass);
                                if (this.worldObj.rand.nextInt(30) == 1) {
                                    if (this.worldObj.getBlock(ix, (int) this.posY + k + 1, iz) == Blocks.air) {
                                        if (this.worldObj.rand.nextInt(2) == 1) {
                                            this.worldObj.setBlock(
                                                ix,
                                                (int) this.posY + k + 1,
                                                iz,
                                                OreSpawnMain.MyFlowerPinkBlock);
                                        } else {
                                            this.worldObj.setBlock(
                                                ix,
                                                (int) this.posY + k + 1,
                                                iz,
                                                OreSpawnMain.MyFlowerBlueBlock);
                                        }
                                    }
                                } else if (this.worldObj.rand.nextInt(100) == 1
                                    && this.worldObj.getBlock(ix, (int) this.posY + k + 1, iz) == Blocks.air) {
                                        OreSpawnMain.OreSpawnTrees
                                            .SmallTree(this.worldObj, ix, (int) this.posY + k + 1, iz);
                                    }
                            }
                        } else if (bid == Blocks.bedrock) {
                            this.setDead();
                            return;
                        }
                    } else {
                        this.mySetBlock(ix, (int) this.posY + k, iz);
                    }
                }
            }
        }
        this.worldObj.setBlock((int) this.posX - xoff, (int) this.posY, (int) this.posZ - zoff, Blocks.air);
    }

    private void mySetBlock(final int ix, final int iy, final int iz) {
        Block bid = Blocks.stone;
        if (this.blocktype == 0) {
            this.blocktype = 1 + this.worldObj.rand.nextInt(8);
        }
        if (this.blocktype == 1 && this.worldObj.rand.nextInt(5) == 1) {
            bid = Blocks.coal_ore;
        }
        if (this.blocktype == 2 && this.worldObj.rand.nextInt(10) == 1) {
            bid = Blocks.iron_ore;
        }
        if (this.blocktype == 3 && this.worldObj.rand.nextInt(20) == 1) {
            bid = Blocks.emerald_ore;
        }
        if (this.blocktype == 4 && this.worldObj.rand.nextInt(30) == 1) {
            bid = OreSpawnMain.MyOreTitaniumBlock;
        }
        if (this.blocktype == 5 && this.worldObj.rand.nextInt(30) == 1) {
            bid = OreSpawnMain.MyOreUraniumBlock;
        }
        if (this.blocktype == 6 && this.worldObj.rand.nextInt(30) == 1) {
            bid = OreSpawnMain.MyOreRubyBlock;
        }
        if (this.blocktype == 7 && this.worldObj.rand.nextInt(30) == 1) {
            bid = OreSpawnMain.MyOreAmethystBlock;
        }
        if (this.blocktype == 8 && this.worldObj.rand.nextInt(20) == 1) {
            bid = Blocks.gold_ore;
        }
        if (bid == Blocks.stone) {
            if (this.worldObj.rand.nextInt(3000) == 1) {
                bid = OreSpawnMain.MyEnderPearlBlock;
            }
            if (this.worldObj.rand.nextInt(3000) == 2) {
                bid = OreSpawnMain.MyEyeOfEnderBlock;
            }
            if (this.worldObj.rand.nextInt(3000) == 3) {
                bid = OreSpawnMain.MyBlockAmethystBlock;
            }
            if (this.worldObj.rand.nextInt(3000) == 4) {
                bid = OreSpawnMain.MyBlockRubyBlock;
            }
            if (this.worldObj.rand.nextInt(3000) == 5) {
                bid = OreSpawnMain.MyBlockUraniumBlock;
            }
            if (this.worldObj.rand.nextInt(3000) == 6) {
                bid = OreSpawnMain.MyBlockTitaniumBlock;
            }
            if (this.worldObj.rand.nextInt(3000) == 7) {
                bid = Blocks.gold_block;
            }
            if (this.worldObj.rand.nextInt(3000) == 8) {
                bid = Blocks.diamond_block;
            }
        }
        this.FastSetBlock(ix, iy, iz, bid);
    }

    private void update_island() {
        int xoff = 0;
        int zoff = 0;
        if (this.dir == 0) {
            this.myZ -= this.speed;
        } else if (this.dir == 1) {
            this.myZ += this.speed;
        } else if (this.dir == 2) {
            this.myX += this.speed;
        } else {
            this.myX -= this.speed;
        }
        int ke;
        int ks;
        int js;
        int je = js = (ks = (ke = 0));
        final int mx = (int) this.myX;
        final int mz = (int) this.myZ;
        final int px = (int) this.posX;
        final int pz = (int) this.posZ;
        if (mx != px || mz != pz) {
            if (this.dir == 0) {
                js = 1;
                je = 1;
                ks = -1;
                ke = 1;
            } else if (this.dir == 1) {
                js = -1;
                je = -1;
                ks = -1;
                ke = 1;
            } else if (this.dir == 2) {
                js = -1;
                je = 1;
                ks = -1;
                ke = -1;
            } else {
                js = -1;
                je = 1;
                ks = 1;
                ke = 1;
            }
            if (this.posX < 0.0) {
                xoff = 1;
            }
            if (this.posZ < 0.0) {
                zoff = 1;
            }
            for (int i = 0; i <= this.depth; ++i) {
                int il = this.length / (this.depth - i + 1);
                if (il < 1) {
                    il = 1;
                }
                for (int j = js * il; j <= je * il; ++j) {
                    for (int k = ks * il; k <= ke * il; ++k) {
                        final int ix = (int) this.posX + k - xoff;
                        final int iz = (int) this.posZ + j - zoff;
                        if (i == this.depth) {
                            Block bid = this.worldObj.getBlock(ix, (int) this.posY + i + 1, iz);
                            if (bid == OreSpawnMain.MyFlowerPinkBlock || bid == OreSpawnMain.MyFlowerBlueBlock
                                || bid == OreSpawnMain.MyFlowerBlackBlock
                                || bid == OreSpawnMain.MyFlowerScaryBlock) {
                                this.FastSetBlock(ix, (int) this.posY + i + 1, iz, Blocks.air);
                            }
                            if (bid == Blocks.water || bid == Blocks.flowing_water) {
                                this.worldObj.setBlock(ix, (int) this.posY + i, iz, Blocks.air);
                            }
                            if (bid == OreSpawnMain.MySkyTreeLog) {
                                this.worldObj.setBlock(ix, (int) this.posY + i + 1, iz, Blocks.air);
                                bid = this.worldObj.getBlock(ix, (int) this.posY + i + 2, iz);
                                if (bid == OreSpawnMain.MySkyTreeLog) {
                                    this.worldObj.setBlock(ix, (int) this.posY + i + 2, iz, Blocks.air);
                                    bid = this.worldObj.getBlock(ix, (int) this.posY + i + 3, iz);
                                    if (bid == OreSpawnMain.MySkyTreeLog) {
                                        this.worldObj.setBlock(ix, (int) this.posY + i + 3, iz, Blocks.air);
                                    }
                                }
                            }
                            bid = this.worldObj.getBlock(ix, (int) this.posY + i, iz);
                            if (bid == Blocks.water || bid == Blocks.flowing_water) {
                                this.worldObj.setBlock(ix, (int) this.posY + i, iz, Blocks.air);
                            }
                        }
                        this.FastSetBlock(ix, (int) this.posY + i, iz, Blocks.air);
                    }
                }
            }
            this.mySetBlock((int) this.posX - xoff, (int) this.posY, (int) this.posZ - zoff);
            this.posX = mx;
            if (this.myX < 0.0) {
                this.posX -= 0.5;
            } else {
                this.posX += 0.5;
            }
            this.posZ = mz;
            if (this.myZ < 0.0) {
                this.posZ -= 0.5;
            } else {
                this.posZ += 0.5;
            }
            if (this.dir == 0) {
                js = -1;
                je = -1;
                ks = -1;
                ke = 1;
            } else if (this.dir == 1) {
                js = 1;
                je = 1;
                ks = -1;
                ke = 1;
            } else if (this.dir == 2) {
                js = -1;
                je = 1;
                ks = 1;
                ke = 1;
            } else {
                js = -1;
                je = 1;
                ks = -1;
                ke = -1;
            }
            zoff = (xoff = 0);
            if (this.posX < 0.0) {
                xoff = 1;
            }
            if (this.posZ < 0.0) {
                zoff = 1;
            }
            this.worldObj.setBlock((int) this.posX - xoff, (int) this.posY, (int) this.posZ - zoff, Blocks.air);
            for (int i = 0; i <= this.depth; ++i) {
                int il = this.length / (this.depth - i + 1);
                if (il < 1) {
                    il = 1;
                }
                for (int j = js * il; j <= je * il; ++j) {
                    for (int k = ks * il; k <= ke * il; ++k) {
                        final int ix = (int) this.posX + k - xoff;
                        final int iz = (int) this.posZ + j - zoff;
                        if (i == this.depth) {
                            final Block bid;
                            if ((bid = this.worldObj.getBlock(ix, (int) this.posY + i, iz)) == Blocks.air) {
                                if (this.worldObj.rand.nextInt(5000) == 1) {
                                    this.worldObj.setBlock(ix, (int) this.posY + i, iz, Blocks.water);
                                } else {
                                    this.FastSetBlock(ix, (int) this.posY + i, iz, (Block) Blocks.grass);
                                    if (this.worldObj.rand.nextInt(30) == 1) {
                                        if (this.worldObj.getBlock(ix, (int) this.posY + i + 1, iz) == Blocks.air) {
                                            if (this.worldObj.rand.nextInt(2) == 1) {
                                                this.worldObj.setBlock(
                                                    ix,
                                                    (int) this.posY + i + 1,
                                                    iz,
                                                    OreSpawnMain.MyFlowerPinkBlock);
                                            } else {
                                                this.worldObj.setBlock(
                                                    ix,
                                                    (int) this.posY + i + 1,
                                                    iz,
                                                    OreSpawnMain.MyFlowerBlueBlock);
                                            }
                                        }
                                    } else if (this.worldObj.rand.nextInt(100) == 1
                                        && this.worldObj.getBlock(ix, (int) this.posY + i + 1, iz) == Blocks.air) {
                                            OreSpawnMain.OreSpawnTrees
                                                .SmallTree(this.worldObj, ix, (int) this.posY + i + 1, iz);
                                        }
                                }
                            } else if (bid == Blocks.bedrock) {
                                this.setDead();
                                return;
                            }
                        } else {
                            final Block bid = this.worldObj.getBlock(ix, (int) this.posY + i, iz);
                            if (bid == Blocks.end_stone) {
                                if (!this.worldObj.isRemote) {
                                    this.worldObj.createExplosion(this, ix, this.posY + i, iz, 5.0f, true);
                                }
                            } else {
                                this.mySetBlock(ix, (int) this.posY + i, iz);
                            }
                        }
                    }
                }
            }
            this.worldObj.setBlock((int) this.posX - xoff, (int) this.posY, (int) this.posZ - zoff, Blocks.air);
        }
    }

    protected Item getDropItem() {
        return Item.getItemFromBlock(OreSpawnMain.MyIslandBlock);
    }

    public void FastSetBlock(final int ix, final int iy, final int iz, final Block id) {
        OreSpawnMain.setBlockFast(this.worldObj, ix, iy, iz, id, 0, 3);
    }
}
